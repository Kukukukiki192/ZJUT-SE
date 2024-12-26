<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head><title>用户注册</title></head>
<body>
<p>注册一个新用户</p>
<s:form action="Register">
       
<s:textfield name="user.username" label="用户名" />
   <s:password name="user.password" label="口令" />
   <s:textfield name="user.age"  label="年龄"  />
   <s:textfield name="user.email"  label ="邮箱地址"/>  
   <s:submit value="注册"/>
</s:form>	
</body>
</html>
