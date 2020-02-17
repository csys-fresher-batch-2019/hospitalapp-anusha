
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

		// input
		Appointments d1 = new Appointments();
		LOGGER.debug("Enter PatientId : ");
		d1.setPatientId(in.nextInt()) ;
		LOGGER.debug("Enter the purpose : ");
		d1.setPurpose(in.next());
		LOGGER.debug("Enter the DoctorId : ");
		d1.setDoctorId(in.nextInt());
		
		// call dao
		AppointmentsDAO dao =  DAOFactory.getAppointmentsDAO();
		dao.addAppointments(d1);

		in.close();

	}

}
