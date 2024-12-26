<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>地区统计</title>
</head>
<body>
<div class="container">
	<!--导航菜单-->
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" href="C1.jsp">成绩管理系统|<small>校级管理员</small></a>
		<ul class="navbar-nav">			
			<li class="nav-item"><a class="nav-link" href="T">教师管理</a></li>
			<li class="nav-item"><a class="nav-link" href="S">学生管理</a></li>	
			<li class="nav-item"><a class="nav-link" href="Address">地区统计</a></li>
		</ul>
		<div class="ml-auto"><a class="nav-link" href="login.jsp">退出</a></div>
	</nav>
	<!--面包屑导航-->
	<nav class="breadcrumb pull-right">
		<a class="breadcrumb-item" href="C1.jsp">首页</a>
		<span class="breadcrumb-item active">地区统计</span>
	</nav>
	<!--内容-->
	<div id="content">
		<table border="1">
			<tr align="center"><th width="300">序号</th><th width="500">生源地</th><th width="300">人数</th></tr><% int i=1; %>
			<c:forEach var="List" items="${requestScope.List}">
			<tr align="center">
				<td><%=i++%></td>
				<td>${List.address}</td>
				<td>${List.sage}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>