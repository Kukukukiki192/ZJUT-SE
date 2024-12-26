<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>传智书城注册页面</title>
	<%--导入css和js --%>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/main.css" type="text/css"/>
	<script type="text/javascript">
		var emailObj;
		var usernameObj;
		var passwordObj;
		var confirmObj;

		var emailMsg;
		var usernameMsg;
		var passwordMsg;
		var confirmMsg;

		window.onload = function() {	// 页面加载之后, 获取页面中的对象
			emailObj = document.getElementById("email");
			usernameObj = document.getElementById("username");
			passwordObj = document.getElementById("password");
			confirmObj = document.getElementById("repassword");

			emailMsg = document.getElementById("emailMsg");
			usernameMsg = document.getElementById("usernameMsg");
			passwordMsg = document.getElementById("passwordMsg");
			confirmMsg = document.getElementById("confirmMsg");
		};

		function checkForm() {			// 验证整个表单
			var bEmail = checkEmail();
			var bUsername = checkUsername();
			var bPassword = checkPassword();
			var bConfirm = checkConfirm();
			return bUsername && bPassword && bConfirm && bEmail ;	// return false后, 事件将被取消
		}

		function checkEmail() {			// 验证邮箱
			var regex = /^[\w-]+@([\w-]+\.)+[a-zA-Z]{2,4}$/;
			var value =emailObj.value;
			var msg = "";
			if (!value)
				msg = "邮箱必须填写：";
			else if (!regex.test(value))
				msg = "邮箱格式不合法：";
			emailMsg.innerHTML = msg;
			emailObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
			return msg == "";
		}

		function checkUsername() {		// 验证用户名
			var regex = /^[a-zA-Z_]\w{0,9}$/;	// 字母数字下划线1到10位, 不能是数字开头
			var value = usernameObj.value;// 获取usernameObj中的文本
			var msg = "";						// 最后的提示消息, 默认为空
			if (!value)							// 如果用户名没填, 填了就是一个字符串可以当作true, 没填的话不论null或者""都是false
				msg = "用户名必须填写：";			// 改变提示消息
			else if (!regex.test(value))		// 如果用户名不能匹配正则表达式规则
				msg = "用户名不合法：";			// 改变提示消息
			usernameMsg.innerHTML = msg;		// 将提示消息放入SPAN
			usernameObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";	// 根据消息结果改变tr的颜色
			return msg == "";					// 如果提示消息为空则代表没出错, 返回true
		}

		function checkPassword() {		// 验证密码
			var regex = /^.{6,16}$/;			// 任意字符, 6到16位
			var value = passwordObj.value;
			var msg = "";
			if (!value)
				msg = "密码必须填写：";
			else if (!regex.test(value))
				msg = "密码不合法：";
			passwordMsg.innerHTML = msg;
			passwordObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
			return msg == "";
		}

		function checkConfirm() {		// 验证确认密码
			var passwordValue = passwordObj.value;
			var confirmValue = confirmObj.value;
			var msg = "";

			if(!confirmValue){
				msg = "确认密码必须填写";
			}
			else	if (passwordValue != confirmValue){
				msg = "密码必须保持一致";
			}
			confirmMsg.innerHTML = msg;
			confirmObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
			return msg == "";
		}

	</script>
	<script type="text/javascript">
		function changeImage() {
			// 改变验证码图片中的文字
			document.getElementById("img").src = "${pageContext.request.contextPath}/imageCode?time="
					+ new Date().getTime();
		}
	</script>
</head>

<body class="main">
<!-- 1.网上书城顶部 start -->
<%@include file="head.jsp"%>
<!-- 网上书城顶部  end -->
<!--2. 网上书城菜单列表  start -->
<%@include file="menu_search.jsp" %>
<!-- 网上书城菜单列表  end -->
<!-- 3.网上书城用户注册  start -->
<div id="divcontent">
	<form action="${pageContext.request.contextPath}/register" method="post" onsubmit="return checkForm();">
		<table width="850px" border="0" cellspacing="0">
			<tr>
				<td style="padding: 30px"><h1>新用户注册</h1>
					<table width="70%" border="0" cellspacing="2" class="upline">
						<tr>
							<td style="text-align: right; width: 20%">邮箱：</td>
							<td style="width: 40%">
								<input type="text" class="textinput"  id="email" name="email" onkeyup="checkEmail();"/>
							</td>
							<td colspan="2"><span id="emailMsg"></span><font color="#999999">请输入有效的邮箱地址</font></td>
						</tr>
						<tr>
							<td style="text-align: right">用户名：</td>
							<td><input type="text" class="textinput"  id="username" name="username" onkeyup="checkUsername();"/>
							</td>
							<td colspan="2"><span id="usernameMsg"></span><font color="#999999">字母数字下划线1到10位, 不能是数字开头</font></td>
						</tr>
						<tr>
							<td style="text-align: right">密码：</td>
							<td><input type="password" class="textinput"  id="password" name="password" onkeyup="checkPassword();"/></td>
							<td><span id="passwordMsg"></span><font color="#999999">密码请设置6-16位字符</font></td>
						</tr>
						<tr>
							<td style="text-align: right">重复密码：</td>
							<td>
								<input type="password" class="textinput"  id="repassword" name="repassword" onkeyup="checkConfirm();"/>
							</td>
							<td><span id="confirmMsg"></span>&nbsp;</td>
						</tr>
						<tr>
							<td style="text-align: right">性别：</td>
							<td colspan="2">&nbsp;&nbsp;
								<input type="radio" name="gender" value="男" checked="checked" /> 男
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" name="gender" value="女" /> 女
							</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td style="text-align: right">联系电话：</td>
							<td colspan="2">
								<input type="text" class="textinput"
									   style="width: 350px" name="telephone" />
							</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td style="text-align: right">个人介绍：</td>
							<td colspan="2">
								<textarea class="textarea" name="introduce"></textarea>
							</td>
							<td>&nbsp;</td>
						</tr>
					</table>


					<h1>注册验证</h1>
					<table width="80%" border="0" cellspacing="2" class="upline">
						<tr>
							<td style="text-align: right; width: 20%">输入验证码：</td>
							<td style="width: 50%">
								<input type="text" class="textinput" />
							</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td style="text-align: right; width: 20%;">&nbsp;</td>
							<td rowspan="2" style="width: 50%">
								<img src="${pageContext.request.contextPath}/imageCode" width="180"
									 height="30" class="textinput" style="height: 30px;" id="img" />&nbsp;&nbsp;
								<a href="javascript:void(0);" onclick="changeImage()">看不清换一张</a>
							</td>
						</tr>
					</table>

					<table width="70%" border="0" cellspacing="0">
						<tr>
							<td style="padding-top: 20px; text-align: center">
								<input type="image" src="images/signup.gif" name="submit" border="0" width="140" height="35"/>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</div>

<!-- 网上书城用户注册  end -->
<!--4. 网上书城下方显示 start -->
<%@ include file="foot.jsp" %>
<!-- 网上书城下方显示 start -->
</body>
</html>
