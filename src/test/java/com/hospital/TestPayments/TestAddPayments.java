package com.hospital.testPayments;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;
import com.hospital.Payments;
import com.hospital.dao.PaymentsDAO;
import com.hospital.manage.DAOFactory;
import com.hospital.manage.Logger;

public class TestAddPayments {

	private static Logger LOGGER = Logger.getInstance();
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner in = new Scanner(System.in);
		
		Payments d1 = new Payments();
		
		LOGGER.debug("Enter PatientId : ");
		d1.setPatientId(in.nextInt());
		
		LOGGER.debug("Enter Total Amount : ");
		d1.setTotalAmount(in.nextInt());
		
		LOGGER.debug("Enter Amount Paid : ");
		d1.setAmountPaid(in.nextInt());
		
		LOGGER.debug("Enter Bill Date & Time: ");
		d1.setBillDateTime(LocalDateTime.parse(in.next()));
		
		PaymentsDAO dao = DAOFactory.getPaymentsDAO();
		dao.addPayments(d1);

		in.close();

	}

}
