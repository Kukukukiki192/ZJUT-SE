<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.model.*,com.dao.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="time.js"></script>
<title>师生健康码管理系统 | 每日填报</title>
<script languge="JavaScript">
    function Check(){
        var phone=document.getElementById("phone");
        var a1=document.getElementsByName("a1");
        var a2=document.getElementsByName("a2");
        var a3=document.getElementsByName("a3");
        var a4=document.getElementsByName("a4");
        var a5=document.getElementsByName("a5");
        var a6=document.getElementsByName("a6");
        //var a6=document.getElementById("a6");
      /*  if(!phone.checked
        ||!a1[0].checked&&!a1[1].checked
        ||!a2[0].checked&&!a2[1].checked
        ||!a3[0].checked&&!a3[1].checked
        ||!a4[0].checked&&!a4[1].checked
        ||!a5[0].checked&&!a5[1].checked&&!a5[2].checked&&!a5[3].checked&&!a5[4].checked&&!a5[5].checked&&!a5[6].checked&&!a5[7].checked
        ||!a6[0].checked){
            alert("请填写完整!");
            return false;
        } */
        if(!phone.value){
        	alert("请填写完整!");
            return false;
        }else if(!a1[0].value&&!a1[1].value){
        	alert("请填写完整!");
            return false;
        }else if(!a2[0].value&&!a2[1].value){
        	alert("请填写完整!");
            return false;
        }else if(!a3[0].value&&!a3[1].value){
        	alert("请填写完整!");
            return false;
        }else if(!a4[0].value&&!a4[1].value){
        	alert("请填写完整!");
            return false;
        }else if(!a5[0].checked&&!a5[1].checked&&!a5[2].checked&&!a5[3].checked&&!a5[4].checked&&!a5[5].checked&&!a5[6].checked&&!a5[7].checked){
        //}else if(!a5[0].value&&!a5[1].value&&!a5[2].value&&!a5[3].value&&!a5[4].value&&!a5[5].value&&!a5[6].value&&!a5[7].value){
        	alert("请填写完整!");
            return false;
        }else if(!a6[0].checked){
        	alert("请填写完整!");
            return false;
        }
        
        alert('提交成功!')
        return true;
    }
</script>
</head>
<body>
<%	String num=request.getParameter("num");
    int type=Integer.parseInt(request.getParameter("type"));
    UserDao dao = new UserDao();
    Student student=dao.findSByNum(num);   
    Teacher teacher=dao.findTByNum(num); 
