create database gmall1;

use gmall1;


-- ODS层 ---------------------------------------------------------------------------------------------------------------

-- 日志表 --------------------------------------------
drop table if exists ods_log;
CREATE EXTERNAL TABLE ods_log (`line` string)
PARTITIONED BY (`dt` string) -- 按照日期创建分区
STORED AS -- 指定存储方式,读数据采用 LzoTextInputFormat (LZO压缩格式处理),输出数据采用TextOutputFormat
    INPUTFORMAT 'com.hadoop.mapred.DeprecatedLzoTextInputFormat'
    OUTPUTFORMAT 'org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat'
LOCATION '/warehouse/gmall1/ods/ods_log'; -- 指定数据在 hdfs 上的存储位置


-- DWD层 ---------------------------------------------------------------------------------------------------------------

-- 启动日志表 --------------------------------------------
drop table if exists dwd_start_log;
CREATE EXTERNAL TABLE dwd_start_log(
--     公共字段
    `area_code` string COMMENT '地区编码',
    `brand` string COMMENT '手机品牌',
    `channel` string COMMENT '渠道',
    `model` string COMMENT '手机型号',
    `mid_id` string COMMENT '设备 id',
    `os` string COMMENT '操作系统',
    `user_id` string COMMENT '会员 id',
    `version_code` string COMMENT 'app 版本号',
--     启动信息
    `entry` string COMMENT ' icon 手机图标 notice 通知 install 安装后启动',
    `loading_time` bigint COMMENT '启动加载时间',
    `open_ad_id` string COMMENT '广告页 ID ',
    `open_ad_ms` bigint COMMENT '广告总共播放时间',
    `open_ad_skip_ms` bigint COMMENT '用户跳过广告时点',
--     启动时间
    `ts` bigint COMMENT '时间'
) COMMENT '启动日志表'
PARTITIONED BY (dt string) -- 按照时间创建分区
stored as parquet -- 采用 parquet 列式存储 (支持切片,无需要再对数据创建索引)
LOCATION '/warehouse/gmall1/dwd/dwd_start_log' -- 指定在 HDFS 上存储位置
TBLPROPERTIES('parquet.compression'='lzo'); -- 采用 LZO 压缩


-- 页面日志表 --------------------------------------------
drop table if exists dwd_page_log;
CREATE EXTERNAL TABLE dwd_page_log(
--     公共字段
    `area_code` string COMMENT '地区编码',
    `brand` string COMMENT '手机品牌',
    `channel` string COMMENT '渠道',
    `model` string COMMENT '手机型号',
    `mid_id` string COMMENT '设备 id',
    `os` string COMMENT '操作系统',
    `user_id` string COMMENT '会员 id',
    `version_code` string COMMENT 'app 版本号',
--     页面信息
    `during_time` bigint COMMENT '持续时间毫秒',
    `page_item` string COMMENT '目标 id ',
    `page_item_type` string COMMENT '目标类型',
    `last_page_id` string COMMENT '上页类型',
    `page_id` string COMMENT '页面 ID ',
    `source_type` string COMMENT '来源类型',
--     跳入当前页时间
    `ts` bigint
) COMMENT '页面日志表'
PARTITIONED BY (dt string)
stored as parquet
LOCATION '/warehouse/gmall1/dwd/dwd_page_log'
TBLPROPERTIES('parquet.compression'='lzo');


-- 动作日志表 --------------------------------------------
drop table if exists dwd_action_log;
CREATE EXTERNAL TABLE dwd_action_log(
--     公共字段
    `area_code` string COMMENT '地区编码',
    `brand` string COMMENT '手机品牌',
    `channel` string COMMENT '渠道',
    `model` string COMMENT '手机型号',
    `mid_id` string COMMENT '设备 id',
    `os` string COMMENT '操作系统',
    `user_id` string COMMENT '会员 id',
    `version_code` string COMMENT 'app 版本号',
--     页面信息
    `during_time` bigint COMMENT '持续时间毫秒',
    `page_item` string COMMENT '目标 id ',
    `page_item_type` string COMMENT '目标类型',
    `last_page_id` string COMMENT '上页类型',
    `page_id` string COMMENT '页面 id ',
    `source_type` string COMMENT '来源类型',
--     动作(事件)信息
    `action_id` string COMMENT '动作 id',
    `item` string COMMENT '目标 id ',
    `item_type` string COMMENT '目标类型',
--     跳入当前页时间
    `ts` bigint COMMENT '时间'
) COMMENT '动作日志表'
PARTITIONED BY (dt string)
stored as parquet
LOCATION '/warehouse/gmall1/dwd/dwd_action_log'
TBLPROPERTIES('parquet.compression'='lzo');



