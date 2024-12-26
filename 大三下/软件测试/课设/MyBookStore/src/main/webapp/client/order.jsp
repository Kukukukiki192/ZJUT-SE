<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>电子书城</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/main.css" type="text/css" />
	<script type="text/javascript">
		var receiverAddressObj;
		var receiverNameObj;
		var receiverPhoneObj;

		window.onload = function() {	// 页面加载之后, 获取页面中的对象
			receiverAddressObj = document.getElementById("receiverAddress");
			receiverNameObj = document.getElementById("receiverName");
			receiverPhoneObj = document.getElementById("receiverPhone");
		};

		function checkOnSubmit() {			// 验证整个表单
			var receiverAddress = checkReceiverAddress();
			var receiverName = checkReceiverName();
			var receiverPhone = checkReceiverPhone();
			if(receiverAddress && receiverName && receiverPhone){
				document.getElementById("orderForm").submit();
			}else{
				return "";
			}
		}

		function checkReceiverAddress() {			// 验证收获地址
			var value =receiverAddressObj.value;
			var msg = "";
			if (!value)
				msg = "收获地址必须填写";
			receiverAddressMsg.innerHTML = msg;
			receiverAddressObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
			return msg == "";
		}

		function checkReceiverName() {		// 验证收货人
			var value =receiverNameObj.value;
			var msg = "";
			if (!value)
				msg = "收获人必须填写";
			receiverNameMsg.innerHTML = msg;
			receiverNameObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
			return msg == "";
		}

		function checkReceiverPhone() {		// 验证联系方式
			var regex =/^1[3,5,8]\d{9}$/;	//以13、15、18开头的手机号
			var value =receiverPhoneObj.value;
			var msg = "";
			if (!value)
				msg = "联系方式必须填写";
			else if (!regex.test(value))
				msg = "手机号码不合法：";
			receiverPhoneMsg.innerHTML = msg;
			receiverPhoneObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
			return msg == "";
		}

	</script>
</head>
<body class="main">
	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />
	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td><div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="${pageContext.request.contextPath }/index.jsp">首页</a>
						   &nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath}/client/cart.jsp">&nbsp;购物车</a>
						   &nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;订单
					</div>
					<form id="orderForm" action="${pageContext.request.contextPath}/createOrder" method="post">
						<table cellspacing="0" class="infocontent">
							<tr>
								<td>
								<table width="100%" border="0" cellspacing="0">
										<tr>
											<td><img src="images/buy2.gif" width="635" height="38" />
												<p>你好，${sessionScope.user.username}！欢迎您来到网上书城结算中心</p>
											</td>
										</tr>
										<tr>
											<td>
											    <table cellspacing="1" class="carttable">
													<tr>
														<td width="10%">序号</td>
														<td width="40%">商品名称</td>
														<td width="10%">价格</td>
														<td width="10%">类别</td>
														<td width="10%">数量</td>
														<td width="10%">小计</td>
													</tr>
												</table> 
												<c:set value="0" var="totalPrice"/>
												<c:forEach items="${sessionScope.cart}" var="entry" varStatus="vs">
													<table width="100%" border="0" cellspacing="0">
														<tr>
															<td width="10%">${entry.value.product.id}</td>
															<td width="40%">${entry.value.product.name}</td>
															<td width="10%">${entry.value.product.price}</td>
															<td width="10%">${entry.value.product.category}</td>
															<td width="10%">
															  <input name="text" type="text" value="${entry.value.count}" style="width:20px" readonly="readonly"/>
															</td>
															<td width="10%">${entry.value.product.price * entry.value.count}</td>
														</tr>
													</table>
													<c:set var="totalPrice" value="${totalPrice+entry.value.product.price*entry.value.count}"/>
												</c:forEach>

												<table cellspacing="1" class="carttable">
													<tr>
														<td style="text-align:right; padding-right:40px;"><font
															style="color:#FF0000">合计：&nbsp;&nbsp;${totalPrice}元</font>
															<input type="hidden" name="money" value="${totalPrice}">
														</td>
													</tr>
												</table>
												<p>
													收货地址：<input id="receiverAddress" name="receiverAddress" type="text" value=""style="width:350px" onkeyup="checkReceiverAddress();" />
													&nbsp;&nbsp;&nbsp;&nbsp;
													<span id="receiverAddressMsg"></span>
													<br/>
												        收货人：&nbsp;&nbsp;&nbsp;&nbsp;<input id="receiverName" name="receiverName" type="text" value="${sessionScope.user.username}" style="width:150px" onkeyup="checkReceiverName();" />
												    <span id="receiverNameMsg"></span>
												    &nbsp;&nbsp;&nbsp;&nbsp;
													<br/> 
													联系方式：<input type="text" id="receiverPhone" name="receiverPhone" value="${sessionScope.user.telephone}" style="width:150px" onkeyup="checkReceiverPhone();" />
													<span id="receiverPhoneMsg"></span>
													&nbsp;&nbsp;&nbsp;&nbsp;
												</p>
												<hr />
												<p style="text-align:right">
													<img src="images/gif53_029.gif" width="204" height="51" border="0" onclick="checkOnSubmit();"/>
												</p>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>
