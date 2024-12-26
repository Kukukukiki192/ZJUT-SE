

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FileDownloadServlet")
public class FileDownloadServlet extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		HttpSession session = request.getSession();
	        // ���û�û�е�¼��ת����¼ҳ��
//		if (session == null || session.getAttribute("loggedIn") == null) {
//	            RequestDispatcher dispatcher =  request.getRequestDispatcher("login.html");
//	            dispatcher.forward(request, response);
//	            return;   // ������Ǳ����
//	        }
		if (session == null || session.getAttribute("user") == null) {
            RequestDispatcher dispatcher =  request.getRequestDispatcher("login.jsp");//未登录,则跳转至登录页面
            dispatcher.forward(request, response);
            return;  
        }
	        String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/files");
//	        File file = new File(dataDirectory, "servlet.pdf");
//	        String f=(String)session.getAttribute("filename");
//	        File file = new File(dataDirectory, f);
	        File file = new File(dataDirectory, "201511111_1587914305.doc");
	        if (file.exists()) {
	            // ������Ӧ����������ΪPDF�ļ�
//	           response.setContentType("pdf");
	        	response.setContentType("doc");
	            // ����Content-Disposition��Ӧͷ��ָ���ļ���
	            response.addHeader("Content-Disposition", "attachment;filename=201511111_1587914305.doc");
	            byte[] buffer = new byte[1024];
	            FileInputStream fis = null;
	            BufferedInputStream bis = null;
	            try {
	                fis = new FileInputStream(file);  // �����ļ�������
	                bis = new BufferedInputStream(fis);
	                // �������������
	               OutputStream os = response.getOutputStream();
	                // ��ȡ1K���ֽ�
	               int i = bis.read(buffer);
	               while (i != -1) {
	                    os.write(buffer, 0, i);
	                    i = bis.read(buffer);
	               }
	            } catch (IOException ex) {
	                System.out.println (ex.toString());
	            } finally {
	                if (bis != null) {
	                    bis.close();
	                }
	                if (fis != null) {
	                    fis.close();
	                }
	            }
	        }else{
	        	response.setContentType("text/html;charset=UTF-8");
	            PrintWriter out = response.getWriter();
	    		out.println("�ļ������ڣ�");
	        }
	}

}
