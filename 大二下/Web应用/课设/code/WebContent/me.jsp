<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.model.*,com.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="time.js"></script>
<title>师生健康码管理系统 | 个人信息</title>
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
				  	<%	} else { %>	
				  	<a class="breadcrumb-item" href="index4.jsp?num=<%=num%>">首页</a>
				  	<%	} %>
				  	<span class="breadcrumb-item active">个人信息(我)</span>
				</nav>
				<!-- 核心内容 -->
  				<section>
					<fieldset> 
						<!--<legend>个人信息</legend>-->
						<table>
					<%	if(type==1) { %>
						<tr><td>姓名：</td><td><%=student.getName()%></td></tr>	
						<tr><td>身份证号： </td><td><%=student.getID()%></td></tr>
						<tr><td>学号：</td><td><%=num%></td></tr>
						<tr><td>学院：</td><td><%=student.getInstitute()%></td></tr>
						<tr><td>专业：</td><td><%=student.getMajor()%></td></tr>
						<tr><td>班级：</td><td><%=student.getClas()%></td></tr>
						<% if(student.getPhone()==null){ %>
						<tr><td>手机号：</td><td>未填写</td></tr>
						<% } else { %>
						<tr><td>手机号：</td><td><%=student.getPhone()%></td></tr>
						<% } %>						
						<% if(student.getCode().equals("无")){ %>
						<tr><td>健康码：</td><td><font color="blue">暂未申领</font></td></tr>
						<% } else if(student.getCode().equals("绿码")){ %>
						<tr><td>健康码：</td><td><font color="green">绿码</font></td></tr>
						<% } else if(student.getCode().equals("黄码")){ %>
						<tr><td>健康码：</td><td><font color="yellow">黄码</font></td></tr>
						<% } else { %>
						<tr><td>健康码：</td><td><font color="red">红码</font></td></tr>			
						<% } %>
						<% if(student.getClockin()==1){ %>
						<tr><td>今日打卡：</td><td><font color="blue">已完成</font></td></tr>
						<% } else { %>
						<tr><td>今日打卡：</td><td><font color="red">未完成</font></td></tr>
						<% } %>
					<%	} else { %>	
						<tr><td>姓名：</td><td><%=teacher.getName()%></td></tr>	
						<tr><td>身份证号： </td><td><%=teacher.getID()%></td></tr>
						<tr><td>工号：</td><td><%=num%></td></tr>
						<tr><td>学院：</td><td><%=teacher.getInstitute()%></td></tr>
						<tr><td>角色：</td><td><%=teacher.getCharacter()%></td></tr>
						<% if(teacher.getPhone()==null){ %>
						<tr><td>手机号：</td><td>未填写</td></tr>
						<% } else { %>
						<tr><td>手机号：</td><td><%=teacher.getPhone()%></td></tr>
						<% } %>
						<% if(teacher.getCode().equals("无")){ %>
						<tr><td>健康码：</td><td><font color="blue">暂未申领</font></td></tr>
						<% } else if(teacher.getCode().equals("绿码")){ %>
						<tr><td>健康码：</td><td><font color="green">绿码</font></td></tr>
						<% } else if(teacher.getCode().equals("黄码")){ %>
						<tr><td>健康码：</td><td><font color="yellow">黄码</font></td></tr>
						<% } else { %>
						<tr><td>健康码：</td><td><font color="red">红码</font></td></tr>						
						<% } %>
						<% if(teacher.getClockin()==1){ %>
						<tr><td>今日打卡：</td><td><font color="blue">已完成</font></td></tr>
						<% } else { %>
						<tr><td>今日打卡：</td><td><font color="red">未完成</font></td></tr>
						<% } %>
					<%	} %>
						<tr><td colspan=2><a href="modifyPsw.jsp?num=<%=num%>&type=<%=type%>" class="btn btn-info" role="button">修改密码</a></td></tr>
						</table>
					</fieldset>
				</section><br>	       
				<!--版权标志-->
				<section id="copyright">Copyright ZKX   © 浙江工业大学计算机学院</section>
			</div>	
		</div>
	</div>
</div>
</body>
</html>