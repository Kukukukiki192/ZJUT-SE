<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>个人信息</title>
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
		<span class="breadcrumb-item active">个人信息</span>
	</nav>
	<!--内容-->
	<div id="content">
		<center>
		<table>
			<tr align="left"><td width="50%">学号</td><td>S01</td></tr>
			<tr align="left"><td>姓名</td><td>王敏倩</td></tr>
			<tr align="left"><td>性别</td><td>女</td></tr>
			<tr align="left"><td>年龄</td><td>22</td></tr>
			<tr align="left"><td>生源地</td><td>浙江杭州</td></tr>
			<tr align="left"><td>已修学分总数</td><td>13</td></tr>
			<tr align="left"><td>班级编号</td><td>B01</td></tr>
		</table></center>
	</div>
</div>
</body>
</html>