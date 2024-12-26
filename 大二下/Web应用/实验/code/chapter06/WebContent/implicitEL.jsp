<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.model.*" %>
<html><head><title>EL隐含变量的使用</title></head><body>
<% 
   Address address = new Address("上海", 
            "科技路25号","201600");
   Employee employee = new Employee("automan", 
              "hacker@163.com","8899123",address);
   session.setAttribute("employee", employee);
   Cookie cookie = new Cookie("userName","Hacker");
   response.addCookie(cookie);
 %>
<p>EL隐含变量的使用</p>
<table border="1">
 <tr><td>EL表达式</td><td>值</td></tr>
 <tr><td>\${pageContext.request.method}</td>
 <td>${pageContext.request.method}</td></tr>
 <tr><td>\${param.userName}</td><td>${param.userName}</td></tr>
 <tr><td>\${header.host}</td><td>${header.host}</td></tr>
 <tr><td>\${cookie.userName.value}</td>
 <td>${cookie.userName.value}</td></tr>
 <tr><td>\${initParam.email}</td><td>${initParam.email}</td></tr> 
 <tr><td>\${sessionScope.employee.address.street}</td>
      <td>${sessionScope.employee.address.street}</td></tr>
</table>  
</body></html>
