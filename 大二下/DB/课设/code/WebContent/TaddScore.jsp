<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>成绩录入</title>
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
		<span class="breadcrumb-item active">成绩录入</span>
	</nav>
	<!--内容-->
	<div>${result}
		<form action="AddScore" method="post"> 
		<center>
			<table>
			<tr align="left"><td>学号</td><td><input type="text" name="sno" id="sno" class="form-control" required></td></tr>
			<tr align="left"><td>课程编号</td><td><input type="text" name="cno" id="cno" class="form-control" required></td></tr>
			<tr align="left"><td>学期</td><td>
				<select name="period" class="form-control" required>
						<option>12/13(1)</option>
						<option>12/13(2)</option>
						<option>13/14(1)</option>
						<option>13/14(2)</option>
				</select></td></tr>
			<tr align="left"><td>成绩</td><td><input type="text" name="score" id="score" class="form-control" required></td></tr>
			<tr align="left"><td>教师姓名</td><td><input type="text" name="tname" id="tname" class="form-control" required></td></tr>
			<tr align="left"><td></td><td><button type="submit" class="btn btn-primary">添加</button></td></tr>
			</table>
		</center>
		</form>
	</div>
</div>
</body>
</html>