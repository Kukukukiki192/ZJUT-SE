<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>院级管理员</title>
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
		<span class="breadcrumb-item active">首页</span>
	</nav>
	<!--内容-->
	<div id="content">
		<h4>欢迎进入院级管理员操作界面,请选择您要进行的操作!</h4>
	</div>
</div>
</body>
</html>