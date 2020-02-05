package com.hospital.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.Doctors;
import com.hospital.DAO.DoctorsDAO;
import com.hospital.manage.ConnectionUtil;
import com.hospital.manage.Logger;

public class DoctorsDAOImpl implements DoctorsDAO {

	private static Logger LOGGER = Logger.getInstance();
	
	public void addDoctors(Doctors doc) {
		// TODO Auto-generated method stub
		String sql = "insert into doctors (doctor_id,doctor_name,department_id,doctor_password) values(doctor_id_sq.nextval,?,?,?)";
		LOGGER.debug(
				"insert into doctors (doctor_id,doctor_name,department_id,doctor_password) values(doctor_id_sq.nextval,?,?,?)");
		// get connection
		try {
			Connection con = ConnectionUtil.getconnection();

			// prepare query
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, doc.getDoctorName());
			pst.setInt(2, doc.getDepartmentId());
			pst.setString(3, doc.getDoctorPassword());

			// execute query
			int rows = pst.executeUpdate();
			LOGGER.debug("No of rows inserted " + rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*public void updateDoctors(String doctorName, int doctorId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		String sql = "Update doctors set doctor_name = ? where doctor_id = ?";
		LOGGER.debug("Update doctors set doctor_name = ? where doctor_id = ?");

		Connection con = ConnectionUtil.getconnection();

		// prepare query
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, doctorName);
		pst.setInt(2, doctorId);

		// execute query
		int rows = pst.executeUpdate();
		LOGGER.debug("No of rows updated " + rows);

	}*/

	public List<Doctors> displayDoctors() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		List<Doctors> list = new ArrayList<Doctors>();
		
		String sql = "select doctor_id,doctor_name,department_id,active_doctors from doctors";
		//LOGGER.debug(sql);
		Connection con = ConnectionUtil.getconnection();
		Statement stmt = con.createStatement();
		ResultSet rows = stmt.executeQuery(sql);
		//LOGGER.debug(rows);
		while (rows.next()) {
			int doctorId = rows.getInt("doctor_id");
			String doctorName = rows.getString("doctor_name");
			int deptId = rows.getInt("department_id");
			int active = rows.getInt("active_doctors");
			LOGGER.debug(doctorId+"-"+doctorName+"-"+deptId+"-"+active);
			Doctors d1 = new Doctors();
			list.add(d1);
		}
		return list;
	}

	public void deleteDoctors(int doctorId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		String sql = "Update doctors set active_doctors = 0 where doctor_id = ?";
		//LOGGER.debug("Delete from doctors where department_id = ?");
		
		Connection con = ConnectionUtil.getconnection();

		// prepare query
		PreparedStatement pst = con.prepareStatement(sql);
		//pst.setInt(1, active);
		pst.setInt(1, doctorId);

		// execute query
		int rows = pst.executeUpdate();
		LOGGER.debug("No of rows deleted " + rows);
	}
	
	public List<Doctors> findDoctorByName(String doctorName) throws SQLException, ClassNotFoundException
	{
		List<Doctors> list = new ArrayList<Doctors>();
		String sql = "Select doctor_id,department_id,active_doctors from doctors where doctor_name = ?";
		
		Connection con = ConnectionUtil.getconnection();

		// prepare query
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, doctorName);

		LOGGER.debug( "Select doctor_id,department_id,active_doctors from doctors where doctor_name = "+doctorName);
		
		// execute query
		ResultSet rows = pst.executeQuery();
		LOGGER.debug("No of rows found: " + rows);
		while (rows.next()) {
			int doctorId = rows.getInt("doctor_id");
			int deptId = rows.getInt("department_id");
			int active = rows.getInt("active_doctors");
			LOGGER.debug(doctorId+"-"+doctorName+"-"+deptId+"-"+active);
			Doctors d1 = new Doctors();
			list.add(d1);
		}
		return list;
	}

}
