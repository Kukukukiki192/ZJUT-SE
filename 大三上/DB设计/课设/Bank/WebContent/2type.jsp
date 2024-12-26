<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.model.*,com.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>账户类型</title>
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
		  <a class="breadcrumb-item" href="2detail.jsp">
		  	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-left-fill" viewBox="0 0 16 16"><path d="M3.86 8.753l5.482 4.796c.646.566 1.658.106 1.658-.753V3.204a1 1 0 0 0-1.659-.753l-5.48 4.796a1 1 0 0 0 0 1.506z"/></svg>返回</a>
		</nav>
	</div>
	<div class="card">  	
	  	<div class="card-body">
	  		<div class="row">
			  	<div class="col">账户类型</div>
			  	<div class="col" style="text-align:right">${A.a_type}</div>
			</div><br>	 
			<% Account A=(Account)session.getAttribute("A"); %>
			<% if(A.getA_type().equals("储蓄账户")){ %>
			<div class="row">
			  	<div class="col">利率</div>
			  	<div class="col" style="text-align:right">${A.a1_interest}</div>
			</div>
			<% } else {%>
			<div class="row">
			  	<div class="col">透支额</div>
			  	<div class="col" style="text-align:right">${A.a2_overdraft}</div>
			</div>
			<% } %>
		</div> 
	</div>
</div>
</body>
</html>