<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,model.Book" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head><title>图书列表</title>
<style>
   table tr,td{
  border:1px solid brown;
}
</style>
</head>
<body> 
<table>
  <tr style="background:#ababff">
    <th width="20%">书名</th><th>作者</th><th width="20%">出版社</th>
    <th>出版时间</th><th width="20%">ISBN号</th><th>价格</th>
  </tr>
  <c:forEach var="book" items="${requestScope.books}">
 	<tr style="background:#eeeeff">
		<td>${book.title}</td>
		<td>${book.author}</td>
		<td>${book.publisher}</td>
		<td>${book.date}</td>
		<td>${book.isbn}</td>
		<td>${book.price}</td>
	</tr>
  </c:forEach>
</table> 
</body></html>
