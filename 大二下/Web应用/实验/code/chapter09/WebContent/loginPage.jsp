<%@ page contentType="text/html;charset=UTF-8" %>
<html><head><title>登录页面</title></head>
<body>
<p>请您输入用户名和口令</p>
<form method="post" action="j_security_check">
   <table>
     <tr><td align="right">用户名：</td>
         <td align="left"><input type="text" name="j_username"><td>
     </tr>
     <tr> <td align="right">口&nbsp;&nbsp;令：</td>
         <td align="left"><input type="password" name="j_password"></td>
     </tr>
     <tr> <td align="right"><input type="submit" value="登录"></td>
         <td align="center"><input type="reset" value="重置"></td>
     </tr>
  </table>
</form>
</body></html>
