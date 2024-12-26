<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>教师管理</title>
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
		        	$("#teacher_id").val($(this).closest("tr").find("td").eq(0).text());
		            $("#teacher_name").val($(this).closest("tr").find("td").eq(1).text());
		            $("#teacher_sex").val($(this).closest("tr").find("td").eq(2).text());
		            $("#teacher_age").val($(this).closest("tr").find("td").eq(3).text());
		            $("#teacher_title").val($(this).closest("tr").find("td").eq(4).text());
		            $("#teacher_phone").val($(this).closest("tr").find("td").eq(5).text());
		            $("#id").val($(this).closest("tr").find("td").eq(0).text());
		        });
		    });	   
</script>
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
		<span class="breadcrumb-item active">教师管理</span>
	</nav>
	<!--内容-->
	<div class="row">
	<div class="col-7">		
		<form action="Query?x=2" method="post" class="form-inline">
			<div class="form-group search">
				<input type="text" name="no" class="form-control" placeholder="请输入教师编号">
				<input type="submit" class="btn" value="搜索">
			</div>
		</form><br>
		<table border="1" id="tab">
			<tr align="center"><th width="100">教师编号</th><th width="100">教师姓名</th><th width="100">教师性别</th><th width="100">教师年龄</th><th width="138">职称</th><th width="138">联系电话</th><th width="138">操作</th></tr>
			<c:forEach var="List" items="${requestScope.List}">
			<tr align="center"><td>${List.tno}</td><td>${List.tname}</td><td>${List.tsex}</td><td>${List.tage}</td>
			<td>${List.title}</td><td>${List.phone}</td>
			<td><button align='left' data-toggle="modal"  data-target="#addUserModal" class='btn btn-info btn-sm'>修改</button>
				<a href="Delete?no=${List.tno}&x=2" class="btn btn-info btn-sm" role="button" onclick="return del()">删除</a>
			</td></tr>
			</c:forEach>
		</table>		
		
		<form method="post" action="Modify?x=2" class="form-horizontal" target="contain" role="form" id="form_data"  style="margin: 20px;">
	    <div class="modal fade" id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	        <div class="modal-dialog ">
	            <div class="modal-content" style="width:500px;">
	                <div class="modal-header">
	                	<h4 class="modal-title" id="myModalLabel">修改教师信息</h4>
	                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>	                    
	                </div>
	                <div  class="modal-body">
	                    <form class="form-horizontal" role="form">
	                        <div class="form-group form-inline">
	                            <label for="teacher_id" class="col-sm-3 control-label">教师编号:</label>
	                            <div class="col-sm-7">
	                                <input type="text" class="form-control" id="teacher_id" name="teacher_id"  >
	                            </div>
	                        </div>	                        
	                        <div class="form-group form-inline"  style="display:none">
	                            <label for="id" class="col-sm-3 control-label">教师编号:</label>
	                            <div class="col-sm-7">
	                                <input type="text" class="form-control" id="id" name="id">
	                            </div>
	                        </div>                        
	                        <div class="form-group form-inline">
	                            <label for="teacher_name" class="col-sm-3 control-label">教师姓名:</label>
	                            <div class="col-sm-7">
	                                <input type="text" class="form-control" id="teacher_name" name="teacher_name" >
	                            </div>
	                        </div>
	                        <div class="form-group form-inline">
	                            <label for="teacher_sex" class="col-sm-3 control-label">教师性别:</label>
	                           <div class="col-sm-7">
	                           <select id="teacher_sex" name="teacher_sex"class="form-control" >
	                                      <option value="男">男</option> 
	                                      <option value="女">女</option> 
	                                </select>
	                                </div>
	                        </div>	
	                        <div class="form-group form-inline">
	                            <label for="teacher_age" class="col-sm-3 control-label">年龄:</label>
	                            <div class="col-sm-7">
	                                <input type="text" class="form-control" name="teacher_age" id="teacher_age" >
	                            </div>
	                        </div>
	                        <div class="form-group form-inline">
	                            <label for="teacher_title" class="col-sm-3 control-label">职称:</label>
	                            <div class="col-sm-7">
	                            <select id="teacher_title" name="teacher_title"class="form-control">
	                                      <option value="教授">教授</option> 
	                                      <option value="副教授">副教授</option> 
	                                      <option value="讲师">讲师</option> 
	                                      <option value="助教">助教</option> 
	                            </select>
	                            </div>
	                        </div>
	                        <div class="form-group form-inline">
	                            <label for="teacher_phone" class="col-sm-3 control-label">联系电话:</label>
	                            <div class="col-sm-7">
	                                <input type="text" class="form-control" name="teacher_phone" id="teacher_phone" >
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
		<form action="C1addTServlet" method="post"> 
			<table>
			<tr align="left"><td>教师编号</td><td><input type="text" name="tno" class="form-control" required></td></tr>
			<tr align="left"><td>教师姓名</td><td><input type="text" name="tname" class="form-control" required></td></tr>
			<tr align="left"><td>教师性别</td><td><input name="tsex" type="radio" required/>男<input name="tsex" type="radio" />女</td></tr>
			<tr align="left"><td>教师年龄</td><td><input type="text" name="tage" class="form-control" required></td></tr>
			<tr align="left"><td>职称</td><td>
				<select id="title" name="title" class="form-control" required>
	              <option value="教授">教授</option> 
	              <option value="副教授">副教授</option> 
	              <option value="讲师">讲师</option> 
	              <option value="助教">助教</option> 
	            </select></td></tr>
			<tr align="left"><td>联系电话</td><td><input type="text" name="phone" class="form-control" required></td></tr>
			<tr align="left"><td></td><td><button type="submit" class="btn btn-primary">添加</button></td></tr>
			</table>
		</form>
	</div>
	</div>
</div>
</body>
</html>