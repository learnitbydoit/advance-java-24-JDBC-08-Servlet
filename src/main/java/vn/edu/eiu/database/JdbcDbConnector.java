package vn.edu.eiu.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDbConnector {
	private String url = "jdbc:mysql://localhost:3306/nhasach";
	
	public Connection getConnection() {
		Connection c = null;
		try {
			/*đăng ký JDBC driver với DriverManager (java 6 trở lên có thể không cần, 
			 * driver có thể tự động được đăng ký.			
			*/
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String user = "root";
		String password = "Ms@6031402";
		
		try {
			c = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	public void closeConnection(Connection c) {
		try {
			if (c != null)
				c.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Connection is Successful to the database " + url;
	}
}
