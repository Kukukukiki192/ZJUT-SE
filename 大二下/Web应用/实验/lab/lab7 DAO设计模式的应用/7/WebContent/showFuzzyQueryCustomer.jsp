<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.model.Customer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>显示模糊查询的客户信息</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>客户编号</td>
			<td>姓名</td>
			<td>邮箱</td>
			<td>余款</td>
		</tr>
		<c:forEach var="customer" items="${requestScope.customer}"
			varStatus="status">
			<%--为奇数行和偶数行设置不同的背景颜色--%>
			<c:if test="${status.count%2==0}">
				<tr style="background: #eeeeff">
			</c:if>
			<c:if test="${status.count%2!=0}">
				<tr style="background: #dedeff">
			</c:if>
			<%--用EL访问作用域变量的成员--%>
			<td>${customer.cust_id}</td>
			<td>${customer.cname}</td>
			<td>${customer.email}</td>
			<td>${customer.balance}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
