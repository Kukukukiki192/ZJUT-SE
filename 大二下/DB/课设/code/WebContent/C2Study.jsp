<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>学生选课信息</title>
</head>
<body>
<div class="container">
	<!--导航菜单-->
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" href="C2.jsp">成绩管理系统|<small>院级管理员</small></a>
		<ul class="navbar-nav">			
			<li class="nav-item"><a class="nav-link" href="C2_kaisheServlet">学院开课信息</a></li>
			<li class="nav-item"><a class="nav-link" href="C2StudyServlet">学生选课信息</a></li>			
		</ul>
		<div class="ml-auto"><a class="nav-link" href="login.jsp">退出</a></div>
	</nav>
	<!--面包屑导航-->
	<nav class="breadcrumb pull-right">
		<a class="breadcrumb-item" href="C2.jsp">首页</a>
		<span class="breadcrumb-item active">学生选课信息</span>
	</nav>
	<!--内容-->
	<div><center>
		<form action="C2addStudyServlet" method="post"> 
			<table>
			<tr align="left"><td>学号</td><td><input type="text" name="sno" id="sno" class="form-control" required></td></tr>
			<tr align="left"><td>课程编号</td><td><input type="text" name="cno" id="cno" class="form-control" required></td></tr>
			<tr align="left"><td>学期</td><td><input type="text" name="period" id="period" class="form-control" required></td></tr>
			<tr align="left"><td>教师姓名</td><td><input type="text" name="tname" id="tname" class="form-control" required></td></tr>
			<tr align="left"><td></td><td><button type="submit" class="btn btn-primary">添加</button></td></tr>
			</table>
		</form><br>
		<table border="1">
			<tr align="center"><th width="300">学号</th><th width="300">课程编号</th><th width="300">学期</th><th width="300">成绩</th><th width="300">教师姓名</th></tr>
			<c:forEach var="List" items="${requestScope.List}">
			<tr align="center"><td>${List.sno}</td><td>${List.cno}</td><td>${List.period}</td><td>${List.score}</td><td>${List.tname}</td></tr>
			</c:forEach>
		</table>	</center>
	</div>
</div>
</body>
</html>