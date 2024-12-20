package BusReservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbconnection {
	
	
	private static final String url = "jdbc:mysql://localhost:3306/busreservation";
	private static final String userName = "root";
	private static final String passWord = "karthi9952";


	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, userName, passWord); 
	}


}
