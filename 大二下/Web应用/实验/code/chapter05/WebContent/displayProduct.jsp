<%@ page contentType="text/html; charset=utf-8" %>
<jsp:useBean id="product" type="com.model.Product"
 scope="session"></jsp:useBean>
<html>
<head><title>商品信息</title></head>
<body>
<table border="0">
<tr><td>商品号：</td>
<td><jsp:getProperty name="product" property="id" /></td>
</tr>	
<tr><td>商品名： </td>
<td><jsp:getProperty name="product" property="pname" /></td>
</tr>
<tr><td>品牌： </td>
<td><jsp:getProperty name="product" property="brand" /></td>
</tr>

<tr><td>价格：</td>
<td><jsp:getProperty name="product" property="price" /></td>
</tr>
<tr><td>库存量：</td>
<td><jsp:getProperty name="product" property="stock" /></td>
</tr>
</table>
</body></html>
