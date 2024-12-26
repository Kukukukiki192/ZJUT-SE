<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.model.Teacher"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教师信息</title>
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
		<tr style="background: #eeeeff">
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
	</table><a href="control.jsp">返回管理页面</a>
</body>
</html>