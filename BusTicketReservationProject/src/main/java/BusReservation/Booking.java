package BusReservation;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking {
	
	String passangername;
	String fromdest;
	String dest;
	Date date;
	String mobileno;
	int busid;
		

	public boolean isAvailable() throws SQLException, ClassNotFoundException {
		
		busDAO busdao = new busDAO();
		bookingDAO bookingdao = new bookingDAO();
		Bus bus = new Bus();
		
		busid = bus.getBusId(fromdest,date,dest) ;
		
		int capacity = busdao.getCapacity(busid);
		
		int booked = bookingdao.getBookedCount(date,busid);
		
		return capacity > booked ? true:false;
	}

	public int randomNumber() {
		
		int randomNum = (int)(Math.random() * 1000000);
		return randomNum;
	}



	public void giveDetail(String passanger_name, String from_dest, String to_dest, String mobile_no, String date_of_travel) {
		
		passangername = passanger_name ;
		fromdest =  from_dest ;
		dest = to_dest ;
		mobileno = mobile_no;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date= sdf.parse(date_of_travel);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
}
