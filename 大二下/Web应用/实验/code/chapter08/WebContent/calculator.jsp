<%@ page contentType="text/html; charset=UTF-8"
            pageEncoding="UTF-8"%>
<html>
<head><title>简单计算器</title></head>
<body>
   <form action="calculator.do" method="post">
   	<p>操作数1:<input type="text" name="value1" size="10">
   	 操作数2:<input type="text" name="value2" size="10"></p>
   	<p><input type="submit" name="submit" value="相加">
   	   <input type="submit" name="submit" value="相减"></p>
   </form>
</body>
</html>
