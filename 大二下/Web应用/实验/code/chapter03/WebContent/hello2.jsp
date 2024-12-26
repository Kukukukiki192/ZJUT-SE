<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head><title>Hello</title></head>
<body>
    <img src="images/duke.gif"> 
    My name is Duke. What is yours?
    <form action="" method="post">
      <input type="text" name="username" size="25">
      <input type="submit" value="提交">
      <input type="reset" value="重置">
    </form>
    <% String userName = request.getParameter("username");
       request.setAttribute("username",userName);
    %>
    <jsp:include page="response2.jsp" />
</body>
</html>	
