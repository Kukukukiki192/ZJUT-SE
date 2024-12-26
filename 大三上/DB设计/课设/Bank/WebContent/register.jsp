<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册页</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
  <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <script>
	  function Check() {
		  //var ID=document.getElementById("U_id");		  
		  //var phone=document.getElementById("U_phone");		  
		  //var p1=document.getElementById("U_psw1");
	      //var p2=document.getElementById("U_psw2");
	      var ID=document.getElementById("U_id").value.length;
	      var phone=document.getElementById("U_phone").value.length;
		  var p1=document.getElementById("U_psw1").value;
	      var p2=document.getElementById("U_psw2").value;

	      //var pattern = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X|x)$/;
	      //if (!pattern.test(ID)) {
	      if (ID!=18) {
	    	  alert('身份证号格式有误!');
	          return false;
	      } 
	      		  
	      //var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
	      //if (!myreg.test(phone)) {
	      if (phone!=11) {
	    	  alert('手机号格式有误!');
	          return false;
	      } 
	      
	      if (p1!=p2) {
	    	  alert('2次密码输入不一致!');
	          return false;
	      } 
	  }
  </script>
</head>
<body>
<div class="jumbotron text-center"><h1>银行业务处理系统</h1></div>
<div class="container">
	<div><!-- 面包屑导航 -->
		<nav class="breadcrumb">
		  <a class="breadcrumb-item" href="login.jsp">
		  	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-left-fill" viewBox="0 0 16 16"><path d="M3.86 8.753l5.482 4.796c.646.566 1.658.106 1.658-.753V3.204a1 1 0 0 0-1.659-.753l-5.48 4.796a1 1 0 0 0 0 1.506z"/></svg>返回</a>
		</nav>
	</div>
	<div class="card">
	  	<div class="card-header"><h4>请填写注册信息</h4></div>
	  	<div class="card-body">
					<form action="Register" method="post" onsubmit="return Check()">
			      		<table class="table">
							<tr><td>身份证号</td><td><input type="text" class="form-control" required name="U_id" id="U_id"></td></tr>
							<tr><td>姓名</td><td><input type="text" class="form-control" required name="U_name" id="U_name"></td></tr>
							<tr><td>电话</td><td><input type="text" class="form-control" required name="U_phone" id="U_phone"></td></tr>
							<tr><td>所在城市</td>
								<td><select class="custom-select" name="U_city"  id="U_city">
									<option selected disabled hidden>请选择</option>
								    <option>上海</option>	
								    <option>杭州</option>	
								    <option>北京</option>	</select></td></tr>
							<tr><td>登录密码</td><td><input type="password" name="U_psw1" id="U_psw1" class="form-control" required></td></tr>
							<tr><td>确认密码</td><td><input type="password" name="U_psw2" id="U_psw2" class="form-control" required></td></tr>
							<tr><td></td><td><button type="submit" class="btn btn-primary">确认</button>&nbsp;&nbsp;&nbsp;<button type="reset" class="btn btn-light">重置</button></td></tr>						
						</table>
					</form>
		</div>
	</div>
</div>
</body>
</html>