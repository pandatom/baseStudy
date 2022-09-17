

# 							css

# 1.字体



![image-20210419100122080](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419100122080.png)



# 2.选择器



![image-20210419100143712](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419100143712.png)![image-20210419100152350](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419100152350.png)

![image-20210419100202115](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419100202115.png)![image-20210419100210438](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419100210438.png)

![image-20210419100218935](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419100218935.png)![image-20210419100229213](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419100229213.png)

## CSS * 选择器

选择所有元素，并设置其背景色：

```css
*
{
background-color:yellow;
}
```

### 定义和用法

\* 选择器选择所有元素。

\* 选择器也可以选择另一个元素内的所有元素:

选择<div>元素内的所有元素：

```css
div *
{
background-color:yellow;
}
```





# 3.转换元素显示模式

![image-20210419100338207](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419100338207.png)







![image-20210419100444549](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419100444549.png)

## 块级元素和行内元素

标签分为两种等级：

​       1，行内元素。2，块级元素。

### 行内元素和块级元素的区别：

行内元素：　　

- 与其他行内元素并排
- 不能设置宽高，默认的宽度就是文字的宽度

块级元素：

- 霸占一行，不能与其他任何元素并列。
- 能接受宽高，如果不设置宽度，那么宽度将默认变为父级的100%。

### 块级元素和行内元素的分类：

　　在HTML的角度来讲，标签分为：

　　　　文本级标签：p , span , a , b , i , u , em

　　　　容器级标签：div , h系列 , li , dt ,dd

　　　　p：里面只能放文字和图片和表单元素，p里面不能放h和ul，也不能放p。

　　从CSS的角度讲，CSS的分类和上面的很像，就p不一样：

　　　　行内元素：除了p之外，所有的文本级标签，都是行内元素。p是个文本级标签，但是是个块级元素。

　　　　块级元素：所有的容器级标签，都是块级元素，以及p标签。



### 块级元素和行内元素的相互转换：

　　我们可以通过display属性将块级元素(比如div)和行内元素进行相互转换。

　　display：inline;

　　那么这个标签将变为行内元素，即：

　　　　1，此时这个div将不能设置宽度和高度了。

　　　　2，此时这个div可以和其他行内元素并排了。

　　同样的到了我们也可以用display将行内元素(比如span)转行成块级元素。

　　display：block；

　　那么这个span标签将变为块级标签，即：

　　　　1，此时这个span能够设置宽度，高度。

　　　　2，此时这个span必须独占一行，其他元素无法与之并排。

　　　　3，如果不设置宽度，将占满父级。

 

标准流里面的限制非常多，导致很多页面效果无法实现，如果我们现在就要并排，并且就要设置宽度，就hi有：脱离标准流。

CSS一共有三种手段，是一个元素脱离标准流文档：

- ## 浮动

- ## 绝对定位

- ## 固定定位

下面章节讲



# 4.三大特性

- 层叠性
- 继承性
- 优先级

![image-20210419105705220](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419105705220.png)

![image-20210419105744088](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419105744088.png)

![image-20210419105802500](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419105802500.png)

![image-20210419105823025](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419105823025.png)

![image-20210419105900205](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419105900205.png)



# 5.盒子模型

![image-20210419105942056](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419105942056.png)

![image-20210419105955590](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419105955590.png)![image-20210419110006978](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419110006978.png)

## ***\*边框\****

![image-20210419110038694](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419110038694.png)

![image-20210419110055655](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419110055655.png)![image-20210419110105696](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419110105696.png)![image-20210419110125379](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419110125379.png)

## ***\*内边距\****

![image-20210419110143379](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419110143379.png)![image-20210419110159658](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419110159658.png)![image-20210419110206839](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419110206839.png)![image-20210419110215204](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419110215204.png)![image-20210419110221538](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419110221538.png)![image-20210419110229846](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419110229846.png)

## ***\*外边距\****

![image-20210419110248365](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419110248365.png)

![image-20210419110258534](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419110258534.png)![image-20210419110307367](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419110307367.png)![image-20210419110324776](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419110324776.png)





# 6.浮动

![image-20210419110538473](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419110538473.png)

![image-20210419110608633](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419110608633.png)

![image-20210419110619574](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419110619574.png)

![image-20210419110634422](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419110634422.png)



## 1.浮动：

　　浮动是CSS里面布局最多的一个属性。

　　float：表示浮动的意思。

属性：

- none：表示不浮动，默认。
- left：表示左浮动。
- rigth：表示右浮动。

