#!/bin/bash

for i in hadoop102 hadoop103 
do
    echo "========== $i =========="
    ssh $i "cd /opt/module/applog/; java -jar gmall2020-mock-log-2020-04-01.jar >/dev/null 2>&1 &"
done 

