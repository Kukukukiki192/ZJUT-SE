create database gmall1;

use gmall1;


-- ODS层 ---------------------------------------------------------------------------------------------------------------
-- 1.保持数据原貌不做任何修改,起到备份数据的作用
-- 2.数据采用 LZO 压缩,减少磁盘存储空间,100G 数据可以压缩到 10G 以内
-- 3.创建分区表,防止后续的全表扫描,在企业开发中大量使用分区表
-- 4.创建外部表. 在企业开发中,除了自己用的临时表,创建内部表外,绝大多数场景都是创建外部表


-- 日志表 --------------------------------------------
drop table if exists ods_log;
-- 创建一张外部表,字段就是一个String类型的json
CREATE EXTERNAL TABLE ods_log (`line` string)
PARTITIONED BY (`dt` string) -- 按照日期创建分区
STORED AS -- 指定存储方式,读数据采用 LzoTextInputFormat (LZO压缩格式处理),输出数据采用TextOutputFormat
    INPUTFORMAT 'com.hadoop.mapred.DeprecatedLzoTextInputFormat'
    OUTPUTFORMAT 'org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat'
LOCATION '/warehouse/gmall1/ods/ods_log'; -- 指定数据在 hdfs 上的存储位置

-- 封装成加载数据脚本: hdfs_to_ods_log1.sh yyyy-mm-dd(日期参数)
-- 加载数据
-- load data inpath '/origin_data/gmall/log/topic_log/2022-04-01' into table ods_log partition(dt='2022-04-01');
-- 为 lzo 压缩文件创建索引
-- hadoop jar /opt/modu le/hadoop-3.1.3/share/hadoop/common/hadoop-lzo-0.4.20.jar com.hadoop.compression.lzo.DistributedLzoIndexer -Dmapreduce.job.queuename=hive /warehouse/gmall1/ods/ods_log/dt=2022-04-01

-- 查看数据
select * from ods_log where dt='2022-04-01' limit 10;



-- DWD层 ---------------------------------------------------------------------------------------------------------------
-- 1.对用户行为数据解析
-- 2.对核心数据进行判空过滤
-- 3.对业务数据采用维度模型重新建模

-- get_json_object 函数:
-- 1.数据 [{"name":" 大 郎 ","sex":" 男 ","age":"25"},{"name":" 西 门 庆 ","sex":" 男","age":"47"}]
-- 2.取出第一个 json 对象
select get_json_object('[{"name":"大郎","sex":"男","age":"25"},{"name":"西门庆","sex":"男","age":"47"}]','$[0]');
-- 3.取出第一个 json 的 age 字段的值
SELECT get_json_object('[{"name":"大郎","sex":"男","age":"25"},{"name":"西门庆","sex":"男","age":"47"}]',"$[0].age");


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

-- 2种方式,分别查询数据有多少行. 结果不一致的原因
select * from ods_log; -- 不执行 MR 操作,默认采用 ods_log 建表语句中指定的 DeprecatedLzoTextInputFormat,能够识别 lzo.index 为索引文件
select count(*) from ods_log; -- 执行 MR 操作,默认采用 CombineHiveInputFormat. 不能识别 lzo.index 为索引文件,将索引文件当做普通文件处理->会导致 LZO文件无法切片
set hive.input.format; -- 查看 默认为..CombineHiveInputFormat
SET hive.input.format=org.apache.hadoop.hive.ql.io.HiveInputFormat; -- 修改. 解决 Hive 读取索引文件问题

-- 数据导入 将所有导入数据的语句封装成加载数据脚本: ods_to_dwd_log1.sh yyyy-mm-dd(日期参数)
insert overwrite table dwd_start_log partition(dt='2022-04-01')
select
    get_json_object(line,'$.common.ar'),
    get_json_object(line,'$.common.ba'),
    get_json_object(line,'$.common.ch'),
    get_json_object(line,'$.common.md'),
    get_json_object(line,'$.common.mid'),
    get_json_object(line,'$.common.os'),
    get_json_object(line,'$.common.uid'),
    get_json_object(line,'$.common.vc'),
    get_json_object(line,'$.start.entry'),
    get_json_object(line,'$.start.loading_time'),
    get_json_object(line,'$.start.open_ad_id'),
    get_json_object(line,'$.start.open_ad_ms'),
    get_json_object(line,'$.start.open_ad_skip_ms'),
    get_json_object(line,'$.ts')
