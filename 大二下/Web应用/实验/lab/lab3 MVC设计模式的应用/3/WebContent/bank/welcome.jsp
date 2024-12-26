<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bank.com.model.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta  http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>Welcome Page</title>
</head>
<body>
<jsp:useBean id="customer" scope="session" type="bank.com.model.Customer"/>
<% Customer c= (Customer)session.getAttribute("customer"); %>
 欢迎你：<font color=red><%=c.getCustName()%></font>
</body>
</html>