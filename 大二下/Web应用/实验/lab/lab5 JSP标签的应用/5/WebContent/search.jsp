<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询页面</title>
</head>
<body>
<form action="SearchServlet" method="post"> 
	<input type="text" name="search"/>
	<input type="submit" name="submit" value="查询"/><br>
	<a href="BooksServlet">查看所有图书信息</a>
</form>
</body>
</html>