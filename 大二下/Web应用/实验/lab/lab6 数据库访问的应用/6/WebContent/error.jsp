<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<script type="text/javascript">
function delayURL() { 
	var delay = document.getElementById("time").innerHTML;
	if(delay>1) {
		delay--;
		document.getElementById("time").innerHTML = delay;
	} else {
		window.top.location="login.jsp";
		return;
	} 
	setTimeout('delayURL()', 1000); //必须加单引号
} 
</script>
<body>
<h4>${result}</h4><br>
<!-- 该商品不存在。<a href="queryProduct.jsp">返回</a> --> 
您的用户名或密码错误!<br><br><%response.setHeader("refresh", "3;URL=login.jsp"); %>
<font color="red"><span id="time">4</span></font>秒后自动跳转至登录页面 <br><br>
若没有跳转,请按 <a href="login.jsp">这里</a>
<script>delayURL();</script>
</body></html>
