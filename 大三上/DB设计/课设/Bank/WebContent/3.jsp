<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>业务办理</title>
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
		  <span class="breadcrumb-item active">业务办理</span>
		</nav>
	</div>
	<div class="row">
		<div class="col-2"><!-- 业务导航栏 -->
			<nav class="navbar">
			  <ul class="navbar-nav">
			    <li class="nav-item"><a href="3in.jsp" class="btn bg-info btn-lg">存款</a></li><br>
			    <li class="nav-item"><a href="3out.jsp" class="btn btn-warning btn-lg">取款</a></li><br>
			    <li class="nav-item"><a href="3transfer.jsp" class="btn btn-success btn-lg">转账</a></li><br>
			    <li class="nav-item"><a href="3loan.jsp" class="btn btn-dark btn-lg">贷款</a></li><br>
			    <li class="nav-item"><a href="3repay.jsp" class="btn btn-secondary btn-lg">还款</a></li>
			  </ul>
			</nav>
		</div>	
		<div class="col-10"><!--内容-->
			<div class="text-center"><h2>请选择您要办理的业务!</h2></div>				
		</div>
	</div>
</div>
</body>
</html>