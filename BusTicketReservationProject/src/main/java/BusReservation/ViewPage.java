package BusReservation;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ViewPage")
public class ViewPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String Bookingid;
	String busid;
	String pasname;
	String fromdest;
	String pasdest;
	String pasdate;
	String mobileno;
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bookingid = Integer.parseInt(request.getParameter("bookingid")) ;
		String name = request.getParameter("name");
		
		bookingDAO bookingdao1 = new bookingDAO();
		try {
			String[] details = bookingdao1.viewBookingDetail(bookingid,name);
			
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
		response.sendRedirect("viewdetail.jsp");
		session.setAttribute("Bookingid", Bookingid);
		session.setAttribute("busid", busid);
		session.setAttribute("pasname", pasname);
		session.setAttribute("fromdest", fromdest);
		session.setAttribute("pasdest", pasdest);
		session.setAttribute("pasdate", pasdate);
		session.setAttribute("mobileno", mobileno);
		
	}

}
