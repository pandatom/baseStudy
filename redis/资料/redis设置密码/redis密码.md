# redis密码

可以使用密码启动 Redis 服务器。使用的命令是：

```bash
redis-server --requirepass mypassword
```

本文介绍在容器中对 Redis 添加密码的方法。



### Docker 设置密码

```bash
docker run --name myredis -p 6379:6379 -d redis --requirepass "mypassword"
```

### docker-compose 设置密码

```yaml
services:
  redis:
    container_name: 'myredis'
    image: 'redis'
    restart: always
    ports:
      - 6379:6379
    command: redis-server --requirepass mypassword
```



## 配置文件修改

![image-20220309160552809](/Users/changxiong/Library/Application Support/typora-user-images/image-20220309160552809.png)

登录

![image-20220309160614376](/Users/changxiong/Library/Application Support/typora-user-images/image-20220309160614376.png)





参考地址

https://www.cnblogs.com/wmpblogs/p/7134414.html

https://jueee.github.io/2021/03/2021-03-14-Docker%E5%90%AF%E5%8A%A8Redis%E5%B9%B6%E6%B7%BB%E5%8A%A0%E5%AF%86%E7%A0%81/

https://blog.csdn.net/weixin_30527143/article/details/101093269