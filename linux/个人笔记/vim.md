# 1.安装vim

原生linux系统支持vi  是没有vim  如果没有vim就安装，vim是vi的 升级版

参考：

https://blog.csdn.net/loveyour_1314/article/details/83108142?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_baidulandingword-0&spm=1001.2101.3001.4242



i. 那么如何安裝 vim 呢?
输入rpm -qa|grep vim 命令, 如果 vim 已经正确安裝,会返回下面的三行代码:

```
root@server1 [~]``# rpm -qa|grep vim
vim-enhanced-7.0.109-7.el5
vim-minimal-7.0.109-7.el5
vim-common-7.0.109-7.el5
```

如果少了其中的某一条,比如 vim-enhanced 的,就用命令 yum -y install vim-enhanced 来安裝:

```
yum -y ``install ``vim-enhanced
```

如果上面的三条一条都沒有返回, 可以直接用 yum -y install vim* 命令

```
yum -y ``install ``vim*
```



# 常用命令



Set nu 显示行号



#  查看日志

**例如搜索 the写法：/the   +回车**

1. /+关键字 ，回车即可。此为从文档当前位置向下查找关键字，按n键查找关键字下一个位置；
2. ?+关键字，回车即可。此为从文档挡圈位置向上查找关键字，按n键向上查找关键字；



### 1.动态查看日志

- tailf 总是从文件开头一点一点的读， 而 `tail -f` 则是从文件尾部开始读。
- tailf check 文件增长时，使用的是文件名，用 stat 系统调用；而 `tail -f` 则使用的是已打开的文件描述符。注：tail 也可以做到类似跟踪文件名的效果；
- 但是tail总是使用fstat系统调用，而不是stat系统调用；结果就是：默认情况下，当tail的文件被偷偷删除时，tail是不知道的，而tailf是知道的



**一、tail命令语法**

tail [ -f ] [ -c Number | -n Number | -m Number | -b Number | -k Number ] [ File ]
参数解释：
-f 该参数用于监视File文件增长。
-c Number 从 Number 字节位置读取指定文件
-n Number 从 Number 行位置读取指定文件。
-m Number 从 Number 多字节字符位置读取指定文件，比方你的文件假设包括中文字，假设指定-c参数，可能导致截断，但使用-m则会避免该问题。
-b Number 从 Number 表示的512字节块位置读取指定文件。
-k Number 从 Number 表示的1KB块位置读取指定文件。
File 指定操作的目标文件名称
上述命令中，都涉及到number，假设不指定，默认显示10行。Number前面可使用正负号，表示该偏移从顶部还是从尾部開始计算。
tail可运行文件一般在/usr/bin/以下。



常用 ：

- tail -f -n 40 aa.text 

- 查看tomcat日志
  tail -f catalina.out
  就可以查看Linux下启动tomcat时隐藏的输出日志，但是只能查看最后10行，ctrl+c可以退出

  查看具体哪天的启动日志可以用 sh startup.sh && tail -f ../logs/catalina.2018-08-29.log

1、查看日志 前 n行：
　　cat 文件名 | head -n 数量

　　demo：

　　　　cat  test.log | head -n 200　　# 查看test.log前200行

2、查看日志 尾 n行：
　　cat 文件名 | tail -n 数量

　　demo：

　　　　cat  test.log | tail -n 200　　# 查看test.log倒数200行



*方法一：***cat 路径/文件名 | grep 关键词**

　　demo：

　　　　cat test.log | grep "http"　　# 返回test.log中包含http的所有行





## 自动换行
只要在 /etc/vimrc中加上这两句就行了
set autoindent
set smartindent

