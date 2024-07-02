package dbConfig;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class DBConfig{
	private static PreparedStatement pst;
	private static Statement stmt;
	private static ResultSet rs;
	private static Connection con;
	private static DBConfig dbc = null;
    
	private DBConfig() {
		try {
			Properties p = new Properties();
			p.load(PathHelper.fin);
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String username = p.getProperty("username");
			String password = p.getProperty("password");
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			if (con != null) {
				System.out.println("Connection Secured");
			} else {
				System.out.println("Connection not secured");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static DBConfig getConnection() {
		if (dbc == null) {
			dbc = new DBConfig();
		}
		return dbc;
	}

	public static Connection getConn() {
		return con;
	}

	public static PreparedStatement getPst() {
		return pst;
	}

	public static Statement getStmt() {
		return stmt;
	}

	public static ResultSet getRs() {
		return rs;
	}

}