from ods_log
where dt='2022-04-01'
and get_json_object(line,'$.start') is not null;

-- 查看数据
select * from dwd_start_log where dt='2022-04-01' limit 10;


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

-- 数据导入
insert overwrite table dwd_page_log partition(dt='2022-04-01')
select
    get_json_object(line,'$.common.ar'),
    get_json_object(line,'$.common.ba'),
    get_json_object(line,'$.common.ch'),
    get_json_object(line,'$.common.md'),
    get_json_object(line,'$.common.mid'),
    get_json_object(line,'$.common.os'),
    get_json_object(line,'$.common.uid'),
    get_json_object(line,'$.common.vc'),
    get_json_object(line,'$.page.during_time'),
    get_json_object(line,'$.page.item'),
    get_json_object(line,'$.page.item_type'),
    get_json_object(line,'$.page.last_page_id'),
    get_json_object(line,'$.page.page_id'),
    get_json_object(line,'$.page.sourceType'),
    get_json_object(line,'$.ts')
from ods_log
where dt='2022-04-01'
and get_json_object(line,'$.page') is not null;

-- 查看数据
select * from dwd_page_log where dt='2022-04-01' limit 10;


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

-- 创建永久函数与开发好的java class关联 (修改了自定义函数重新生成jar包只需替换HDFS路径/user/hive/jars上的旧jar包,重启Hive客户端) explode_json_array一进多出永久函数属于gmall1库
create function explode_json_array as 'hive.udtf.ExplodeJSONArray' using jar 'hdfs://hadoop102:9820/user/hive/jars/hivefunction-1.0-SNAPSHOT.jar';
-- 查看创建的函数
show functions like "*json*";
-- 测试
select explode_json_array(1);

select * -- count(*)
from ods_log
-- 自定义UDTF函数“炸开”action数组 tmp是函数输出结构体别名 action是结构体每列别名(这里只有一列String类型的json,该别名覆盖函数中定义的item别名)
lateral view explode_json_array(get_json_object(line,'$.actions')) tmp as action
where dt='2022-04-01'
and get_json_object(line,'$.actions') is not null;

-- 数据导入
insert overwrite table dwd_action_log partition(dt='2022-04-01')
select
    get_json_object(line,'$.common.ar'),
    get_json_object(line,'$.common.ba'),
    get_json_object(line,'$.common.ch'),
    get_json_object(line,'$.common.md'),
    get_json_object(line,'$.common.mid'),
    get_json_object(line,'$.common.os'),
    get_json_object(line,'$.common.uid'),
    get_json_object(line,'$.common.vc'),
    get_json_object(line,'$.page.during_time'),
    get_json_object(line,'$.page.item'),
    get_json_object(line,'$.page.item_type'),
    get_json_object(line,'$.page.last_page_id'),
    get_json_object(line,'$.page.page_id'),
    get_json_object(line,'$.page.sourceType'),
    get_json_object(action,'$.action_id'),
    get_json_object(action,'$.item'),
    get_json_object(action,'$.item_type'),
    get_json_object(action,'$.ts')
from ods_log
-- 自定义UDTF函数“炸开”action数组 tmp是函数输出结构体别名 action是结构体每列别名(这里只有一列String类型的json,该别名覆盖函数中定义的item别名)
lateral view explode_json_array(get_json_object(line,'$.actions')) tmp as action
where dt='2022-04-01'
and get_json_object(line,'$.actions') is not null;

-- 查看数据
select * from dwd_action_log where dt='2022-04-01' limit 10;


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

