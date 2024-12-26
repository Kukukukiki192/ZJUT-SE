<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改学生信息</title>
</head>
<body>
<p>修改学生信息</p> 
<form action = "modifySInfo.do" method = "post"> 
${student.name}
	<table> 
		<tr><td></td> <td><input type="hidden" name="num" value="${student.num}"></td></tr>
		<tr><td>学院</td><td><input type="text" name="institute" value="${student.institute}"></td></tr> 
		<tr><td>专业</td><td><input type="text" name="major" value="${student.major}"></td></tr>
		<tr><td>班级</td><td><input type="text" name="class" value="${student.clas}"></td></tr>
		<tr><td><input type="submit" value="确定" ></td><td><input type="reset" value="重置" ></td></tr>
	</table>
</form>
</body>
</html>