<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>贷款</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
  <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="js/time.js"></script>
  <script>
	  function Check() {
	      var B_city=document.getElementById("B_city").value;
	      var A_id=document.getElementById("A_id").value;
	      
	      if ( B_city=="请选择") {
	    	  alert('请选择所在城市!');
	          return false;
	      }  
	      
	      if ( A_id=="请选择") {
	    	  alert('请选择到账账户!');
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
		  <span class="breadcrumb-item active">贷款</span>
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
					<form action="LoanServlet" method="post" onsubmit="return Check()">
			      		<table class="table">
							<tr><td>所在城市</td>
								<td><select name="B_city" id="B_city" class="custom-select" required>
								    <option selected disabled hidden>请选择</option>
								    <!--  -->
								    <option>上海</option>	
								    <option>杭州</option>	
								    <option>北京</option>								   
									</select></td></tr>
							<tr><td>申请数额</td><td><input name="L_money" id="L_money" type="text" class="form-control" required></td></tr>	
							<tr><td>到账账户</td>
								<td><select name="A_id" id="A_id" class="custom-select" required>
								    <option selected disabled hidden>请选择</option>
								    <c:forEach var="A_id" items="${sessionScope.A_ids}" varStatus="status">
								    <option>${A_id}</option>	
								    </c:forEach>								   
									</select></td></tr>
							<tr><td>贷款日期</td><td><div id="displaydate"></div></td></tr>
							<tr><td></td><td><button type="submit" class="btn btn-primary">申请</button>&nbsp;&nbsp;&nbsp;<button type="reset" class="btn btn-light">重置</button></td></tr>
						</table>
					</form>
				</div> 
				<div class="card-footer">
				    <button type="button" class="btn btn-default text-info" data-toggle="modal" data-target="#a">贷款记录</button>
				    
					<!-- 模态框 -->
					<div class="modal fade" id="a">
					  <div class="modal-dialog modal-lg">
					    <div class="modal-content">
					 
					      <!-- 模态框头部 -->
					      <div class="modal-header">
					        <h4 class="modal-title">贷款记录</h4>
					        <button type="button" class="close" data-dismiss="modal">&times;</button>
					      </div>
					 
					      <!-- 模态框主体 -->
					      <div class="modal-body">					       
						      	<table class="table">
						      		<tr align="left"><th>贷款日期</th><th>到账账户</th><th>已贷金额</th></tr>
						      		
						      		<c:forEach var="Loan" items="${sessionScope.Loans}" varStatus="status">														      		
									<tr align="left" class="table-success">
										<td>${Loan.l_date}</td>
										<td>${Loan.a_id}</td>
										<td align="right">
											<div data-toggle="tooltip" data-placement="right" title="贷款详情">
												${Loan.l_money}
												<a href="Ldetail?L_id=${Loan.l_id}" class="btn btn-default"><!-- 3loan_detail.jsp -->
													<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-right" viewBox="0 0 16 16"><path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"/></svg>
												</a></div></td></tr>	
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