<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head><title>Hello</title></head>
<%! String userName="Duke"; %>
<body>    
<img src="images/duke.gif"> 
    My name is Duke. What is yours?
    <form action="" method="post">
      <input type="text" name="username" size="25">
      <input type="submit" value="提交">
      <input type="reset" value="重置">
    </form>
    <%@include file="response.jsp" %>
</body>
</html>
