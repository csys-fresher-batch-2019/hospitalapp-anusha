package com.hospital.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.hospital.Departments;
import com.hospital.Doctors;
import com.hospital.Patients;
import com.hospital.dao.PatientsDAO;
import com.hospital.manage.ConnectionUtil;
import com.hospital.manage.Logger;

public class PatientsDAOImpl implements PatientsDAO {

	private static final Logger LOGGER = Logger.getInstance();
	
	public void addPatients(Patients p) throws ClassNotFoundException, SQLException {

		String sql = "insert into patient (patient_id, patient_name, age, address, p_phone_number, p_gender,patient_password) values (patient_id_sq.nextval,?, ?, ?, ?, ?, ?)";

		LOGGER.debug(sql);

		try (Connection con = ConnectionUtil.getconnection(); PreparedStatement pst = con.prepareStatement(sql);){
			
			pst.setString(1, p.getPatientName());
			pst.setInt(2, p.getAge());
			pst.setString(3, p.getAddress());
			pst.setString(4, p.getpPhoneNumber());
			pst.setString(5, p.getGender());
			pst.setString(6,p.getPatientPassword());

			// execute query
			int rows = pst.executeUpdate();
			LOGGER.debug("No of rows inserted " + rows);
		} 
		catch (Exception e) {
			LOGGER.debug(e);
		}
	}

	public List<Patients> displayPatients() throws ClassNotFoundException, SQLException {

		List<Patients> list = new ArrayList<>();
		String sql = "select patient_id,patient_name,age, p_gender, address, p_phone_number, active_patients from patient";
		LOGGER.debug(sql);
	
		try(Connection con = ConnectionUtil.getconnection(); Statement stmt = con.createStatement(); ResultSet rows = stmt.executeQuery(sql);) {
			
			LOGGER.debug(rows);
			
			while (rows.next()) {
				int patientId = rows.getInt("patient_id");
				String patientName = rows.getString("patient_name");
				int age = rows.getInt("age");
				String gender = rows.getString("p_gender");
				String address = rows.getString("address");
				String phoneNo = rows.getString("p_phone_number");
				int active = rows.getInt("active_patients");
				
				LOGGER.debug(patientId+" "+patientName+" "+age+" "+gender+" "+address+" "+phoneNo+" "+active );
				Patients d1 = new Patients();
				d1.setPatientId(patientId);
				d1.setActivePatient(active);
				d1.setAddress(address);
				d1.setAge(age);
				d1.setGender(gender);
				d1.setPatientName(patientName);
				d1.setpPhoneNumber(phoneNo);
				
				list.add(d1);
			}
		} 
		catch (Exception e) {
			LOGGER.debug(e);
		}

		return Collections.emptyList();
	}

	public void deletePatients(int patientId) throws ClassNotFoundException, SQLException {

		String sql = "update active_patients=0 from patient where patient_id = ?";
		LOGGER.debug("sql"+patientId);

		
		try(Connection con = ConnectionUtil.getconnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, patientId);

			// execute query
			int rows = pst.executeUpdate();
			LOGGER.debug("No of rows deleted " + rows);
		} catch (Exception e) {
			LOGGER.debug(e);
		}

	}

	public List<Patients> findMyProfile(int patientId) throws SQLException, ClassNotFoundException {

		List<Patients> list = new ArrayList<>();
		String sql = "Select patient_id,patient_name, age, address, p_phone_number, p_gender,active_patients from patient where patient_id = ?";
		
		try(Connection con = ConnectionUtil.getconnection(); PreparedStatement pst = con.prepareStatement(sql); ResultSet rows = pst.executeQuery();) {
			pst.setInt(1, patientId);

			LOGGER.debug(sql+patientId);

			LOGGER.debug("No of rows found: " + rows);

			while (rows.next()) {		
				String name = rows.getString("patient_name");
				int age = rows.getInt("age");
				String address = rows.getString("address");
				String phoneNumber = rows.getString("phone_number");
				String gender = rows.getString("p_gender");
				
				Patients d2 = new Patients();
				d2.setPatientName(name);
				d2.setAddress(address);
				d2.setAge(age);
				d2.setpPhoneNumber(phoneNumber);
				d2.setGender(gender);
				
				list.add(d2);

			}
		} catch (Exception e) {
			LOGGER.debug(e);
		}
		return list;
	}
	
	public List<Doctors> joinDepartmentsDoctors() throws SQLException, ClassNotFoundException  {//to display doctor name nd id during doctor id entry
		
		List<Doctors> list = new ArrayList<>();
		
		String sql = ("select d.doctor_name,s.department_name,d.doctor_id from doctors d join departments s on d.department_id = s.department_id ");

		try(Connection con = ConnectionUtil.getconnection(); Statement stmt = con.createStatement(); ResultSet rows = stmt.executeQuery(sql);) {
			
			
			while (rows.next())
			{
				String doctorName = rows.getString("doctor_name") ;
				int doctorId = rows.getInt("doctor_id");
				String departmentName = rows.getString("department_name") ;
				
				Departments d1= new Departments();
				d1.setDepartmentName(departmentName);
				Doctors d2 = new Doctors();
				d2.setDoctorName(doctorName);
				d2.setDoctorId(doctorId);
				
				list.add(d2);

			}
		} catch (Exception e) {
			LOGGER.debug(e);
		}
		return list;
	}


}
