<%@ page contentType="text/html;charset=utf-8"%>
<html>
<head><title>计算素数</title></head>
<body>
<%
   for(int n = 2;n < 100;n++){
     int i; 
     for(i = 2;i < n;i++){
         if(n % i==0)
            break;
     }
     if(i==n){
%>
   <%=n%>&nbsp;&nbsp;
<%
}
   }
%>
</body>
</html>
