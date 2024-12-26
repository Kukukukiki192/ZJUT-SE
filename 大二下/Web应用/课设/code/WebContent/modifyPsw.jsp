<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.model.*,com.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>师生健康码管理系统 | 修改密码</title>
</head>
<body>
<%	String num=request.getParameter("num");
    int type=Integer.parseInt(request.getParameter("type"));
    UserDao dao = new UserDao();
    Student student=dao.findSByNum(num);   
    Teacher teacher=dao.findTByNum(num); 
%>
<div class="container">
	<!--页眉-->
	<div id="header" class="navbar-header">
		<header>
			<div id="logo" style="display:inline-block">
				<span class="navbar-brand">师生健康码管理系统</span>				
			</div>
			<div style="display:inline-block;float:right">
				<a href="me.jsp?num=<%=num%>&type=<%=type%>">我</a>	
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
		            	<%	if(type==1 || type==2 && teacher.getCharacter().equals("普通教师")) { %>
		            	<li class="nav-item"><a class="nav-link" href="index2.jsp?num=<%=num%>&type=<%=type%>">首页</a></li>
		            	<li class="nav-item"><a class="nav-link" href="clockin.jsp?num=<%=num%>&type=<%=type%>">每日填报</a></li>
		            	<li class="nav-item"><a class="nav-link" href="myCode.jsp?num=<%=num%>&type=<%=type%>">我的健康码</a></li>
		            	<%	} else { %>	
		            	<li class="nav-item"><a class="nav-link" href="index4.jsp?num=<%=num%>">首页</a></li>
						<li class="nav-item"><a class="nav-link" href="clockin.jsp?num=<%=num%>&type=2">每日填报</a></li>
						<li class="nav-item"><a class="nav-link" href="myCode.jsp?num=<%=num%>&type=2">我的健康码</a></li>
						<li class="nav-item"><a class="nav-link" href="importUser.jsp?num=<%=num%>">导入数据</a></li>
						<li class="nav-item"><a class="nav-link" href="addUser.jsp?num=<%=num%>">添加数据</a></li>
						<li class="nav-item"><a class="nav-link" href="selectS.jsp?num=<%=num%>">查询信息</a></li>
						<li class="nav-item"><a class="nav-link" href="AllUser?num=<%=num%>&type=2">教师信息</a></li>
						<li class="nav-item"><a class="nav-link" href="AllUser?num=<%=num%>&type=1">学生信息</a></li>
						<li class="nav-item"><a class="nav-link" href="Statistics?num=<%=num%>">健康码、打卡情况统计</a></li>
		            	<%	} %>
		            </ul>
		        </nav>
			</div>
		</div>
		<div class="col-10">
			<!--内容-->
			<div id="content">
				<!--面包屑导航-->
	       		<nav class="breadcrumb pull-right">
	       			<%	if(type==1 || type==2 && teacher.getCharacter().equals("普通教师")) { %>
				  	<a class="breadcrumb-item" href="index2.jsp?num=<%=num%>&type=<%=type%>">首页</a>
				  	<a class="breadcrumb-item" href="me.jsp?num=<%=num%>&type=<%=type%>">个人信息(我)</a>				  
				  	<%	} else { %>	
				  	<a class="breadcrumb-item" href="index4.jsp?num=<%=num%>">首页</a>
				  	<a class="breadcrumb-item" href="me.jsp?num=<%=num%>&type=2">个人信息(我)</a>
				  	<%	} %>
				  	<span class="breadcrumb-item active">修改密码</span>
				</nav>
				<!-- 核心内容 -->
  				<section><form action="ModifyPsw?num=<%=num%>&type=<%=type%>" method="post" >
					<fieldset> 
						<table>
						<tr><td>旧密码</td><td><input type="text" name="password1" id="password1"></td></tr>	
						<tr><td>新密码 </td><td><input type="text" name="password2" id="password2"></td></tr>
						<tr><td colspan=2><button type="submit">确认</button></td></tr>
						</table>
					</fieldset></form>
				</section><br>	       
				<!--版权标志-->
				<section id="copyright">Copyright ZKX   © 浙江工业大学计算机学院</section>
			</div>	
		</div>
	</div>
</div>
</body>
</html>