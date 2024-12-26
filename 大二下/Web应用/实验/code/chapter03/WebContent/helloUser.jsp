<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page errorPage="errorHandler.jsp" %>
<html>
<body>
<%
if (request.getParameter("name")==null){
throw new RuntimeException("没有指定name 请求参数。");
}
%>
Hello, <%=request.getParameter("name")%>
</body>
</html>
