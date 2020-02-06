package com.hospital.TestDoctors;

import java.util.Scanner;

import com.hospital.hospitalDAO.DoctorsDAO;
import com.hospital.manage.DAOFactory;
import com.hospital.manage.Logger;

public class TestSearchDoctor {

	private static Logger LOGGER = Logger.getInstance();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		
		DoctorsDAO dao = DAOFactory.getDoctorsDAO();

		LOGGER.debug("Enter doctorName : ");
		String doctorName = in.next();

		dao.findDoctorByName(doctorName);

		in.close();

		/*
		 * DoctorsDAOImpl d1= new DoctorsDAOImpl(); d1.findDoctorByName("Dhana");
		 */
	}

}
