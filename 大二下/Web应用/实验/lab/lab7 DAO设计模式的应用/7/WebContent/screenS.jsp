<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>筛选学生用户</title>
<script language="JavaScript" type="text/javascript">
function Check(){    	
	var institute=document.getElementById("institute");    	     	 
	var major=document.getElementById("major");
	var clas=document.getElementById("clas");
	if(institute.value ==""||institute.value==null){
		alert("学院不能为空！");
		return false;
	}    	      		  
	if(major.value ==""||major.value==null){
		alert("专业不能为空！");
		return false;
	}
	if(clas.value ==""||clas.value==null){
		alert("班级不能为空！");
		return false;
	}   	     	
	return true ;
}
</script>
</head>
<body>
请设置筛选条件
<form action="screenS.do" method="post" onsubmit="return Check()"> 
	<table>
		<tr><td>学院</td><td><input type="text" name="institute" id="institute"/></td></tr>
		<tr><td>专业</td><td><input type="text" name="major" id="major"/></td></tr>
		<tr><td>班级</td><td><input type="text" name="clas" id="clas"/></td></tr>
		<tr colspan="2"><td><input type="submit" value="查询" /></td></tr>
	</table>
</form><a href="control.jsp">返回</a>
</body>
</html>