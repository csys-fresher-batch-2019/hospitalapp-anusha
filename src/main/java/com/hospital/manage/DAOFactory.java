package com.hospital.manage;

import com.hospital.dao.AdminDAO;
import com.hospital.dao.AppointmentsDAO;
import com.hospital.dao.DepartmentsDAO;
import com.hospital.dao.DoctorsDAO;
import com.hospital.dao.PatientsDAO;
import com.hospital.dao.PaymentsDAO;
import com.hospital.impl.AdminDAOImpl;
import com.hospital.impl.AppointmentsDAOImpl;
import com.hospital.impl.DepartmentsDAOImpl;
import com.hospital.impl.DoctorsDAOImpl;
import com.hospital.impl.PatientsDAOImpl;
import com.hospital.impl.PaymentsDAOImpl;

public class DAOFactory {

	private DAOFactory() {
		throw new IllegalStateException("Utility class");
	}

	public static DepartmentsDAO getDepartmentsDAO() {

		return new DepartmentsDAOImpl();

	}

	public static DoctorsDAO getDoctorsDAO() {

		return new DoctorsDAOImpl();

	}

	public static PatientsDAO getPatientsDAO() {

		return new PatientsDAOImpl();

	}

	public static AppointmentsDAO getAppointmentsDAO() {

		return new AppointmentsDAOImpl();

	}

	public static PaymentsDAO getPaymentsDAO() {

		return new PaymentsDAOImpl();

	}

	public static AdminDAO getAdminDAO() {
		
		return  new AdminDAOImpl();
		
	}
}