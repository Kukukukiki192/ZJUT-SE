<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
<script language="JavaScript" type="text/javascript">
	function Change(){
		var type=document.getElementById("type");
		var a1=document.getElementById("1");
		var a2=document.getElementById("2");
		var a3=document.getElementById("3");
			if(type.value=="教师"){				
				a1.style.display="block";
				a2.style.display="none";
				a3.style.display="none";
			}else{
				a1.style.display="none";
				a2.style.display="block";
				a3.style.display="block";
			}
	}
      function Check(){
    	  var type=document.getElementById("type");
    	  var name=document.getElementById("name");
    	  var ID=document.getElementById("ID");
    	  var num=document.getElementById("num");
    	  var password=document.getElementById("password");
    	  var institute=document.getElementById("institute");    	     	 
    	  if(name.value ==""||name.value==null){
    		  alert("姓名不能为空！");
    		  return false;
    	  }
    	  if(ID.value ==""||ID.value==null){
    		  alert("身份证号不能为空！");
    		  return false;
    	  }
    	  if(num.value ==""||num.value==null){
    		  alert("工号/学号不能为空！");
    		  return false;
    	  }
    	  else if(password.value == ""||password.value ==null){
    		  alert("密码不能为空！");
    		  return false;
    	  }
    	  if(institute.value ==""||institute.value==null){
    		  alert("学院不能为空！");
    		  return false;
    	  }    	  
    	  if(type.value=="学生"){
    		  var major=document.getElementById("major");
        	  var clas=document.getElementById("clas");
    		  if(major.value ==""||major.value==null){
        		  alert("专业不能为空！");
        		  return false;
        	  }
    		  if(clas.value ==""||clas.value==null){
        		  alert("班级不能为空！");
        		  return false;
        	  }
    	  }    	
    	   return true ;
      }
</script>
</head>
<body>
<form action="register.do" method="post" onsubmit="return Check()"> 
		<fieldset> 
			<legend>用户注册</legend> 
			<p><label>用户类型 <select name="type" id="type" onchange="Change()">
				<option>学生</option>
				<option>教师</option>
			</select></label></p> 
			<p><label>姓名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="name" id="name"/></label></p> 
			<p><label>身份证号&nbsp;<input type="text" name="ID" id="ID"/></label></p> 
			<p><label>工号/学号<input type="text" name="num" id="num"/></label></p> 
			<p><label>密码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="password" id="password"/></label></p> 
			<p><label>学院&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="institute" id="institute"/></label></p> 
			
			<p id="1" hidden><label>角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select name="character" id="character" >
				<option>系统管理员</option>
				<option>校级管理员</option>
				<option>院级管理员</option>
				<option selected="普通教师">普通教师</option>
			</select></label></p> 
			
			<p id="2"><label>专业&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="major" id="major"/></label></p>
			<p id="3"><label>班级&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="clas" id="clas"/></label></p>
			
			<p><label>
				<input type="submit" value="注册" />
				<input type="reset" value="取消" /> 
			</label></p>
		</fieldset>
	</form>
</body>
</html>