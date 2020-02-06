package com.hospital.manage;

import com.hospital.dao.AppointmentsDAO;
import com.hospital.dao.DepartmentsDAO;
import com.hospital.dao.DoctorsDAO;
import com.hospital.dao.PatientsDAO;
import com.hospital.dao.PaymentsDAO;
import com.hospital.impl.AppointmentsDAOImpl;
import com.hospital.impl.DepartmentsDAOImpl;
import com.hospital.impl.DoctorsDAOImpl;
import com.hospital.impl.PatientsDAOImpl;
import com.hospital.impl.PaymentsDAOImpl;

public class DAOFactory {

	public static DepartmentsDAO getDepartmentsDAO() {
		
		DepartmentsDAO departmentsDAO = new DepartmentsDAOImpl();
		return departmentsDAO;
		
	}

	public static DoctorsDAO getDoctorsDAO() {
		
		DoctorsDAO doctorsDAO = new DoctorsDAOImpl();
		return doctorsDAO;
		
	}

	public static PatientsDAO getPatientsDAO() {
		
		PatientsDAO patientsDAO = new PatientsDAOImpl();
		return patientsDAO;
		
	}

	public static AppointmentsDAO getAppointmentsDAO() {
		
		AppointmentsDAO appointmentsDAO = new AppointmentsDAOImpl();
		return appointmentsDAO;
		
	}

	public static PaymentsDAO getPaymentsDAO() {
		
		PaymentsDAO paymentDAO = new PaymentsDAOImpl();
		return paymentDAO;
		
	}
}