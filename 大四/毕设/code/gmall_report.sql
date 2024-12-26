CREATE DATABASE `gmall1_report` CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

USE `gmall1_report`;

-- 1活跃设备数（日、周、月）
DROP TABLE IF EXISTS `ads_uv_count`;
CREATE TABLE `ads_uv_count` (
  `dt` date NOT NULL,
  `day_count` bigint(255) DEFAULT NULL,
  `wk_count` bigint(255) DEFAULT NULL,
  `mn_count` bigint(255) DEFAULT NULL,
  `is_weekend` varchar(255) DEFAULT NULL,
  `is_monthend` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dt`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- 2每日新增设备数
DROP TABLE IF EXISTS `ads_new_mid_count`;
CREATE TABLE `ads_new_mid_count` (
  `create_date` date NOT NULL,
  `new_mid_count` bigint(255) DEFAULT NULL,
  PRIMARY KEY (`create_date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- 3沉默设备数
DROP TABLE IF EXISTS `ads_silent_count`;
CREATE TABLE `ads_silent_count` (
  `dt` date NOT NULL,
  `silent_count` bigint(255) DEFAULT NULL,
  PRIMARY KEY (`dt`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- 4流失设备数
DROP TABLE IF EXISTS `ads_wastage_count`;
CREATE TABLE `ads_wastage_count` (
  `dt` date NOT NULL,
  `wastage_count` bigint(255) DEFAULT NULL,
  PRIMARY KEY (`dt`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- 5本周回流设备数
DROP TABLE IF EXISTS `ads_back_count`;
CREATE TABLE `ads_back_count` (
  `dt` date NOT NULL,
  `wk_dt` varchar(255) DEFAULT NULL,
  `wastage_count` bigint(255) DEFAULT NULL,
  PRIMARY KEY (`dt`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- 6留存率
DROP TABLE IF EXISTS `ads_user_retention_day_rate`;
CREATE TABLE `ads_user_retention_day_rate` (
  `stat_date` date NOT NULL,
  `create_date` date NOT NULL,
  `retention_day` int(11) DEFAULT NULL,
  `retention_count` bigint(255) DEFAULT NULL,
  `new_mid_count` bigint(255) DEFAULT NULL,
  `retention_ratio` double(255,2) DEFAULT NULL,
  PRIMARY KEY (`stat_date`,`create_date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

DROP TABLE IF EXISTS `ads_user_retention_day_rate2`;
CREATE TABLE `ads_user_retention_day_rate2` (
  `create_date` date NOT NULL,
  `d1` double(255,2) DEFAULT NULL,
  `d2` double(255,2) DEFAULT NULL,
  `d3` double(255,2) DEFAULT NULL,
  `d4` double(255,2) DEFAULT NULL,
  `d5` double(255,2) DEFAULT NULL,
  `d6` double(255,2) DEFAULT NULL,
  `d7` double(255,2) DEFAULT NULL,
  PRIMARY KEY (`create_date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

DROP TABLE IF EXISTS `ads_user_retention_day_rate2`;
CREATE TABLE `ads_user_retention_day_rate2` (
  `日期` date NOT NULL,
  `新增设备数` bigint(255) DEFAULT NULL,
  `1天后` double(255,2) DEFAULT NULL,
  `2天后` double(255,2) DEFAULT NULL,
  `3天后` double(255,2) DEFAULT NULL,
  `4天后` double(255,2) DEFAULT NULL,
  `5天后` double(255,2) DEFAULT NULL,
  `6天后` double(255,2) DEFAULT NULL,
  `7天后` double(255,2) DEFAULT NULL,
  PRIMARY KEY (`日期`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;


INSERT INTO ads_user_retention_day_rate2
SELECT
	create_date,
	--MIN(new_mid_count), --这里不准确
	SUM(if(retention_day=1,retention_ratio,NULL)) d1, 
	SUM(if(retention_day=2,retention_ratio,NULL)) d2,
	SUM(if(retention_day=3,retention_ratio,NULL)) d3,
	SUM(if(retention_day=4,retention_ratio,NULL)) d4,
	SUM(if(retention_day=5,retention_ratio,NULL)) d5,
	SUM(if(retention_day=6,retention_ratio,NULL)) d6,
	SUM(if(retention_day=7,retention_ratio,NULL)) d7
FROM ads_user_retention_day_rate1
GROUP BY create_date;

-- 7最近连续三周活跃设备数
DROP TABLE IF EXISTS `ads_continuity_wk_count`;
CREATE TABLE `ads_continuity_wk_count` (
  `dt` date NOT NULL,
  `wk_dt` varchar(255) DEFAULT NULL,
  `continuity_count` bigint(255) DEFAULT NULL,
  PRIMARY KEY (`dt`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- 8最近七天内连续三天活跃设备数
DROP TABLE IF EXISTS `ads_continuity_uv_count`;
CREATE TABLE `ads_continuity_uv_count` (
  `dt` date NOT NULL,
  `wk_dt` varchar(255) DEFAULT NULL,
  `continuity_count` bigint(255) DEFAULT NULL,
  PRIMARY KEY (`dt`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
