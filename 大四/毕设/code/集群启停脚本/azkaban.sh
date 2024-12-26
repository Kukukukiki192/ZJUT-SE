#!/bin/bash
start-web(){
    for i in hadoop102
    do
        ssh $i "cd /opt/module/azkaban/azkaban-web/;bin/start-web.sh"
    done
}

stop-web(){
    for i in hadoop102
    do
        ssh $i "cd /opt/module/azkaban/azkaban-web/;bin/shutdown-web.sh"
    done
}

start-exec(){
    for i in hadoop102 hadoop103 hadoop104
    do
        ssh $i "cd /opt/module/azkaban/azkaban-exec/;bin/start-exec.sh"
    done
}

active-exec(){
    for i in hadoop102 hadoop103 hadoop104
    do
        ssh $i "curl -G '$i:12321/executor?action=activate' && echo"
    done
}

stop-exec(){
    for i in hadoop102 hadoop103 hadoop104
    do
        ssh $i "cd /opt/module/azkaban/azkaban-exec/;bin/shutdown-exec.sh"
    done
}

case $1 in
    start-exec)
        start-exec
    ;;
    active-exec)
        active-exec
    ;;
    stop-exec)
        stop-exec
    ;;
    start-web)
        start-web
    ;;
    stop-web)
        stop-web
    ;;
    start)
	echo "============启动executor============"
        start-exec
	sleep 5
	echo "============激活executor============"
        active-exec
	sleep 5
        echo "============启动webserver============"
	start-web
    ;;
    stop)
	echo "============关闭executor============"
        stop-exec
	sleep 5
	echo "============关闭webserver============"
        stop-web
    ;;
    *)
	echo 'Input args ERROR...'
esac

