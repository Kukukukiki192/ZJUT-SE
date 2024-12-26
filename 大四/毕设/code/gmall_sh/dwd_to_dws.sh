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
with
tmp_start as(
	select 
		mid_id,
		brand,
		model,
		count(*) login_count
	from ${APP}.dwd_start_log
	where dt='$do_date'
	group by mid_id,brand,model
),
tmp_page as(
	select
		mid_id,
		brand,
		model, 
		collect_set(named_struct('page_id',page_id,'page_count',page_count)) page_stats
	from(
		select
			mid_id,
			brand,
			model,
			page_id,
			count(*) page_count
		from ${APP}.dwd_page_log
		where dt='$do_date'
		group by mid_id,brand,model,page_id
	)tmp
	group by mid_id,brand,model
)
insert overwrite table ${APP}.dws_uv_detail_daycount partition(dt='$do_date')
select
	nvl(tmp_start.mid_id,tmp_page.mid_id),
	nvl(tmp_start.brand,tmp_page.brand),
	nvl(tmp_start.model,tmp_page.model),
	tmp_start.login_count,
	tmp_page.page_stats
from tmp_start 
full outer join tmp_page
on tmp_start.mid_id=tmp_page.mid_id
and tmp_start.brand=tmp_page.brand
and tmp_start.model=tmp_page.model;
"
$hive -e "$sql"
