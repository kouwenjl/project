#!/bin/bash
#source /etc/profile
project_name="ycmp-register-0.0.1-SNAPSHOT"
project_jar="${project_name}.jar"
project_log="${project_name}.log"
project_path=/dxs
project_port=10010
jvm_opts="-Xms512m -Xmx512m -Xss1204k"

usage() {
 echo "Usage: sh $0 [start|stop|restart|status]"
 exit 1
}

#检查程序是否在运行
is_exist(){
 pid=`ps -ef|grep $project_jar|grep -v grep|awk '{print $2}' `
 #如果不存在返回1，存在返回0 
 if [ -z "${pid}" ]; then
 return 1
 else
 return 0
 fi
}
  
#启动
start(){
 is_exist
 if [ $? -eq "0" ]; then
 echo "${project_name} is already running. Pid is ${pid}."
 else
 echo "${project_name} starting......"
 nohup java -jar  $jvm_opts $project_path/$project_jar > $project_path/lanch/$project_log 2>&1 &
#tail -f $project_path/$project_log
 
 is_pid=`lsof -i:$project_port|grep "LISTEN"|awk '{print $2}'`
 is_exist
 is_ok=$?

 until [ -n "$is_pid" ] || [ "$is_ok" != "0" ] 
    do
      is_pid=`lsof -i:$project_port|grep "LISTEN"|awk '{print $2}'`
      is_exist
      is_ok=$?      
   done
 if [ "$is_ok" -eq "0" ]; then
 echo "${project_name} starting success"    
 else
 echo "${project_name} starting failed"
  fi
#  cat $project_path/lanch/$project_log|grep -i 'exception' -B 2 -C 2 
fi
}

#停止
stop(){
 is_exist
 if [ $? -eq "0" ]; then
 echo "${project_name} Stop."
 kill -15 $pid
 else
 echo "${project_name} is not running."
 fi
}
  
#输出运行状态
status(){
 is_exist
 if [ $? -eq "0" ]; then
 echo "${project_name} is running. Pid is ${pid}."
 else
 echo "${project_name} is not running."
 fi
}
  
#重启
restart(){
 stop
 sleep 3
 start
}
  
#根据输入参数，选择执行对应方法，不输入则执行使用说明
case "$1" in
 "start")
 start
 ;;
 "stop")
 stop
 ;;
 "status")
 status
 ;;
 "restart")
 restart
 ;;
 *)
 usage
 ;;
esac
