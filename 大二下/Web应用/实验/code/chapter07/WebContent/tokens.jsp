<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>唐诗一首</title></head>
<body>
<c:set var="poems" 
       value="朝辞白帝彩云间,千里江陵一日还,两岸猿声啼不住,轻舟已过万重山" />
<center>
<h4>早发白帝城[唐]李白 </h4>
<c:forTokens var="line" items="${poems}" delims=",">
     ${line}<br>
 </c:forTokens>
</center>
</body>
</html>	
