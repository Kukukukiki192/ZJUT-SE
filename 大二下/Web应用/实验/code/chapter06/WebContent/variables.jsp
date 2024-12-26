<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>访问作用域变量</title></head>
<body>
 <h3>访问作用域变量</h3>
<ul>
   <li>属性1: ${attrib1}
   <li>属性1: <%=request.getAttribute("attrib1") %>
   <li>属性2: ${attrib2}
   <li>属性3: ${attrib3}
   <li>属性4: ${sessionScope.attrib4}
</ul>
</body></html>
