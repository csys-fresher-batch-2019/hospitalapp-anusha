package com.hospital.testPayments;

import java.sql.SQLException;

import com.hospital.dao.PaymentsDAO;
import com.hospital.manage.DAOFactory;

public class TestDisplayPayments {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		PaymentsDAO dao = DAOFactory.getPaymentsDAO();
		dao.displayPayments();
		
	}

}
