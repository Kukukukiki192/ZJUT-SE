<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>教师</title>
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
		<span class="breadcrumb-item active">首页</span>
	</nav>
	<!--内容-->
	<div id="content">
		<h4>欢迎进入教师操作界面,请选择您要进行的操作!</h4>
	</div>
</div>
</body>
</html>