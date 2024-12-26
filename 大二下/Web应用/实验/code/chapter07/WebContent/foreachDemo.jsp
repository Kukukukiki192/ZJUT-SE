<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>forEach示例</title></head>
<body>
<table border="1">
<th colspan="6">forEach示例</th>
<tr><td>x值</td>
    <td>status.index</td>
    <td>status.current</td>
    <td>status.count</td>
    <td>status.first</td>
    <td>status.last</td> 
</tr>
<c:forEach var="x" varStatus="status" begin="10" end="20" step="3">
<tr><td align="center"><font color="blue">${x}</font></td>
    <td align="center">${status.index}</td>
    <td align="center">${status.current}</td>
    <td align="center">${status.count}</td>
    <td align="center">${status.first}</td>
    <td align="center">${status.last}</td> 
</tr>
</c:forEach>
</table>
</body></html>
