package com.hospital.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.hospital.Payments;
import com.hospital.dao.PaymentsDAO;
import com.hospital.manage.ConnectionUtil;
import com.hospital.manage.Logger;

public class PaymentsDAOImpl implements PaymentsDAO {

	private static final Logger LOGGER = Logger.getInstance();
	
	public void addPayments(Payments pay) throws SQLException, ClassNotFoundException {

		String sql = "insert into bills (bill_no, patient_id, total_amount, amount_paid, bill_date) values (bill_no_sq.nextval,?,?,?,?)";
		LOGGER.debug(sql);
				
		try (Connection con = ConnectionUtil.getconnection(); PreparedStatement pst = con.prepareStatement(sql);){
			
			pst.setInt(1, pay.getPatientId());
			pst.setInt(2, pay.getTotalAmount());
			pst.setInt(3, pay.getAmountPaid()); 
			pst.setTimestamp(4, Timestamp.valueOf(pay.getBillDate()));
			
			int rows = pst.executeUpdate();
			LOGGER.debug("No of rows inserted " + rows);
		
		} 
		
		catch (Exception e) {
			LOGGER.debug(e);		
		}
	}

	public void updatePayments() throws ClassNotFoundException, SQLException {

		String sql = "update bills set status ='PAID' where total_amount=amount_paid";
		LOGGER.debug(sql);
				
		try(Connection con = ConnectionUtil.getconnection(); Statement stmt = con.createStatement(); ResultSet rows = stmt.executeQuery(sql);) {
			
			LOGGER.debug("No of rows updated " + rows);
		} 
		
		catch (Exception e) {
			LOGGER.debug(e);
		}
		
	}

	public List<Payments> displayPayments() throws ClassNotFoundException, SQLException {

		List<Payments> list = new ArrayList<>();
		
		String sql = "select bill_no, patient_id, total_amount, amount_paid, pending_amount, bill_date, status from bills";
		LOGGER.debug(sql);
				
		try(Connection con = ConnectionUtil.getconnection(); Statement stmt = con.createStatement(); ResultSet rows = stmt.executeQuery(sql);) {
			
			LOGGER.debug(rows);
			
			while (rows.next()) {
				int billNo = rows.getInt("bill_no");
				int patientId = rows.getInt("patient_id");
				int totalAmount = rows.getInt("total_amount");
				int amountPaid = rows.getInt("amount_paid");
				int pendingAmount = rows.getInt("pending_amount");
				String billDate = rows.getString("bill_date");
				String status = rows.getString("status");			
				LOGGER.debug(billNo+","+patientId+","+totalAmount+","+amountPaid+","+pendingAmount+","+billDate+","+status);
				Payments d1 = new Payments();
				list.add(d1);
			}
		} 
		catch (Exception e) {
			LOGGER.debug(e);
		}
		
		return Collections.emptyList();
	}

	public List<Payments> findMyPayments(int patientId) throws SQLException, ClassNotFoundException {
		
		List<Payments> list = new ArrayList<>();
		
		String sql = "select bill_no, total_amount, amount_paid, pending_amount, bill_date, status from bills where patient_id = ?";
				
		try(Connection con = ConnectionUtil.getconnection(); PreparedStatement pst = con.prepareStatement(sql); ResultSet rows = pst.executeQuery();) {
			pst.setInt(1, patientId);			
			
			LOGGER.debug( "select bill_no, total_amount, amount_paid, pending_amount, bill_date, status from bills where patient_id = "+patientId);

			LOGGER.debug("No of rows found: " + rows);
			
			while (rows.next()) {
				int billNo = rows.getInt("bill_no");
				int totalAmount = rows.getInt("total_amount");
				int amountPaid = rows.getInt("amount_paid");
				int pendingAmount = rows.getInt("pending_amount");
				String billDate = rows.getString("bill_date");
				String status = rows.getString("status");			
				LOGGER.debug(billNo+","+patientId+","+totalAmount+","+amountPaid+","+pendingAmount+","+billDate+","+status);
				Payments d1 = new Payments();
				list.add(d1);
			}
		} 
		catch (Exception e) {
			LOGGER.debug(e);
		}
		
		return Collections.emptyList();
	}

	public void updatePendingAmnt() throws ClassNotFoundException, SQLException {
		
		String sql = "update bills set pending_amount=total_amount-amount_paid";
		LOGGER.debug(sql);
		
		try(Connection con = ConnectionUtil.getconnection(); Statement stmt = con.createStatement(); ResultSet rows = stmt.executeQuery(sql);) {

			// execute query
			LOGGER.debug("No of rows updated " + rows);
		} 
		catch (Exception e) {
			LOGGER.debug(e);
		}
	}

}
