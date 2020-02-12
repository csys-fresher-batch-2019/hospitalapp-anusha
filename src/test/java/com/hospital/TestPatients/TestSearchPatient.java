package com.hospital.testPatients;

import java.sql.SQLException;
import java.util.Scanner;

import com.hospital.dao.PatientsDAO;
import com.hospital.manage.DAOFactory;
import com.hospital.manage.Logger;

public class TestSearchPatient {
	
	private static Logger LOGGER = Logger.getInstance();

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner in = new Scanner(System.in);
		
		PatientsDAO dao = DAOFactory.getPatientsDAO();

		LOGGER.debug("Enter patientId : ");
		int patientId = in.nextInt();

		dao.findMyProfile(patientId);

		in.close();
		
	}

}
