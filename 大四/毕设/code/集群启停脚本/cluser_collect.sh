#!/bin/bash
case $1 in
"start"){
 echo ================== 启动 集群 ==================
 #启动 Zookeeper 集群
 zk.sh start
 #启动 Hadoop 集群
 hdp.sh start
 #启动 Kafka 采集集群
 kf.sh start
 #启动 Flume 采集集群
 f1.sh start
 #启动 Flume 消费集群
 f2.sh start
 };;
"stop"){
 echo ================== 停止 集群 ==================
 #停止 Flume 消费集群
 f2.sh stop
 #停止 Flume 采集集群
 f1.sh stop
 #停止 Kafka 采集集群
 kf.sh stop
 #停止 Hadoop 集群
 hdp.sh stop
 #停止 Zookeeper 集群
 zk.sh stop
};;
esac
