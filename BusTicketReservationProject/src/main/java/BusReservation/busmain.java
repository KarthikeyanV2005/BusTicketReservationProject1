package BusReservation;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class busmain {


	public void giveDetailBus(String passanger_name, String from_dest, String to_dest, String mobile_no,String date_of_travel) throws ClassNotFoundException, SQLException {
		Booking booking = new Booking();
		booking.giveDetail(passanger_name, from_dest, to_dest, mobile_no, date_of_travel);
		if(booking.isAvailable()) {
			bookingDAO bookingdao = new bookingDAO();
			try {
				bookingdao.addBooking(booking);	
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			
		}
		else {
			BookingTicket bookingticket = new BookingTicket();
//			try {
//				bookingticket.bookingfailed(null, null);
//			} catch (ServletException | IOException e) {
//				e.printStackTrace();
//			}
		}
		
	}

	public void giveCancelDetail(String bookingid, String name, String mobileno) throws ClassNotFoundException, SQLException {
		DeleteBooking delete = new DeleteBooking();
		delete.passDeleteDetail(bookingid,name,mobileno);
		
	}



}
