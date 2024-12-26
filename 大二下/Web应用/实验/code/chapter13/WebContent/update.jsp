<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>修改会员信息</title>
</head>
<body>
   <s:form action="memberUpdate" method="post">
<h4>修改会员信息</h4>
<s:actionerror />
<s:hidden name="member.id" value="%{member.id}"></s:hidden>
<s:textfield name="member.name" label="会员姓名" required="true">
</s:textfield>
<s:textfield name="member.password" label="会员口令">
</s:textfield>
<s:textfield name="member.address" label="会员地址">
</s:textfield>
<s:textfield name="member.email" label="会员邮箱">
</s:textfield>
<s:textfield name="member.level" label="会员级别">
</s:textfield>
<s:submit value="提交" />
     </s:form>
</body>
</html>
