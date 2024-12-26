# 基于Hadoop的电商用户行为数据分析系统的设计与实现

>  毕业设计 大四下 2022/06

内容：项目参考资料 + 学校论文查重系统说明 + 源代码(code) + 毕设要求说明(X材料) + 答辩ppt + 上交材料(朱可心-X材料) + 系统演示录屏(GmallDataAnalysis.mp4【缺失】)

### 项目

电商网站产生的大量用户行为数据和系统业务数据如果加以利用则能发掘其中的巨大潜能。为尽量发掘数据中的潜在价值，需要搭建数据仓库系统。数据仓库系统从数据的采集流程开始，将不同来源的数据统一采集进数据仓库中，在数据仓库中对数据进行合理的分析分类存储计算。这个数据仓库将面向所有的有数据分析需求的用户，包括企业决策者、运营人员、数据分析师等，为用户提供多样的数据服务，解决用户的数据方面需求。

#### 功能结构

1. 数据采集

   数据采集运输方面包括三方面需求，将服务器中的日志数据实时采集进大数据存储系统中，防止数据丢失以及数据堵塞，将业务数据库中的数据采集进数仓中，同时将需求计算结果导出至关系型数据库方便进行展示。为此将选用Flume、Kafka和Sqoop来收集电子商务系统前端埋点的用户行为数据。

2. 数据仓库分析  

   数仓业务模块主要将采集系统采集到HDFS系统的日志文件进行挖掘分析，从中发现内部练习和业务规律，为相关人员提供决策参考。这一过程主要通过对数据仓库进行合理分层实现，主要分为5层：ODS 层-原始数据层，DWD层-明细数据层，DWS层-服务数据层，DWT层-主题数据层，ADS层-数据应用层。分析工具选用Hive，配置Spark引擎，分别对数据进行保存、清洗、合并、拆分、统计等工作。     

   最终要求实现如下需求：

   - 统计当日、当周、当月的活跃设备数
   - 每日新增设备数
   - 沉默用户数
   - 本周回流用户数
   - 流失用户数
   - 留存率
   - 最近连续3周活跃用户数
   - 最近7天内连续3天活跃用户数       

3. 数据可视化展示

   使用Sqoop将最终需求结果数据导入到MySQL中，并采用Superset对最终需求的实现进行Web页面展示

#### 技术难点

- Flume、Kafka、Sqoop、Hive、SuperSet等框架的搭建部署和整合使用

- 数仓搭建
- 用户行为指标分析

#### 系统总体设计

![](https://github.com/Kukukukiki192/TyporaImg/raw/main/img/ZJUT%E6%AF%95%E8%AE%BE1.png)

### 运行

#### 启动集群

![](https://github.com/Kukukukiki192/TyporaImg/raw/main/img/ZJUT%E6%AF%95%E8%AE%BE2.png)

HDFS上的Hive数据仓库目录

![](https://github.com/Kukukukiki192/TyporaImg/raw/main/img/ZJUT%E6%AF%95%E8%AE%BE3.png)

ADS层指标

![](https://github.com/Kukukukiki192/TyporaImg/raw/main/img/ZJUT%E6%AF%95%E8%AE%BE4.png)

#### 执行Azkaban任务调度

![](https://github.com/Kukukukiki192/TyporaImg/raw/main/img/ZJUT%E6%AF%95%E8%AE%BE5.png)

#### Superset可视化展示

![](https://github.com/Kukukukiki192/TyporaImg/raw/main/img/ZJUT%E6%AF%95%E8%AE%BE6.png)

![](https://github.com/Kukukukiki192/TyporaImg/raw/main/img/ZJUT%E6%AF%95%E8%AE%BE7.png)
