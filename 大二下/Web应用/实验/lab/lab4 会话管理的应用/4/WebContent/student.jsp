<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生用户页面</title>
</head>
<body>
<jsp:useBean id="userBean" scope="session" class="model.UserBean"/>
<% UserBean c= (UserBean)session.getAttribute("user"); %>
<%=c.getName()%>同学，欢迎您！
</body>
</html>