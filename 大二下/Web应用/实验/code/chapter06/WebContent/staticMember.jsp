<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>访问静态成员</title>
</head>
<body>
今天的日期是：${LocalDate.now()} <br>
Random=${Math.random()}

</body>
</html>