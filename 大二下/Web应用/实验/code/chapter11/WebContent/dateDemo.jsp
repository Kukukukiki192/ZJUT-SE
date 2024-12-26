<%@ page contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head><title>Date Tag Example!</title></head>
<body>
 <p><font color="#000080">Current Date Format</font></p>
<table border="1" width="90%" bgcolor="ffffcc">
<tr>
  <td width="50%"><b><font color="#000080">Date Format</font></b></td>
  <td width="50%"><b><font color="#000080">Date</font></b></td>
</tr>
<tr>
  <td width="50%">年-月-日</td>
  <td width="50%"><s:date name="currentDate" format="yyyy-MM-dd" /></td>
</tr>
<tr>
  <td width="50%">Month/Day/Year</td>
  <td width="50%"><s:date name="currentDate" format="MM/dd/yyyy" /></td>
</tr>
<tr>
  <td width="50%">Month/Day/Year</td>
  <td width="50%"><s:date name="currentDate" format="MM/dd/yy" /></td>
</tr>
<tr>
  <td width="50%">Month/Day/Year Hour<B>:</B>Minute<B>:</B>Second</td>
  <td width="50%"><s:date name="currentDate" 
format="MM/dd/yy hh:mm:ss" /></td>
</tr>
<tr>
  <td width="50%">Nice Date (Current Date & Time)</td>
  <td width="50%"><s:date name="currentDate" nice="false" /></td>
</tr>	
<tr>
  <td width="50%">Nice Date</td>
  <td width="50%"><s:date name="currentDate" nice="true" /></td>
</tr>
</table>  
<s:debug />
</body>

</html>
