package com.hospital.testAppointments;

import java.sql.SQLException;

import com.hospital.dao.AppointmentsDAO;
import com.hospital.manage.DAOFactory;

public class TestDisplayAppointments {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		AppointmentsDAO dao = DAOFactory.getAppointmentsDAO();
		dao.displayAppointments();
		

	}

}
