<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>学生已修学分查询</title>
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
		<span class="breadcrumb-item active">学生已修学分查询</span>
	</nav>
	<!--内容-->
	<div id="content">
		<a href="SqueryCreditServlet?x=1" class="btn btn-info" role="button">个人总学分</a>
		<a href="SqueryCreditServlet?x=2" class="btn btn-info" role="button">各科学分</a>
		<br><h4>${result}</h4>
		<% int x; if(request.getAttribute("x")==null) x=3; else{ x=(Integer)request.getAttribute("x");} if(x==1){ %>
		<table border="1">
			<tr align="center"><th width="466">学号</th><th width="466">姓名</th><th width="466">已修学分总数</th></tr>
			<tr align="center"><td>${s.sno}</td><td>${s.sname}</td><td>${s.credits}</td></tr>
		</table>	
		<% } else if(x==2) { %>	
		<table border="1">
			<tr align="center"><th width="466">学号</th><th width="466">课程名称</th><th width="466">学分</th></tr>
			<c:forEach var="cList" items="${requestScope.cList}">
			<tr align="center"><td>${cList.sno}</td><td>${cList.cname}</td><td>${cList.credit}</td></tr>
			</c:forEach>
		</table>	
		<% } %>
	</div>
</div>
</body>
</html>