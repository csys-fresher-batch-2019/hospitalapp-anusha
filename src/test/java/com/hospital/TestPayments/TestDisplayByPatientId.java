package com.hospital.testPayments;

import java.sql.SQLException;
import java.util.Scanner;

import com.hospital.dao.PaymentsDAO;
import com.hospital.manage.DAOFactory;
import com.hospital.manage.Logger;

public class TestDisplayByPatientId {

	private static Logger LOGGER = Logger.getInstance();

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		LOGGER.debug("Enter Patient ID : ");
		int patientId = in.nextInt();

		PaymentsDAO dao = DAOFactory.getPaymentsDAO();
		dao.findMyPayments(patientId);

		in.close();
	}

}
