package BusReservation;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/BookingTicket")
public class BookingTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String Bookingid;
	String busid;
	String pasname;
	String fromdest;
	String pasdest;
	String pasdate;
	String mobileno;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String passanger_name = request.getParameter("pass_name");
		String from_dest = request.getParameter("from_dest");
		String to_dest = request.getParameter("to_dest");
		String mobile_no = request.getParameter("mobile_no");
		String date_of_travel = request.getParameter("date_of_travel");
		
		busmain busmain = new busmain();
		try {
			busmain.giveDetailBus(passanger_name,from_dest,to_dest,mobile_no,date_of_travel);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		bookingDAO bookingdao = new bookingDAO();
		try {
			String[] details = bookingdao.getBookingDetail();
			
			 Bookingid = details[0] ;
			 busid = details[1];
			 pasname = details[2];
			 fromdest = details[3];
			 pasdest = details[4];
			 pasdate = details[5];
			 mobileno = details[6];
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		

		HttpSession session = request.getSession();
		response.sendRedirect("Booked.jsp");
		session.setAttribute("Bookingid", Bookingid);
		session.setAttribute("busid", busid);
		session.setAttribute("pasname", pasname);
		session.setAttribute("fromdest", fromdest);
		session.setAttribute("pasdest", pasdest);
		session.setAttribute("pasdate", pasdate);
		session.setAttribute("mobileno", mobileno);	
		
	}


	public void bookingfailed(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		response.sendRedirect("BookingFsiled.jsp");
	}	
	
	
}
