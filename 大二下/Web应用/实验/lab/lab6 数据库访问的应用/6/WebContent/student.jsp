<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生用户页面</title>
</head>
<body>
<h4>${result}</h4>
<table>
<tr><td>姓名：</td><td>${student.name}</td>
</tr>	
<tr><td>身份证号： </td><td>${student.ID}</td>
</tr>
<tr><td>学号：</td><td>${student.num}</td>
</tr>
<tr><td>密码：</td><td>${student.psw}</td>
</tr>
<tr><td>学院：</td><td>${student.institute}</td>
</tr>
<tr><td>专业：</td><td>${student.major}</td>
</tr>
<tr><td>班级：</td><td>${student.clas}</td>
</tr>
</table>
</body>
</html>