-- 数据导入
insert overwrite table dwd_display_log partition(dt='2022-04-01')
select
    get_json_object(line,'$.common.ar'),
    get_json_object(line,'$.common.ba'),
    get_json_object(line,'$.common.ch'),
    get_json_object(line,'$.common.md'),
    get_json_object(line,'$.common.mid'),
    get_json_object(line,'$.common.os'),
    get_json_object(line,'$.common.uid'),
    get_json_object(line,'$.common.vc'),
    get_json_object(line,'$.page.during_time'),
    get_json_object(line,'$.page.item'),
    get_json_object(line,'$.page.item_type'),
    get_json_object(line,'$.page.last_page_id'),
    get_json_object(line,'$.page.page_id'),
    get_json_object(line,'$.page.sourceType'),
    get_json_object(line,'$.ts'),
    get_json_object(display,'$.displayType'),
    get_json_object(display,'$.item'),
    get_json_object(display,'$.item_type'),
    get_json_object(display,'$.order')
from ods_log lateral view explode_json_array(get_json_object(line,'$.displays')) tmp as display
where dt='2022-04-01'
and get_json_object(line,'$.displays') is not null;

-- 查看数据
select * from dwd_action_log where dt='2022-04-01' limit 10;


-- 错误日志表 --------------------------------------------
-- 意义:方便定位错误 需要保留跟错误有关的所有相关因素
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

-- 数据导入
insert overwrite table dwd_error_log partition(dt='2022-04-01')
select
    get_json_object(line,'$.common.ar'),
    get_json_object(line,'$.common.ba'),
    get_json_object(line,'$.common.ch'),
    get_json_object(line,'$.common.md'),
    get_json_object(line,'$.common.mid'),
    get_json_object(line,'$.common.os'),
    get_json_object(line,'$.common.uid'),
    get_json_object(line,'$.common.vc'),
    get_json_object(line,'$.page.item'),
    get_json_object(line,'$.page.item_type'),
    get_json_object(line,'$.page.last_page_id'),
    get_json_object(line,'$.page.page_id'),
    get_json_object(line,'$.page.sourceType'),
    get_json_object(line,'$.start.entry'),
    get_json_object(line,'$.start.loading_time'),
    get_json_object(line,'$.start.open_ad_id'),
    get_json_object(line,'$.start.open_ad_ms'),
    get_json_object(line,'$.start.open_ad_skip_ms'),
    get_json_object(line,'$.actions'),
    get_json_object(line,'$.displays'),
    get_json_object(line,'$.ts'),
    get_json_object(line,'$.err.error_code'),
    get_json_object(line,'$.err.msg')
from ods_log
where dt='2022-04-01'
and get_json_object(line,'$.err') is not null;

-- 查看数据
select * from dwd_error_log where dt='2022-04-01' limit 10;



-- DWS层 ---------------------------------------------------------------------------------------------------------------
-- 统计各个主题对象的当天行为

-- nvl 函数:
-- 如果expr1为空值,返回expr2的值,否则返回expr1的值. 目的:把一个空值（null）转换成一个实际的值. expr1、2数据类型必须相同
select nvl(1,0);
select nvl(null,"hello");

-- 日期处理函数:
-- 根据格式整理日期
select date_format('2022-04-01','yyyy-MM');
-- 取当天的下一个周一
select next_day('2022-05-17','MO');
-- 取当前周的周一
select date_add(next_day('2022-05-17','MO'),-7);
-- 求当月最后一天日期
select last_day('2022-05-17');

-- 复杂数据类型定义:
-- map<string,string>
-- array<string>
-- struct<id:int,name:string,age:int>
-- array<struct<id:int,name:string,age:int>>


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

