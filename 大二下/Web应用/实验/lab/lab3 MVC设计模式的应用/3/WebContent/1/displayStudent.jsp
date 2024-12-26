<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="StuBean" class="stu.Student"  scope="session"/>
<jsp:setProperty name="StuBean" property="*"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息显示页面</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8"); %>
<h3>读取设置后的属性值</h3>
<h4> 
学生学号：<jsp:getProperty name="StuBean" property="stuid" /> <br><br>
学生姓名：<jsp:getProperty name="StuBean" property="name" /> <br><br>
学生专业：<jsp:getProperty name="StuBean" property="major" /> <br><br>
</h4>
</body>
</html>