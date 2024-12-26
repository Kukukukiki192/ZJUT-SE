<%@ page contentType="text/html; charset=UTF-8" %>
<html><head> <title>添加商品</title></head>
<body>
<font color=red>${result}</font>
<p>请输入一条商品记录</p>
<form action = "add-product" method = "post">
 <table>
 <tr><td>商品号：</td> <td><input type="text" name="id" ></td></tr>
  <tr><td>商品名：</td> <td><input type="text" name="pname" ></td></tr>
   <tr><td>品牌：</td><td><input type="text" name="brand"></td></tr>      
   <tr><td>价格：</td><td><input type="text" name="price" ></td></tr>
   <tr><td>库存量：</td><td><input type="text" name="stock" ></td></tr>
   <tr><td><input type="submit" value="确定" ></td>
      <td><input type="reset" value="重置" ></td>
  </tr>
</table>
</form>
</body></html>
