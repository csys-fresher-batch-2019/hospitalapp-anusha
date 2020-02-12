package com.hospital.testDoctors;

import com.hospital.dao.DoctorsDAO;
import com.hospital.manage.DAOFactory;

public class TestDoctorsPresent {

	public static void main(String[] args) {
		
		DoctorsDAO dao = DAOFactory.getDoctorsDAO();
		dao.doctorsPresent();

	}

}
