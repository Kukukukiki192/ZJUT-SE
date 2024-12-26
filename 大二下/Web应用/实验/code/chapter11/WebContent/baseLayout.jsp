<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<style type="text/css">@import url(css/style.css);</style>
</head>
<body>
<div id="container">
    <div id="header">
        <tiles:insertAttribute name="header" /></div>
    <div id="mainContent" class="clearfix">
        <div id="sidebar"><tiles:insertAttribute name="leftmenu" /></div>
        <div id="content"><tiles:insertAttribute name="content" /></div>
    </div>
    <div id="footer"><tiles:insertAttribute name="footer" /></div>
</div>
</body>
</html>

