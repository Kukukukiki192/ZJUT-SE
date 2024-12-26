<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>系统管理员登录</title>
<script language="JavaScript" type="text/javascript">
    function Check(){
    	var num=document.getElementById("num");
  	  	var password=document.getElementById("password");
  		if(num.value ==""||num.value==null){
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
	<form action="login.do" method="post" onsubmit="return Check()"> 
		<fieldset> 
			<legend>系统管理员登录</legend> 
			<p><label>用户名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="num" id="num"/></label></p> 
			<p><label>密码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="password" id="password"/></label></p> 
			<p><label><input type="submit" value="登录" />&nbsp;&nbsp;<input type="reset" value="取消" /></label></p>
		</fieldset>
	</form>
</body>
</html>