<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.model.Teacher"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>系统管理员页面</title>
</head>
<body>
<h4>${result}</h4>
<fieldset> 
	<legend>个人信息</legend> 
	<table>
	<tr><td>姓名：</td><td>${teacher.name}</td></tr>	
	<tr><td>身份证号： </td><td>${teacher.ID}</td></tr>
	<tr><td>工号：</td><td>${teacher.num}</td></tr>
	<tr><td>密码：</td><td>${teacher.psw}</td></tr>
	<tr><td>学院：</td><td>${teacher.institute}</td></tr>
	<tr><td>角色：</td><td>${teacher.character}</td></tr>
	</table>
</fieldset><br>
<a href="control.jsp">进入管理系统</a>
</body>
</html>