
chcp 65001
echo 开始进行agent
java -Dfile.encoding=utf-8 -javaagent:C:\Users\dxs\Desktop\my-github\project\myAgent\target\myAgent-1.0-SNAPSHOT-jar-with-dependencies.jar=myAgent -jar C:\Users\dxs\Desktop\my-github\project\springcCoudDemo\target\spring.cloud-0.0.1-SNAPSHOT.jar
echo 启动完毕
pause