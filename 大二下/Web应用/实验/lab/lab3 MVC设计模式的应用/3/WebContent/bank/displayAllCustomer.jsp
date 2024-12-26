<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有客户信息显示页面</title>
</head>
<body>
    <%
          String path="D:/web4_12/WebContent/customerinfo.txt";
          File file=new File(path);
          FileReader fr=new FileReader(file);
          BufferedReader br=new BufferedReader(fr);
          StringBuffer strB=new StringBuffer();
          String line=br.readLine();
          String name[]=new String[1000];
          String email[]=new String[1000];
          String number[]=new String[1000];
          int sum=0;
          while(line!=null){
        	  String[] str = line.split("\\|");
        	  name[sum]=str[0];
        	  email[sum]=str[1];
        	  number[sum]=str[2];
        	  line=br.readLine();
        	  sum++;
          }
          br.close();
    %>
    <table align=center width=360 border="3" bordercolor="#a0c6e5" style="border-collapse:collapse;">
    <tr><td colspan=3 align=center>
       <h2>所有客户信息</h2></td></tr>
    <tr>
       <td align=center>姓名<td align=center>邮箱<td align=center>手机号
       </tr>
    <tr> 
    <%for(int i=0;i<sum;i++){
    %>
    <tr><td align=center>
    <%=name[i] %>
    <td align=center>
    <%=email[i] %>
    <td align=center>
    <%=number[i] %>
    <% } %>
</table>
</body>
</html>