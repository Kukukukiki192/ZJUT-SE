<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.model.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息</title>
</head>
<body>
	<table border="1">
		<tr align="center">
			<td>姓名</td>
			<td>身份证号</td>
			<td>工号</td>
			<td>学院</td>
			<td>专业</td>
			<td>班级</td>
			<td>操作</td>
		</tr>
		<tr style="background: #eeeeff">
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
	</table><a href="control.jsp">返回管理页面</a>
</body>
</html>