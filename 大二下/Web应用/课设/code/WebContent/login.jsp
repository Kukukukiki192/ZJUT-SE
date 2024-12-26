<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>师生健康码管理系统 | 登录</title>
<style>
	label{
        display: inline-block;/*实现列对齐*/
        text-align: right;
        font-size:20px;
        width: 100px;
        color: #ffffff;      
    }
	input{ width: 170px; height:20px;}
	select{ height:20px; }
	legend{
		 top: 25px; left: 90px; color: #ffffff; 
		 font-size:30px;
		 text-shadow: 3px 3px 3px #E6E6FA;
	}
	form{
		 margin:0 auto; 
		 padding: 70px 0;
		 width: 400px; 
		 font-family:"微软雅黑";
	}
	h4{ color: #ffffff; text-align:center;}
</style>
<script language="JavaScript" type="text/javascript">
	function Change(){
		var type=document.getElementById("type");
		var a1=document.getElementById("1");
		var a2=document.getElementById("2");
		var a3=document.getElementById("3");
		var a4=document.getElementById("4");
		var a5=document.getElementById("5");
		var a6=document.getElementById("6");
			if(type.value=="学生"){		
				a1.style.display="none";
				a2.style.display="block";
				a3.style.display="block";
				a4.style.display="none";
				a5.style.display="none";
				a6.style.display="block";
			}else{
				a1.style.display="block";
				a2.style.display="none";
				a3.style.display="none";
				a4.style.display="none";
				a5.style.display="none";
				a6.style.display="none";
				var character=document.getElementById("character");
				if(character.value=="普通教师"){
					a2.style.display="block";
					a3.style.display="none";
					a4.style.display="block";
					a5.style.display="none";
					a6.style.display="block";
				}else{
					a2.style.display="none";
					a3.style.display="none";
					a4.style.display="block";
					a5.style.display="block";
					a6.style.display="none";
				}
			}
	}
	function Check(){
   		var type=document.getElementById("type");
    		if(type.value=="学生"){
        		var name=document.getElementById("name");
        	  	var num1=document.getElementById("num1");
		    	var password2=document.getElementById("password2");
        	  	if(name.value ==""||name.value==null){
        			alert("姓名不能为空！");
        		  	return false;
        	  	}
        	  	if(num1.value ==""||num1.value==null){
        		  	alert("学号不能为空！");
        		  	return false;
        	  	}
        	  	if(password2.value == ""||password2.value ==null){
		    		 alert("密码不能为空！");
		    		 return false;
		    	}
    	  	}else{
				var character=document.getElementById("character");
				if(character.value=="普通教师"){
					var name=document.getElementById("name");
	        	  	var num2=document.getElementById("num2");
			    	var password2=document.getElementById("password2");
	        	  	if(name.value ==""||name.value==null){
	        			alert("姓名不能为空！");
	        		  	return false;
	        	  	}
	        	  	if(num2.value ==""||num2.value==null){
	        		  	alert("工号不能为空！");
	        		  	return false;
	        	  	}
	        	  	if(password2.value == ""||password2.value ==null){
			    		 alert("密码不能为空！");
			    		 return false;
			    	}
				}else{
					var num2=document.getElementById("num2");
			    	var password1=document.getElementById("password1");
			    	if(num2.value ==""||num2.value==null){
	        		  	alert("工号不能为空！");
	        		  	return false;
	        	  	}
			    	if(password1.value == ""||password1.value ==null){
			    		 alert("密码不能为空！");
			    		 return false;
			    	}
				}
    	  	}
    	   return true ;
    }
</script>
</head>
<body background="file/BG.JPG" style=" background-repeat:no-repeat ;background-size:100% 100%; background-attachment: fixed;">
<form action="Login" method="post" onsubmit="return Check()"> 
	<fieldset> 
		<legend>师生健康码管理系统   <small>登录...</small></legend>
		<p><label>用户类型&nbsp;&nbsp;</label>
			<select name="type" id="type" onchange="Change()">
				<option>学生</option>
				<option>教师</option>
			</select></p>			
		<p id="1" style="display:none"><label>角色&nbsp;&nbsp;</label>
			<select name="character" id="character" onchange="Change()">
				<option>普通教师</option>
				<option>系统管理员</option>
				<option>校级管理员</option>
				<option>院级管理员</option>
				</select></p>								
		<p id="2"><label>姓名&nbsp;&nbsp;</label><input type="text" name="name" id="name" placeholder="姓名"></p>
		<p id="3"><label>学号&nbsp;&nbsp;</label><input type="text" name="num1" id="num1" placeholder="学号"></p>
		<p id="4" style="display:none"><label>工号&nbsp;&nbsp;</label><input type="text" name="num2" id="num2" placeholder="工号"></p>	
		<p id="5" style="display:none"><label>密码&nbsp;&nbsp;</label><input type="password" name="password1" id="password1" placeholder="密码"></p>
		<p id="6"><label>密码&nbsp;&nbsp;</label><input type="password" name="password2" id="password2" placeholder="初始密码为身份证号后8位"></p>
		<p><label></label><button type="submit">登录</button>&nbsp;&nbsp;<button type="reset">重置</button></p>
		<p><h4>${result}</h4></p>
	</fieldset>
</form>	
</body>
</html>