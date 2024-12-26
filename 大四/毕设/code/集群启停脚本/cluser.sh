#!/bin/bash

case $1 in
"start"){
        echo ================== 启动 集群 ==================
        #启动 Azkaban消费集群
        azkaban.sh start
	sleep 5
        #启动 Zookeeper集群
        zk.sh start

        #启动 Hadoop集群
        hdp.sh start

        #启动 Kafka采集集群
        kf.sh start

        #启动 Flume采集集群
        f1.sh start

        #启动 Flume消费集群
        f2.sh start

	#启动 Hive元数据服务	
	nohup hive --service metastore >hive_metastore.log 2>&1 &

        #启动 superset消费集群
        superset.sh start
	
        };;
"stop"){
        echo ================== 停止 集群 ==================
     
        #停止 superset消费集群
        superset.sh stop

        #停止 Flume消费集群
        f2.sh stop

        #停止 Flume采集集群
        f1.sh stop

        #停止 Kafka采集集群
        kf.sh stop

        #停止 Hadoop集群
        hdp.sh stop

        #停止 Zookeeper集群
        zk.sh stop

        #停止 Azkaban消费集群
        azkaban.sh stop

	#停止 Hive元数据服务
	ssh hadoop102 "ps -ef | grep hive-metastore | grep -v grep |awk  '{print \$2}' | xargs -n1 kill -9 "
};;
esac
