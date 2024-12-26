<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="demo" uri="http://www.mydomain.com/sample" %>
<html><title>Welcome Tag</title><body>
   <p><demo:welcome /></p>
   <p><demo:welcome user="小明" /></p>
   <p><demo:welcome user="${param.userName}" /></p>
   <p><demo:welcome user='<%= request.getParameter("userName") %>'/> </p>
</body>
</html>
