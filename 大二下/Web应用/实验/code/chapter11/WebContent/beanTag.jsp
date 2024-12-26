<%@ page contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head><title>Bean Tag Example!</title></head>
<body>
 <p>Bean Tag Example</p>
 <s:bean name="com.model.Converter" var="converter">
    <s:param name="celcius">37</s:param> 
 </s:bean>
  37&deg;C=<s:property value="#converter.fahrenheit"/>&deg;F
</body>
</html>
