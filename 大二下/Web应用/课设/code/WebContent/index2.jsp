<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.model.*,com.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>师生健康码管理系统 | 首页</title>
</head><!-- 点击超链接跳转的接受超链接值的首页 -->
<body>
<%	String num=request.getParameter("num");
    int type=Integer.parseInt(request.getParameter("type")); %>
<div class="container">
	<!--页眉-->
	<div id="header" class="navbar-header">
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
		            	<li class="nav-item"><a class="nav-link" href="index2.jsp?num=<%=num%>&type=<%=type%>">首页</a></li>
						<li class="nav-item"><a class="nav-link" href="clockin.jsp?num=<%=num%>&type=<%=type%>">每日填报</a></li>
						<li class="nav-item"><a class="nav-link" href="myCode.jsp?num=<%=num%>&type=<%=type%>">我的健康码</a></li>
		            </ul>
		        </nav>
			</div>
		</div>
		<div class="col-10">
			<!--内容-->
			<div id="content">
				<!--面包屑导航-->
	       		<nav class="breadcrumb pull-right">
				  <span class="breadcrumb-item active">首页</span>
				</nav>
				<!-- 核心内容 -->
  				<section>
	        		<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2019年底开始流行的新型冠状病毒(2019-nCoV)疫情给全世界人民带来了无法考量的灾难。
		        	在全国人民众志成城地抗疫下，我国的疫情于3月份逐渐得到了有效控制。浙江省人民政府新闻办公室于2020年4月3日下午举行第四十一场新冠肺炎疫情防控工作新闻发布会，
		        	浙江省教育厅公布了开学复课方案。为确保开学安全，浙江省各地教育主管部门和学校制定了一系列保障措施。一是在开学前，对即将返校的师生健康状况作了全面排摸，按“一人一档”
		        	要求建立师生健康信息档案。二是在开学后，师生继续凭“健康码+测体温”受控入校，健康状况有异常的不得进校，对因病请假缺课的学生要追踪病因。</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;健康码是以个人健康数据为基础，由居民自主通过健康登记系统网上申报，结合新冠肺炎疫情相关数据
					进行比对核验，生成个人专属二维码。杭州市于2020年2月11日率先在全国推出绿色、黄色和红色的健康码，<mark><font color="green">绿码</font></mark>可以直接进入杭州，<mark><font color="red">红码</font></mark>集中隔离14天，<mark><font color="yellow">
		        	黄码</font></mark>隔离7天以内。</p>
				</section>	       
				<!--版权标志-->
				<section id="copyright">Copyright ZKX   © 浙江工业大学计算机学院</section>
			</div>	
		</div>
	</div>
</div>
</body>
</html>