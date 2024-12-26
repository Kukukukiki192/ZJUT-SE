#!/bin/bash

hive_db_name=gmall1
mysql_db_name=gmall1_report

export_data() {
/opt/module/sqoop/bin/sqoop export \
-Dmapreduce.job.queuename=hive \
--connect "jdbc:mysql://hadoop102:3306/${mysql_db_name}?useUnicode=true&characterEncoding=utf-8"  \
--username root \
--password 123456 \
--table $1 \
--num-mappers 1 \
--export-dir /warehouse/$hive_db_name/ads/$1 \
--input-fields-terminated-by "\t" \
--update-mode allowinsert \
--update-key $2 \
--input-null-string '\\N'    \
--input-null-non-string '\\N'
}

case $1 in
  "ads_uv_count")
     export_data "ads_uv_count" "dt"
;;
  "ads_new_mid_count")
     export_data "ads_new_mid_count" "create_date"
;;
  "ads_user_retention_day_rate")
     export_data "ads_user_retention_day_rate" "stat_date,create_date"
;;
  "ads_silent_count")
     export_data "ads_silent_count" "dt"
;;
  "ads_back_count")
     export_data "ads_back_count" "dt"
;;
  "ads_wastage_count")
     export_data "ads_wastage_count" "dt"
;;
  "ads_continuity_wk_count")
     export_data "ads_continuity_wk_count" "dt"
;;
  "ads_continuity_uv_count")
     export_data "ads_continuity_uv_count" "dt"
;;
   "all")
    export_data "ads_uv_count" "dt"
    export_data "ads_new_mid_count" "create_date"
    export_data "ads_user_retention_day_rate" "stat_date,create_date"
    export_data "ads_silent_count" "dt"
    export_data "ads_back_count" "dt"
    export_data "ads_wastage_count" "dt"
    export_data "ads_continuity_wk_count" "dt"
    export_data "ads_continuity_uv_count" "dt"
;;
esac

