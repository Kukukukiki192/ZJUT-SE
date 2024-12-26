<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head><title>会员注册页面</title>
</head>
<body>
 <s:form action="memberRegister" method="post">
<h4>欢迎注册会员</h4>
<s:property value="exception.message" />
<s:textfield name="member.name" label="会员姓名"
tooltip="输入姓名" required="true"></s:textfield>
<s:password name="member.password" label="会员口令" 
tooltip="输入密码"></s:password>
<s:textfield name="member.address" label="会员地址"></s:textfield>
<s:textfield name="member.email" label="会员邮箱"></s:textfield>
<s:textfield name="member.level" label="会员级别"></s:textfield>
<s:submit value="提交" />
</s:form>
</body>
</html>