<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.model.Product" %>
<html>
<head><title>显示商品详细信息</title>
<!--使用JavaScript脚本保证文本域中输入整数值 -->
<script language="JavaScript" type="text/javascript">
  function check(form) {
	var regu = /^[1-9]\d*$/;
	if(form.quantity.value=='') {
		alert("数量值不能为空!");
		form.quantity.focus();
		return false;
	}
	if(!regu.test(form.quantity.value)) {
		alert("必须输入整数!");
		form.quantity.focus();
		return false;
	}
  }
</script>
</head>
<body>
<center>
<%
   Product product = (Product)session.getAttribute("product");
%>
<p>商品详细信息</p>
<form name="myform" method='post' action='addToCart' >
   <!--使用隐藏表单域将id请求参数传递给addToCart动作 -->
   <input type='hidden' name='id' value='<%=product.getId() %>'/>
   <table>
      <tr><td>商品名:</td><td><%=product.getPname() %></td></tr>
      <tr><td>价格:</td><td><%=product.getPrice() %></td></tr>
      <tr><td>库存量:</td><td><%=product.getStock() %></td></tr>
      <tr><td>类型:</td><td><%=product.getType() %></td></tr>
      <tr><td><input type="text" name='quantity' id='quantity' /></td>
      <td><input type='submit' value='放入购物车' 
                      onclick="return check(this.form)"/></td>
      </tr>
     <tr><td colspan='2'><a href='index.jsp'>显示商品列表</a></td></tr>
    </table>
</form>
</center>
</body>
</html>
