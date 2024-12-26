<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示会员信息</title>
</head>
<body>
  <h4>会员信息</h4>
  <table border='0'>
    <tr> <td>会员id</td><td>会员名</td><td>密码</td><td>地址</td>
<td>邮箱</td><td>级别</td><td>删除</td><td>修改</td>
</tr>
<!—对集合元素迭代-->
<s:iterator value="#request.memberList" var="mb">
<tr>
<td><s:property value="#mb.id" /></td>
<td><s:property value="#mb.name" /></td>
<td><s:property value="#mb.password"/></td>
<td><s:property value="#mb.address"/></td>
<td><s:property value="#mb.email"/></td>
<td><s:property value="#mb.level"/></td>
<td>
<a href="<s:url action="memberDelete">
            <s:param name="id"><s:property value="#mb.id" /></s:param>
         </s:url>">删除 </a>
</td>
<td>
<a href="<s:url action="memberShow">
            <s:param name="id"><s:property value="#mb.id" /></s:param>
         </s:url>">修改</a>
</td></tr> 
</s:iterator>
</table>
<a href="index.jsp">返回首页面</a>
</body>
</html>

