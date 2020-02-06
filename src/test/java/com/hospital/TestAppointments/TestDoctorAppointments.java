package com.hospital.testappointments;

import java.sql.SQLException;
import java.util.Scanner;

import com.hospital.dao.AppointmentsDAO;
import com.hospital.manage.DAOFactory;
import com.hospital.manage.Logger;

public class TestDoctorAppointments {

	private static Logger LOGGER = Logger.getInstance();
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
        
        LOGGER.debug("Enter Doctor ID : ");
        int doctorId = in.nextInt();
		
        AppointmentsDAO dao = DAOFactory.getAppointmentsDAO();
		dao.doctorAppointments(doctorId);
		
		in.close();
		
		/*AppointmentsDAOImpl d1= new AppointmentsDAOImpl();
		d1.doctorAppointments(2);
		*/
	}

}
