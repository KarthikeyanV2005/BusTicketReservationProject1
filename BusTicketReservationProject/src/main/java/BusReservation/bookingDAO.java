package BusReservation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class bookingDAO {
	
	public int getBookedCount(java.util.Date date, int busid) throws SQLException, ClassNotFoundException {
		
		String query = "Select count(pasname) from booking where busid=? and pasdate=?";
		Connection con = jdbconnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		java.sql.Date sqldate = new java.sql.Date(date.getTime());
		pst.setInt(1, busid);
		pst.setDate(2, sqldate);
		ResultSet rs = pst.executeQuery();
		rs.next();
		return rs.getInt(1);
	}

	
	public void addBooking(Booking booking) throws SQLException, ClassNotFoundException {
		
		
		String query = "insert into booking (pasname,pasdest,pasdate,mobileno,busid,random,fromdest) values(?,?,?,?,?,?,?)";
		Connection con = jdbconnection.getConnection();
		java.sql.Date sqldate = new java.sql.Date(booking.date.getTime());
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, booking.passangername);
		pst.setString(2,booking.dest);
		pst.setDate(3,sqldate);
		pst.setString(4, booking.mobileno);
		pst.setInt(5,booking.busid);
		pst.setInt(6,booking.randomNumber());
		pst.setString(7, booking.fromdest);
		pst.executeUpdate();
		
	}
	

	String Passangername ;
	String Passangerdestination ; 
	String Passangertravelingdate ;
	String Passangermobilenumber ;
	String PassangerbusID  ;
	String BookingId ;
	String fromdest ; 


	public String[] getBookingDetail() throws SQLException, ClassNotFoundException {
		
		
		String query = "SELECT *  FROM booking ORDER BY created_at DESC LIMIT 1" ;
		
		Connection con = jdbconnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		rs.next();
		
		 Passangername = rs.getString(1);
		 Passangerdestination = rs.getString(2); 
		 
		 java.sql.Date sqlDate = rs.getDate(3);
         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
         Passangertravelingdate = formatter.format(sqlDate);	 
		 
		 Passangermobilenumber = rs.getString(4) ;
		 PassangerbusID  = String.valueOf(rs.getInt(5)) ;
		 BookingId = String.valueOf(rs.getInt(6));
		 fromdest = rs.getString(7);


		 return new String[] {BookingId,  PassangerbusID , Passangername, fromdest, Passangerdestination, Passangertravelingdate , Passangermobilenumber};
		 
		
	}
	
	
	public String[] viewBookingDetail(int bookingid, String name) throws SQLException, ClassNotFoundException {
		
		
		String query = "SELECT *  FROM booking where random =? and pasname =?" ;
		
		Connection con = jdbconnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, bookingid);
		pst.setString(2, name);
		ResultSet rs = pst.executeQuery();
		rs.next();
		
		 Passangername = rs.getString(1);
		 Passangerdestination = rs.getString(2); 
		 
		 java.sql.Date sqlDate = rs.getDate(3);
         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
         Passangertravelingdate = formatter.format(sqlDate);	 
		 
		 Passangermobilenumber = rs.getString(4) ;
		 PassangerbusID  = String.valueOf(rs.getInt(5)) ;
		 BookingId = String.valueOf(rs.getInt(6));
		 fromdest = rs.getString(7);


		 return new String[] {BookingId,  PassangerbusID , Passangername, fromdest, Passangerdestination, Passangertravelingdate , Passangermobilenumber};
		 
		
	}

}
