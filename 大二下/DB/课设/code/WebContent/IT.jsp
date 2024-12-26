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
		<span class="breadcrumb-item active">个人信息</span>
	</nav>
	<!--内容-->
	<div id="content"><center>
		<table>
			<tr align="left"><td width="50%">教师编号</td><td>1000555</td></tr>
			<tr align="left"><td>姓名</td><td>K</td></tr>
			<tr align="left"><td>性别</td><td>女</td></tr>
			<tr align="left"><td>年龄</td><td>30</td></tr>
			<tr align="left"><td>职称</td><td>讲师</td></tr>
			<tr align="left"><td>联系电话</td><td>13114537881</td></tr>
		</table></center>
	</div>
</div>
</body>
</html>