package com.hospital.TestDoctors;

import java.sql.SQLException;
import java.util.Scanner;

import com.hospital.hospitalDAO.DoctorsDAO;
import com.hospital.manage.DAOFactory;
import com.hospital.manage.Logger;

public class TestDeleteDoctors {
	
	private static Logger LOGGER = Logger.getInstance();

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		
		DoctorsDAO dao = DAOFactory.getDoctorsDAO();
		
		dao.displayDoctors();
		
		LOGGER.debug("Enter doctorId : ");
		int doctorId = in.nextInt();

		dao.deleteDoctors(doctorId);

		in.close();
		
		/*DoctorsDAOImpl d1 = new DoctorsDAOImpl();
		d1.deleteDoctors(1,6);*/
		
	}

}
