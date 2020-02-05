package com.hospital.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.Departments;
import com.hospital.DAO.DepartmentsDAO;
import com.hospital.manage.ConnectionUtil;
import com.hospital.manage.Logger;

public class DepartmentsDAOImpl implements DepartmentsDAO {

	private static Logger LOGGER = Logger.getInstance();
	
	public void addDepartment(Departments dept) {
		// TODO Auto-generated method stub

		String sql = "insert into departments (department_id,department_name)values (department_id_sq.nextval,?)";
		LOGGER.debug("insert into departments (department_id,department_name)values (department_id_sq.nextval,?)");
		// get connection
		try {
			Connection con = ConnectionUtil.getconnection();

			// prepare query
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, dept.getDepartmentName());

			// execute query
			int rows = pst.executeUpdate();
			LOGGER.debug("No of rows inserted " + rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Departments> displayDepartments() throws Exception {
		
		List<Departments> list = new ArrayList<Departments>();
		String sql = "select department_id,department_name from departments";
		LOGGER.debug(sql);
		Connection con = ConnectionUtil.getconnection();
		Statement stmt = con.createStatement();
		ResultSet rows = stmt.executeQuery(sql);
		LOGGER.debug(rows);
		
		while (rows.next()) {
			String deptName = rows.getString("department_name");
			int deptId = rows.getInt("department_id");
			LOGGER.debug(deptId+"-"+deptName);
			Departments d1 = new Departments();
			d1.setDepartmentID(deptId);
			d1.setDepartmentName(deptName);
			list.add(d1);
		}
		return list;
		// TODO Auto-generated method stub

	}

	public void updateDepartment(int active, int departmentID) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		String sql = "Update departments set active_departments = ? where department_id = ?";
		LOGGER.debug("Update departments set active_departments = ? where department_id = ?");

		Connection con = ConnectionUtil.getconnection();

		// prepare query
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, active);
		pst.setInt(2, departmentID);

		// execute query
		int rows = pst.executeUpdate();
		LOGGER.debug("No of rows updated " + rows);

	}

	/*public void deleteDepartment(int DepartmentID) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

		String sql = "Delete from departments where department_id = ?";
		LOGGER.debug("Delete from departments where department_id = ?");
		
		Connection con = ConnectionUtil.getconnection();

		// prepare query
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, DepartmentID);

		// execute query
		int rows = pst.executeUpdate();
		LOGGER.debug("No of rows deleted " + rows);

	}*/

}
