package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class AbstractDAO {
	protected final String DB_URL = "jdbc:mysql://localhost/netflix";
	protected final String USER = "root";
	protected final String PASS = "sasha125";
	
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
