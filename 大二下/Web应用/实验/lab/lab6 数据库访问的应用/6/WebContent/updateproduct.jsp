<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,model.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品信息页面</title>
</head>
<body>
<%	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");    
    String pname = request.getParameter("pname"); 	
	String price = request.getParameter("price");
	String stock = request.getParameter("stock");
%>
<form action = "updateproduct.do?id=<%=id%>" method="post">
 请输入商品<%=id%>的修改信息：<br>
 商品名称：<input type = "text" name="pname" size="30" value=<%=pname%>><br><br>
 商品价格：<input type = "text" name="price" size="30" value=<%=price%>><br><br>
 商品库存：<input type = "text" name="stock" size="30" value=<%=stock%>>
<br><input type = "submit" value = "确认">
</form>
</body>
</html>