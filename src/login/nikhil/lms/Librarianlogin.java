package login.nikhil.lms;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Librarianlogin")
public class Librarianlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Librarianlogin() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Librarian l = new Librarian();
		boolean status;
		LibrarianDAO lib = new LibrarianDAOImpl();
		String libname = request.getParameter("libname");
		String libpwd = request.getParameter("libpassword");
		String submitType = request.getParameter("submit");
		
		l.setName(libname);
		l.setPassword(libpwd);
		
		status = lib.Librarianlogin(l);
		System.out.println(status);
		if(status==true){
			request.getRequestDispatcher("LibrarianSection.html").forward(request, response);
		}else{
			System.out.println("Please try again!");
		}
		
		
		
	}

}