-- 数据导入 封装成加载数据脚本: dwd_to_dws1.sh yyyy-mm-dd(日期参数)
with
tmp_start as(
    select
        mid_id,
        brand,
        model,
        count(*) login_count
    from dwd_start_log
    where dt='2022-04-01'
    group by mid_id,brand,model
),
tmp_page as(
    select
        mid_id,
        brand,
        model,
        collect_set(named_struct('page_id',page_id,'page_count',page_count)) page_stats
--         collect_list(named_struct('page_id',page_id,'page_count',page_count)) page_stats -- 这里不用去重
--         collect_set(named_struct('page_id',page_id,'page_count',page_count)) page_stats, -- set去重
--         str_to_map(concat_ws(',',collect_set(concat(page_id,':',page_count))),',',':') page_stats1
    from(
        select
            mid_id,
            brand,
            model,
            page_id,
            count(*) page_count
        from dwd_page_log
        where dt='2022-04-01'
--         and page_id is not null -- 若结果中有页面id为null的情况就过滤掉
        group by mid_id,brand,model,page_id
    )tmp
    group by mid_id,brand,model
)
insert overwrite table dws_uv_detail_daycount partition(dt='2022-04-01')
select -- 全外联 选非空的出来
    nvl(tmp_start.mid_id,tmp_page.mid_id),
    nvl(tmp_start.brand,tmp_page.brand),
    nvl(tmp_start.model,tmp_page.model),
    nvl(tmp_start.login_count,0),
    tmp_page.page_stats
from tmp_start
full outer join tmp_page
on tmp_start.mid_id=tmp_page.mid_id
and tmp_start.brand=tmp_page.brand  -- 可省 和设备id绑定
and tmp_start.model=tmp_page.model; -- 可省 和设备id绑定

-- 查看数据
select * from dws_uv_detail_daycount where dt='2022-04-01' limit 10;



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

-- 数据导入 封装成加载数据脚本: dws_to_dwt1.sh yyyy-mm-dd(日期参数)
insert overwrite table dwt_uv_topic
select
    nvl(new.mid_id,old.mid_id),
    nvl(new.model,old.model),
    nvl(new.brand,old.brand),
    if(old.mid_id is null,'2022-04-01',old.login_date_first),
    if(new.mid_id is not null,'2022-04-01',old.login_date_last),
    if(new.mid_id is not null, new.login_count,0),
    nvl(old.login_count,0)+if(new.login_count>0,1,0)
from(
    select *
    from dwt_uv_topic
)old
full outer join(
    select *
    from dws_uv_detail_daycount
    where dt='2022-04-01'
)new
on old.mid_id=new.mid_id;



-- ADS层 ---------------------------------------------------------------------------------------------------------------
-- 对电商系统 设备主题 指标分别进行分析
-- (不用分区:一天就插入一条数据
-- 不用进行列式存储:ads已经是结果了,sqoop全表导入mysql,不用选哪几列
-- 不用压缩:数据量太少,一天就一条)


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

-- 数据导入 into追加会有数据重跑重复和小文件问题(into对表追加而对hdfs+新文件)->取出原文件数据和新增数据合并再插入
insert overwrite table ads_uv_count -- overwrite解决小文件问题
select * from ads_uv_count
union -- 解决重跑问题
select
    '2022-04-01',
    sum(if(login_date_last='2022-04-01',1,0)), -- 当天登录过(活跃)
    sum(if(login_date_last>=date_add(next_day('2022-04-01','MO'),-7) and login_date_last<= date_add(next_day('2022-04-01','MO'),-1),1,0)), -- 末次活跃在本周1-周7之间
    sum(if(date_format(login_date_last,'yyyy-MM')=date_format('2022-04-01','yyyy-MM'),1,0)), -- 本月登录过
    if('2022-04-01'=date_add(next_day('2022-04-01','MO'),-1),'Y','N') ,
    if('2022-04-01'=last_day('2022-04-01'),'Y','N')
from dwt_uv_topic;


-- 2每日新增设备数 --------------------------------------------
drop table if exists ads_new_mid_count;
create external table ads_new_mid_count(
    `create_date` string comment '创建时间' ,
    `new_mid_count` bigint comment '新增设备数量'
) COMMENT '每日新增设备数量'
row format delimited fields terminated by '\t'
location '/warehouse/gmall1/ads/ads_new_mid_count/';

