<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>师生健康码管理系统 | 查询信息</title>
</head>
<body>
<%	String num=(String)request.getAttribute("num");%>
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
				  	<a class="breadcrumb-item" href="selectS.jsp?num=<%=num%>">查询信息</a>
				  	<span class="breadcrumb-item active">查询结果</span>
				</nav>
				<!-- 核心内容 -->
  				<section>
	        		<font color=red>${result}</font><br><br>
					<table border="1">
						<tr align="center">
							<td>姓名</td>
							<td>身份证号</td>
							<td>学号</td>
							<td>密码</td>
							<td>学院</td>
							<td>专业</td>
							<td>班级</td>
							<td>手机号</td>
							<td>操作</td>
						</tr>
						<c:forEach var="student" items="${requestScope.student}" varStatus="status">
						<tr>
							<td>${student.name}</td>
							<td>${student.ID}</td>
							<td>${student.num}</td>
							<td>${student.psw}</td>
							<td>${student.institute}</td>
							<td>${student.major}</td>
							<td>${student.clas}</td>
							<td>${student.phone}</td>
							<td>
				              <a href="Modify?num=<%=num%>&num1=${student.num}&type=1&x=1">修改</a>&nbsp;
				              <a href="Delete?num=<%=num%>&num1=${student.num}&type=1&x=1">删除</a>
				            </td>
						</tr>
						</c:forEach>
					</table>
	        	</section><br>	       
				<!--版权标志-->
				<section id="copyright">Copyright ZKX   © 浙江工业大学计算机学院</section>
			</div>	
		</div>
	</div>
</div>
</body>
</html>


