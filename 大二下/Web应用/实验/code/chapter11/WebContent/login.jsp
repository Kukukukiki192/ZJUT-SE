<%@ page contentType="text/html; charset=UTF-8"
           pageEncoding="UTF-8"%>  
<%@ taglib prefix="s" uri="/struts-tags" %> 
<html>
<head><title>登录页面</title></head>
<body>
<p>请输入用户名和密码：</p>

<s:form action="Login">
  <s:textfield name="user.username" label="用户名" 
       tooltip="输入用户名" labelposition="left" />
  <s:password name="user.password" label="密码"
       tooltip="输入密码" labelposition="left" />
  <s:submit value="登录" align="center" />
</s:form>
</body>
</html>

