package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class AbstractDAO {
	protected final String DB_URL = "jdbc:mysql://localhost/netflix";
	protected final String USER = "root";
<<<<<<< HEAD
	protected final String PASS = "p4ssw0rd";
=======
	protected final String PASS = "root";
>>>>>>> 8cf94bff17e3b75cd3dc41c39f92dde1cc194fbf
	
	protected Connection conn;
	protected Statement stmt;
	
	public AbstractDAO() {
		try {
			this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
			this.stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
