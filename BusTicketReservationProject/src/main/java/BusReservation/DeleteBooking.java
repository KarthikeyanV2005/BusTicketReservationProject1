package BusReservation;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteBooking {
	
	int bookingId;
	

	public void passDeleteDetail(String bookingid, String name, String mobileno) throws ClassNotFoundException, SQLException {
		bookingId = Integer.parseInt(bookingid);
		DeleteDAO deletedao = new DeleteDAO();
		deletedao.deleteBookingDao(bookingId,name,mobileno);
		
	}
}
