







# docker compose



## 1.docker compose

![image-20211218110839480](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218110839480.png)

容器的编排工具。



![image-20211218111738283](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218111738283.png)





https://docs.docker.com/compose/install/





## 2.compose入门

编写docker-comose.yml文件

![image-20211218114002779](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218114002779.png)

启动

docker-compose up

![image-20211218114049158](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218114049158.png)



## 3.docker-compose 模板

![image-20211218115056367](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218115056367.png)

### volume docker卷

![image-20211218115803339](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218115803339.png)

查看volume

![image-20211218115831775](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218115831775.png)



上面方式创建的卷，本机卷的目录放在默认的目录

![image-20211218120332423](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218120332423.png)

如果想自己制定自己的目录可以修改compose文件

加上external，制定目录为volumes/tomcatwebapps 

先定义volume，然后在service中引用

![image-20211218120150472](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218120150472.png)



创建对应目录，在启动docker-compse

![image-20211218120029775](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218120029775.png)



### network

比如创建两个tomcat在同一个网桥里面

![image-20211218122217320](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218122217320.png)



要指定外部网桥

![image-20211218122811061](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218122811061.png)



然后创建外部网桥，在启动

![image-20211218122845020](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218122845020.png)

查看网桥命令

`docker network ls`

### name

![image-20211218122326595](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218122326595.png)



docker使用exec执行，后面加个bash，进去容器执行一条命令，就退出



![image-20211218122513110](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218122513110.png)



### 案例 加一个mysql

可以根据我们原来的启动mysql命令来写

![image-20211218123925594](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218123925594.png)

编写compose文件：

![image-20211218123824675](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218123824675.png)



#### 加一个redis

命令模式

![image-20211218125302672](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218125302672.png)

compose

![image-20211218125403177](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218125403177.png)

#### 小结

![image-20211218132122789](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218132122789.png)



### 模板命令总结

参考 https://yeasy.gitbook.io/docker_practice/compose/compose_file



![image-20211218135257847](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218135257847.png)



## 4.compose的build指令

案例

![image-20211218140320212](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218140320212.png)





## compose命令

- up

​         docker-compse up xxx 指定服务启动，不加xxx就是全部启动

- down
- exec
- ps
- restart
- rm
- start
- stop
- top
- unpause

参考：https://yeasy.gitbook.io/docker_practice/compose/commands#up

![image-20211218141214357](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218141214357.png)



![image-20211218141319366](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218141319366.png)

![image-20211218142225740](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218142225740.png)

![image-20211218142249692](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218142249692.png)



## 5.docker可视化工具portainer



![image-20211218142407391](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218142407391.png)



![image-20211218144012005](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218144012005.png)



通过compose启动

![image-20211218144032235](/Users/changxiong/Downloads/资料/java高级/docker/docker-compse/compose.assets/image-20211218144032235.png)



https://docs.portainer.io/v/ce-2.9/start/install/server/docker/linux



