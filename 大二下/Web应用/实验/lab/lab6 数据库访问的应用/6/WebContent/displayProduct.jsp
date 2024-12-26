<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head><title>商品信息</title></head>
<body>
<table>
<tr><td>商品号：</td><td>${product.prod_id}</td>
</tr>	
<tr><td>商品名： </td><td>${product.pname}</td>
</tr>
<tr><td>价格：</td><td>${product.price}</td>
</tr>
<tr><td>库存量：</td><td>${product.stock}</td>
</tr>
</table>
</body>
</html>
