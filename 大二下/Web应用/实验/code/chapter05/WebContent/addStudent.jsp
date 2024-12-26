<%@ page contentType="text/html; charset=UTF-8"
           pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.demo.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>添加学生信息</title></head>
<body>

<form action="addStudent.do?action=addStudent" method="post">
<p>请输入学生信息</p>
 ${msg}<br>
  学号<input type="text" name="sno" value="20180101"/><br>
 姓名<input type="text" name="name" value="王小明"/><br>
 年龄<input type="text" name="age" value="20"/><br>
 专业<input type="text" name="major" value="物联网工程"/><br>
 <input type="submit" value="确定"/><input type="reset" value="重置"/> 
</form>
<hr/>
<table>
<tr><td>学号</td><td>姓名</td><td>年龄</td><td>专业</td><td>是否删除</td></tr>
<c:forEach var="s" items="${studentList}">
  <tr>
     <td>${s.sno}</td><td>${s.sname}</td><td>${s.sage }</td>
<td>${s.major}</td>
<td><a href="addStudent.do?action=remove&id=${s.id}" >删除</a></td>
  </tr>
</c:forEach>
</table>
</body>
</html>
