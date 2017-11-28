package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LibraryConnectDB {
	private Connection conn;
	private String user = "root";
	private String password= "root";
	private String url = "jdbc:mysql://localhost:3306/quanlythietbi?useUnicode=true&characterEncoding=UTF-8";
	
	public Connection GetConnectMySQL() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
}