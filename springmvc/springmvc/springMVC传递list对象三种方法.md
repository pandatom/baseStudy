# springMVC传递list对象三种方法

参考：https://blog.csdn.net/qq_40428665/article/details/84556902

前言
概念
      1.ajax请求里Content-type2个常用类型
      JSON对象和JSON字符串
      dataType与contentType
      对象复杂度
dispatchServlet-mvc.xml配置
最简单：单个数组对象和key-value就比较简单了
      前端
      后端
稍微复杂：只接收对象数组
      前端
      后端
最复杂：对象数组与key-value一起传
      前端
      后台

# 前言

springMVC接收List对象以及List对象与其它对象一起传参数的使用方法

# 概念

## 1.ajax请求里`Content-type`2个常用类型

- `application/x-www-form-urlencoded`：传递的`key/value`会经过URL转码，所以如果传递的参数存在中文或者特殊字符需要注意。 
  默认编码方式。

```java
//例子



//b=曹,a=1



POST  HTTP/1.1(CRLF)



Host: www.example.com(CRLF)



Content-Type: application/x-www-form-urlencoded(CRLF)



Cache-Control: no-cache(CRLF)



(CRLF)



b=%E6%9B%B9&a=1(CRLF)



//这里b参数的值"曹"因为URL转码变成其他的字符串了
```

-`application/json`:`application/json用来告诉服务端消息主体是序列化后的 JSON 字符串`,重点是使用JSON.stringify(data)将json对象转化是json字符串。

JSON对象和JSON字符串

在使用@RequestBody注解时，在SpringMVC环境中，@RequestBody接收的是一个Json对象的字符串，而不是一个Json对象。然而在ajax请求往往传的都是Json对象，用 JSON.stringify(data)的方式就能将对象变成字符串。同时ajax请求的时候也要指定dataType: "json",contentType:"application/json" 这样就可以轻易的将一个对象或者List传到Java端。 

@RequestBody与contentType:"application/json"必需配合使用，且数据是字符串。

## dataType与contentType

`contentType`：指定向后台传递数据编码格式 
`dataType`：指定后台返回数据格式

## 对象复杂度

传单个key-value，或基本类型的数组最简单，稍微复杂一点的是传对象数组(`[object]`)，最复杂的是对象数组与key-value一起传到后台

# dispatchServlet-mvc.xml配置

```java
<bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping"></bean>



    <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter">



        <property name="messageConverters">



            <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter"></bean>



        </property>



    </bean>
```

或者更简单的写法

```java
<mvc:annotation-driven/> 
```

# 最简单：单个数组对象和key-value就比较简单了

## 前端

```javascript
$("#test").click(function(){



    var testData={"nameIds": [1,2,3], "age": 18}



    $.ajax({



        type:"POST",



        url: basePath + "/test/testInOut",



        dataType:"json",



        contentType:"application/x-www-form-urlencoded", // 指定这个协议很重要



        data:faultList, //只有这一个参数，json格式，后台解析为实体，后台可以直接用



        success:function(data){



        }



    });



})
```

重点

- `contentType:"application/x-www-form-urlencoded"`，一般使用这个当然我们也可以使用`application/json`(它需要序列化json数据)

# 后端

```java
//controller层



 



 @RequestMapping(value = "/test/testInOut")



 @ResponseBody



 public void testInOut(Integer[] nameIds, Integer age){ 



      System.out.println(nameIds, age) ;



 }
```

重点

- `Integer[] nameIds`：接收数组

# 稍微复杂：只接收对象数组

下面要使用到的pojo类

```java
//POJO对象传输对象   RepairFaultList.java



public class RepairFaultList{



    private Integer id;



    private String faultName;//故障名称



    private String employeeGroup;//所属工组



    //getter  setter



}
```

下面还会使用`RepairFaultList.java`,需要传递的结构体。

## 前端

