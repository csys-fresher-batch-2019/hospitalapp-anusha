package com.hospital.testPatients;

import java.sql.SQLException;
import java.util.Scanner;
import com.hospital.Patients;
import com.hospital.dao.PatientsDAO;
import com.hospital.manage.DAOFactory;
import com.hospital.manage.Logger;

public class TestAddPatients {

	private static Logger LOGGER = Logger.getInstance();
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner in = new Scanner(System.in);

		Patients d1 = new Patients();

		PatientsDAO dao = DAOFactory.getPatientsDAO();

		LOGGER.debug("Enter patientName : ");
		d1.setPatientName(in.next());

		LOGGER.debug("Enter age : ");
		d1.setAge(in.nextInt());

		LOGGER.debug("Enter gender : ");
		d1.setGender(in.next());

		LOGGER.debug("Enter address : ");
		d1.setAddress(in.next());

		LOGGER.debug("Enter phoneNumber : ");
		d1.setpPhoneNumber(in.next());

		LOGGER.debug("Enter patientPassword : ");
		d1.setPatientPassword(in.next());

		dao.addPatients(d1);
		
		in.close();
	}

}
