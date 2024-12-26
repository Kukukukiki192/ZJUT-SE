<%@ page contentType="text/html; charset=UTF-8" %>
<html><head> <title>Input a Customer</title></head>
<body>
<font color=red>${result}</font>
<p>请输入一条客户记录</p>
<form action = "addCustomer.do" method = "post">
 <table>
  <tr><td>客户号：</td> <td><input type="text" name="cust_id" ></td></tr>
  <tr><td>客户名：</td> <td><input type="text" name="cname" ></td></tr>
   <tr><td>Email：</td><td><input type="text" name="email"></td></tr>      
   <tr><td>余额：</td><td><input type="text" name="balance" ></td></tr>
   <tr><td><input type="submit" value="确定" ></td>
      <td><input type="reset" value="重置" ></td>
  </tr>
</table>
</form>
<br><a href="allCustomer.do">查看所有客户信息</a>
</body></html>
