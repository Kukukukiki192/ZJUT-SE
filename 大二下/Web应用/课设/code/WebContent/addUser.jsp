<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.model.*,com.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>师生健康码管理系统 | 添加数据</title>
<style>
	label{
        display: inline-block;/*实现列对齐*/
        text-align: right;
        width: 80px;
    }
</style>
<script language="JavaScript" type="text/javascript">
	function Change(){
		var type=document.getElementById("type");
		var a1=document.getElementById("1");
		var a2=document.getElementById("2");
		var a3=document.getElementById("3");
			if(type.value=="教师"){				
				a1.style.display="block";
				a2.style.display="none";
				a3.style.display="none";
			}else{
				a1.style.display="none";
				a2.style.display="block";
				a3.style.display="block";
			}
	}
      function Check(){
    	  var type=document.getElementById("type");
    	  var name=document.getElementById("name");
    	  var ID=document.getElementById("ID");
    	  var num=document.getElementById("num1");
    	  var password=document.getElementById("password");
    	  var institute=document.getElementById("institute");    	     	 
    	  if(name.value ==""||name.value==null){
    		  alert("姓名不能为空！");
    		  return false;
    	  }
    	  if(ID.value ==""||ID.value==null){
    		  alert("身份证号不能为空！");
    		  return false;
    	  }
    	  if(num.value ==""||num.value==null){
    		  alert("工号/学号不能为空！");
    		  return false;
    	  }
    	  else if(password.value == ""||password.value ==null){
    		  alert("密码不能为空！");
    		  return false;
    	  }
    	  if(institute.value ==""||institute.value==null){
    		  alert("学院不能为空！");
    		  return false;
    	  }    	  
    	  if(type.value=="学生"){
    		  var major=document.getElementById("major");
        	  var clas=document.getElementById("clas");
    		  if(major.value ==""||major.value==null){
        		  alert("专业不能为空！");
        		  return false;
        	  }
    		  if(clas.value ==""||clas.value==null){
        		  alert("班级不能为空！");
        		  return false;
        	  }
    	  }    	
    	   return true ;
      }
</script>
</head>
<body>
<%	String num=request.getParameter("num"); 
	UserDao dao = new UserDao();
	Teacher teacher = dao.findTByNum(num); 
	String c=teacher.getCharacter(); %>
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
				 	<span class="breadcrumb-item active">添加数据</span>
				</nav>
				<!-- 核心内容 -->
  				<section>					        		
					<font color=red>${result}</font>
					<form action="Add?num=<%=num%>" method="post" onsubmit="return Check()"> 
						<fieldset> 
							<legend>添加用户<small>(学生和普通教师初始密码为身份证后8位)</small></legend> 
							<p><label>用户类型&nbsp;&nbsp; </label><select name="type" id="type" onchange="Change()">
								<option>学生</option>
								<option>教师</option>
							</select></p> 
							<p><label>姓名&nbsp;&nbsp;</label><input type="text" name="name" id="name"/></p> 
							<p><label>身份证号&nbsp;&nbsp;</label><input type="text" name="ID" id="ID"/></p> 
							<p><label>工号/学号&nbsp;&nbsp;</label><input type="text" name="num1" id="num1"/></p> 
							<p><label>密码&nbsp;&nbsp;</label><input type="password" name="password" id="password"/></p>
							<p><label>学院&nbsp;&nbsp;</label><input type="text" name="institute" id="institute"/></p> 
							
							<p id="1" style="display:none"><label>角色&nbsp;&nbsp;</label><select name="character" id="character" >
								<option>普通教师</option>
								<% if(!(c.equals("院级管理员"))){ %>
								<option>院级管理员</option>	
								<% if(!(c.equals("校级管理员"))){ %>
								<option>校级管理员</option>
								<option>系统管理员</option>																	
								<% } } %>						
							</select></p> 
							
							<p id="2"><label>专业&nbsp;&nbsp;</label><input type="text" name="major" id="major"/></p>
							<p id="3"><label>班级&nbsp;&nbsp;</label><input type="text" name="clas" id="clas"/></p>
							
							<p><label></label><button type="submit">添加</button></p>			
						</fieldset>
					</form>
				</section>	       
				<!--版权标志-->
				<section id="copyright">Copyright ZKX   © 浙江工业大学计算机学院</section>
			</div>	
		</div>
	</div>
</div>
</body>
</html>