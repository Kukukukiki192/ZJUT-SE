<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>成绩管理系统</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container">
<form action="LoginServlet" method="post" onsubmit="return Check()" class="form-signin"> 
	<fieldset> 
		<legend>成绩管理系统|<small>登录</small></legend>
		<p><label>用户类型</label>
			<select name="type" id="type" class="form-control" required autofocus>
				<option>学生</option>
				<option>教师</option>
				<option>校级管理员</option>
				<option>院级管理员</option>
			</select></p>											
		<p><label>用户名</label><input type="text" name="name" id="name" class="form-control" placeholder="用户名" required ></p>
		<p><label>密码</label><input type="password" name="psw" id="psw" class="form-control" placeholder="密码" required ></p>
		<p><button type="submit" class="btn btn-primary">登录</button>&nbsp;&nbsp;<button type="reset" class="btn btn-primary">取消</button></p>
		<p><h4>${result}</h4>
	</fieldset>
</form>	
</div>
</body>
</html>