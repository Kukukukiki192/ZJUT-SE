<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><body>
<c:forEach var="x" begin="1" end="9" step="1">
   <c:forEach var="y" begin="1" end="${x}" step="1">
     ${y}*${x}=${x*y} &nbsp;  
   </c:forEach>
   <br/>
</c:forEach>
</body></html>
