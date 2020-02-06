package com.hospital.testpatients;

import java.sql.SQLException;
import java.util.Scanner;

import com.hospital.dao.PatientsDAO;
import com.hospital.manage.DAOFactory;
import com.hospital.manage.Logger;

public class TestUpdatePatients {

	private static Logger LOGGER = Logger.getInstance();
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		PatientsDAO dao = DAOFactory.getPatientsDAO();
		Scanner in = new Scanner(System.in);

		LOGGER.debug("Enter PatientId : ");
		String patientId = in.next();
		
		LOGGER.debug("Enter age : ");
		int age = in.nextInt();

		dao.updatePatientsweight(age,patientId);

		in.close();
		/*
		d1.updatePatients(33,"Ammu");
		*/
	}

}