%>
<div class="container">
	<!--页眉-->
	<div id="header">
		<header>
			<div id="logo" style="display:inline-block">
				<span class="navbar-brand">师生健康码管理系统</span>
			</div>
			<div style="display:inline-block;float:right">
				<a href="me.jsp?num=<%=num%>&type=<%=type%>">我</a>	
				<a href="login.jsp">退出</a>
			</div>
		</header>
	</div>
	<div class="row">
		<div class="col-2">
			<!--导航菜单-->
			<div id="sidebar">
				<nav>
		            <ul class="nav flex-column">
		            	<%	if(type==1 || type==2 && teacher.getCharacter().equals("普通教师")) { %>
		            	<li class="nav-item"><a class="nav-link" href="index2.jsp?num=<%=num%>&type=<%=type%>">首页</a></li>
		            	<li class="nav-item"><a class="nav-link" href="clockin.jsp?num=<%=num%>&type=<%=type%>">每日填报</a></li>
		            	<li class="nav-item"><a class="nav-link" href="myCode.jsp?num=<%=num%>&type=<%=type%>">我的健康码</a></li>
		            	<%	} else { %>	
		            	<li class="nav-item"><a class="nav-link" href="index4.jsp?num=<%=num%>">首页</a></li>
						<li class="nav-item"><a class="nav-link" href="clockin.jsp?num=<%=num%>&type=2">每日填报</a></li>
						<li class="nav-item"><a class="nav-link" href="myCode.jsp?num=<%=num%>&type=2">我的健康码</a></li>
						<li class="nav-item"><a class="nav-link" href="importUser.jsp?num=<%=num%>">导入数据</a></li>
						<li class="nav-item"><a class="nav-link" href="addUser.jsp?num=<%=num%>">添加数据</a></li>
						<li class="nav-item"><a class="nav-link" href="selectS.jsp?num=<%=num%>">查询信息</a></li>
						<li class="nav-item"><a class="nav-link" href="AllUser?num=<%=num%>&type=2">教师信息</a></li>
						<li class="nav-item"><a class="nav-link" href="AllUser?num=<%=num%>&type=1">学生信息</a></li>
						<li class="nav-item"><a class="nav-link" href="Statistics?num=<%=num%>">健康码、打卡情况统计</a></li>
		            	<%	} %>
		            </ul>
		        </nav>
			</div>
		</div>
		<div class="col-10">
			<!--内容-->
			<div id="content">
				<!--面包屑导航-->
				<nav class="breadcrumb pull-right">
					<%	if(type==1 || type==2 && teacher.getCharacter().equals("普通教师")) { %>
				  	<a class="breadcrumb-item" href="index2.jsp?num=<%=num%>&type=<%=type%>">首页</a>
				  	<%	} else { %>	
				  	<a class="breadcrumb-item" href="index4.jsp?num=<%=num%>&type=<%=type%>">首页</a>
				  	<%	} %>
				  	<span class="breadcrumb-item active">每日填报</span>
				</nav>
		        <section>
		        <% if(type==2&&teacher.getCharacter().equals("系统管理员")){ %>
		        <a href="Clockin0?num=<%=num%>&type=<%=type%>" class="btn btn-info" role="button">打卡记录清零</a>
		        <% } %>
		        <% if(type==1&&student.getClockin()==1 || type==2&&teacher.getClockin()==1){ %>
		        	<h4 align="center">今日已完成打卡,不可重复打卡!</h4>
		        <% } else { %>
		        <form action="Code?num=<%=num%>&type=<%=type%>" method="post" onSubmit="return Check()">
		        	<fieldset> 
						<!-- <legend>每日填报</legend>-->
						<p><label><font color=red>*</font>个人信息:</label></p>
						<%	if(type==1) {  %>
						<p><label>姓名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><%=student.getName()%></p>
			           	<p><label>身份证号&nbsp;</label><%=student.getID()%></p>
			           	<p><label>学号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><%=num%></p>
			           	<p><label>手机号&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="phone" id="phone" value=<%=student.getPhone()%>></p>
			           	<%	} else { %>	
			           	<p><label>姓名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><%=teacher.getName()%></p>
			           	<p><label>身份证号&nbsp;</label><%=teacher.getID()%></p>
			           	<p><label>工号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><%=num%></p>
			           	<p><label>手机号&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="phone" id="phone" value=<%=teacher.getPhone()%>></p>
			           	<%	} %>			           	
			           	<p><font color=red>*</font>1.本人近期(14天内)是否去过湖北省或重点疫区?  <small>单选</small></p>
		               	<p><label><input name="a1" type="radio" value="否" />否</label><label><input name="a1" type="radio" value="是" />是</label></p>
		           		
		           		<p><font color=red>*</font>2.本人近期(14天内)是否去过国外?  <small>单选</small></p>
		           		<p><label><input name="a2" type="radio" value="否" />否</label><label><input name="a2" type="radio" value="是" />是</label></p>
		           		
		           		<p><font color=red>*</font>3.本人近期(14天内)是否接触过新冠确诊病人或疑似病人?  <small>单选</small></p>
		           		<p><label><input name="a3" type="radio" value="否" />否</label><label><input name="a3" type="radio" value="是" />是</label></p>
		               	
		               	<p><font color=red>*</font>4.本人是否被卫生部门确认为新冠肺炎确诊病例或疑似病例?  <small>单选</small></p>
		               	<p><label><input name="a4" type="radio" value="否" />否</label><label><input name="a4" type="radio" value="是" />是</label></p>
		          
		           		<p><font color=red>*</font>5.当前健康状况(若有以下状况,请在方框内勾选)  <small>多选</small></p>
		               	<p><label><input name="a5" type="checkbox" value="无异常" />无异常</label></p>
		               	<p><label><input name="a5" type="checkbox" value="发烧" />发烧(≥37.3℃)</label></p>
		           		<p><label><input name="a5" type="checkbox" value="乏力" />乏力</label></p>
		           		<p><label><input name="a5" type="checkbox" value="干咳" />干咳</label></p>
		          		<p><label><input name="a5" type="checkbox" value="鼻塞" />鼻塞</label></p>
		           		<p><label><input name="a5" type="checkbox" value="流涕" />流涕</label></p>
		           		<p><label><input name="a5" type="checkbox" value="咽痛" />咽痛</label></p>
		          		<p><label><input name="a5" type="checkbox" value="腹泻" />腹泻</label></p>
		           
		           		<p>本人郑重承诺(必选):</p>
		           		<p><label><input name="a6" id="a6" type="checkbox" value="1" />填报信息真实,愿意承担相应法律责任</label></p>          
					
						<p><button type="submit">提交</button></p>
					</fieldset>    
		        </form>
		        <% } %>
		        </section><br>  
		        <!--版权标志-->
				<section id="copyright">Copyright ZKX   © 浙江工业大学计算机学院</section>    
			</div>
		</div>
	</div>
</div>
</body>
</html>