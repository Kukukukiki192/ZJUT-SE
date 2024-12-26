<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,model.Product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>显示所有商品</title>
</head>
<body>
	<table border="1">
		<tr align="center">
			<td>商品号</td>
			<td>商品名</td>
			<td>价格</td>
			<td>数量</td>
			<td colspan=2>更新</td>
		</tr>
		<c:forEach var="product" items="${sessionScope.productList}" varStatus="status">
			<%--为奇数行和偶数行设置不同的背景颜色--%>
			<c:if test="${status.count%2==0}">
				<tr style="background: #eeeeff">
			</c:if>
			<c:if test="${status.count%2!=0}">
				<tr style="background: #dedeff">
			</c:if>
			<%--用EL访问作用域变量的成员--%>
			<td>${product.prod_id}</td>
			<td>${product.pname}</td>
			<td>${product.price}</td>
			<td>${product.stock}</td>
			<td><a href="updateproduct.jsp?id=${product.prod_id}&pname=${product.pname}&price=${product.price}&stock=${product.stock}" >修改</a></td>	
			<td><a href="addndrop.do?id=${product.prod_id}" >删除</a></td>		
			</tr>
		</c:forEach>
	</table>
</body>
</html>
