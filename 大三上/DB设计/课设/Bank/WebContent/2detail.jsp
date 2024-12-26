<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>账户详情</title>
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
		  <a class="breadcrumb-item" href="2.jsp">账户管理</a>
		  <span class="breadcrumb-item active">账户详情</span>
		</nav>
	</div>
	<div class="card">
	    <div class="card-header">
		<!-- 账户号	账户类型 -->
		<!-- 余额		****.** -->
			<div class="row">
			  	<div class="col">${A.a_id}</div>
			  	<div class="col" style="text-align:right">
					<a href="2type.jsp" class="btn btn-default">
						${A.a_type}
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-right" viewBox="0 0 16 16"><path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"/></svg>
					</a>
				</div>
			</div><br>
			<div class="row">
			  	<div class="col">人民币 余额</div>
			  	<div class="col" style="text-align:right">${A.a_money}</div>
			</div><br>
		</div>
		
		
	    <div class="card-body">
			<div class="row">
			  <div class="col" style="text-align:center">
			  <button type="button" class="btn btn-light btn-lg" data-toggle="modal" data-target="#a">查询明细</button>
			  			  
			  <!-- 模态框 -->
				<div class="modal fade" id="a">
				  <div class="modal-dialog modal-lg">
				    <div class="modal-content">
				 
				      <!-- 模态框头部 -->
				      <div class="modal-header">
				        <h4 class="modal-title">查询明细</h4>
				        <button type="button" class="close" data-dismiss="modal">&times;</button>
				      </div>
				 
				      <!-- 模态框主体 -->
				      <div class="modal-body">
				      	<!-- <div class="row">
			  				<div class="col">当页人民币汇总</div>
			  				<div class="col text-danger">收:+</div>
			  				<div class="col text-success">支:-</div>
			  			</div><br>-->
				      	<table class="table">
							<tr align="left"><td width="40%">时间</td><td width="30%">交易类型</td><td width="30%">金额</td></tr>	
							
							<c:forEach var="Record" items="${sessionScope.Records}" varStatus="status">	
							<tr class="table-success">
								<td>${Record.time}</td><td>${Record.type}</td><td>${Record.money}</td>
							</tr>
							</c:forEach>
						</table>
				      </div>						 
				    </div>
				  </div>
				</div>		  
			  </div>
			  
			  <div class="col" style="text-align:center">
			  	<button type="button" class="btn btn-light btn-lg" data-toggle="modal" data-target="#b">开户支行</button>
				 
				<!-- 模态框 -->
				<div class="modal fade" id="b">
				  <div class="modal-dialog">
				    <div class="modal-content">				 
				      <!-- 模态框头部 -->
				      <div class="modal-header">
				        <h4 class="modal-title">开户支行</h4>
				        <button type="button" class="close" data-dismiss="modal">&times;</button>
				      </div>				 
				      <!-- 模态框主体 -->
				      <div class="modal-body">
				     	<table class="table">
							<tr><td width="50%"  align="right">支行名</td><td align="left">${B.b_name}</td></tr>
							<tr><td align="right">所在城市</td><td align="left">${B.b_city}</td></tr>
							<tr><td align="right">支行资产</td><td align="left">${B.b_money}</td></tr>
						</table>
				      </div>
				    </div>
				  </div>
				</div>		  
			  </div>
			</div><br>
			
			
			<div class="row">
			  <div class="col" style="text-align:center">
			  	<button type="button" class="btn btn-light btn-lg" data-toggle="modal" data-target="#c">密码管理</button>
			  
			  <!-- 模态框 -->
				<div class="modal fade" id="c">
				  <div class="modal-dialog">
				    <div class="modal-content">
				 
				      <!-- 模态框头部 -->
				      <div class="modal-header">
				        <h4 class="modal-title">密码管理</h4>
				        <button type="button" class="close" data-dismiss="modal">&times;</button>
				      </div>
				 
				      <!-- 模态框主体 -->
				      <div class="modal-body">
				        	<h4>修改密码</h4>
				        	<form action="Apsw" method="post">
							  <div class="input-group mb-3 input-group-lg">
							    <div class="input-group-prepend"><span class="input-group-text">输入原密码</span></div>
							    <input name="A_psw1" id="A_psw1" type="password" class="form-control" required>
							  </div>						  
							  <div class="input-group mb-3 input-group-lg">
							    <div class="input-group-prepend"><span class="input-group-text">输入新密码</span></div>
							    <input name="A_psw2" id="A_psw2" type="password" class="form-control" required>
							  </div>  						  
							  <button type="submit" class="btn btn-primary">确认修改</button>
							</form>
				      </div>			 
				    </div>
				  </div>
				</div>		  
			  </div>
			  
			  <div class="col" style="text-align:center">
			  	<button type="button" class="btn btn-light btn-lg" data-toggle="modal" data-target="#d">账户挂失</button>
			  
			  <!-- 模态框 -->
				<div class="modal fade" id="d">
				  <div class="modal-dialog">
				    <div class="modal-content">
				 
				      <!-- 模态框头部 -->
				      <div class="modal-header">
				        <h4 class="modal-title">账户挂失</h4>
				        <button type="button" class="close" data-dismiss="modal">&times;</button>
				      </div>
				 
				      <!-- 模态框主体 -->
				      <div class="modal-body">
				        	<h4>请确认如下信息</h4>
								<table class="table">
									<tr><td width="50%"  align="right">挂失账号</td><td align="left">${A.a_id}</td></tr>
									<tr><td align="right">户名</td><td align="left">${U.u_name}</td></tr>
									<tr><td align="right">开户行</td><td align="left">${B.b_name}</td></tr>
									<tr><td align="right">人民币余额</td><td align="left">${A.a_money}</td></tr>
									<tr><td align="right">临时挂失期限</td><td align="left">15天</td></tr>
								</table>
							<!-- <form action="Alose" method="post">				  
							  <button type="submit" class="btn btn-primary">确定</button>
							</form><br>-->
							<a href="Alose" class="btn btn-primary">确定</a>
														
							<hr style="border-top:1px dashed #987cb9;" width="100%" color="#987cb9" size=1>
							<p class="text-center"><strong>温馨提示</strong></p>
							<p class="text-left">1.临时挂失:储蓄卡/存折临时挂失有效期为15个自然日(含挂失当日),到期后自动解除挂失,账户状态恢复正常。临时挂失生效后，,如您开户证件是二代身份证,您可在我行手机银行办理正式挂失或者持您的身份证到营业网点补办正式挂失手续。如您开户证件是非身份证,请您及时持有效开户证件到营业网点补办正式挂失手续。临时挂失免收手续费;</p>
					        <p class="text-left">2.储蓄卡/存折临时挂失或正式挂失生效后,受影响交易参考如下:第三方快捷支付、信用卡自动还款、个人贷款还款、工银信使缴费等将进行止付(涉及存折交易除外);购买理财产品的交易账户在挂失状态下不可以修改自动再投标志。不受影响交易参考如下:无介质存款、接收汇款、投资理财类产品到期或赎回、贵金属类业务平仓或赎回、代发工资等资金一般均可入账。基金定投、如意金、积存金(积存一号)定期积存、积存金(积存二号)定期积存、实物贵金属递延保证金扣划等,不受影响。对于其他类型业务,请您随时关注账户资金变化,并以实际入账为准。 </p>
					        <p class="text-left">3.点击确认挂失后挂失立即生效。</p>							
				      </div>
				    </div>
				  </div>
				</div>
			  </div>
			</div><br>
			
			
			<div class="row">
			  <div class="col" style="text-align:center">
			  	<button type="button" class="btn btn-light btn-lg" data-toggle="modal" data-target="#e">删除账户</button>
			  
			  <!-- 模态框 -->
				<div class="modal fade" id="e">
				  <div class="modal-dialog">
				    <div class="modal-content">			 
				      <!-- 模态框头部 -->
				      <div class="modal-header">
				        <h4 class="modal-title">删除账户</h4>
				        <button type="button" class="close" data-dismiss="modal">&times;</button>
				      </div>			 
				      <!-- 模态框主体 -->
				      <div class="modal-body">
				    	<table class="table">
							<tr><td width="50%"  align="right">账户号</td><td align="left">${A.a_id}</td></tr>
							<tr><td align="right">人民币 余额</td><td align="left">${A.a_money}</td></tr>
						</table>		
						<a href="Adelete" class="btn btn-primary">确定</a>		        
				      </div>			 			 
				    </div>
				  </div>
				</div>
			  </div>		  
			  <div class="col"></div>
			</div>				
	    </div> 
	</div>
</div>
</body>
</html>