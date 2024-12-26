<%@ page contentType="text/html; charset=UTF-8"
                pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head><title>Basic Struts 2 Application - Welcome</title>
</head>
<body>
<h3>Welcome To Struts 2!</h3>
<s:form action="hello">
	<s:textfield name="userName" label="用户名" />
	<s:submit value="提交" />
</s:form>

<p><a href="<s:url action='hello'/>">Hello User</a></p>
<p><a href="<s:url action='sample'/>">Sample JSP</a></p>
<p><a href="<s:url action='populateRegister'/>">用户注册</a></p>
</body>
</html>
