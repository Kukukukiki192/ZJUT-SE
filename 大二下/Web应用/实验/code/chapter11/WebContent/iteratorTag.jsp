<%@ page contentType="text/html; charset=UTF-8"
              pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html> 
<head><title>Iterator Tag Example!</title>
<style>
    table{
      padding:0px;
      margin:0px;
      border-collapse:collapse;
    }
    td,th{
      border:1px solid black;
      padding:5px;
      margin:0px;
    }
    .evenRow{
      background:#f8f8ff;
    }
    .oddRow{
      background:#efefef;
    }
</style> 
</head> 
<body> 
  <h3><span style="background-color: #FFFFcc">
Iterator Tag Example!</span></h3> 
  <s:iterator value="fruit" status="status"> 
     <s:property />
     <s:if test="!#status.last">, </s:if>
     <s:else><br></s:else> 
  </s:iterator> 
  <table>
    <tr><th>国家名</th><th>首都</th>
    </tr>
    <s:iterator value="country" status="status">
    <s:if test="#status.odd">
      <tr class="oddRow">
    </s:if>
    <s:if test="#status.even">
      <tr class="evenRow">
    </s:if>
    <td><s:property value="key" /></td>
    <td><s:property value="value" /></td>
    </tr> 
    </s:iterator>
  </table>
</body> 
</html>