```css
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style>
        *{
            /*margin: 0;*/
        }
        .box1{
            width: 300px;
            height: 300px;
            background-color: red;
            float: left;
        }
        .box2{
            width: 400px;
            height: 400px;
            background-color: green;
            float: right;
        }
        span{
            float: left;
            width: 100px;
            height: 200px;
            background-color: yellow;
        }
    </style>
</head>
<body>
    <div class="box1"></div>
    <div class="box2"></div>
    <span>路飞</span>
</body>
</html>
```

![image-20210419111052557](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419111052557.png)





我们会发现，三个元素并排显示，.box1和span因为是左浮动，所有紧挨在一起，这种现象是贴边现象。

.box2盒子因为是右浮动，所以紧靠着右边。

### 浮动的四大特性：

　　1，浮动的的元素脱离标准流

　　2，浮动的元素互相贴靠。

　　3，浮动的元素由"子围"效果。

　　4，收缩的效果。

### 浮动元素的脱标：

　　脱标：就是脱离了标准文档流。

```css
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style>
        .box1{
            width: 200px;
            height: 200px;
            background-color: red;
            float: left;
        }
        .box2{
            width: 400px;
            height: 400px;
            background-color: yellow;
        }
        span{
            float: left;
            width: 300px;
            height: 50px;
            background-color: green;
        }
    </style>
</head>
<body>
    <div class="box1">小红</div>
    <div class="box2">小黄</div>
    <span>顾清秋</span>
    <span>顾清秋</span>
</body>
</html>

```



![image-20210419111440863](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419111440863.png)



效果：红色的盒子盖住了黄色的盒子，一个行内的span标签，竟然能够设置宽高了。

原因1：小红设置了浮动，而小黄并没有设置浮动，小红脱离了标准文档流，其实就是他不在页面中占据位置了，此时浏览器认为小黄是标准文档流的第一个盒子，所以就渲染到了页面中的第一个位置上，这种现象，也有一种叫法：浮动元素"飘起来了"。

原因2：所有的标签一旦设置浮动，就能够并排且不区分块元素或行内元素，换言之，能够设置宽高了。

### 浮动元素互相贴靠：

```css
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style>
        .box1{
            width: 100px;
            height: 400px;
            background-color: red;
            float: left;
        }
        .box2{
            width: 150px;
            height: 450px;
            float:     left;
            background-color: yellow;
        }
        .box3{
            width:     300px;
            height: 300px;    
            float:     left;
            background-color: green;
        }
    </style>
</head>
<body>
    <div class="box1">小红</div>
    <div class="box2">小黄</div>
    <div class="box3">小绿</div>
</body>
</html>


```



效果发现：如果父元素有足够的空间，那么小绿就会紧靠小黄，小黄紧靠小红，小红靠着边。

如果没有足够的空间，小绿那么就会靠着小红，若没有足够的空间靠着小红，就会自己靠边。



```css
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style>
        .box{
                    width: 300px;
                    border:1px solid black;        
        }
        .box1{
            width: 100px;
            height: 400px;
            background-color: red;
            float: left;
        }
        .box2{
            width: 150px;
            height: 450px;
            float:     left;
            background-color: yellow;
        }
        .box3{
            width:     80px;
            height: 300px;    
            float:     left;
            background-color: green;
        }
    </style>
</head>
<body>
    <div class="box">
        <div class="box1">小红</div>
        <div class="box2">小黄</div>
        <div class="box3">小绿</div>
    </div>
</body>
</html>
例子
```





效果发现：如果父元素有足够的空间，那么小绿就会紧靠小黄，小黄紧靠小红，小红靠着边。

如果没有足够的空间，小绿那么就会靠着小红，若没有足够的空间靠着小红，就会自己靠边。

```css
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style>
        .box{
                    width: 300px;
                    border:1px solid black;        
        }
        .box1{
            width: 100px;
            height: 400px;
            background-color: red;
            float: left;
        }
        .box2{
            width: 150px;
            height: 450px;
            float:     left;
            background-color: yellow;
        }
        .box3{
            width:     80px;
            height: 300px;    
            float:     left;
            background-color: green;
        }
    </style>
</head>
<body>
    <div class="box">
        <div class="box1">小红</div>
        <div class="box2">小黄</div>
        <div class="box3">小绿</div>
    </div>
</body>
</html>

```

![image-20210419141301429](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419141301429.png)

### 浮动元素字围效果：

```css
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <style>
        *{
            padding: 0;
            margin:0;
        }
        div{
            float:     left;    
        }
        p{
            background-color: #    666;
        }
    </style>
</head>
<body>
    <div class="d1"><img src="    ../../images/1.jpg" alt="图片"></div>
    <p style="font-size:34px" >顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋</p>
</body>
</html>
```



![image-20210419141352715](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419141352715.png)





效果发现：所谓的字围效果，当div浮动，p不浮动，div遮盖了p,div的层级提高，但是p中的文字不会被遮盖，此时就形成了字围效果。

