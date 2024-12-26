<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head><title>Sample JSP</title></head>
<body>
<p>OGNL访问数组示例!</p>
<b>cities :</b> <s:property value="cities"/> <br> 
<b>cities.length :</b> <s:property value="cities.length"/> <br> 
<b>cities[0] :</b> <s:property value="cities[0]"/> <br> 
<b>top.cities :</b> <s:property value="top.cities"/> <br>



<s:debug />
</body>
</html>
