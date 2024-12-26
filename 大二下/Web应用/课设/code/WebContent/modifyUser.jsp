<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>师生健康码管理系统 | 修改信息</title>
<style>
	label{
        display: inline-block;/*实现列对齐*/
        text-align: right;
        width: 80px;
    }
	input{ width: 170px; }
</style>
</head>
<body>
<%	String num=(String)request.getAttribute("num");
	int type=(Integer)request.getAttribute("type");
	int x=(Integer)request.getAttribute("x");	%>
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
				  	<%	if(x==1){%>
				  	<a class="breadcrumb-item" href="selectS.jsp?num=<%=num%>">查询信息</a>
				  	<%	} else { %>	
					  	<%	if(type==2){%>
					  	<a class="breadcrumb-item" href="AllUser?num=<%=num%>&type=2">教师信息</a>
					  	<%	} else { %>	
					  	<a class="breadcrumb-item" href="AllUser?num=<%=num%>&type=1">学生信息</a>
					  	<%	}} %>
				  	<span class="breadcrumb-item active">修改信息</span>
				</nav>
				<!-- 核心内容 -->
  				<section> 					
  					<form action = "ModifyInfo?num=<%=num%>&type=<%=type%>&x=<%=x%>" method = "post"> 								
					<fieldset>
					<%	if(type==1){%><input type="hidden" name="num1" value="${student.num}">
						<p><label>姓名&nbsp;&nbsp;</label><input type="text" name="name" value="${student.name}"></p>
						<p><label>身份证号&nbsp;&nbsp;</label><input type="text" name="ID" value="${student.ID}"></p>
						<p><label>密码&nbsp;&nbsp;</label><input type="text" name="password" value="${student.psw}"></p>						
						<p><label>学院&nbsp;&nbsp;</label><input type="text" name="institute" value="${student.institute}"></p>
						<p><label>专业&nbsp;&nbsp;</label><input type="text" name="major" value="${student.major}"></p>
						<p><label>班级&nbsp;&nbsp;</label><input type="text" name="clas" value="${student.clas}"></p>
						<p><label>手机号&nbsp;&nbsp;</label><input type="text" name="phone" value="${student.phone}"></p>
					<%	} else { %>	<input type="hidden" name="num1" value="${teacher.num}">												
						<p><label>姓名&nbsp;&nbsp;</label><input type="text" name="name" value="${teacher.name}"></p>
						<p><label>身份证号&nbsp;&nbsp;</label><input type="text" name="ID" value="${teacher.ID}"></p>
						<p><label>密码&nbsp;&nbsp;</label><input type="text" name="password" value="${teacher.psw}"></p>	
						<p><label>学院&nbsp;&nbsp;</label><input type="text" name="institute" value="${teacher.institute}"></p>
						<p><label>角色&nbsp;&nbsp;</label><input type="text" name="character" value="${teacher.character}"></p>
						<p><label>手机号&nbsp;&nbsp;</label><input type="text" name="phone" value="${teacher.phone}"></p>	
					<%	} %>			
						<p><label></label><button type="submit">确认</button></p>
					</fieldset></form> 					
				</section>	       
				<!--版权标志-->
				<section id="copyright">Copyright ZKX   © 浙江工业大学计算机学院</section>
			</div>	
		</div>
	</div>
</div>
</body>
</html>