

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Adminlogin")
public class Adminlogin extends HttpServlet { 
	private static final long serialVersionUID = 1L;
       
    public Adminlogin() {
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String adminusername = request.getParameter("adminname");
		String adminpassword = request.getParameter("adminpassword");
		String submittype = request.getParameter("submit");
		
		if(adminusername.equals("admin") && adminpassword.equals("admin123")){
			request.getRequestDispatcher("AdminSection.html");
		}
		
		
	}

}
