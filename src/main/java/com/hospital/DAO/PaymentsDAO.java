package com.hospital.DAO;

import java.sql.SQLException;
import java.util.List;
import com.hospital.Payments;

public interface PaymentsDAO {
	
	//Add Payment
	public void addPayments(Payments pay) throws SQLException, ClassNotFoundException;
	
	//Update pending amount
	public void updatePendingAmnt() throws ClassNotFoundException, SQLException ;
	
	//Update Payment Status
	public void updatePayments() throws ClassNotFoundException, SQLException ;
	
	//Display All Payments
	List<Payments> displayPayments() throws ClassNotFoundException, SQLException;
	
	//Display Payments paid by a Patient
	public List<Payments> findMyPayments(int patientId) throws SQLException, ClassNotFoundException;

}
