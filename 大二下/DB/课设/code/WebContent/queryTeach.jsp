<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>教师任课查询</title>
</head>
<body>
<div class="container-fluid">
	<!--导航菜单-->
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" href="S.jsp">成绩管理系统|<small>学生</small></a>
		<ul class="navbar-nav">			
		 	<li class="nav-item"><a class="nav-link" href="#">各生源地平均成绩统计</a></li>
			<li class="nav-item"><a class="nav-link" href="#">班级开课情况</a></li>
			<li class="nav-item"><a class="nav-link" href="QueryTeachServlet?x=2">教师任课查询</a></li>
			<li class="nav-item"><a class="nav-link" href="SqueryScore.jsp">学生成绩查询</a></li>
			<li class="nav-item"><a class="nav-link" href="SqueryCredit.jsp">学生已修学分查询</a></li>
		</ul>
		<div class="ml-auto"><a class="nav-link" href="login.jsp">退出</a></div>
	</nav>
	<!--面包屑导航-->
	<nav class="breadcrumb pull-right">
		<a class="breadcrumb-item" href="S.jsp">首页</a>
		<span class="breadcrumb-item active">教师任课查询</span>
	</nav>
	<!--内容-->
	<div id="content">
		<br><h4>${result}</h4>
		<table border="1">
			<tr align="center"><td>教师编号</td><td>教师姓名</td><td>课程编号</td><td>课程名称</td></tr>
			<c:forEach var="List" items="${requestScope.List}">
			<tr><td>${List.tno}</td><td>${List.tname}</td><td>${List.cno}</td><td>${List.cname}</td></tr>
			</c:forEach>
		</table>	
	</div>
</div>
</body>
</html>