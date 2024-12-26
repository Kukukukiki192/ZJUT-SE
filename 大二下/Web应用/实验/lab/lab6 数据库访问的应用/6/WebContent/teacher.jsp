<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教师用户页面</title>
</head>
<body>
<h4>${result}</h4>
<table>
<tr><td>姓名：</td><td>${teacher.name}</td>
</tr>	
<tr><td>身份证号： </td><td>${teacher.ID}</td>
</tr>
<tr><td>工号：</td><td>${teacher.num}</td>
</tr>
<tr><td>密码：</td><td>${teacher.psw}</td>
</tr>
<tr><td>学院：</td><td>${teacher.institute}</td>
</tr>
<tr><td>角色：</td><td>${teacher.character}</td>
</tr>
</table>
</body>
</html>