<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客户注册页面</title>
</head>
<body>
<form action="../CustomerServlet.do" method="post">
<h3>输入客户注册信息</h3> 
  输入邮箱：<input type="text" name="Email"><br> <br>
  输入密码：<input type="text" name="Password"><br> <br>
  输入姓名：<input type="text" name="CustName"><br> <br>
  输入手机号：<input type="text" name="Phone"><br> <br>
<input type="submit" name="Submit" value="提交">
</form>
</body>
</html>