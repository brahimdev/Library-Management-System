package login.nikhil.lms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibrarianDAOImpl implements LibrarianDAO {
	
	static Connection conn;
	static PreparedStatement ps;
	
	@Override
	public Librarian getLibrarian(Librarian lib) {
		// TODO Auto-generated method stub
		
		
		conn = ConnectionProvider.getCon();
		
		try {
			ps=conn.prepareStatement("select * from librarian where Name=?");
			ps.setString(1, lib.getName());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lib.setName(rs.getString(1));
			
				
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		
		
		return lib;
	}

	@Override
	public void setLibrarian(Librarian lib) {
		// TODO Auto-generated method stub
		conn = ConnectionProvider.getCon();
		try {
			ps = conn.prepareStatement("insert into librarian values(?,?,?,?)");
			ps.setString(1, lib.getName());
			ps.setString(2, lib.getPassword());
			ps.setString(3, lib.getCity());
			ps.setString(4, lib.getCnumber());
			ps.executeUpdate();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	}

