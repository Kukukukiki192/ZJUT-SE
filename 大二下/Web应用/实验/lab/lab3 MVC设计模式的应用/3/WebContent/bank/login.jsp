<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客户登录页面</title>
</head>
<body>
<p><font color="#6666CC">请登录</font></p> <hr> 
<form action="../LoginServlet.do" method="post" > 
	<table width="68%" border="0" cellpadding="2" cellspacing="2"> 
		<tr>
			<td align="right">邮箱：</td> 
			<td><input type="text" name="Email"></td>
		</tr> 
		<tr>
			<td align="right">密码：</td> 
			<td><input type="text" name="Password" ></td>
		</tr> 
		<tr align="center"> 
			<td colspan="2"> <input type="submit" name="Submit" value="登录"> <a href='inputCustomer.jsp'>未注册？</a></td>
		</tr>
	</table>
</form>
</body>
</html>