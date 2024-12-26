<%@ page contentType="text/html; charset=UTF-8"
                pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head><title>Basic Struts 2 Application - Welcome</title>
</head>
<body>
<h3>Welcome To Struts 2!</h3>
<p><a href="<s:url action='hello'/>">Hello User</a></p>
<p><a href="<s:url action='registerInput' />">用户注册</a></p>
<p><a href="<s:url action='loginInput' />">用户登录</a></p>
<p><a href="<s:url action='Register' />">注册</a></p>
</body>
</html>
