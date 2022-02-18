

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.Cookie;
/**
 * Servlet implementation class setcookie
 */
@WebServlet("/setcookie")
public class setcookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public setcookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		for (int i = 1; i < 4; i++) {
			String nm = "Type1-CookieNo"+i;
			String val = "Type1-CookieVal"+i;
			out.print(nm+" "+val+"<br>");
			Cookie ck = new Cookie(nm,val);
			response.addCookie(ck);
			String nm1 = "Type2-CookieNo"+i;
			String val1 = "Type2-CookieVal"+i;
			ck = new Cookie(nm1,val1);
			ck.setMaxAge(3600);
			out.print(nm1+" "+val1+"<br>"+"<h2>"+ck.getMaxAge());
			response.addCookie(ck);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("Hellow");
	
	}

}
