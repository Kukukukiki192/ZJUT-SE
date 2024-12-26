<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="demo" uri="http://www.mydomain.com/sample" %>
<html>
<head><title>商品信息</title></head>
<body>
  <table border='1'>
     <tr>
       <td>商品号</td><td>商品名</td><td>品牌</td><td>价格</td><td>库存量</td>
     </tr>
    <demo:showProduct productList="${prodList}">
     <tr>
       <td>${product.id}</td>
       <td>${product.pname}</td>
       <td>${product.brand}</td>
       <td>${product.price}</td>
       <td>${product.stock}</td>
     </tr>
    </demo:showProduct>
  </table>
</body></html>
