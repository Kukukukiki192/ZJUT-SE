<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.model.*,com.dao.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>贷款详情</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
  <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<div><!-- 面包屑导航 -->
		<nav class="breadcrumb">
		  <a class="breadcrumb-item" href="3loan.jsp">
		  	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-left-fill" viewBox="0 0 16 16"><path d="M3.86 8.753l5.482 4.796c.646.566 1.658.106 1.658-.753V3.204a1 1 0 0 0-1.659-.753l-5.48 4.796a1 1 0 0 0 0 1.506z"/></svg>返回</a>
		</nav>
	</div>
	<div class="card">  	
		<div class="card-header"><h4>贷款详情</h4></div>
	  	<div class="card-body">
	  		<table class="table">
				<tr><td>贷款号</td><td>${L.l_id}</td></tr>
				<tr><td>申请人</td><td>${L.u_name}</td></tr>
				<tr><td>已贷金额</td><td>${L.l_money}</td></tr>
				<tr><td>贷款日期</td><td>${L.l_date}</td></tr>
				<tr><td>贷款发放支行</td><td>${L.b_name}</td></tr>
				<tr><td>负责人</td>
					<td>
						<div data-toggle="tooltip" data-placement="right" title="负责人详情">
							徐大大
							<button type="button" class="btn btn-default text-info" data-toggle="modal" data-target="#a"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-right" viewBox="0 0 16 16"><path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"/></svg></button>
				    	</div>
						<!-- 模态框 -->
						<div class="modal fade" id="a">
						  <div class="modal-dialog">
						    <div class="modal-content">
						 
						      <!-- 模态框头部 -->
						      <div class="modal-header">
						        <h4 class="modal-title">负责人详情</h4>
						        <button type="button" class="close" data-dismiss="modal">&times;</button>
						      </div>
						 
						      <!-- 模态框主体 -->
						      <div class="modal-body">					       
							      	<table class="table">
										<tr><td width="50%"  align="right">负责人</td><td align="left">徐大大</td></tr>
										<tr><td align="right">负责人类型</td><td align="left">领导</td></tr><!-- 员工 -->
										<tr><td align="right">所在城市</td><td align="left">上海</td></tr>
										<tr><td align="right">所属支行</td><td align="left">上海长桥支行</td></tr>
										<tr><td align="right">开始工作日期</td><td align="left">2018-3-18</td></tr>
										<tr><td align="right">联系电话</td><td align="left">15287117652<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-telephone" viewBox="0 0 16 16"><path fill-rule="evenodd" d="M3.654 1.328a.678.678 0 0 0-1.015-.063L1.605 2.3c-.483.484-.661 1.169-.45 1.77a17.568 17.568 0 0 0 4.168 6.608 17.569 17.569 0 0 0 6.608 4.168c.601.211 1.286.033 1.77-.45l1.034-1.034a.678.678 0 0 0-.063-1.015l-2.307-1.794a.678.678 0 0 0-.58-.122l-2.19.547a1.745 1.745 0 0 1-1.657-.459L5.482 8.062a1.745 1.745 0 0 1-.46-1.657l.548-2.19a.678.678 0 0 0-.122-.58L3.654 1.328zM1.884.511a1.745 1.745 0 0 1 2.612.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z"/></svg></td></tr>
									</table>
						      </div>			    
						    </div>
						  </div>
						</div>	
					
					
					</td>			
				</tr>
			</table>
		</div> 
	</div>
</div>
</body>
</html>