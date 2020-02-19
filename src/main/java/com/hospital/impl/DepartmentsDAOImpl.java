package com.hospital.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.hospital.Departments;
import com.hospital.dao.DepartmentsDAO;
import com.hospital.manage.ConnectionUtil;
import com.hospital.manage.Logger;

public class DepartmentsDAOImpl implements DepartmentsDAO {

	private static final Logger LOGGER = Logger.getInstance();

	public void addDepartment(Departments dept) throws ClassNotFoundException, SQLException {
		
		String sql = "insert into departments (department_id,department_name)values (department_id_sq.nextval,?)";
		LOGGER.debug(sql);

		try (Connection con = ConnectionUtil.getconnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, dept.getDepartmentName());

			int rows = pst.executeUpdate();
			LOGGER.debug("No of rows inserted " + rows);

		} catch (Exception e) {
			LOGGER.debug(e);
		}
	}

	public List<Departments> adminDisplayDepartments() throws ClassNotFoundException, SQLException {

		List<Departments> list = new ArrayList<>();
		String sql = "select department_id,department_name, active_departments from departments ";
		LOGGER.debug(sql);

		try (Connection con = ConnectionUtil.getconnection();
				Statement stmt = con.createStatement();
				ResultSet rows = stmt.executeQuery(sql);) {

			LOGGER.debug(rows);

			while (rows.next()) {
				String deptName = rows.getString("department_name");
				int deptId = rows.getInt("department_id");
				int active = rows.getInt("active_departments");
				LOGGER.debug(deptId + "-" + deptName);
				
				Departments d1 = new Departments();
				d1.setDepartmentID(deptId);
				d1.setDepartmentName(deptName);
				d1.setActive(active);
				
				list.add(d1);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
		}
		return list;

	}

	public void updateDepartment(int active, int departmentID) throws ClassNotFoundException, SQLException {

		String sql = "Update departments set active_departments = ? where department_id = ?";
		LOGGER.debug(sql);

		try (Connection con = ConnectionUtil.getconnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			// prepare query
			pst.setInt(1, active);
			pst.setInt(2, departmentID);

			// execute query
			int rows = pst.executeUpdate();
			LOGGER.debug("No of rows updated " + rows);
		} catch (Exception e) {
			LOGGER.debug(e);
		}

	}
	public List<Departments> displayDepartments() throws ClassNotFoundException, SQLException {

		List<Departments> list = new ArrayList<>();
		String sql = "select department_id,department_name from departments where active_departments = 1";
		LOGGER.debug(sql);

		try (Connection con = ConnectionUtil.getconnection();
				Statement stmt = con.createStatement();
				ResultSet rows = stmt.executeQuery(sql);) {

			LOGGER.debug(rows);

			while (rows.next()) {
				String deptName = rows.getString("department_name");
				int deptId = rows.getInt("department_id");
				
				LOGGER.debug(deptId + "-" + deptName);
				
				Departments d1 = new Departments();
				d1.setDepartmentID(deptId);
				d1.setDepartmentName(deptName);
				
				list.add(d1);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
		}
		return list;

	}

}
