package business.kunde;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Datenbank {

	private Connection conn = null;
	
	Datenbank() {
		
	}

	public Connection connect() {

		try {
			String driver = "com.mysql.jdbc.cj.Driver";
			String url = "jdbc:mysql://mysql2e80.netcup.net/k136759_projekt?useTimezone=true&serverTimezone=GMT";
			String username = "k136759_user";
			String password = "123456";

			conn = DriverManager.getConnection(url, username, password);

			System.out.println("Mit der Datenbank Verbunde !");

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

		return this.conn;

	}

}





