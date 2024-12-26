<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>存款</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
  <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="js/time.js"></script>
  <script>
	  function Check() {
	      var A_id=document.getElementById("A_id").value;
	      
	      if ( A_id=="请选择") {
	    	  alert('请选择存款账户!');
	          return false;
	      }    
	  }
  </script>
</head>
<body>
<div class="container">
	<div><!-- 面包屑导航 -->
		<nav class="breadcrumb">
		  <a class="breadcrumb-item" href="index.jsp">首页</a>
		  <a class="breadcrumb-item" href="3.jsp">业务办理</a>
		  <span class="breadcrumb-item active">存款</span>
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
			<div class="card">
			  	<div class="card-body">
					<form action="InSevlet" method="post" onsubmit="return Check()">
			      		<table class="table">
							<tr><td>账户号</td>
								<td><select name="A_id" id="A_id" class="custom-select" required>
								    <option selected disabled hidden>请选择</option>
								    <c:forEach var="A_id" items="${sessionScope.A_ids}" varStatus="status">
								    <option>${A_id}</option>	
								    </c:forEach>							   
									</select></td></tr>
							<tr><td>存入金额</td><td><input name="I_money" id="I_money" type="text" class="form-control" required></td></tr>	
							<tr><td>存款时间</td><td><div><div style="display:inline-block" id="displaydate"></div><div style="display:inline-block" id="displaytime"></div></div></td></tr>						
							<tr><td></td><td><button type="submit" class="btn btn-primary">确认</button>&nbsp;&nbsp;&nbsp;<button type="reset" class="btn btn-light">重置</button></td></tr>
						</table>
					</form>
				</div> 
				<div class="card-footer">
				    <button type="button" class="btn btn-default text-info" data-toggle="modal" data-target="#a">存款记录</button>
				    
					<!-- 模态框 -->
					<div class="modal fade" id="a">
					  <div class="modal-dialog modal-lg">
					    <div class="modal-content">
					 
					      <!-- 模态框头部 -->
					      <div class="modal-header">
					        <h4 class="modal-title">存款记录</h4>
					        <button type="button" class="close" data-dismiss="modal">&times;</button>
					      </div>
					 
					      <!-- 模态框主体 -->
					      <div class="modal-body">					       
						      	<table class="table">
						      		<tr align="left"><th>存款时间</th><th>存款账户</th><th>金额</th></tr>
						      		<c:forEach var="In" items="${sessionScope.Ins}" varStatus="status">
									<tr align="left" class="table-success"><td>${In.i_time}</td><td>${In.a_id}</td><td>${In.i_money}</td></tr>	
									</c:forEach>											
								</table>
					      </div>			    
					    </div>
					  </div>
					</div>	
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>