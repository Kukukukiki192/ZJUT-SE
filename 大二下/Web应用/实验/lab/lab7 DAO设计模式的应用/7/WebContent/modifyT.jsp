<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改教师信息</title>
</head>
<body>
<p>修改教师信息</p> 
<form action = "modifyTInfo.do" method = "post"> 
${teacher.name}
	<table> 
	<tr><td></td> <td><input type="hidden" name="num" value="${teacher.num}"></td></tr>
	<tr><td>学院</td>	<td><input type="text" name="institute" value="${teacher.institute}"></td></tr>
	<tr><td><input type="submit" value="确定" ></td><td><input type="reset" value="重置" ></td></tr>
	</table>
</form>
</body>
</html>