<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>输入学生信息页面</title>
</head>
<body>
<form action="../StudentServlet" method="post">
<h3>输入学生基本信息</h3> 
  输入学号：<input type="text" name="Stuid"><br> <br>
  输入姓名：<input type="text" name="Name"><br> <br>
  输入专业：<input type="text" name="Major"><br> <br>
  	   <input type="submit" name="Submit" value="提交">
</form>
</body>
</html>