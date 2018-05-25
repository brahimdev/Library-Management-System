package login.nikhil.lms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class LibrarianDAOImpl implements LibrarianDAO {
	
	static Connection conn;
	static PreparedStatement ps;
	
	@Override
	public ArrayList<Librarian> getLibrarian() {
		ArrayList<Librarian> librarians = new ArrayList<>();
		conn = ConnectionProvider.getCon();
		try {
			ps=conn.prepareStatement("select * from librarian");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Librarian l = new Librarian();
				l.setName(rs.getString(1));
				l.setPassword(rs.getString(2));
				l.setCity(rs.getString(3));
				l.setCnumber(rs.getString(4));
				librarians.add(l);
		}
		
			
		} catch (SQLException e) {
			System.out.println(e);
		}
				
		return librarians;
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
	
	public void deleteLibrarian(Librarian lib){
		conn = ConnectionProvider.getCon();
		try {
			ps = conn.prepareStatement("delete from librarian where Name=?");
			ps.setString(1, lib.getName());
			ps.executeUpdate();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	
	public boolean Librarianlogin(Librarian lib){
		conn = ConnectionProvider.getCon();
		boolean status=false;
		try {
			ps = conn.prepareStatement("select * from librarian where Name=? and Password=?");
			ps.setString(1, lib.getName());
			ps.setString(2, lib.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				status=true;
			}else{
				status=false;
			}               
			conn.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return status;
	}
	}

