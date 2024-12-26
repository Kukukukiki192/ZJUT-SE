<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
  <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="jumbotron text-center"><h1>银行业务处理系统</h1></div>
<div class="container">
	<form action="Login" method="post">
	  <div class="input-group mb-3 input-group-lg">
	    <div class="input-group-prepend">
	      <span class="input-group-text">身份证号</span>
	    </div>
	    <input type="text" class="form-control" name="U_id" id="U_id" required><!-- request.getParameter("..")取值填的是 name而不是id -->
	  </div>
	  
	  <div class="input-group mb-3 input-group-lg">
	    <div class="input-group-prepend">
	      <span class="input-group-text">登录密码</span>
	    </div>
	    <input type="password" class="form-control" name="U_psw" id="U_psw" required>
	  </div>  
	  
	  <button type="submit" class="btn btn-primary">登录</button>&nbsp;&nbsp;&nbsp;
	  <a href="register.jsp" class="btn btn-default">注册</a>
	</form>
</div>
</body>
</html>