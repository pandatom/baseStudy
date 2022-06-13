# 									linux网络

## 1.修改网卡

### 网卡配置文件

配置文件目录：/etc/sysconfig/network-scripts./ifefg-ens33
配置管理命令：ifconfig/ip address show
配置文件内容：

```conf
DEVICE=ens33  			 #设备名称
NAME=ens33   		 	 #网卡名称
BOOTPROTO=static  	 #连接方式（dhcp/static）
ONBOOT=yes          	 #是否开机加载
IPADDR=192.168.12.250	#IP地址
NETMASK=255.255.255.0	#子网掩码(PREFIX=24
GATEWAY=192.168.12.1	#网关
DNS1=8.8.8.8	#DNS
```

注意：**网卡配置文件内，选项要大写，小写不报错，但不生效，参数可小写**

![image-20220316143033800](/Users/changxiong/Desktop/linux网络.assets/image-20220316143033800.png)



### 修改网卡名

》修改网卡配置文件名（建议将原配置文件备份）
cp -a ifcfg-ens33 ifcfg-ethO
>修改网卡配置文件内容
>NAME=etho
>DEVICE=eth0
>》修改grub配置文件
>vi /etc/default/grub
>GRUB_CMDLINE LINUX=“
>crashkernel=auto rhgb quiet net.ifnames=0 biosdevname=0"#在指定位置新增红色参数，关闭一致性命名规则
>更新grub配置文件，并加载新的参数
>grub2-mkconfig -o /boot/grub2/grub.cfg
>》重启操作系统
>reboot

![image-20220316143702809](/Users/changxiong/Desktop/linux网络.assets/image-20220316143702809.png)





# 网络地址和物理地址

![image-20220316144602186](/Users/changxiong/Desktop/linux网络.assets/image-20220316144602186.png)





![image-20220316151531963](/Users/changxiong/Desktop/linux网络.assets/image-20220316151531963.png)



![image-20220316151613455](/Users/changxiong/Desktop/linux网络.assets/image-20220316151613455.png)



![image-20220316151918132](/Users/changxiong/Desktop/linux网络.assets/image-20220316151918132.png)



![image-20220316155937812](/Users/changxiong/Desktop/linux网络.assets/image-20220316155937812.png)







## 网络常见命令

![image-20220316160512415](/Users/changxiong/Desktop/linux网络.assets/image-20220316160512415.png)





![image-20220316191521338](/Users/changxiong/Desktop/linux网络.assets/image-20220316191521338.png)



![image-20220316191546879](/Users/changxiong/Desktop/linux网络.assets/image-20220316191546879.png)



![image-20220316194231449](/Users/changxiong/Desktop/linux网络.assets/image-20220316194231449.png)





![image-20220316194335088](/Users/changxiong/Desktop/linux网络.assets/image-20220316194335088.png)



![image-20220316194420005](/Users/changxiong/Desktop/linux网络.assets/image-20220316194420005.png)





