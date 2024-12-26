<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>学生成绩查询</title>
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
			<li class="nav-item"><a class="nav-link" href="SqueryScoreServlet">学生成绩查询</a></li>
			<li class="nav-item"><a class="nav-link" href="SqueryCredit.jsp">学生已修学分查询</a></li>
		</ul>
		<div class="ml-auto"><a class="nav-link" href="login.jsp">退出</a></div>
	</nav>
	<!--面包屑导航-->
	<nav class="breadcrumb pull-right">
		<a class="breadcrumb-item" href="S.jsp">首页</a>
		<span class="breadcrumb-item active">学生成绩查询</span>
	</nav>
	<!--内容-->
	<div id="content">
		<!-- <a href="SqueryScoreServlet" class="btn btn-info" role="button">学生各科成绩查询</a>-->
		<!--<a href="SqueryScoreServlet?x=2" class="btn btn-info" role="button">每门课程平均成绩统计</a>-->
		<br><h4>${result}</h4>
		<table border="1">
			<tr align="center">
				<th width="175">学号</th><th width="175">姓名</th><th width="175">课程名称</th><th width="175">班级名称</th>
				<th width="175">教师姓名</th><th width="175">学分</th><th width="175">学期</th><th width="175">成绩</th>
			</tr>
			<c:forEach var="sList" items="${requestScope.sList}">
			<tr align="center">
				<td>${sList.sno}</td>
				<td>${sList.sname}</td>
				<td>${sList.cname}</td>
				<td>${sList.bname}</td>
				<td>${sList.tname}</td>
				<td>${sList.credit}</td>
				<td>${sList.period}</td>
				<td>${sList.score}</td>
			</tr>
			</c:forEach>
		</table>	
	</div>
</div>
</body>
</html>