import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exportfile.do")

public class ExportExcelServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		StringBuffer sb=new StringBuffer(request.getParameter("tableInfo"));
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		response.setHeader("Content-Disposition","attachment; filename=" + java.net.URLEncoder.encode("ѧ���ɼ�.xls", "UTF-8"));
		response.resetBuffer();
		//��������������ļ�
		ServletOutputStream sos=response.getOutputStream();
		sos.write(sb.toString().getBytes());
		sos.flush();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				doPost(request, response);
	}
}