-- 数据导入
insert overwrite table ads_new_mid_count
select * from ads_new_mid_count
union
select
    '2022-04-01',
    count(*) -- where+count比sum(if())快-只有一个需求,where先过滤数据再聚合,if数据都要判断效率低
from dwt_uv_topic
where login_date_first='2022-04-01'; --当天首次登录(活跃)


-- 3沉默设备数 --------------------------------------------
drop table if exists ads_silent_count;
create external table ads_silent_count(
    `dt` string COMMENT '统计日期',
    `silent_count` bigint COMMENT '沉默设备数'
) COMMENT '沉默设备数'
row format delimited fields terminated by '\t'
location '/warehouse/gmall1/ads/ads_silent_count';

-- 数据导入
insert overwrite table ads_silent_count
select * from ads_silent_count
union
select
    '2022-04-12',
    count(*)
from dwt_uv_topic
where login_date_first=login_date_last -- 或 login_count==1
and login_date_last<=date_add('2022-04-12',-7); -- 距今7天前启动


-- 4流失设备数 --------------------------------------------
drop table if exists ads_wastage_count;
create external table ads_wastage_count(
    `dt` string COMMENT '统计日期',
    `wastage_count` bigint COMMENT '流失设备数'
) COMMENT '流失设备数'
row format delimited fields terminated by '\t'
location '/warehouse/gmall1/ads/ads_wastage_count';

-- 数据导入
insert overwrite table ads_wastage_count
select * from ads_wastage_count
union
select
    '2022-04-12',
    count(*)
from dwt_uv_topic
where login_date_last<=date_add('2022-04-12',-7); -- 最近7天未活跃


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

-- 数据导入
insert overwrite table ads_back_count
select *
from ads_back_count
union
select
    '2022-04-12',
    concat(date_add(next_day('2022-04-12','MO'),-7),'_',date_add(next_day('2022-04-12','MO'),-1)),
    count(*)
from(
    select
        mid_id
    from dwt_uv_topic
    where login_date_last>=date_add(next_day('2022-04-12','MO'),-7)
    and login_date_last<= date_add(next_day('2022-04-12','MO'),-1)
    and login_date_first<date_add(next_day('2022-04-12','MO'),-7)
)current_wk
left join(
    select
        mid_id
    from dws_uv_detail_daycount
    where dt>=date_add(next_day('2022-04-12','MO'),-7*2)
    and dt<= date_add(next_day('2022-04-12','MO'),-7-1)
    group by mid_id
)last_wk
on current_wk.mid_id=last_wk.mid_id
where last_wk.mid_id is null;

insert overwrite table ads_back_count
select *
from ads_back_count
union
select '2022-04-12',
       concat(date_add(next_day('2022-04-12', 'MO'), -7), '_', date_add(next_day('2022-04-12', 'MO'), -1)),
       count(*)
from (select mid_id
      from dwt_uv_topic
      where login_date_last >= date_add(next_day('2022-04-12', 'MO'), -7)
        and login_date_last <= date_add(next_day('2022-04-12', 'MO'), -1)
        and login_date_first < date_add(next_day('2022-04-12', 'MO'), -7)
        and mid_id not in (select mid_id -- hql不能在where中放子查询,只能在表中放子查询 Error while compiling statement: FAILED: ParseException line 14:44 cannot recognize input near '<EOF>' '<EOF>' '<EOF>' in subquery source
                           from dws_uv_detail_daycount
                           where dt >= date_add(next_day('2022-04-12', 'MO'), -7 * 2)
                             and dt <= date_add(next_day('2022-04-12', 'MO'), -7 - 1)
                             and login_count>0
                           group by mid_id));

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

