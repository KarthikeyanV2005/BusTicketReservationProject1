package BusReservation;

import java.sql.SQLException;
import java.util.Date;

public class Bus {
	

public int getBusId(String fromdest, Date date, String dest) throws SQLException, ClassNotFoundException {
	busDAO busdao = new busDAO();
	int busid = busdao.getBusDetail(fromdest,date,dest);
	
	return busid;
}

}
