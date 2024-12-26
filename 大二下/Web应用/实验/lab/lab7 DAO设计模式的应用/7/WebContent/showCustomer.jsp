<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>客户信息</title>
</head>
<body>
	<table>
		<tr><td>客户编号：</td><td>${customer.cust_id}</td>
		</tr>
		<tr><td>客户姓名：</td><td>${customer.cname}</td>
		</tr>
		<tr><td>邮箱：</td><td>${customer.email}</td>
		</tr>
		<tr><td>余额：</td><td>${customer.balance}</td>
		</tr>
	</table>
</body>
</html>
