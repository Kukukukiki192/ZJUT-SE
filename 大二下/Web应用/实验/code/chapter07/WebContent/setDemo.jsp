<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="product" class="com.model.Product" scope="session"/>
<html>
<head><title>Set Tag Example</title></head>
<body>
<c:set target="${product}" property="pname" value="苹果iPhone 8手机" />
<c:out value="${sessionScope.product.pname}" />  <br>
<c:set target="${product}" property="pname">
   OLYMPUS数码相机 
</c:set>
<c:out value="${product.pname}" />
</body></html>
