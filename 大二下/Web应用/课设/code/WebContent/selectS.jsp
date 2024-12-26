<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.model.*,com.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>师生健康码管理系统 | 查询信息</title>
<script language="JavaScript" type="text/javascript">
function Check(){    	
	var institute=document.getElementById("institute");    
	if(institute.value ==""||institute.value==null){
		alert("学院不能为空！");
		return false;
	}    	     	
	return true ;
}
</script>
</head><!-- 点击超链接跳转的接受超链接值的首页 -->
<body>
<%	String num=request.getParameter("num");
	UserDao dao = new UserDao();
	Teacher teacher = dao.findTByNum(num); %>
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
				  	<span class="breadcrumb-item active">查询信息</span>
				</nav>
				<!-- 核心内容 -->
  				<section>
	        		<form action="SelectS?num=<%=num%>" method="post" onsubmit="return Check()"> 
						<fieldset> 
							<legend>筛选学生信息</legend>
							<% if(teacher.getCharacter().equals("院级管理员")){ %>
				        	<p><label>学院&nbsp;&nbsp;</label><input type="text" name="institute" id="institute" value=<%=teacher.getInstitute()%> readonly/><small>不可修改</small></p>
				        	<% } else { %>
							<p><label>学院&nbsp;&nbsp;</label><input type="text" name="institute" id="institute"/><small>必填</small></p>
							<% } %>
							<p><label>专业&nbsp;&nbsp;</label><input type="text" name="major" id="major"/><small>选填</small></p>
							<p><label>班级&nbsp;&nbsp;</label><input type="text" name="clas" id="clas"/><small>选填</small></p>
							<p><button type="submit">查询</button></p>
						</fieldset>  
					</form>
	        	</section><br>	       
				<!--版权标志-->
				<section id="copyright">Copyright ZKX   © 浙江工业大学计算机学院</section>
			</div>	
		</div>
	</div>
</div>
</body>
</html>