<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="product" class="com.model.Product" scope="session"/>
<html>
<head><title>Set Tag Example</title></head>
<body>
<c:set var="color" value="blacke" scope="session" />
  <c:choose>
      <c:when test="${color == 'white'}">
                 白色!
      </c:when>
         <c:when test="${color == 'black'}">
                黑色!
      </c:when> 
    <c:otherwise>
         其他颜色!
      </c:otherwise>   
  </c:choose>

