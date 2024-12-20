package BusReservation;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class busDAO {
	

		
		public int getCapacity(int busid) throws SQLException, ClassNotFoundException {
			
			String query = "select capacity from bus where id = "+busid;
			Connection con = jdbconnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			return rs.getInt(1);
		}

		public int getBusDetail(String fromdest, Date date, String dest) throws SQLException, ClassNotFoundException {
		    
		    String query = "select id from bus where busdate = ? and frombus = ? and dest = ?";
		    Connection con = jdbconnection.getConnection();
		    PreparedStatement pst = con.prepareStatement(query);
		    
		    java.sql.Date sqldate = new java.sql.Date(date.getTime());
		    pst.setDate(1, sqldate);
		    pst.setString(2, fromdest.trim());
		    pst.setString(3, dest.trim());


		    ResultSet rs = pst.executeQuery();
		    if (rs.next()) {
		        return rs.getInt(1);
		    } else {
		        System.out.println("No matching records found for the given criteria.");
		        throw new SQLException("No bus found with the specified details.");
		    }
		}


}
