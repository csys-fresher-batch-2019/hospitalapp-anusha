package com.hospital.testAppointments;

import java.util.Scanner;
import java.sql.SQLException;
import com.hospital.Appointments;
import com.hospital.dao.AppointmentsDAO;
import com.hospital.manage.DAOFactory;
import com.hospital.manage.Logger;

public class TestAddAppointments {

	private static Logger LOGGER = Logger.getInstance();
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner in = new Scanner(System.in);
		// TODO Auto-generated method stub

		// input
		Appointments d1 = new Appointments();
		LOGGER.debug("Enter PatientId : ");
		d1.setPatientId(in.nextInt()) ;
		LOGGER.debug("Enter the purpose : ");
		d1.setPurpose(in.next());
		LOGGER.debug("Enter the DoctorId : ");
		d1.setDoctorId(in.nextInt());
		LOGGER.debug("Enter the DoctorId : ");
		
		// call dao
		AppointmentsDAO dao =  DAOFactory.getAppointmentsDAO();
		dao.addAppointments(d1);

		in.close();
		// input
		/*Appointments d2 = new Appointments();
		d2.patientId = 3 ;
		d2.purpose = "Surgery";
		d2.doctorId = 6;
		d2.startingTime = LocalDateTime.parse("2020-01-20T12:00:00");
		d2.endingTime = LocalDateTime.parse("2020-01-20T12:00:00").plus(Duration.of(30, ChronoUnit.MINUTES));

		// call dao
		AppointmentsDAOImpl daoImpl2 = new AppointmentsDAOImpl();
		daoImpl2.addAppointments(d2);*/

	}

}
