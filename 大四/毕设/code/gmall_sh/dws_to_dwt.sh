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
insert overwrite table ${APP}.dwt_uv_topic
select
 nvl(new.mid_id,old.mid_id),
 nvl(new.model,old.model),
 nvl(new.brand,old.brand),
 if(old.mid_id is null,'$do_date',old.login_date_first),
 if(new.mid_id is not null,'$do_date',old.login_date_last),
 if(new.mid_id is not null, new.login_count,0),
 nvl(old.login_count,0)+if(new.login_count>0,1,0)
from(
 select *
 from ${APP}.dwt_uv_topic
)old
full outer join(
 select *
 from ${APP}.dws_uv_detail_daycount
 where dt='$do_date'
)new
on old.mid_id=new.mid_id;
"
$hive -e "$sql"
