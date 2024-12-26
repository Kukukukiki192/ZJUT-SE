<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.model.*,com.dao.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="time.js"></script>
<title>师生健康码管理系统 | 健康码、打卡情况统计</title>
</head><!-- 点击超链接跳转的接受超链接值的首页 -->
<body>
<%	String num=request.getParameter("num"); %>
<div class="container">
	<!--页眉-->
	<div id="header" class="navbar-header">
		<header>
			<div id="logo" style="display:inline-block">
				<span class="navbar-brand">师生健康码管理系统</span>
			</div>
			<div style="display:inline-block;float:right">
				<a href="me.jsp?num=<%=num%>&type=2">我</a>	
				<a href="login.jsp">退出</a>
			</div>
		</header>
	</div>
	<div class="row">
		<div class="col-2">
			<!--导航菜单-->
			<div id="sidebar">
				<nav>
		            <ul class="nav flex-column">
		            	<li class="nav-item"><a class="nav-link" href="index4.jsp?num=<%=num%>">首页</a></li>
						<li class="nav-item"><a class="nav-link" href="clockin.jsp?num=<%=num%>&type=2">每日填报</a></li>
						<li class="nav-item"><a class="nav-link" href="myCode.jsp?num=<%=num%>&type=2">我的健康码</a></li>
						<li class="nav-item"><a class="nav-link" href="importUser.jsp?num=<%=num%>">导入数据</a></li>
						<li class="nav-item"><a class="nav-link" href="addUser.jsp?num=<%=num%>">添加数据</a></li>
						<li class="nav-item"><a class="nav-link" href="selectS.jsp?num=<%=num%>">查询信息</a></li>
						<li class="nav-item"><a class="nav-link" href="AllUser?num=<%=num%>&type=2">教师信息</a></li>
						<li class="nav-item"><a class="nav-link" href="AllUser?num=<%=num%>&type=1">学生信息</a></li>
						<li class="nav-item"><a class="nav-link" href="Statistics?num=<%=num%>">健康码、打卡情况统计</a></li>
		            </ul>
		        </nav>
			</div>
		</div>
		<div class="col-10">
			<!--内容-->
			<div id="content">
				<!--面包屑导航-->
	       		<nav class="breadcrumb pull-right">
	       			<a class="breadcrumb-item" href="index4.jsp?num=<%=num%>">首页</a>
				  	<span class="breadcrumb-item active">健康码、打卡情况统计</span>
				</nav>
				<!-- 核心内容 -->
  				<section>
		        	<div class="row">
						<div class="col-6"><h4>学生</h4>
							<form action="Query?num=<%=num%>&type=1&x=0" method="post">
								请输入学号： <input type="text" name="num1" size="15"><button type="submit">查询</button>
							</form><br>
							<table border="1">
								<tr align="center">
									<td>姓名</td>
									<td>学号</td>
									<td>健康码</td>
									<td>今日打卡</td>
								</tr>
								<c:forEach var="student" items="${requestScope.student}">
								<tr>
									<td>${student.name}</td>
									<td>${student.num}</td>
									<td align="center">${student.code}</td>
									<td align="center">${student.clockin}</td>
								</tr>
								</c:forEach>
							</table>
						</div>
						<div class="col-6"><h4>教师</h4>
							<form action="Query?num=<%=num%>&type=2&x=0" method="post">
								请输入工号： <input type="text" name="num1" size="15"><button type="submit">查询</button>
							</form><br>
							<table border="1">
								<tr align="center">
									<td>姓名</td>
									<td>工号</td>
									<td>健康码</td>
									<td>今日打卡</td>
								</tr>
								<c:forEach var="teacher" items="${requestScope.teacher}">
								<tr>
									<td>${teacher.name}</td>
									<td>${teacher.num}</td>
									<td align="center">${teacher.code}</td>
									<td align="center">${teacher.clockin}</td>
								</tr>
								</c:forEach>
							</table>
						</div>
					</div><br>
					<ul class="pagination">
						<li class="page-item"><a class="page-link" href="#">&lt;&lt;</a></li>
					    <li class="page-item active"><a class="page-link" href="#">1</a></li>
					    <li class="page-item"><a class="page-link" href="#">2</a></li>
					    <li class="page-item"><a class="page-link" href="#">3</a></li>
					    <li class="page-item"><a class="page-link" href="#">&gt;&gt;</a></li>
					</ul>       	
	        	</section><br><br>	       
				<!--版权标志-->
				<section id="copyright">Copyright ZKX   © 浙江工业大学计算机学院</section>
			</div>	
		</div>
	</div>
</div>
</body>
</html>