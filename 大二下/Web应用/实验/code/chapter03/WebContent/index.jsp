<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>百斯特电子商城</title>
<link href="css/layout.css" rel="stylesheet" type="text/css" />
</head>
<body>
     <div id="container">
        <div id="header"><%@ include file="/WEB-INF/jsp/header.jsp"%></div>
        <div id="topmenu"><%@ include file="/WEB-INF/jsp/topmenu.jsp"%></div>
        <div id="mainContent" class="clearfix" >
            <div id="leftmenu"><%@ include file="/WEB-INF/jsp/leftmenu.jsp"%></div>
            <div id="content"><%@ include file="/WEB-INF/jsp/content.jsp"%></div>
        </div>
        <div id="footer"><%@ include file="/WEB-INF/jsp/footer.jsp"%></div>
     </div>
</body>
</html>
