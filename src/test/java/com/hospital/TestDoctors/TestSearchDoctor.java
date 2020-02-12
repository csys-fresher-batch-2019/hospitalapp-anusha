package com.hospital.testDoctors;

import java.util.Scanner;

import com.hospital.dao.DoctorsDAO;
import com.hospital.manage.DAOFactory;
import com.hospital.manage.Logger;

public class TestSearchDoctor {

	private static Logger LOGGER = Logger.getInstance();
	
	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(System.in);
		
		DoctorsDAO dao = DAOFactory.getDoctorsDAO();

		LOGGER.debug("Enter doctorName : ");
		String doctorName = in.next();

		dao.findDoctorByName(doctorName);

		in.close();

	}

}
