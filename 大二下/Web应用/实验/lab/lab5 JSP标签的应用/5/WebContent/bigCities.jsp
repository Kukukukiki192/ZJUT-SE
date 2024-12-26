<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首都-城市</title>
</head>
<body>
<table>
    <tr style="background:#448755;color:white;font-weight:bold">
        <td>国家</td>
        <td>首都</td>
    </tr>
    <c:forEach items="${requestScope.capitals}" var="mapItem">
    <tr>
        <td>${mapItem.key}</td>
        <td>${mapItem.value}</td>
    </tr>
    </c:forEach>
</table>
<br/>
<table>
    <tr style="background:#448755;color:white;font-weight:bold">
        <td>国家</td>
        <td>城市</td>
    </tr>
    <c:forEach items="${requestScope.bigCities}" var="mapItem">
    <tr>
        <td>${mapItem.key}</td>
        <td>
            <c:forEach items="${mapItem.value}" var="city" varStatus="status">
                ${city}<c:if test="${!status.last}">,</c:if>
            </c:forEach>
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>