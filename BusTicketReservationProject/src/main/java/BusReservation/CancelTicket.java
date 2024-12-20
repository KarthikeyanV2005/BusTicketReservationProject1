package BusReservation;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/CancelTicket")
public class CancelTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookingid = request.getParameter("bookingid");
		String name = request.getParameter("name");
		String mobileno = request.getParameter("mobileno");
		
		busmain bus = new busmain();
		try {
			bus.giveCancelDetail(bookingid,name,mobileno);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		response.sendRedirect("Canceled.jsp");
		session.setAttribute("bookingid", bookingid);
		session.setAttribute("name", name);
		session.setAttribute("mobileno", mobileno);
		
	}

}
