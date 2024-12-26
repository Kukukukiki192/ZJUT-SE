<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>输入学生信息</title>
</head>
<body>
<form action="FirstServlet" method="post">
   学号<input type="text" name="sno" size="15" /><br>
   姓名<input type="text" name="sname" size="15"/><br>
   <input type="submit" value="登录" /> 
   <input type="reset" value="取消" />
</form>
</body>

</html>