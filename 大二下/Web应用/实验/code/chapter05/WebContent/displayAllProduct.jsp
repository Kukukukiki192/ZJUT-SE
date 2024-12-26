<%@ page contentType="text/html; charset=UTF-8"
                              pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.model.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>显示所有商品</title></head>
<body>
<table border="1">
<tr><td>商品号</td><td>商品名</td><td>品牌</td>
<td>价格</td><td>数量</td><td>是否删除</td></tr>
<c:forEach var="product" items="${productList}" >
   <tr><td>${product.id}</td>
       <td>${product.pname}</td>
       <td>${product.brand}</td>
       <td>${product.price}</td>
       <td>${product.stock}</td>
        <td><a href="delete-product?id=${product.id}">删除</a></td>
       </tr>
</c:forEach>
</table>
</body></html>
