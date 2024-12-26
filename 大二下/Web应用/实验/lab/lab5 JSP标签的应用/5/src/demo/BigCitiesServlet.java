package demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BigCitiesServlet")
public class BigCitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public BigCitiesServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		Map<String, String> capitals = new HashMap<String, String>();
		capitals.put("俄罗斯", "莫斯科");
		capitals.put("日本", "东京");
		capitals.put("中国", "北京");
		request.setAttribute("capitals", capitals);

		Map<String, String[]> bigCities = new HashMap<String, String[]>();
		bigCities.put("澳大利亚", new String[] { "悉尼", "墨尔本", "布里斯班" });
		bigCities.put("美国", new String[] { "纽约", "洛杉矶", "加利福尼亚" });
		bigCities.put("中国", new String[] { "北京", "上海", "深圳" });

		request.setAttribute("capitals", capitals);
		request.setAttribute("bigCities", bigCities);
		RequestDispatcher rd = request.getRequestDispatcher("/bigCities.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doGet(request, response);
	}
}