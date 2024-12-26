<%@ page contentType="text/html;charset = UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<%! LocalDate date = null; %>  
<html><head><title>当前日期</title></head>
<body>
   <%
      date = LocalDate.now();  // 创建一个LocalDate对象
   %> 
今天的日期是：<%=date.toString() %>
</body>
</html>
