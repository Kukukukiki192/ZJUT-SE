<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>课程查询</title>
</head>
<body>
<div class="container">
	<!--导航菜单-->
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" href="S.jsp">成绩管理系统|<small>学生</small></a>
		<ul class="navbar-nav">	
			<li class="nav-item"><a class="nav-link" href="IS.jsp">个人信息</a></li>		
		 	<li class="nav-item"><a class="nav-link" href="showCourse">课程查询</a></li>
			<li class="nav-item"><a class="nav-link" href="S_kaikeServlet">班级开课查询</a></li>
			<li class="nav-item"><a class="nav-link" href="SqueryScore.jsp">学生成绩查询</a></li>
			<li class="nav-item"><a class="nav-link" href="SqueryCredit.jsp">学生已修学分查询</a></li>
		</ul>
		<div class="ml-auto"><a class="nav-link" href="login.jsp">退出</a></div>
	</nav>
	<!--面包屑导航-->
	<nav class="breadcrumb pull-right">
		<a class="breadcrumb-item" href="S.jsp">首页</a>
		<span class="breadcrumb-item active">课程查询</span>
	</nav>
	<!--内容-->
	<div id="content">
		<h4>${result}</h4>
		<table border="1">
			<tr align="center"><th width="200">课程编号</th><th width="200">课程名称</th><th width="200">教师姓名</th><th width="200">学期</th><th width="200">课程学时</th><th width="200">考核方式</th><th width="200">学分</th></tr>
			<c:forEach var="List" items="${requestScope.List}">
			<tr align="center"><td>${List.cno}</td><td>${List.cname}</td><td>${List.tname}</td><td>${List.period}</td><td>${List.hour}</td><td>${List.test}</td><td>${List.credit}</td></tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>