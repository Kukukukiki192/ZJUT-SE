<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>会员登录</title>
</head>
<body>
<s:form action="memberLogin" method="post">
  <s:textfield name="member.name" label="会员姓名"></s:textfield>
  <s:password name="member.password" label="会员口令"></s:password>
  <s:submit value="提交"></s:submit>
</s:form>
</body>
</html>
