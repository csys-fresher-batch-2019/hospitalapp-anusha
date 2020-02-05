package com.hospital.manage;

import com.hospital.DAO.AppointmentsDAO;
import com.hospital.DAO.DepartmentsDAO;
import com.hospital.DAO.DoctorsDAO;
import com.hospital.DAO.PatientsDAO;
import com.hospital.DAO.PaymentsDAO;
import com.hospital.Impl.AppointmentsDAOImpl;
import com.hospital.Impl.DepartmentsDAOImpl;
import com.hospital.Impl.DoctorsDAOImpl;
import com.hospital.Impl.PatientsDAOImpl;
import com.hospital.Impl.PaymentsDAOImpl;

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