package dbConfig;

import java.sql.*;

public class DBHelper {

	protected DBConfig db = DBConfig.getConnection();
	protected Connection cn = DBConfig.getConn();
	protected ResultSet rs = DBConfig.getRs();
	protected PreparedStatement pst = DBConfig.getPst();
	protected Statement stmt = DBConfig.getStmt();
}
