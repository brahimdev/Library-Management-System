package login.nikhil.lms;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminSection")
public class AdminSection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AdminSection() {
        super();
          }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		LibrarianDAO lib = new LibrarianDAOImpl();
		
		String name = request.getParameter("libname");
		String pwd = request.getParameter("libpass");
		String city = request.getParameter("libcity");
		String cnumb = request.getParameter("libnumber");
		String submitType = request.getParameter("submit");
		String deletelib = request.getParameter("Delete Librarian");
		String viewlib = request.getParameter("View Librarians");
		
		if(submitType.equals("Addlibrarian")){
		Librarian l = new Librarian();
		l.setName(name); 
		l.setPassword(pwd);
		l.setCity(city);
		l.setCnumber(cnumb);
		lib.setLibrarian(l);
		request.getRequestDispatcher("success.html").forward(request, response);
		}
		else if (submitType.equals("Delete")){
			Librarian l = new Librarian();
			l.setName(deletelib);
			lib.deleteLibrarian(l);
			request.getRequestDispatcher("success.html").forward(request, response);
		}
		else if (submitType.equals("View Librarians")){
			ArrayList<Librarian> l = new ArrayList<>();
			l=lib.getLibrarian();
			request.setAttribute("LibrariansList", l);
			request.getServletContext().getRequestDispatcher("/ViewLibrarians.jsp").forward(request, response);
		}
		
		
	}

}
