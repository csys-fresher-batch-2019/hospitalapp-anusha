package com.hospital.manage;

import com.hospital.Impl.AppointmentsDAOImpl;
import com.hospital.Impl.DepartmentsDAOImpl;
import com.hospital.Impl.DoctorsDAOImpl;
import com.hospital.Impl.PatientsDAOImpl;
import com.hospital.Impl.PaymentsDAOImpl;
import com.hospital.hospitalDAO.AppointmentsDAO;
import com.hospital.hospitalDAO.DepartmentsDAO;
import com.hospital.hospitalDAO.DoctorsDAO;
import com.hospital.hospitalDAO.PatientsDAO;
import com.hospital.hospitalDAO.PaymentsDAO;

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