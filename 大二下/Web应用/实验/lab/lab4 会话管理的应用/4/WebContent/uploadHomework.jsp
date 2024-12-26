<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上传作业页面</title>
</head>
<body>${message}<br>
<form action="FileUploadServlet" enctype="multipart/form-data" method="post">
    <table>
      <tr> <td colspan="2" align="center">文件上传</td> </tr>
      <tr><td>作业标题：</td>
        <td><input type="text" name="workName" size="30" /></td>
      </tr>
      <tr> <td>文件：</td>
          <td><input type="file" name="fileName" multiple= "multiple" size="30" /></td>
      </tr>
      <tr>
         <td align="right"><input type="submit" value="提交" /></td>
         <td align="left"><input type="reset" value="重置"/></td>
      </tr>
    </table>
</form>
</body>
</html>