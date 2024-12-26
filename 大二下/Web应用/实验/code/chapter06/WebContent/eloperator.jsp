<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html><head>
<title>表达式语言示例</title>
</head>
<body>
<p>JSP Expression Language Example</p>
<table border="1">
<thead><td>Expression</td><td>Value</td></thead>
<tr><td>\${2+5}</td> <td>${2+5}</td></tr>
<tr><td>\${4/5}</td><td>${4/5}</td></tr>
<tr><td>\${5 div 6}</td><td>${5 div 6}</td></tr>
<tr><td>\${5 mod 7}</td><td>${5 mod 7}</td></tr>
<tr><td>\${2<3}</td><td>${2 < 3}</td></tr>
<tr><td>\${2gt3}</td><td>${2 gt 3}</td></tr>
<tr><td>\${3.1 le 3.2}</td><td>${3.1 le 3.2}</td></tr>
<tr><td>\${(5>3)?5:3}</td><td>${(5>3)?5:3}</td></tr>
<tr><td>\${empty null}</td><td>${empty null}</td></tr>
<tr><td>\${empty param}</td><td>${empty param}</td></tr>
</table>
</body></html>