```javascript
$("#test").click(function(){



     //对象数组



     var faultList=[];



     var data1={id:1,"faultName":"机电有问题","employeeGroup":"机电"};



     var data2={id:2,"faultName":"钣金有问题","employeeGroup":"钣金"};



     faultList.push(data1);



     faultList.push(data2);



    $.ajax({



        type:"POST",



        url: basePath + "/test/testInOut",



        dataType:"json",



        contentType:"application/json", // 指定这个协议很重要



        data:JSON.stringify(faultList), //只有这一个参数，json格式，后台解析为实体，后台可以直接用



        success:function(data){



        }



    });



})
```

重点

- `contentType:"application/json"`
- `JSON.stringify(faultList)`

这里传入的是一个数组，直接使用`JSON.stringify(faultList)`序列化数据，不是`{"faultList":faultList}`，相应的后端接收数据的地方也只有一个参数。

## 后端

```java
//controller层



 @RequestMapping(value = "/test/testInOut", method = {RequestMethod.POST })



 @ResponseBody



 public void testInOut( @RequestBody List<RepairFaultList> faultList ){ 



 //此时的faultList是map数据，并没有解析为bean // 不建议使用



      System.out.println(users) ;



 }



 



//使用如下方法，可以使用bean



 @RequestMapping(value = "/test/testInOut", method = RequestMethod.POST)



 @ResponseBody



 public void testInOut( @RequestBody RepairFaultList[] faultList ){ 



     // 此时的faultList是实体bean



      System.out.println(users.getName()) ; 



 }
```

重点

- `RepairFaultList[]或List<RepairFaultList>`
- `method=RequestMethod.POST`,指定post请求方式
- `@RequestBody`
- 注意faultList是随机命名，没要求。

还有种不需要POJO对象的写法，比较另类，代码如下

```java
//前端同上



//controller层



 @RequestMapping(value = "/test/testInOut", method = RequestMethod.POST)



 @ResponseBody



 public void testInOut( @RequestBody List<Map<String,String>> faultList ){ // spring MVC只能解析外层的json格式，内部的bean转化为Map格式的键值对，需要对map解析



      List<RepairFaultList> result = new ArrayList<RepairFaultList>();



      for(Map<String,String> map : faultList){



          RepairFaultList u = new RepairFaultList();



          //一系列get  set数据



      }



     // 这里就可以使用 result 了



 }
```

# 最复杂：对象数组与key-value一起传

使用`@RequestBody与json`一起操作，上面说过，`application/json`用来告诉服务端消息主体是序列化后的 JSON 字符串。

## 前端

```javascript
 //基本数据类型数组对象



     var operatorIds = [1,2,3];



     //对象数组



      var faultList=[];



      var data1={id:1,"faultName":"机电有问题","employeeGroup":"机电"};



      var data2={id:2,"faultName":"钣金有问题","employeeGroup":"钣金"};



      faultList.push(data1);



      faultList.push(data2);



      var testData={operatorIds:operatorIds,repairBillId: 110,faultList: faultList};



      $.ajax({



          type:"POST",



          url: basePath + "/test/testInOut",



          dataType:"json",



          contentType: application/json,



          data:JSON.stringify(testData), //只有这一个参数，json格式，后台解析为实体，后台可以直接用



          success:function(data){



          }



      });



  })
```

重点

- `contentType: application/json`，指定数据编码格式
- `JSON.stringify(testData)`序列化数据，字符串

## 后台

 

```java
//POJO对象   创建一个对象由于存放key-value和对象数组  AppointPrePersonRo.java



public class AppointPrePersonRo {



    private Integer[] operatorIds;



    private List<RepairFaultList> faultList;



    private Integer repairBillId;



    //getter setter



}



 



//controller层



@RequestMapping(value = "/test/testInOut")



@ResponseBody



 public String testInOut(@RequestBody  AppointPrePersonRo appointPrePersonRo) {



         return "sucess";



     }



 }
```

 这样就可以接收对象数组和key-value混合的数据。 
重点 
\- 创建`AppointPrePersonRo`类，由于保存接收的数据对象 
\- `@RequestBody`注解，必需与`application/json`配合使用