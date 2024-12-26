<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="CusBean" class="bank.com.model.Customer"  scope="session"/>
<jsp:setProperty name="CusBean" property="*"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客户信息显示页面</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8"); %>
<h3>客户注册信息</h3>
<h4> 
邮箱：<jsp:getProperty name="CusBean" property="email" /> <br><br>
姓名：<jsp:getProperty name="CusBean" property="custName" /> <br><br>
手机号：<jsp:getProperty name="CusBean" property="phone" /> <br><br>
</h4>
</body>
</html>