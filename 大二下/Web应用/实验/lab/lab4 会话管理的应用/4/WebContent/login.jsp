<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
<script language="JavaScript" type="text/javascript">
    function Check(){
    	var username=document.getElementById("username");
  	  	var password=document.getElementById("password");
  		if(username.value ==""||username.value==null){
		  	alert("用户名不能为空！");
		  	return false;
	  	}
	  	else if(password.value == ""||password.value==null){
		  	alert("密码不能为空！");
		  	return false;
	  	}
	}
</script>
</head> 
<body>
	<form action="LoginActionServlet" method="post" Onsubmit="return Check()"> 
		<fieldset> 
			<legend>用户登录</legend> 
			<p><label>用户类型 <select name="usertype">
				<option>学生</option>
				<option>教师</option>
			</select></label></p> 
			<p><label>用户名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="username" id="username"/></label></p> 
			<p><label>密码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="password" id="password"/></label></p> 
			<p>
			<label>
				<input type="submit" value="登录" />
				<input type="reset" value="取消" /> 
			</label>
			</p>
		</fieldset>
	</form>
</body>
</html>