<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%> 
<%@taglib uri="/struts-tags"  prefix="s"%> 
<html> 
<head><title>用户信息页面</title> 
</head> 
<body> 
用户名: <s:property value="username" /><br> 
性别: <s:property value="gender" /><br> 
城市: <s:property value="city" /><br> 
简历: <s:property value="about" /><br> 
精通语言: <s:property value="language" /><br> 
婚否：<s:property value="marry" /> 
</body> 
</html>