-- 曝光日志表 --------------------------------------------
drop table if exists dwd_display_log;
CREATE EXTERNAL TABLE dwd_display_log(
--     公共字段
    `area_code` string COMMENT '地区编码',
    `brand` string COMMENT '手机品牌',
    `channel` string COMMENT '渠道',
    `model` string COMMENT '手机型号',
    `mid_id` string COMMENT '设备 id',
    `os` string COMMENT '操作系统',
    `user_id` string COMMENT '会员 id',
    `version_code` string COMMENT 'app 版本号',
--     页面信息
    `during_time` bigint COMMENT 'app 版本号',
    `page_item` string COMMENT '目标 id ',
    `page_item_type` string COMMENT '目标类型',
    `last_page_id` string COMMENT '上页类型',
    `page_id` string COMMENT '页面 ID ',
    `source_type` string COMMENT '来源类型',
--     跳入当前页时间
    `ts` bigint COMMENT 'app 版本号',
--     曝光信息
    `display_type` string COMMENT '曝光类型',
    `item` string COMMENT '曝光对象 id ',
    `item_type` string COMMENT 'app 版本号',
    `order` bigint COMMENT '出现顺序'
) COMMENT '曝光日志表'
PARTITIONED BY (dt string)
stored as parquet
LOCATION '/warehouse/gmall1/dwd/dwd_display_log'
TBLPROPERTIES('parquet.compression'='lzo');



-- 错误日志表 --------------------------------------------
drop table if exists dwd_error_log;
CREATE EXTERNAL TABLE dwd_error_log(
--     公共字段
    `area_code` string COMMENT '地区编码',
    `brand` string COMMENT '手机品牌',
    `channel` string COMMENT '渠道',
    `model` string COMMENT '手机型号',
    `mid_id` string COMMENT '设备 id',
    `os` string COMMENT '操作系统',
    `user_id` string COMMENT '会员 id',
    `version_code` string COMMENT 'app 版本号',
--     页面信息
    `page_item` string COMMENT '目标 id ',
    `page_item_type` string COMMENT '目标类型',
    `last_page_id` string COMMENT '上页类型',
    `page_id` string COMMENT '页面 ID ',
    `source_type` string COMMENT '来源类型',
    `entry` string COMMENT ' icon 手机图标 notice 通知 install 安装后启动',
--     启动信息
    `loading_time` string COMMENT '启动加载时间',
    `open_ad_id` string COMMENT '广告页 ID ',
    `open_ad_ms` string COMMENT '广告总共播放时间',
    `open_ad_skip_ms` string COMMENT '用户跳过广告时点',
--     动作数组
    `actions` string COMMENT '动作',
--     曝光数组
    `displays` string COMMENT '曝光',
--     跳入当前页时间
    `ts` string COMMENT '时间',
--     错误信息
    `error_code` string COMMENT '错误码',
    `msg` string COMMENT '错误信息'
) COMMENT '错误日志表'
PARTITIONED BY (dt string)
stored as parquet
LOCATION '/warehouse/gmall1/dwd/dwd_error_log'
TBLPROPERTIES('parquet.compression'='lzo');



-- DWS层 ---------------------------------------------------------------------------------------------------------------
-- 统计各个主题对象的当天行为

-- 每日设备行为表 (按照设备id统计) --------------------------------------------
drop table if exists dws_uv_detail_daycount;
create external table dws_uv_detail_daycount(
    `mid_id` string COMMENT '设备 id',
    `brand` string COMMENT '手机品牌',
    `model` string COMMENT '手机型号',
    `login_count` bigint COMMENT '活跃次数',
    `page_stats` array<struct<page_id:string,page_count:bigint>> COMMENT '页面访问统计'
) COMMENT '每日设备行为表'
partitioned by(dt string)
stored as parquet
location '/warehouse/gmall1/dws/dws_uv_detail_daycount'
tblproperties ("parquet.compression"="lzo");



-- DWT层 ---------------------------------------------------------------------------------------------------------------
-- 统计各个主题对象的累积行为(无需分区)

