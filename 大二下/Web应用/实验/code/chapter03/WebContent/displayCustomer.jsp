<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="customer" class="com.demo.Customer" scope="session">
<jsp:setProperty name="customer" property="*"/>
</jsp:useBean>
<html><head> <title>显示客户信息</title></head>
<body>
<h4>客户信息如下</h4>
<table border="1">
<tr>
<td>客户名:</td>
<td>${customer.custName }</td>
</tr>
<tr>
<td>Email地址:</td>
<td><jsp:getProperty name="customer" property="email"/></td>
</tr>
<tr>
<td>电话:</td>
<td><jsp:getProperty name="customer" property="phone"/></td>
</tr>
</table>
</body></html>
