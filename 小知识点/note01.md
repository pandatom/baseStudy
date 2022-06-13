# 小知识总结：

# mac m1 brew安装

  https://zhuanlan.zhihu.com/p/341831809

# vue-ls

  https://www.jianshu.com/p/ab7f67878279



# git冲突解决

https://blog.csdn.net/xiaoxuelilei/article/details/51014672



# cookie和localStorage

cookie和localStorage都受同源策略的限制
  在同一浏览器的相同域名、不同端口号下，
  cookie可以共享
  localStorage不可以共享



# 1.单列如何保证线程安全

  类加载的时候就实列化了，一个现场拿到，另一个线程就只能阻塞等待
  如果是懒加载，形式两个线程会抢占去new单列对象，可能会出现问题

# 2.引用方式

  3.使用格式: 类(或对象) :: 方法名
  4.具体分为如下的三种情况:
  对象::非静态方法
  类::静态方法
  类::非静态方法

# 3.部署

linux：
1.mvn clean install -Dmaven.test.skip=true
2.拷贝到指定目录
3.nohup java -jar xxx.jar &   



nohup java -jar xxxxx.jar
nohup:表示当ssl登录用户退出的时候程序任然运行
lsof -i:9090  查看端口
Linux命令行下杀死一个进程：
1. top查看 可以实时动态地查看系统的整体运行情况
2. 查看端口 lsof -i：8080
3. ps -aux | grep ***
    aux选项如下所示：
    a-显示所有用户的进程
    u-显示进程的用户和拥有者
    x-显示不依附于终端的进程
    kill SIGNAL PID --SIGNAL 是要发送的信号，PID是进程号
    kill -9 14992 --9 发出杀死信号
    killall -9 python  --如果有多个python程序在运行，想要全部结束的话  



# window下关闭端口：

​    C:\Users\helloworld>netstat -ano|findstr "9097"

    TCP    0.0.0.0:9097           0.0.0.0:0              LISTENING       6832
    TCP    [::]:9097              [::]:0                 LISTENING       6832
    
    关闭对应pid
    -F 强制关闭
    
    C:\Users\helloworld>taskkill  -F -PID 6832
    成功: 已终止 PID 为 6832 的进程。