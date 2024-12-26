<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head><title>会员管理系统</title>
</head>
<body>
<h3>会员管理系统</h3>
<a href="<s:url action='register'/>">1.会员注册</a>
<a href="<s:url action='login'/>">2.会员登录</a>
<a href="<s:url action='memberQuery'/>">3.查询所有会员</a>

<p><a href="<s:url action='hello'/>">Hello User</a></p>
<s:form action="hello">
	   <s:textfield name="userName" label="用户名" />
	   <s:submit value="提交" />
</s:form>
</body>
</html>
