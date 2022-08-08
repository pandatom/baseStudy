https://blog.csdn.net/wangmx1993328/article/details/84766806

   如同 JSP 中 JSTL 的 <c:set var="j" value="${1}"/> 标签可以用于设置变量值和对象属性一样，Thymeleaf 中可以使用 th:with 进行指定局部变量，局部变量是指定义在模版⽚段中的变量，并且该变量的作⽤域为所在的模版⽚段。

> <tr th:each="user : ${userList}">  ...  </tr>

  1）如上所示 th:each 迭代中的 user 其实就是局部变量，仅在 <tr> 标签范围内可⽤，包括所有子元素，可⽤于在该标签中执⾏优先级低于 th:each 的任何其他 th:* 属性。
   Thymeleaf 提供 th:with 属性声明局部变量，其语法与属性值分配类似：

> <div th:with="firstPer=${persons[0]}">    <p>The name of the first person is <span th:text="${firstPer.name}">Julius Caesar</span>.</p> </div>

   当 th:with 被处理时，firstPer 变量被创建为局部变量并被添加到来⾃上下⽂ map 中，以便它可以与上下⽂中声明的任何其他变量⼀起使⽤，但只能在包含的 <div> 标签内使⽤。

   2）可以使用同时定义多个变量，用逗号隔开：

> <div th:with="firstPer=${persons[0]},secondPer=${persons[1]}">    <p>The name of the first person is <span th:text="${firstPer.name}">Julius Caesar</span>.</p>    <p>But the name of the second person is<span th:text="${secondPer.name}">Marcus Antonius</span>.</p> </div>

  3） th:with 属性允许重⽤在同⼀属性中定义的变量：

> <div th:with="company=${user.company + ' Co.'},account=${accounts[company]}">...</div>