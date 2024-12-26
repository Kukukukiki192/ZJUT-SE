<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
  <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
	<div><!-- 面包屑导航 -->
		<nav class="breadcrumb">
		  <a class="breadcrumb-item" href="index.jsp">首页</a>
		  <span class="breadcrumb-item active">个人信息</span>
		</nav>
	</div>
	<div class="card">
	  	<div class="card-header"><h4>我的资料</h4></div>
	  	<div class="card-body">
			<table class="table">
				<tr><td>身份证号</td><td>${U.u_id}</td></tr>
				<tr><td>姓名</td><td>${U.u_name}</td></tr>
				<tr><td>电话</td><td>${U.u_phone}</td></tr>
				<tr><td>所在城市</td><td>${U.u_city}</td></tr>
			</table>
		</div> 
	  	<div class="card-footer">
		    <button type="button" class="btn btn-default text-info" data-toggle="modal" data-target="#a">修改密码</button>
		    
			<!-- 模态框 -->
			<div class="modal fade" id="a">
			  <div class="modal-dialog">
			    <div class="modal-content">
			 
			      <!-- 模态框头部 -->
			      <div class="modal-header">
			        <h4 class="modal-title">修改密码</h4>
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			      </div>
			 
			      <!-- 模态框主体 -->
			      <div class="modal-body">
				        	<form action="Upsw" method="post">
							  <div class="input-group mb-3 input-group-lg">
							    <div class="input-group-prepend"><span class="input-group-text">输入原密码</span></div>
							    <input name="U_psw1" id="U_psw1" type="password" class="form-control" required>
							  </div>						  
							  <div class="input-group mb-3 input-group-lg">
							    <div class="input-group-prepend"><span class="input-group-text">输入新密码</span></div>
							    <input name="U_psw2" id="U_psw2" type="password" class="form-control" required>
							  </div>  						 
							  <div style="text-align:center"><button type="submit" class="btn btn-primary">确认修改</button></div> 
							</form>
			      </div>			    
			    </div>
			  </div>
			</div>	
		</div>
	</div>
</div>
</body>
</html>