<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教师用户页面</title>
</head>
<body>
<jsp:useBean id="userBean" scope="session" class="model.UserBean"/>
<!-- class换成type不行,出现错误java.lang.InstantiationException: bean login not found within scope当登入信息销毁时，获取bean中的用户信息时出错 -->
<% UserBean c= (UserBean)session.getAttribute("user"); %>
<%=c.getName()%>，欢迎您！
</body>
</html>