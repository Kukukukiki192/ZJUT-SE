<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib uri="/struts-tags" prefix="s"%> 
<html> 
<head><title>注册页面</title></head> 
<body> 
<s:form action="Register"> 
      <s:textfield name="username" label="用户名" />
      <s:password name="password" label="口令" />
      <s:radio name="gender" label="性别" list="{'男','女'}" />
      <s:select name="city" list="cityList" listKey="id" listValue="name"
             headerKey="0" headerValue="城市" label="请选择城市" />
      <s:textarea name="resume" label="简历" />
      <s:checkboxlist name="language" list="langList"  label="精通语言" />
      <s:checkbox name="marry" label="婚否?" />
      <s:submit value="提交"/>
</s:form> 
</body> 
</html>


