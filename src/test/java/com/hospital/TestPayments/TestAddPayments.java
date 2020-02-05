package com.hospital.TestPayments;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;
import com.hospital.Payments;
import com.hospital.DAO.PaymentsDAO;
import com.hospital.manage.DAOFactory;
import com.hospital.manage.Logger;

public class TestAddPayments {

	private static Logger LOGGER = Logger.getInstance();
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		Payments d1 = new Payments();
		
		LOGGER.debug("Enter PatientId : ");
		d1.setPatientId(in.nextInt());
		
		LOGGER.debug("Enter Total Amount : ");
		d1.setTotalAmount(in.nextInt());
		
		LOGGER.debug("Enter Amount Paid : ");
		d1.setAmountPaid(in.nextInt());
		
		LOGGER.debug("Enter Bill Date: ");
		d1.setBillDate(LocalDateTime.parse(in.next()));
		
		PaymentsDAO dao = DAOFactory.getPaymentsDAO();
		dao.addPayments(d1);

		in.close();
		
		/*// input
				Payments d1 = new Payments();
				d1.setPatientId(2) ;
				d1.setTotalAmount(3234);
				d1.setAmountPaid(543);
				d1.setBillDate(LocalDateTime.parse("2020-01-02T02:37:02")) ;

				// call dao
				PaymentsDAOImpl daoImpl1 = new PaymentsDAOImpl();
				daoImpl1.addPayments(d1);

				// input
				Payments d2 = new Payments();
				d2.patientId = 4 ;
				d2.totalAmount = 1200 ;
				d2.amountPaid = 1200 ;
				d2.billDate = LocalDateTime.parse("2020-01-18T18:35:06") ;

				// call dao
				PaymentsDAOImpl daoImpl2 = new PaymentsDAOImpl();
				daoImpl2.addPayments(d2);
				
				// input
				Payments d3 = new Payments();
				d3.patientId = 6 ;
				d3.totalAmount = 3670;
				d3.amountPaid = 2734;
				d3.billDate = LocalDateTime.parse("2020-01-20T20:44:10") ;

				// call dao
				PaymentsDAOImpl daoImpl3 = new PaymentsDAOImpl();
				daoImpl3.addPayments(d3);
				
				// input
				Payments d4 = new Payments();
				d4.patientId = 7 ;
				d4.totalAmount = 7653;
				d4.amountPaid = 5443;
				d4.billDate =  LocalDateTime.parse("2020-01-12T05:22:12") ;
				
				// call dao
				PaymentsDAOImpl daoImpl4 = new PaymentsDAOImpl();
				daoImpl4.addPayments(d4);
				
				// input
				Payments d5 = new Payments();
				d5.patientId = 9 ;
				d5.totalAmount = 3234 ;
				d5.amountPaid = 3234;
				d5.billDate =  LocalDateTime.parse("2020-01-28T03:50:16") ;

				// call dao
				PaymentsDAOImpl daoImpl5 = new PaymentsDAOImpl();
				daoImpl5.addPayments(d5);
				
				// input
				Payments d6 = new Payments();
				d6.patientId = 1 ;
				d6.totalAmount = 8942 ;
				d6.amountPaid = 8942;
				d6.billDate = LocalDateTime.parse("2020-01-01T12:30:00") ;

				// call dao
				PaymentsDAOImpl daoImpl6 = new PaymentsDAOImpl();
				daoImpl6.addPayments(d6);
				
				// input
				Payments d7 = new Payments();
				d7.patientId = 3 ;
				d7.totalAmount = 8978 ;
				d7.amountPaid = 543;
				d7.billDate = LocalDateTime.parse("2020-01-25T06:22:04") ;

				// call dao
				PaymentsDAOImpl daoImpl7 = new PaymentsDAOImpl();
				daoImpl7.addPayments(d7);
				
				// input
				Payments d8 = new Payments();
				d8.patientId = 5 ;
				d8.totalAmount = 75341 ;
				d8.amountPaid = 75341;
				d8.billDate = LocalDateTime.parse("2020-01-02T23:11:08") ;

				// call dao
				PaymentsDAOImpl daoImpl8 = new PaymentsDAOImpl();
				daoImpl8.addPayments(d8);
				
				// input
				Payments d9 = new Payments();
				d9.patientId = 10 ;
				d9.totalAmount = 8637 ;
				d9.amountPaid = 5632;
				d9.billDate = LocalDateTime.parse("2020-01-02T10:40:18") ;

				// call dao
				PaymentsDAOImpl daoImpl9 = new PaymentsDAOImpl();
				daoImpl9.addPayments(d9);

				// input
				Payments d10 = new Payments();
				d10.patientId = 8 ;
				d10.totalAmount = 6532 ;
				d10.amountPaid = 6532;
				d10.billDate = LocalDateTime.parse("2020-01-23T08:56:14") ;

				// call dao
				PaymentsDAOImpl daoImpl10 = new PaymentsDAOImpl();
				daoImpl10.addPayments(d10);*/
	}

}