### 浮动元素紧凑效果：

　　收缩：一个浮动元素，如果没有设置width，那么就自动收缩为文字的宽度。（和行内元素很像）

```css
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>紧凑效果</title>
    <style>
        div{
            float: left;
            background-color: red;
        }
    </style>
</head>
<body>
    <div>顾清秋</div>
</body>
</html>

```

![image-20210419142949501](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419142949501.png)



## 2.清除浮动



**谨记：关于浮动，一定要遵循一个原则，永远不是一个盒子单独浮动，要浮动就要一起浮动。另外，有浮动，一定要清楚浮动。**

![image-20210419143141273](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419143141273.png)

### 为什么要清楚浮动：

　　在页面布局的时候，每个结构中的父元素的高度，我们一般不会设置。

　　大家想，如果我第一版的页面的写完了，感觉非常爽，突然隔了一个月，老板说页面某一块的区域，我要加点内容，或者我觉得图片要缩小一下。这样的需求在工作中非常常见的。真想打他啊。那么此时作为一个前端小白，肯定是去每个地方加内容，改图片，然后修改父盒子的高度。那问题来了，这样不影响开发效率吗？答案是肯定的。



```css
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style>
        *{
            padding: 0;
            margin: 0;
        }
        .father{
            width: 1126px;
            /*子元素浮动，父级一般不设置高度*/
        }
        .box1{
            width: 200px;
            height: 500px;
            float: left;
            background-color: red;
        }
        .box2{
            width: 300px;
            height: 200px;
            float: left;
            background-color: green;
        }
        .box3{
            width: 400px;
            height: 100px;
            float: left;
            background-color: blue;
        }
        .father{
            width: 1126px;
            height: 600px;
            background-color: purple;
        }
    </style>
</head>
<body>
    <div class="father">
        <div class="box1"></div>
        <div class="box2"></div>
        <div class="box3"></div>
    </div>
    <div class="father2"></div>
</body>
</html>


```

![image-20210419145006306](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419145006306.png)



效果发现：如果不给.father一个高度，那么浮动子元素是不会填充父盒子的高度，那么.father2的盒子就会占据第一个位置，影响页面布局。

那么我们知道，浮动元素确实能实现我们页面元素并排的效果，这是它的好处，同时它还带来了页面布局极大的错乱！！！所以我们要清除浮动！



#### 清除浮动的方法：

　　1，给父盒子设置高度。

　　2，clear：both;

　　3，伪元素清除法

　　4，overflow：hidden；

#### 给父盒子设置高度：

　　使用不灵活，会固定父盒子的高度。

#### clear：both；

　　clear：意思就是清楚的意思。

　　有三个值：

　　left：当前元素左边不允许有浮动元素，

　　rigtht：当前元素右边不允许有浮动元素。

　　both：当前元素的左右两边都不允许有浮动元素。

　　给浮动元素后面加一个空的div，并且该元素不浮动，然后设置clear：both。



```css
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style>
        *{
            padding: 0;
            margin: 0;
        }
        ul{
            list-style: none;
        }
        div{
            width: 400px;
        }
        div ul li{
            float: left;
            width: 100px;
            height: 40px;
            background-color:red;
        }
        .clear{
            width: 200px;
            height: 200px;
            background-color: yellow;
            clear:both;
        }
    </style>
</head>
<body>
    <div>
        <ul>
            <li>python</li>
            <li>web</li>
            <li>linux</li>
        </ul>
    </div>
    <div class="clear"></div>
</body>
</html>
例子
```

![image-20210419145629476](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419145629476.png)

## 伪元素清除法(常用)：

　　给浮动子元素的父盒子，也就是不浮动元素，添加一个clearfix的类，然后设置：



```css
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style>
        *{
            padding: 0;
            margin: 0;
        }
        ul{
            list-style: none;
        }
        div{
            width: 400px;
        }
        div ul li{
            float: left;
            width: 100px;
            height: 40px;
            background-color:red;
        }
        .clear{
            width: 200px;
            height: 200px;
            background-color: yellow;
            /*clear:both;*/
        }
        .clearfix:after{
            content: '.';
            height: 0;
            clear:both;
            display: block;
            visibility: hidden;
        }
    </style>
</head>
<body>
    <div class="clearfix">
        <ul>
            <li>python</li>
            <li>web</li>
            <li>linux</li>
        </ul>
    </div>
    <div class="clear"></div>
</body>
</html>
例子
```



![image-20210419145540042](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419145540042.png)

## overflow:hidden(常用)：

　　overflow属性规定当内容溢出元素框时，发生的事情。

　　属性值：

　　visible：默认值，内容不会被修剪，会呈现在元素框之外。

　　hidden：内容会被修剪，并且其余内容是不可见的。

