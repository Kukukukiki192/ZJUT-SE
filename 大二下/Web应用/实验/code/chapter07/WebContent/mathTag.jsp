<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="demo" uri="http://www.mydomain.com/sample" %>
<html><head><title>动态属性</title></head>
<body>
<p>动态属性的使用</p>
    <table border="1">
      <demo:mathtag num="6" pow="2" min="4" max="8"/>
      <demo:mathtag num="${5*2}" pow="2" />
    </table>
</body></html>
