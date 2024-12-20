package BusReservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDAO {
	
public void deleteBookingDao(int bookingID, String name, String mobileno) throws SQLException, ClassNotFoundException {
		
		Connection con = jdbconnection.getConnection();
	
		String query = " delete from booking where random =? and pasname=? and mobileno = ? ";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, bookingID);
		pst.setString(2, name);
		pst.setString(3, mobileno);
		pst.executeUpdate();
	}

}
