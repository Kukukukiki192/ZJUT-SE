<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script type="text/javascript">		
			function del() {
				if(!confirm("确认要删除？")) {
					window.event.returnValue = false;
				}
			}
			
			$(function(){
		        $("#tab").on("click", ":button", function(event){
		        	$("#student_id").val($(this).closest("tr").find("td").eq(0).text());
		            $("#student_name").val($(this).closest("tr").find("td").eq(1).text());
		            $("#student_sex").val($(this).closest("tr").find("td").eq(2).text());
		            $("#student_age").val($(this).closest("tr").find("td").eq(3).text());
		            $("#student_address").val($(this).closest("tr").find("td").eq(4).text());
		            $("#student_credits").val($(this).closest("tr").find("td").eq(5).text());
		            $("#student_bno").val($(this).closest("tr").find("td").eq(6).text());
		            $("#id").val($(this).closest("tr").find("td").eq(0).text());
		        });
		    });	   
</script>
<title>学生管理</title>
</head>
<body>
<div class="container">
	<!--导航菜单-->
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" href="C1.jsp">成绩管理系统|<small>校级管理员</small></a>
		<ul class="navbar-nav">			
			<li class="nav-item"><a class="nav-link" href="T">教师管理</a></li>
			<li class="nav-item"><a class="nav-link" href="S">学生管理</a></li>	
			<li class="nav-item"><a class="nav-link" href="Address">地区统计</a></li>			
		</ul>
		<div class="ml-auto"><a class="nav-link" href="login.jsp">退出</a></div>
	</nav>
	<!--面包屑导航-->
	<nav class="breadcrumb pull-right">
		<a class="breadcrumb-item" href="C1.jsp">首页</a>
		<span class="breadcrumb-item active">学生管理</span>
	</nav>
	<!--内容-->
	<div class="row">
	<div class="col-7">		
		<form action="Query?x=1" method="post" class="form-inline">
			<div class="form-group search">
				<input type="text" name="no" class="form-control" placeholder="请输入学号">
				<input type="submit" class="btn" value="搜索">
			</div>
		</form><br>${result}
		<table border="1" id="tab">
			<tr align="center"><th width="80">学号</th><th width="80">姓名</th><th width="80">性别</th><th width="80">年龄</th><th width="130">生源地</th><th width="150">已修学分总数</th><th width="130">班级编号</th><th width="140">操作</th></tr>
			<tr align="center"><td>${s.sno}</td><td>${s.sname}</td><td>${s.ssex}</td><td>${s.sage}</td><td>${s.address}</td><td>${s.credits}</td><td>${s.bno}</td>
			<td><button align='left' data-toggle="modal"  data-target="#addUserModal" class='btn btn-info btn-sm'>修改</button>
				<a href="Delete?no=${sList.sno}&x=1" class="btn btn-info btn-sm" role="button" onclick="return del()">删除</a>			
			</td></tr>
		</table>
		
		<form method="post" action="Modify?x=1" class="form-horizontal" target="contain" role="form" id="form_data"  style="margin: 20px;">
	    <div class="modal fade" id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	        <div class="modal-dialog ">
	            <div class="modal-content" style="width:500px;">
	                <div class="modal-header">
	                	<h4 class="modal-title" id="myModalLabel">修改学生信息</h4>
	                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>	                    
	                </div>
	                <div  class="modal-body">
	                    <form class="form-horizontal" role="form">
	                        <div class="form-group form-inline">
	                            <label for="student_id" class="col-sm-3 control-label">学号:</label>
	                            <div class="col-sm-7">
	                                <input type="text" class="form-control" id="student_id" name="student_id"  >
	                            </div>
	                        </div>	                        
	                        <div class="form-group form-inline"  style="display:none">
	                            <label for="id" class="col-sm-3 control-label">学号:</label>
	                            <div class="col-sm-7">
	                                <input type="text" class="form-control" id="id" name="id">
	                            </div>
	                        </div>                        
	                        <div class="form-group form-inline">
	                            <label for="student_name" class="col-sm-3 control-label">姓名:</label>
	                            <div class="col-sm-7">
	                                <input type="text" class="form-control" id="student_name" name="student_name" >
	                            </div>
	                        </div>
	                        <div class="form-group form-inline">
	                            <label for="student_sex" class="col-sm-3 control-label">性别:</label>
	                           <div class="col-sm-7">
	                           <select id="student_sex" name="student_sex"class="form-control" >
	                                      <option value="男">男</option> 
	                                      <option value="女">女</option> 
	                            </select>
	                            </div>
	                        </div>	
	                        <div class="form-group form-inline">
	                            <label for="student_age" class="col-sm-3 control-label">年龄:</label>
	                            <div class="col-sm-7">
	                                <input type="text" class="form-control" name="student_age" id="student_age" >
	                            </div>
	                        </div>
	                        <div class="form-group form-inline">
	                            <label for="student_address" class="col-sm-3 control-label">生源地:</label>
	                            <div class="col-sm-7">
	                            	<input type="text" class="form-control" name="student_address" id="student_address" >
	                            </div>
	                        </div>
	                        <div class="form-group form-inline">
	                            <label for="student_credits" class="col-sm-3 control-label">已修学分总数:</label>
	                            <div class="col-sm-7">
	                                <input type="text" class="form-control" name="student_credits" id="student_credits" >
	                            </div>
	                        </div>	     
	                        <div class="form-group form-inline">
	                            <label for="student_bno" class="col-sm-3 control-label">班级编号:</label>
	                            <div class="col-sm-7">
	                                <input type="text" class="form-control" name="student_bno" id="student_bno" >
	                            </div>
	                        </div>	                    	                        
	                    </form>
	                </div>
	                <div class="modal-footer">
	                    <button type="submit" class="btn btn-info">确定</button>
	                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭 </button>
	                    <span id="tip"> </span>
	                </div>
	            </div>
	        </div>
	    </div>
	</form>			
	</div>
	<div class="col-5">
		<form action="C1addSServlet" method="post"> 
			<table>
			<tr align="left"><td>学号</td><td><input type="text" name="sno" id="sno" class="form-control" required></td></tr>
			<tr align="left"><td>姓名</td><td><input type="text" name="sname" id="sname" class="form-control" required></td></tr>
			<tr align="left"><td>性别</td><td><input name="ssex" type="radio" required/>男<input name="ssex" type="radio" />女</td></tr>
			<tr align="left"><td>年龄</td><td><input type="text" name="sage" id="sage" class="form-control" required></td></tr>
			<tr align="left"><td>生源地</td><td><input type="text" name="address" id="address" class="form-control" required></td></tr>
			<tr align="left"><td>已修学分总数</td><td><input type="text" name="credits" id="credits" class="form-control" required></td></tr>
			<tr align="left"><td>班级编号</td><td><input type="text" name="bno" id="bno" class="form-control" required></td></tr>
			<tr align="left"><td></td><td><button type="submit" class="btn btn-primary">添加</button></td></tr>
			</table>
		</form>
	</div>
	</div>
</div>
</body>
</html>