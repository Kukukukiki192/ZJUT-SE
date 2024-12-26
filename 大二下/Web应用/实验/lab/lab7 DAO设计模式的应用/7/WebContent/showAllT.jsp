<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.model.Teacher"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示所有教师信息</title>
</head>
<body>
	<table border="1">
		<tr align="center">
			<td>姓名</td>
			<td>身份证号</td>
			<td>工号</td>
			<td>学院</td>
			<td>角色</td>
			<td>操作</td>
		</tr>
		<c:forEach var="teacher" items="${requestScope.teacher}" varStatus="status">
			<%--为奇数行和偶数行设置不同的背景颜色--%>
			<c:if test="${status.count%2==0}">
				<tr style="background: #eeeeff">
			</c:if>
			<c:if test="${status.count%2!=0}">
				<tr style="background: #dedeff">
			</c:if>
			<%--用EL访问作用域变量的成员--%>
			<td>${teacher.name}</td>
			<td>${teacher.ID}</td>
			<td>${teacher.num}</td>
			<td>${teacher.institute}</td>
			<td>${teacher.character}</td>
			<td>
              <a href="modifyT.do?num=${teacher.num}">修改</a>&nbsp;
              <a href="deleteT.do?num=${teacher.num}">删除</a>
            </td>
			</tr>
		</c:forEach>
	</table>
	<form action="queryT.do" method="post">
		请输入工号： <input type="text" name="num" size="15"> <input type="submit" value="查询">
	</form><a href="control.jsp">返回</a>
</body>
</html>