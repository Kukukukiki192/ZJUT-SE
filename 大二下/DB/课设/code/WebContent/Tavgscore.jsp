<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>平均成绩</title>
</head>
<body>
<div class="container-fluid">
	<!--导航菜单-->
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" href="#">成绩管理系统|<small>教师</small></a>
		<ul class="navbar-nav">			
			<li class="nav-item"><a class="nav-link" href="IT.jsp">个人信息</a></li>
		 	<li class="nav-item"><a class="nav-link" href="QueryTeachServlet">教师任课</a></li>
			<li class="nav-item"><a class="nav-link" href="AVGscore">平均成绩</a></li>
			<li class="nav-item"><a class="nav-link" href="DESCscore">成绩排名 </a></li>
			<li class="nav-item"><a class="nav-link" href="TaddScore.jsp">成绩录入</a></li>
		</ul>
		<div class="ml-auto"><a class="nav-link" href="login.jsp">退出</a></div>
	</nav>
	<!--面包屑导航-->
	<nav class="breadcrumb pull-right">
		<a class="breadcrumb-item" href="T.jsp">首页</a>
		<span class="breadcrumb-item active">平均成绩</span>
	</nav>
	<!--内容-->
	<div id="content">
		<h4>${result}</h4>
		<table border="1">
			<tr align="center"><th width="400">课程编号</th><th width="600">课程名称</th><th width="400">平均成绩</th></tr>
			<c:forEach var="List" items="${requestScope.List}">
			<tr align="center"><td>${List.cno}</td><td>${List.cname}</td><td>${List.avgscore}</td></tr>
			</c:forEach>
		</table>		
	</div>
</div>
</body>
</html>