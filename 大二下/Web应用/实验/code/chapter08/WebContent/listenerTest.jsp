<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.sql.*,javax.sql.*" %>
<% 
   DataSource dataSource =
      (DataSource)application.getAttribute("dataSource");
   Connection conn = dataSource.getConnection();
   Statement stmt = conn.createStatement();
   ResultSet rst = stmt.executeQuery(
"SELECT * FROM products WHERE id < 104");
%>
<html><head><title>监听器示例</title></head>
<body>
<h4>商品表中信息</h4>
<table border="1">
<tr><td>商品号</td><td>商品名</td><td>品牌</td>
<td>价格</td><td>库存</td></tr>
<% while (rst.next()){ %>
<tr><td><%= rst.getInt(1) %></td>
    <td><%= rst.getString(2) %></td>
    <td><%= rst.getString(3) %></td>
    <td><%= rst.getFloat(4) %></td>
    <td><%= rst.getInt(5) %></td></tr>
<% } %>
</table>
</body>
</html>
