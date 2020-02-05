package com.hospital.TestPayments;

import java.sql.SQLException;
import com.hospital.DAO.PaymentsDAO;
import com.hospital.manage.DAOFactory;

public class TestUpdatePendingAmnt {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		PaymentsDAO dao = DAOFactory.getPaymentsDAO();
		dao.updatePendingAmnt();
		
	}

}
