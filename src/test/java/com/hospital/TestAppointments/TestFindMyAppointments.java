package com.hospital.TestAppointments;

import java.sql.SQLException;
import java.util.Scanner;
import com.hospital.DAO.AppointmentsDAO;
import com.hospital.manage.DAOFactory;
import com.hospital.manage.Logger;

public class TestFindMyAppointments {

	private static Logger LOGGER = Logger.getInstance();
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
        
        LOGGER.debug("Enter Patient ID : ");
        int patientId = in.nextInt();
		
        AppointmentsDAO dao = DAOFactory.getAppointmentsDAO();
		dao.findMyAppointments(patientId);
		
		in.close();
		/*AppointmentsDAOImpl d1= new AppointmentsDAOImpl();
		d1.findMyAppointments(2);
		*/
	}

}