-- 设备主题宽表 --------------------------------------------
drop table if exists dwt_uv_topic;
create external table dwt_uv_topic(
    `mid_id` string comment '设备 id',
    `brand` string comment '手机品牌',
    `model` string comment '手机型号',
    `login_date_first` string comment '首次活跃时间',
    `login_date_last` string comment '末次活跃时间',
    `login_day_count` bigint comment '当日活跃次数',
    `login_count` bigint comment '累积活跃天数'
) COMMENT '设备主题宽表'
stored as parquet
location '/warehouse/gmall1/dwt/dwt_uv_topic'
tblproperties ("parquet.compression"="lzo");


-- ADS层 ---------------------------------------------------------------------------------------------------------------

-- 1活跃设备数（日、周、月）--------------------------------------------
drop table if exists ads_uv_count;
create external table ads_uv_count(
    `dt` string COMMENT '统计日期',
    `day_count` bigint COMMENT '当日用户数量',
    `wk_count` bigint COMMENT '当周用户数量',
    `mn_count` bigint COMMENT '当月用户数量',
    `is_weekend` string COMMENT 'Y,N 是否是周末,用于得到本周最终结果',
    `is_monthend` string COMMENT 'Y,N 是否是月末,用于得到本月最终结果'
) COMMENT '活跃设备数'
row format delimited fields terminated by '\t'
location '/warehouse/gmall1/ads/ads_uv_count/';


-- 2每日新增设备数 --------------------------------------------
drop table if exists ads_new_mid_count;
create external table ads_new_mid_count(
    `create_date` string comment '创建时间' ,
    `new_mid_count` bigint comment '新增设备数量'
) COMMENT '每日新增设备数量'
row format delimited fields terminated by '\t'
location '/warehouse/gmall1/ads/ads_new_mid_count/';


-- 3沉默设备数 --------------------------------------------
drop table if exists ads_silent_count;
create external table ads_silent_count(
    `dt` string COMMENT '统计日期',
    `silent_count` bigint COMMENT '沉默设备数'
) COMMENT '沉默设备数'
row format delimited fields terminated by '\t'
location '/warehouse/gmall1/ads/ads_silent_count';


-- 4流失设备数 --------------------------------------------
drop table if exists ads_wastage_count;
create external table ads_wastage_count(
    `dt` string COMMENT '统计日期',
    `wastage_count` bigint COMMENT '流失设备数'
) COMMENT '流失设备数'
row format delimited fields terminated by '\t'
location '/warehouse/gmall1/ads/ads_wastage_count';


-- 5本周回流设备数 --------------------------------------------
-- 上周未活跃 本周活跃 非本周新增设备
drop table if exists ads_back_count;
create external table ads_back_count(
    `dt` string COMMENT '统计日期',
    `wk_dt` string COMMENT '统计日期所在周',
    `wastage_count` bigint COMMENT '回流设备数'
) COMMENT '本周回流设备数'
row format delimited fields terminated by '\t'
location '/warehouse/gmall1/ads/ads_back_count';


-- 6留存率 --------------------------------------------
-- 记录每天3日留存 每行：某天的几日留存
drop table if exists ads_user_retention_day_rate;
create external table ads_user_retention_day_rate (
    `stat_date` string comment '统计日期',
    `create_date` string comment '设备新增日期',
    `retention_day` int comment '截止当前日期留存天数',
    `retention_count` bigint comment '留存数量',
    `new_mid_count` bigint comment '设备新增数量',
    `retention_ratio` decimal(16,2) comment '留存率'
) COMMENT '留存率'
row format delimited fields terminated by '\t'
location '/warehouse/gmall1/ads/ads_user_retention_day_rate/';


-- 7最近连续三周活跃设备数 --------------------------------------------
drop table if exists ads_continuity_wk_count;
create external table ads_continuity_wk_count(
    `dt` string COMMENT '统计日期,一般用结束周周日日期,如果每天计算一次,可用当天日期',
    `wk_dt` string COMMENT '持续时间',
    `continuity_count` bigint COMMENT '活跃次数'
) COMMENT '最近连续三周活跃设备数'
row format delimited fields terminated by '\t'
location '/warehouse/gmall1/ads/ads_continuity_wk_count';


-- 8最近七天内连续三天活跃设备数 --------------------------------------------
drop table if exists ads_continuity_uv_count;
create external table ads_continuity_uv_count(
    `dt` string COMMENT '统计日期',
    `wk_dt` string COMMENT '最近 7 天日期',
    `continuity_count` bigint
) COMMENT '最近七天内连续三天活跃设备数'
row format delimited fields terminated by '\t'
location '/warehouse/gmall1/ads/ads_continuity_uv_count';