-- 数据导入
-- 4.5的计算任务 到4.5才计算完4.4的活跃设备 1天插入3条数据
-- 4.3的1日留存
-- 4.2的2日留存
-- 4.1的3日留存
insert overwrite table ads_user_retention_day_rate
select *
from ads_user_retention_day_rate
union
select
    '2022-04-04', --统计日期 为计算日期的前一天
    date_add('2022-04-04',-1), --新增日期
    1, --留存天数
    sum(if(login_date_first=date_add('2022-04-04',-1) and login_date_last='2022-04-04',1,0)), --2022-04-03的1日留存数 2022-04-04的前1日留存数
    sum(if(login_date_first=date_add('2022-04-04',-1),1,0)), --2022-04-03新增
    sum(if(login_date_first=date_add('2022-04-04',-1) and login_date_last='2022-04-04',1,0)) / sum(if(login_date_first=date_add('2022-04-04',-1),1,0)) * 100
from dwt_uv_topic
union all --不用去重
select
    '2022-04-04', --统计日期
    date_add('2022-04-04',-2), --新增日期
    2, --留存天数
    sum(if(login_date_first=date_add('2022-04-04',-2) and login_date_last='2022-04-04',1,0)), --2022-04-02的2日留存数 2022-04-04的前2日留存数
    sum(if(login_date_first=date_add('2022-04-04',-2),1,0)), --2022-04-02新增
    sum(if(login_date_first=date_add('2022-04-04',-2) and login_date_last='2022-04-04',1,0)) / sum(if(login_date_first=date_add('2022-04-04',-2),1,0)) * 100
from dwt_uv_topic
union all
select
    '2022-04-04', --统计日期
    date_add('2022-04-04',-3), --新增日期
    3, --留存天数
    sum(if(login_date_first=date_add('2022-04-04',-3) and login_date_last='2022-04-04',1,0)), --2022-04-01的3日留存数 2022-04-04的前3日留存数
    sum(if(login_date_first=date_add('2022-04-04',-3),1,0)), --2022-04-01新增
    sum(if(login_date_first=date_add('2022-04-04',-3) and login_date_last='2022-04-04',1,0)) / sum(if(login_date_first=date_add('2022-04-04',-3),1,0)) * 100
from dwt_uv_topic;

-- 优化1：先过滤,提高效率
insert overwrite table ads_user_retention_day_rate
select *
from ads_user_retention_day_rate
union
select
    '2022-04-04', --统计日期 为计算日期的前一天
    date_add('2022-04-04',-1), --新增日期
    1, --留存天数
    sum(if(login_date_last='2022-04-04',1,0)), --4.3 1日留存
    count(*), --4.3新增
    sum(if(login_date_last='2022-04-04',1,0)) / count(*) * 100
from dwt_uv_topic
where login_date_first=date_add('2022-04-04',-1)
union all --不用去重
select
    '2022-04-04', --统计日期
    date_add('2022-04-04',-2), --新增日期
    2, --留存天数
    sum(if(login_date_last='2022-04-04',1,0)), --4.2 2日留存
    count(*), --4.2新增
    sum(if(login_date_last='2022-04-04',1,0)) / count(*) * 100
from dwt_uv_topic
where login_date_first=date_add('2022-04-04',-2)
union all
select
    '2022-04-04', --统计日期
    date_add('2022-04-04',-3), --新增日期
    3, --留存天数
    sum(if(login_date_last='2022-04-04',1,0)), --4.1 3日留存
    count(*), --4.1新增
    sum(if(login_date_last='2022-04-04',1,0)) / count(*) * 100
from dwt_uv_topic
where login_date_first=date_add('2022-04-04',-3);

-- 优化2：按设备新增日期分组聚合 计算7日留存率 1天插入7条数据
insert overwrite table ads_user_retention_day_rate
select *
from ads_user_retention_day_rate
union
select
    '2022-04-04', --统计日期 为计算日期的前一天
    login_date_first, --新增日期
    datediff('2022-04-04',login_date_first), --留存天数
    sum(if(login_date_last='2022-04-04',1,0)), --留存数(当天活跃)
    count(*), --新增数
    sum(if(login_date_last='2022-04-04',1,0)) / count(*) * 100
