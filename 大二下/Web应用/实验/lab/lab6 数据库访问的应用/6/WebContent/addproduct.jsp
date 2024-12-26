<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head><title>添加商品页面</title></head>
<body>
<form action = "addndrop.do" method="post">
 请输入商品信息：<br>
 商品号码：<input type = "text" name="prod_id" size="30"><br><br>
 商品名称：<input type = "text" name="pname" size="30"><br><br>
 商品价格：<input type = "text" name="price" size="30"><br><br>
 商品库存：<input type = "text" name="stock" size="30">
<br><input type = "submit" value = "添加商品">
</form>
</body>
</html>
