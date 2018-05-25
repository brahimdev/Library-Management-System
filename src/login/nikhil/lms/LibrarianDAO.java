package login.nikhil.lms;

import java.util.ArrayList;

public interface LibrarianDAO {

	public ArrayList<Librarian> getLibrarian();
	public void setLibrarian(Librarian lib);
	public void deleteLibrarian(Librarian lib);
	public boolean Librarianlogin (Librarian lib);
	
}
