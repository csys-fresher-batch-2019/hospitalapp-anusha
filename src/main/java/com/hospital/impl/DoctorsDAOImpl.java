package com.hospital.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.Doctors;
import com.hospital.dao.DoctorsDAO;
import com.hospital.manage.ConnectionUtil;
import com.hospital.manage.Logger;

public class DoctorsDAOImpl implements DoctorsDAO {

	private static final Logger LOGGER = Logger.getInstance();
	private static final String ACTION_1 = "doctor_id";
	private static final String ACTION_2 = "department_id";
	
	public void addDoctors(Doctors doc) throws ClassNotFoundException, SQLException {
		
		String sql = "insert into doctors (doctor_id,doctor_name,department_id,doctor_password,d_phone_number,d_gender) values(doctor_id_sq.nextval,?,?,?,?,?)";
		LOGGER.debug(sql);

		try (Connection con = ConnectionUtil.getconnection(); PreparedStatement pst = con.prepareStatement(sql);){
			
			pst.setString(1, doc.getDoctorName());
			pst.setInt(2, doc.getDepartmentId());
			pst.setString(3, doc.getDoctorPassword());
			pst.setString(4, doc.getdPhoneNumber());
			pst.setString(5, doc.getdGender());
			
			int rows = pst.executeUpdate();
			LOGGER.debug("No of rows inserted " + rows);
		} 
		catch (Exception e) {
			LOGGER.debug(e);
		}
	}

	public List<Doctors> displayDoctors() throws ClassNotFoundException, SQLException {

		List<Doctors> list;
		list = new ArrayList<>();
		
		String sql = "select doctor_id,doctor_name,department_id,active_doctors,doctor_presence,d_phone_number,d_gender,no_of_appointments from doctors";	
		
		try(Connection con = ConnectionUtil.getconnection(); Statement stmt = con.createStatement();ResultSet rows = stmt.executeQuery(sql);) {

			while (rows.next()) {
				int doctorId = rows.getInt(ACTION_1);
				String doctorName = rows.getString("doctor_name");
				int deptId = rows.getInt(ACTION_2);
				int active = rows.getInt("active_doctors");
				int present = rows.getInt("doctor_presence");
				String dPhoneNumber = rows.getString("d_phone_number");
				String dGender = rows.getString("d_gender");
				int noOfAppointment = rows.getInt("no_of_appointments");
				
				Doctors d1 = new Doctors();
				d1.setDoctorId(doctorId);
				d1.setDoctorName(doctorName);
				d1.setDepartmentId(deptId);
				d1.setActive(active);
				d1.setDoctorPresent(present);
				d1.setdPhoneNumber(dPhoneNumber);
				d1.setdGender(dGender);
				d1.setNoOfAppointment(noOfAppointment);
				
				list.add(d1);
			
			}
		} catch (Exception e) {
			LOGGER.debug(e);
		}
		return list;
	}

	public void deleteDoctors(int doctorId) throws ClassNotFoundException, SQLException {

		String sql = "Update doctors set active_doctors = 0 where doctor_id = ?";
		
		try(Connection con = ConnectionUtil.getconnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setInt(1, doctorId);

			// execute query
			int rows = pst.executeUpdate();
			LOGGER.debug("No of rows deleted " + rows);
		} catch (Exception e) {
			LOGGER.debug(e);
		}
	}
	
	public List<Doctors> findDoctorByName(String doctorName) throws SQLException, ClassNotFoundException
	{
		List<Doctors> list = new ArrayList<>();
		String sql = "Select doctor_id,department_id,active_doctors,doctor_presence from doctors where doctor_name = ?";
			
		try(Connection con = ConnectionUtil.getconnection(); PreparedStatement pst = con.prepareStatement(sql);ResultSet rows = pst.executeQuery();) {
			pst.setString(1, doctorName);

			LOGGER.debug( "Select doctor_id,department_id,active_doctors from doctors where doctor_name = "+doctorName);
			
			// execute query
			
			LOGGER.debug("No of rows found: " + rows);
			while (rows.next()) {
				int doctorId = rows.getInt(ACTION_1);
				int deptId = rows.getInt(ACTION_2);
				int active = rows.getInt("active_doctors");
				int present = rows.getInt("doctor_presence");
				
				Doctors d1 = new Doctors();
				d1.setDoctorId(doctorId);
				d1.setDepartmentId(deptId);
				d1.setActive(active);
				d1.setDoctorPresent(present);
				
				list.add(d1);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
		}
		return list;
	}

	@Override
	public List<Doctors> doctorsPresent() {
		List<Doctors> list = new ArrayList<>();
		String sql = "Select doctor_id,department_id,doctor_name from doctors where doctor_presence = 1";
		try(Connection con = ConnectionUtil.getconnection(); PreparedStatement pst = con.prepareStatement(sql);ResultSet rows = pst.executeQuery();) {

			LOGGER.debug( sql);
			
			// execute query
			
			LOGGER.debug("No of rows found: " + rows);
			while (rows.next()) {
				int doctorId = rows.getInt(ACTION_1);
				int deptId = rows.getInt(ACTION_2);
				String docName = rows.getString("doctor_name");
				
				Doctors d1 = new Doctors();
				d1.setDoctorId(doctorId);
				d1.setDepartmentId(deptId);
				d1.setDoctorName(docName);
				
				list.add(d1);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
		}
		return list;
	}

}
