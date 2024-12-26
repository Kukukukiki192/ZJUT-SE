<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head><title>添加商品信息结果</title></head>
<body>
<h4>${result}</h4>
<table>
<tr><td>商品编号：</td><td>${product.prod_id}</td>
</tr>	
<tr><td>商品名称： </td><td>${product.pname}</td>
</tr>
<tr><td>价格：</td><td>${product.price}</td>
</tr>
<tr><td>库存量：</td><td>${product.stock}</td>
</tr>
</table>
</body></html>