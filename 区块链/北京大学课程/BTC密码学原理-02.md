# BTC 密码学原理





**比特币用到密码学的两个功能：1.哈希 2.签名**

## 1.哈希

**Collision resistance** 哈希碰撞

比如x!=y,但是H(x)=H(y), 就是x和y通过H方法，结果是同一个哈希值，这就是哈希碰撞



**Hiding:**哈希函数的方向是单方向的;



Digital commitment 也叫 digital equivalent of sealed envelope.

公布预测结果的列子

x-->H(x) 预测结果是x，加密为H(x)公布出去；等结果出来，那结果加密，如果预测的H(x)相等，就等于预测正确。



**puzzle friendly** :difficlt to savle,easy to verify



比特币用到的加密 Sha-256: secre hash algorithm





## 2.签名

现有系统，开户需要去银行开户；但是比特币是去中心化的。

比特币的如何开户：每个用户自己决定开户，不需要别人批准，开户过程很简单，就是创建一个公钥私钥的过程

public key，private key



公私钥：asymmetric encryption algorithom 来源于非对称加密



非对称加密用于签名使用，签名使用私钥，验证签名用公钥

比如我转比特币给别人，我会对我转的钱用我的私钥签名，别人要验证，这个钱是不是我转的，可以使用公钥验证



a good source of randomness:一个好的随机原，公私钥需要好的随机原，不然容易被别人猜出公私钥。























