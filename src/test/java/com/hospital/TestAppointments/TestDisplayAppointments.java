package com.hospital.TestAppointments;

import java.sql.SQLException;
import com.hospital.DAO.AppointmentsDAO;
import com.hospital.manage.DAOFactory;

public class TestDisplayAppointments {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		AppointmentsDAO dao = DAOFactory.getAppointmentsDAO();
		dao.displayAppointments();
		

	}

}
