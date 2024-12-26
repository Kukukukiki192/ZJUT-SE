<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.model.*,com.dao.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/time.js"></script>
<title>师生健康码管理系统 | 申领健康码</title>
</head>
<body>
<%	int type=(Integer)request.getAttribute("type");
	String num=(String)request.getAttribute("num");
	String imgPath="file/"+num+".png";
	UserDao dao = new UserDao();
    Student student=dao.findSByNum(num);   
    Teacher teacher=dao.findTByNum(num); 
%>
<div class="container">
	<!--页眉-->
	<div id="header">
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
				  	<a class="breadcrumb-item" href="clockin.jsp?num=<%=num%>&type=<%=type%>">每日填报</a>
				  	<%	} else { %>	
				  	<a class="breadcrumb-item" href="index4.jsp?num=<%=num%>&type=<%=type%>">首页</a>
				  	<a class="breadcrumb-item" href="clockin.jsp?num=<%=num%>&type=2">每日填报</a>
				  	<%	} %>				  	
				  	<span class="breadcrumb-item active">申领健康码</span>
				</nav><br>
		        <section>
		        <% if(type==1&&student.getCode()==null || type==2&&teacher.getCode()==null) { %>
		        	<h4 align="center">您还未申领健康码!</h4>
		        <% } else { %>
		        	<!-- 显示当前日期和时间 -->
		        	<div id="displaydate"></div>
            		<div id="displaytime"></div>
		        	<!-- 显示我的名字 -->
		        	<%	if(type==1)	{ %>
		        	<p align="center"><%=student.getName()%></p>
		        	<%	} else { %>
		        	<p align="center"><%=teacher.getName()%></p>
		        	<%	} %>
		        	<p align="center"><img src=<%=imgPath%> alt="健康码" /></p><br><!-- 生成的新健康码会覆盖旧健康码 -->
		        	<p align="center"><font color="blue">此码不可重复申领,今日无需再打卡</font></p>
		        	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您可以查看自己的专属二维码作为进出校园的凭证,<mark><font color="green">绿码</font></mark>可以进出校园,<mark><font color="yellow">
		        	黄码</font></mark>需居家观察7天不得进入校园,<mark><font color="red">红码</font></mark>需居家医学观察或集中隔离14天不得进入校园.</p>
		        	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请主动出示健康码,配合检查;并做好自身防护工作,码颜色将根据您的申报由当地政府按照相关政策动态更新,出行前请仔细检查您的健康码.</p>
		        <% } %>
		        </section><br>  
		        <!--版权标志-->
				<section id="copyright">Copyright ZKX   © 浙江工业大学计算机学院</section>    
			</div>
		</div>
	</div>
</div>
</body>
</html>