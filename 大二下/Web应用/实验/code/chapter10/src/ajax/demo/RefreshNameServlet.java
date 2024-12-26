package ajax.demo;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name ="refreshServlet", urlPatterns={"/refreshNameList.do" })
public class RefreshNameServlet extends HttpServlet {
    private List<Student> students = 
    	                     new ArrayList<Student>();
public void init() throws ServletException {
      students.add(new Student(2018, "class1", "李小明"));
      students.add(new Student(2018, "class1", "张冬玫"));
      students.add(new Student(2018, "class2", "赵亮"));
      students.add(new Student(2018, "class2", "王强"));
      students.add(new Student(2018, "class2", "孙文"));
      students.add(new Student(2019, "class1", "Micheal Jordon"));
      students.add(new Student(2019, "class1", "Henry Smith"));
      students.add(new Student(2019, "class2", "Joeory Bush"));
      students.add(new Student(2019, "class2", "Karta"));
      students.add(new Student(2019, "class2", "Luews"));
}

protected void doGet(HttpServletRequest request, 
HttpServletResponse response)
throws ServletException, IOException {
        int syear = Integer.parseInt(request.getParameter("syear"));
        String sclass = request.getParameter("sclass");
        StringBuffer results = new StringBuffer("<snames>");
        for(Student stud:students) {
            if(syear == stud.syear && stud.sclass.equals(sclass)){
                 results.append("<sname>");
                 results.append(stud.sname);
                 results.append("</sname>");
            }
        }
        results.append("</snames>");
        response.setContentType("text/xml;charset=UTF-8");
        response.getWriter().println(results.toString());
}
   private class Student{         // 定义内部类
       private int syear;          // 入学年份
       private String sclass;     // 班级
       private String sname;      // 姓名
       public Student(int syear, String sclass, String sname) {
           this.syear = syear;
           this.sclass = sclass;
           this.sname = sname;
        }
   }
}