from dwt_uv_topic
where login_date_first>=date_add('2022-04-04',-7)
and login_date_first<'2022-04-04'
group by login_date_first;


-- 7最近连续三周活跃设备数 --------------------------------------------
drop table if exists ads_continuity_wk_count;
create external table ads_continuity_wk_count(
    `dt` string COMMENT '统计日期,一般用结束周周日日期,如果每天计算一次,可用当天日期',
    `wk_dt` string COMMENT '持续时间',
    `continuity_count` bigint COMMENT '活跃次数'
) COMMENT '最近连续三周活跃设备数'
row format delimited fields terminated by '\t'
location '/warehouse/gmall1/ads/ads_continuity_wk_count';

-- 数据导入
insert overwrite table ads_continuity_wk_count
select *
from ads_continuity_wk_count
union
select '2022-04-12',
       concat(date_add(next_day('2022-04-12', 'MO'), -7 * 3), '_', date_add(next_day('2022-04-12', 'MO'), -1)),
       count(*)
from (select mid_id
      from (select mid_id --查找本周活跃设备
            from dws_uv_detail_daycount
            where dt >= date_add(next_day('2022-04-12', 'MO'), -7)
              and dt <= date_add(next_day('2022-04-12', 'MO'), -1)
            group by mid_id
            union all
            select mid_id --查找上周活跃设备
            from dws_uv_detail_daycount
            where dt >= date_add(next_day('2022-04-12', 'MO'), -7 * 2)
              and dt <= date_add(next_day('2022-04-12', 'MO'), -7 - 1)
            group by mid_id
            union all
            select mid_id --查找上上周活跃设备
            from dws_uv_detail_daycount
            where dt >= date_add(next_day('2022-04-12', 'MO'), -7 * 3)
              and dt <= date_add(next_day('2022-04-12', 'MO'), -7 * 2 - 1)
            group by mid_id --对三周内的所有活跃设备进行分组
           ) t1
      group by mid_id
      having count(*) = 3 --分组后mid_id个数为3的设备为最近连续三周活跃设备
     ) t2;


-- 8最近七天内连续三天活跃设备数 --------------------------------------------
drop table if exists ads_continuity_uv_count;
create external table ads_continuity_uv_count(
    `dt` string COMMENT '统计日期',
    `wk_dt` string COMMENT '最近 7 天日期',
    `continuity_count` bigint
) COMMENT '最近七天内连续三天活跃设备数'
row format delimited fields terminated by '\t'
location '/warehouse/gmall1/ads/ads_continuity_uv_count';

-- 数据导入
insert overwrite table ads_continuity_uv_count
select *
from ads_continuity_uv_count
union
select '2022-04-01',
       concat(date_add('2022-04-01', -6), '_', '2022-04-01'),
       count(*)
from (select mid_id
      from (select mid_id
            from (select mid_id,
                         date_sub(dt, rank) date_dif --取排序值与日期值之差作为连续标志
                  from (select mid_id,
                               dt,
                               rank() over (partition by mid_id order by dt) rank --对7七天内登录过的设备按照登录日期进行排序
                        from dws_uv_detail_daycount
                        where dt >= date_add('2022-04-01', -6)
                          and dt <= '2022-04-01'
                          and login_count > 0) t1) t2
            group by mid_id, date_dif --按照连续标志和设备的mid进行分组
            having count(*) >= 3 --分组后个数大于3的设备为最近7天内连续3天活跃的设备
           ) t3
      group by mid_id) t4;

-- 查看导入数据
select * from ads_uv_count where dt='2022-04-02';
select * from ads_new_mid_count;
select * from ads_silent_count where dt='2022-04-02';
select * from ads_back_count where dt='2022-04-02';
select * from ads_wastage_count where dt='2022-04-02';
select * from ads_user_retention_day_rate;
select * from ads_continuity_wk_count where dt='2022-04-02';
select * from ads_continuity_uv_count where dt='2022-04-02';
















