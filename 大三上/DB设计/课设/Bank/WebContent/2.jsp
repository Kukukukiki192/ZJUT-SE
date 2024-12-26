<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>账户管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
  <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <script>
	  function Check() {
	      var ID=document.getElementById("A_id").value.length;
	      var B_name=document.getElementById("B_name").value;
	      var A_type=document.getElementById("A_type").value;
		  var p1=document.getElementById("A_psw1").value;
	      var p2=document.getElementById("A_psw2").value;
	      
	      if (ID!=19) {
	    	  alert('银行卡号格式有误!');
	          return false;
	      } 
//	      if (B_name==null || B_name=="") {//== 和 equals都判断不了 ??? 
	      if ( B_name=="请选择") {//这样就对了 a!!!
	    	  alert('请选择开户支行!');
	          return false;
	      } 
//	      if (A_type==null || A_type=="") {
		  if ( A_type=="请选择") {
	    	  alert('请选择账户类型!');
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
<div class="container">
	<div><!-- 面包屑导航 -->
		<nav class="breadcrumb">
		  <a class="breadcrumb-item" href="index.jsp">首页</a>
		  <span class="breadcrumb-item active">账户管理</span>
		</nav>
	</div>
	<div class="card">
	    <div class="card-header"><h4>我的账户</h4></div>
	    <div class="card-body">
	    
		    <table class="table table-hover">
			    <tbody>
			   		<c:forEach var="A_id" items="${sessionScope.A_ids}" varStatus="status">
				      <tr>
				        <td>${A_id}</td>
				      <!--   <td>人民币 余额   ${A.a_money}</td> -->
				        <td><a href="Adetail?A_id=${A_id}" class="btn btn-default"><!-- '>'详情图	 跳到Adetail更新session 获得账户及其支行信息 -->			        
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-right" viewBox="0 0 16 16">
								  <path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"/>
								</svg></a></td>			
				      </tr>
			      	</c:forEach>
			    </tbody>
			  </table>
	    
	    </div> 
	    <div class="card-footer">
		    <button type="button" class="btn btn-default text-danger" data-toggle="modal" data-target="#a">+ 添加账户</button>
		    <!-- <a href="2add.jsp" class="btn btn-default text-danger">+ 添加账户</a> -->
		    
			<!-- 模态框 -->
			<div class="modal fade" id="a">
			  <div class="modal-dialog">
			    <div class="modal-content">
			 
			      <!-- 模态框头部 -->
			      <div class="modal-header">
			        <h4 class="modal-title">添加账户</h4>
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			      </div>
			 
			      <!-- 模态框主体 -->
			      <div class="modal-body">
			      	<form action="Aadd" method="post" onsubmit="return Check()">
			      		<table class="table">
							<tr><td>银行卡号</td><td><input name="A_id" id="A_id" type="text" class="form-control" required></td></tr>
							<tr><td>开户支行</td>
								<td><select name="B_name" id="B_name" class="custom-select" required>
									<option selected disabled hidden>请选择</option>
								    <option value="上海长桥支行">上海长桥支行</option>
								    <option value="杭州余杭支行">杭州余杭支行</option>
								    <option value="北京东升路支行">北京东升路支行</option>
								</select></td></tr>
							<tr><td>账户类型</td>
								<td><select name="A_type" id="A_type" class="custom-select" required>
									<option selected disabled hidden>请选择</option>
								    <option value="储蓄账户">储蓄账户</option>
								    <option value="支票账户">支票账户</option>
								</select></td></tr>
							<tr><td>持卡人姓名</td><td>${U.u_name}</td></tr>
							<tr><td>设置密码</td><td><input type="password" name="A_psw1" id="A_psw1" class="form-control" required></td></tr>
							<tr><td>确认密码</td><td><input type="password" name="A_psw2" id="A_psw2" class="form-control" required></td></tr>
						</table>
						<div style="text-align:center"><button type="submit" class="btn btn-primary">确认添加</button></div>
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