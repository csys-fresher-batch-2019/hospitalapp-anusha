package com.hospital.testappointments;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

import com.hospital.dao.AppointmentsDAO;
import com.hospital.manage.DAOFactory;
import com.hospital.manage.Logger;

public class TestUpdateAppointments {

	private static Logger LOGGER = Logger.getInstance();
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
        
        LOGGER.debug("Enter Patient ID : ");
        int patientId = in.nextInt();
		
        LOGGER.debug("Enter Starting time : ");
        LocalDateTime setStartingTime=(LocalDateTime.parse(in.next()));
		
        AppointmentsDAO dao = DAOFactory.getAppointmentsDAO();
        dao.updateAppointments(setStartingTime,patientId);
		
		in.close();
		
		/*AppointmentsDAOImpl d1 = new AppointmentsDAOImpl();
		d1.updateAppointments(LocalDateTime.parse("2020-02-20T12:00:00"),1);
		*/
		
	}

}
