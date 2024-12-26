<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.model.Student"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示所有学生信息</title>
</head>
<body>
	<table border="1">
		<tr align="center">
			<td>姓名</td>
			<td>身份证号</td>
			<td>学号</td>
			<td>学院</td>
			<td>专业</td>
			<td>班级</td>
			<td>操作</td>
		</tr>
		<c:forEach var="student" items="${requestScope.student}" varStatus="status">
			<%--为奇数行和偶数行设置不同的背景颜色--%>
			<c:if test="${status.count%2==0}">
				<tr style="background: #eeeeff">
			</c:if>
			<c:if test="${status.count%2!=0}">
				<tr style="background: #dedeff">
			</c:if>
			<%--用EL访问作用域变量的成员--%>
			<td>${student.name}</td>
			<td>${student.ID}</td>
			<td>${student.num}</td>
			<td>${student.institute}</td>
			<td>${student.major}</td>
			<td>${student.clas}</td>
			<td>
              <a href="modifyS.do?num=${student.num}">修改</a>&nbsp;
              <a href="deleteS.do?num=${student.num}">删除</a>
            </td>
			</tr>
		</c:forEach>
	</table>
	<form action="queryS.do" method="post">
		请输入学号： <input type="text" name="num" size="15"> <input type="submit" value="查询">
	</form><a href="control.jsp">返回</a>
</body>
</html>