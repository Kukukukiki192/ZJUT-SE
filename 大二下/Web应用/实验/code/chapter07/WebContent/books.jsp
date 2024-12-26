<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*,com.model.Book" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>图书列表</title>
<style>
   table tr,td{
  border:1px solid brown;
}
</style>
</head>
<body> 
<table>
<tr style="background:#ababff">
<td>书号</td><td>书名</td><td>价格</td>
</tr>
<c:forEach var="book" items="${requestScope.books}"
varStatus="status">
    <%--为奇数行和偶数行设置不同的背景颜色--%>
    <c:if test="${status.count%2==0}">  
      <tr style="background:#eeeeff">
    </c:if>
    <c:if test="${status.count%2!=0}">  
       <tr style="background:#dedeff">
    </c:if>
    <%--用EL访问作用域变量的成员--%>
     <td>${book.isbn}</td> 
     <td>${book.title}</td>
     <td>${book.price}</td>
   </tr>
</c:forEach>
</table> 
</body></html>
