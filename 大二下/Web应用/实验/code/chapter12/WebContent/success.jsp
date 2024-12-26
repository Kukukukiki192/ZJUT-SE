<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head><title>注册成功页面</title></head>
<body>
<p>注册成功！</p>
<s:property value="user" />
<p><a href="<s:url action='index' />" >返回 首页</a></p>
</body>
</html>
