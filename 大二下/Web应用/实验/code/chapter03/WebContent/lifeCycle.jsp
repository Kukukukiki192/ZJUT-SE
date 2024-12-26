<%@ page contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
<%!  
  int count = 0;   
  public void jspInit(){      // 覆盖jspInit()
	     System.out.println("jspInt...");
  }
  public void jspDestroy(){  // 覆盖jspDestroy()
	     System.out.println("jspDestroy...");
  }
%>
<html><head><title>JSP生命周期示例</title>
</head>
<body>
  <%count++;%>
覆盖jspInit()和jspDestroy()！<br>
该页面被访问<%=count%>次。
</body>
</html>
