<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改客户信息</title>
</head>
<body>
<!-- <font color=red>${result}</font> -->
<p>修改客户信息</p> 
<form action = "modifyCustomerInfo.do" method = "post"> 
	<table> 
		<tr><td></td> <td><input type="hidden" name="cust_id" value="${customer.cust_id}"></td></tr> 
		<tr><td>客户名：</td> <td><input type="text" name="cname" value="${customer.cname}"></td></tr> 
		<tr><td>Email：</td><td><input type="text" name="email" value="${customer.email}"></td></tr> 
		<tr><td>余 额：</td><td><input type="text" name="balance" value="${customer.balance}"></td></tr> 
		<tr><td><input type="submit" value="确定" ></td> <td><input type="reset" value="重置" ></td></tr>
	</table>
</form>
</body>
</html>