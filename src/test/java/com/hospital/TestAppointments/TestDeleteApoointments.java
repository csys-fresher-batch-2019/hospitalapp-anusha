package com.hospital.testAppointments;

import java.util.Scanner;
import java.sql.SQLException;

import com.hospital.dao.AppointmentsDAO;
import com.hospital.manage.DAOFactory;
import com.hospital.manage.Logger;

public class TestDeleteApoointments {

	private static Logger LOGGER = Logger.getInstance();
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
        Scanner in = new Scanner(System.in);
        
        LOGGER.debug("Enter Patient ID : ");
        int patientId = in.nextInt();
		
        AppointmentsDAO dao = DAOFactory.getAppointmentsDAO();
		dao.deleteAppointments(patientId);
		
		in.close();
		
	}

}