　　scroll：内容会被修剪，但是浏览器会显示滚动条以便查看其余的内容。

　　auto：如果内容被修剪，则浏览器会显示滚动条以便利查看其余内容。

　　inherit：规定应该从父元素继承overflow属性的值。

```css
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style>
        body{
            overflow: scroll;
        }
        div{
            width: 100px;
            height: 100px;
            overflow: inherit;
        }
    </style>

</head>
<body>
    <div>顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋顾清秋</div>
</body>
</html>

例子
```





# 7 定位

<img src="/Users/changxiong/Downloads/资料/typora-user-images/image-20210419152215621.png" alt="image-20210419152215621" style="zoom:50%;" />

![image-20210419152239289](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419152239289.png)

![image-20210419152317718](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419152317718.png)![image-20210419152326733](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419152326733.png)

![image-20210419152336819](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419152336819.png)

## 相对定位

![image-20210419152405497](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419152405497.png)



相对定位元素不可层叠，依据left、right、top、bottom等属性在正常文档流中偏移自身位置。同样可以用z-index分层设计。

```html
<head>
	<style type="text/css">
		.box {
			background: red;
			width: 100px;
			height: 100px;
			float: left;
			margin: 5px;
		}
		.two {
			position: relative;
			top: 50px;
			left: 50px;
		}
	</style>
</head>
<body>
	<div class="box" >One</div>
	<div class="box  two" >Two</div>
	<div class="box" >Three</div>
	<div class="box">Four</div>
</body>
```



将class="two"的div定位到距离它本来位置的顶部和左侧分别50px的位置。不会改变其他元素的布局，会在此元素本来位置留下空白。

![image-20210419172205003](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419172205003.png)









## 绝对定位

![image-20210419152525007](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419152525007.png)

绝对定位的元素从文档流中拖出，使用left、right、top、bottom等属性相对于其最接近的一个最有定位设置的父级元素进行绝对定位，如果元素的父级没有设置定位属性，则依据 body 元素左上角作为参考进行定位。绝对定位元素可层叠，层叠顺序可通过 z-index 属性控制，z-index值为无单位的整数，大的在上面，可以有负值。

绝对定位的定位方法：如果它的父元素设置了除static之外的定位，比如position:relative或position:absolute及position:fixed，那么它就会相对于它的父元素来定位，位置通过left , top ,right ,bottom属性来规定，如果它的父元素没有设置定位，那么就得看它父元素的父元素是否有设置定位，如果还是没有就继续向更高层的祖先元素类推，总之它的定位就是相对于设置了除static定位之外的定位的第一个祖先元素，如果所有的祖先元素都没有以上三种定位中的其中一种定位，那么它就会相对于文档body来定位（并非相对于浏览器窗口，相对于窗口定位的是fixed）。



```css
<head>
	<style type="text/css">
		.box {
			background: red;
			width: 100px;
			height: 100px;
			float: left;
			margin: 5px;
		}
		.two {
			position: absolute;
			top: 50px;
			left: 50px;
		}
	</style>
</head>
<body>
	<div class="box" >One</div>
	<div class="box  two" >Two</div>
	<div class="box" >Three</div>
	<div class="box">Four</div>
</body>
```





![image-20210419171957104](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419171957104.png)







## 固定定位

![image-20210419152547116](/Users/changxiong/Downloads/资料/typora-user-images/image-20210419152547116.png)

CSS中的定位使用来布局的熟练应用对页面美化有很好的帮助，下面就进行详细介绍：定位分为静态定位，相对定位，绝对定位，固定定位这四种，定位有不同的参数，例如：left、right、top、bottom、z-index等。



固定定位与绝对定位类似，但它是相对于浏览器窗口定位，并且不会随着滚动条进行滚动。

固定定位的最常见的一种用途是在页面中创建一个固定头部、固定脚部或者固定侧边栏，不需使用margin、border、padding。



## 1、静态定位（static）

一般的标签元素不加任何定位属性都属于静态定位，在页面的最底层属于标准流。



## 2、绝对定位vs相对定位

绝对定位好像把不同元素安排到了一栋楼的不同楼层(除首层，文本流放在首层)，它们之间互不影响；相对定位元素在首层，与文本流一起存放，它们之间互相影响。

被设置了绝对定位的元素，在文档流中是不占据空间的，如果某元素设置了绝对定位，那么它在文档流中的位置会被删除，它浮了起来，其实设置了相对定位也会让元素浮起来，但它们的不同点在于，相对定位不会删除它本身在文档流中占据的空间，其他元素不可以占据该空间，而绝对定位则会删除掉该元素在文档流中的位置，使其完全从文档流中抽了出来，其他元素可以占据其空间，可以通过z-index来设置它们的堆叠顺序 。