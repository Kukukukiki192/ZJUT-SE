<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>请求监听器示例</title></head>
<body>
欢迎您，您的IP地址是${pageContext.request.remoteAddr}<br>
<p>自应用程序启动以来，该页面被访问了
<font color="blue">${applicationScope.count}
</font>次<br>
</body>
</html>
