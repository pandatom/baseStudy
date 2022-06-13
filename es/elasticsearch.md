# elasticsearch

# 1.如何保证并发的问题的

![image-20220315213010842](/Users/changxiong/Downloads/GIT-STUDY/baseStudy/es/elasticsearch.assets/image-20220315213010842.png)





# 4.重建索引

![image-20220315213021252](/Users/changxiong/Downloads/GIT-STUDY/baseStudy/es/elasticsearch.assets/image-20220315213021252.png)

![image-20220315213031134](/Users/changxiong/Downloads/GIT-STUDY/baseStudy/es/elasticsearch.assets/image-20220315213031134.png)

![image-20220315213056887](/Users/changxiong/Downloads/GIT-STUDY/baseStudy/es/elasticsearch.assets/image-20220315213056887.png)

![image-20220315213107981](/Users/changxiong/Downloads/GIT-STUDY/baseStudy/es/elasticsearch.assets/image-20220315213107981.png)

![image-20220315213117412](/Users/changxiong/Downloads/GIT-STUDY/baseStudy/es/elasticsearch.assets/image-20220315213117412.png)

![image-20220315213129586](/Users/changxiong/Downloads/GIT-STUDY/baseStudy/es/elasticsearch.assets/image-20220315213129586.png)





# docker操作es



![image-20220315213213050](/Users/changxiong/Downloads/GIT-STUDY/baseStudy/es/elasticsearch.assets/image-20220315213213050.png)



docker安装es

https://www.elastic.co/guide/en/elasticsearch/reference/current/setup.html



![image-20220315213235072](/Users/changxiong/Downloads/GIT-STUDY/baseStudy/es/elasticsearch.assets/image-20220315213235072.png)

![image-20220315213247301](/Users/changxiong/Downloads/GIT-STUDY/baseStudy/es/elasticsearch.assets/image-20220315213247301.png)



Create a `docker-compose.yml` file:



```yml
version: '2.2'
services:
  es01:
    image: docker.elastic.co/elasticsearch/elasticsearch:7.15.1
    container_name: es01
    environment:
      - node.name=es01
      - cluster.name=es-docker-cluster
      - discovery.seed_hosts=es02,es03
      - cluster.initial_master_nodes=es01,es02,es03
      - bootstrap.memory_lock=true
      - "ES_JAVA_OPTS=-Xms512m -Xmx512m"
    ulimits:
      memlock:
        soft: -1
        hard: -1
    volumes:
      - data01:/usr/share/elasticsearch/data
    ports:
      - 9200:9200
    networks:
      - elastic
  es02:
    image: docker.elastic.co/elasticsearch/elasticsearch:7.15.1
    container_name: es02
    environment:
      - node.name=es02
      - cluster.name=es-docker-cluster
      - discovery.seed_hosts=es01,es03
      - cluster.initial_master_nodes=es01,es02,es03
      - bootstrap.memory_lock=true
      - "ES_JAVA_OPTS=-Xms512m -Xmx512m"
    ulimits:
      memlock:
        soft: -1
        hard: -1
    volumes:
      - data02:/usr/share/elasticsearch/data
    networks:
      - elastic
  es03:
    image: docker.elastic.co/elasticsearch/elasticsearch:7.15.1
    container_name: es03
    environment:
      - node.name=es03
      - cluster.name=es-docker-cluster
      - discovery.seed_hosts=es01,es02
      - cluster.initial_master_nodes=es01,es02,es03
      - bootstrap.memory_lock=true
      - "ES_JAVA_OPTS=-Xms512m -Xmx512m"
    ulimits:
      memlock:
        soft: -1
        hard: -1
    volumes:
      - data03:/usr/share/elasticsearch/data
    networks:
      - elastic

volumes:
  data01:
    driver: local
  data02:
    driver: local
  data03:
    driver: local

networks:
  elastic:
    driver: bridge
```





# docker

![image-20220315213359282](/Users/changxiong/Downloads/GIT-STUDY/baseStudy/es/elasticsearch.assets/image-20220315213359282.png)

![image-20220315213412128](/Users/changxiong/Downloads/GIT-STUDY/baseStudy/es/elasticsearch.assets/image-20220315213412128.png)

![image-20220315213422772](/Users/changxiong/Downloads/GIT-STUDY/baseStudy/es/elasticsearch.assets/image-20220315213422772.png)



![image-20220315213435313](/Users/changxiong/Downloads/GIT-STUDY/baseStudy/es/elasticsearch.assets/image-20220315213435313.png)





# docker网络

![image-20220315213456161](/Users/changxiong/Downloads/GIT-STUDY/baseStudy/es/elasticsearch.assets/image-20220315213456161.png)

![image-20220315213506136](/Users/changxiong/Downloads/GIT-STUDY/baseStudy/es/elasticsearch.assets/image-20220315213506136.png)



查看 docker网络  

![image-20220315213522831](/Users/changxiong/Downloads/GIT-STUDY/baseStudy/es/elasticsearch.assets/image-20220315213522831.png)





![image-20220315213534270](/Users/changxiong/Downloads/GIT-STUDY/baseStudy/es/elasticsearch.assets/image-20220315213534270.png)



![image-20220315213549212](/Users/changxiong/Downloads/GIT-STUDY/baseStudy/es/elasticsearch.assets/image-20220315213549212.png)

![image-20220315213601736](/Users/changxiong/Downloads/GIT-STUDY/baseStudy/es/elasticsearch.assets/image-20220315213601736.png)

# docker  compse

![image-20220315213632208](/Users/changxiong/Downloads/GIT-STUDY/baseStudy/es/elasticsearch.assets/image-20220315213632208.png)

https://docs.docker.com/engine/reference/builder/

安装 docker compose

![image-20220315213656084](/Users/changxiong/Downloads/GIT-STUDY/baseStudy/es/elasticsearch.assets/image-20220315213656084.png)



安装

![image-20220315213712062](/Users/changxiong/Downloads/GIT-STUDY/baseStudy/es/elasticsearch.assets/image-20220315213712062.png)

![image-20220315213723143](/Users/changxiong/Downloads/GIT-STUDY/baseStudy/es/elasticsearch.assets/image-20220315213723143.png)

![image-20220315213752352](/Users/changxiong/Downloads/GIT-STUDY/baseStudy/es/elasticsearch.assets/image-20220315213752352.png)







# 面试

### elasticsearch 基础 —— nested嵌套类型

[链接](https://blog.51cto.com/u_15316394/3215885)

​    保存的时候指定类型是嵌入式属性



###    字符串类型是哪个

   https://blog.csdn.net/ahwsk/article/details/101272455 

###    nested类型是什么

​     https://blog.51cto.com/u_15316394/3215885


###    创建es的索引、时间类型怎么存的 

   https://zhuanlan.zhihu.com/p/34240906





























