#!/bin/bash

APP=gmall1
hive=/opt/module/hive/bin/hive
# 如果是输入的日期按照取输入日期；如果没输入日期取当前时间的前一天
if [ -n "$1" ] ;then
 do_date=$1
else 
 do_date=`date -d "-1 day" +%F`
fi
sql="
set mapreduce.job.queuename=hive;

-- 活跃设备数
insert overwrite table ${APP}.ads_uv_count
select * from ${APP}.ads_uv_count
union
select
    '$do_date',
    sum(if(login_date_last='$do_date',1,0)),
    sum(if(login_date_last>=date_add(next_day('$do_date','MO'),-7) and login_date_last<= date_add(next_day('$do_date','MO'),-1),1,0)),
    sum(if(date_format(login_date_last,'yyyy-MM')=date_format('$do_date','yyyy-MM'),1,0)),
    if('$do_date'=date_add(next_day('$do_date','MO'),-1),'Y','N') ,
    if('$do_date'=last_day('$do_date'),'Y','N')
from ${APP}.dwt_uv_topic;

-- 每日新增设备
insert overwrite table ${APP}.ads_new_mid_count
select * from ${APP}.ads_new_mid_count
union
select
    '$do_date',
    count(*)
from ${APP}.dwt_uv_topic
where login_date_first='$do_date';

-- 沉默设备数
insert overwrite table ${APP}.ads_silent_count
select * from ${APP}.ads_silent_count
union
select
    '$do_date',
    count(*)
from ${APP}.dwt_uv_topic
where login_date_first=login_date_last -- 或 login_count=1
and login_date_last<=date_add('$do_date',-7);

-- 流失设备数
insert overwrite table ${APP}.ads_wastage_count
select * from ${APP}.ads_wastage_count
union
select
    '$do_date',
    count(*)
from ${APP}.dwt_uv_topic
where login_date_last<=date_add('$do_date',-7);

-- 本周回流设备数
insert overwrite table ${APP}.ads_back_count
select *
from ${APP}.ads_back_count
union
select
    '$do_date',
    concat(date_add(next_day('$do_date','MO'),-7),'_',date_add(next_day('$do_date','MO'),-1)),
    count(*)
from(
    select mid_id
    from ${APP}.dwt_uv_topic
    where login_date_last>=date_add(next_day('$do_date','MO'),-7)
    and login_date_last<= date_add(next_day('$do_date','MO'),-1)
    and login_date_first<date_add(next_day('$do_date','MO'),-7)
)current_wk
left join(
    select mid_id
    from ${APP}.dws_uv_detail_daycount
    where dt>=date_add(next_day('$do_date','MO'),-7*2)
    and dt<= date_add(next_day('$do_date','MO'),-7-1)
    group by mid_id
)last_wk
on current_wk.mid_id=last_wk.mid_id
where last_wk.mid_id is null;
                           
-- 留存率
insert overwrite table ${APP}.ads_user_retention_day_rate
select *
from ${APP}.ads_user_retention_day_rate
union
select
    '$do_date',
    login_date_first,
    datediff('$do_date',login_date_first),
    sum(if(login_date_last='$do_date',1,0)),
    count(*),
    sum(if(login_date_last='$do_date',1,0)) / count(*) * 100
from ${APP}.dwt_uv_topic
where login_date_first>=date_add('$do_date',-7)
and login_date_first<'$do_date'
group by login_date_first;

-- 最近连续3周活跃设备数
insert overwrite table ${APP}.ads_continuity_wk_count
select *
from ${APP}.ads_continuity_wk_count
union
select '$do_date',
       concat(date_add(next_day('$do_date', 'MO'), -7 * 3), '_', date_add(next_day('$do_date', 'MO'), -1)),
       count(*)
from (select mid_id
      from (select mid_id
            from ${APP}.dws_uv_detail_daycount
            where dt >= date_add(next_day('$do_date', 'MO'), -7)
              and dt <= date_add(next_day('$do_date', 'MO'), -1)
            group by mid_id
            union all
            select mid_id
            from ${APP}.dws_uv_detail_daycount
            where dt >= date_add(next_day('$do_date', 'MO'), -7 * 2)
              and dt <= date_add(next_day('$do_date', 'MO'), -7 - 1)
            group by mid_id
            union all
            select mid_id
            from ${APP}.dws_uv_detail_daycount
            where dt >= date_add(next_day('$do_date', 'MO'), -7 * 3)
              and dt <= date_add(next_day('$do_date', 'MO'), -7 * 2 - 1)
            group by mid_id
           ) t1
      group by mid_id
      having count(*) = 3
     ) t2;
     
-- 最近7天内连续3天活跃设备数
insert overwrite table ${APP}.ads_continuity_uv_count
select *
from ${APP}.ads_continuity_uv_count
union
select '$do_date',
       concat(date_add('$do_date', -6), '_', '$do_date'),
       count(*)
from (select mid_id
      from (select mid_id
            from (select mid_id,
                         date_sub(dt, rank) date_dif
                  from (select mid_id,
                               dt,
                               rank() over (partition by mid_id order by dt) rank
                        from ${APP}.dws_uv_detail_daycount
                        where dt >= date_add('$do_date', -6)
                          and dt <= '$do_date'
                          and login_count > 0) t1) t2
            group by mid_id, date_dif
            having count(*) >= 3
           ) t3
      group by mid_id) t4;
"
$hive -e "$sql"
