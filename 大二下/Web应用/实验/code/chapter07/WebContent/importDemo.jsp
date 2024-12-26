<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html><head><title>首页</title></head>
<body>
<img src="images/duke.gif"> 
<font color="blue">欢迎访问我的首页面!</font>
<c:import url="/footer.jsp" context="/chapter07" charEncoding="UTF-8" >
    <c:param name = "email" value="hacker@163.com" /> 
</c:import>
</body></html>
