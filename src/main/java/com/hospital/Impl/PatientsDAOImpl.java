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
import com.hospital.Patients;
import com.hospital.dao.PatientsDAO;
import com.hospital.manage.ConnectionUtil;
import com.hospital.manage.Logger;

public class PatientsDAOImpl implements PatientsDAO {

	private static Logger LOGGER = Logger.getInstance();
	
	public void addPatients(Patients p) throws ClassNotFoundException, SQLException {

		String sql = "insert into patient (patient_id, patient_name, age, weight, address, phone_number, gender, disease, doctor_id, patient_type, entry_date,patient_password) \r\n"
				+ "values (patient_id_sq.nextval,?, ?, ?, ?, ?,  ?, ?, ?, ?, ?,?)";

		LOGGER.debug("insert into patient (patient_id, patient_name, age, weight, address, phone_number, gender, disease, doctor_id, patient_type, entry_date,patient_password) values (patient_id_sq.nextval,?, ?, ?, ?, ?,  ?, ?, ?, ?, ?)");

		try (Connection con = ConnectionUtil.getconnection(); PreparedStatement pst = con.prepareStatement(sql);){
			
			pst.setString(1, p.getPatientName());
			pst.setInt(2, p.getAge());
			pst.setInt(3, p.getWeight());
			pst.setString(4, p.getAddress());
			pst.setString(5, p.getPhoneNumber());
			pst.setString(6, p.getGender());
			pst.setString(7, p.getDisease());
			pst.setInt(8, p.getDoctorId());
			pst.setString(9, p.getPatientType());
			pst.setTimestamp(10, Timestamp.valueOf(p.getEntryDate()));
			pst.setString(11,p.getPatientPassword());

			// execute query
			int rows = pst.executeUpdate();
			LOGGER.debug("No of rows inserted " + rows);
		} 
		catch (Exception e) {
			LOGGER.debug(e);
		}
	}

	public void updatePatientsweight(int weight, String patientName) throws ClassNotFoundException, SQLException {

		String sql = "update patient set weight = ? where patient_name = ?";
		LOGGER.debug("update patient set weight = ? where patient_name = ?");

		try(Connection con = ConnectionUtil.getconnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			
			pst.setInt(1, weight);
			pst.setString(2, patientName);

			// execute query
			int rows = pst.executeUpdate();
			LOGGER.debug("No of rows updated " + rows);
		} 
		catch (Exception e) {
			LOGGER.debug(e);
		}

	}

	public List<Patients> displayPatients() throws ClassNotFoundException, SQLException {

		List<Patients> list = new ArrayList<Patients>();
		String sql = "select patient_id,patient_name,age, weight, gender, address, phone_number, disease, doctor_id, entry_date, patient_type,active_patients from patient";
		LOGGER.debug(sql);
	
		try(Connection con = ConnectionUtil.getconnection(); Statement stmt = con.createStatement(); ResultSet rows = stmt.executeQuery(sql);) {
			
			LOGGER.debug(rows);
			
			while (rows.next()) {
				int patientId = rows.getInt("patient_id");
				String patientName = rows.getString("patient_name");
				int age = rows.getInt("age");
				int weight = rows.getInt("weight");
				String gender = rows.getString("gender");
				String address = rows.getString("address");
				String phoneNo = rows.getString("phone_number");
				String disease = rows.getString("disease");
				int docId = rows.getInt("doctor_id");
				String eTime = rows.getString("entry_date");
				String patientType = rows.getString("patient_type");
				int active = rows.getInt("active_patients");
				LOGGER.debug(patientId+","+patientName+","+ age+","+weight +","+ gender +","+ address +","+ phoneNo +","+ disease +","+ docId +","+ eTime +","+ patientType +","+ active);
				Patients d1 = new Patients();
				list.add(d1);
			}
		} 
		catch (Exception e) {
			LOGGER.debug(e);
		}

		return Collections.emptyList();
	}

	public void deletePatients(int patientId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

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

		List<Patients> list = new ArrayList<Patients>();
		String sql = "Select patient_name, age, weight, address, phone_number, gender, disease, doctor_id, patient_type, entry_date from patient where patient_id = ?";

		
		try(Connection con = ConnectionUtil.getconnection(); PreparedStatement pst = con.prepareStatement(sql); ResultSet rows = pst.executeQuery();) {
			pst.setInt(1, patientId);

			LOGGER.debug("Select patient_name, age, weight, address, phone_number, gender, disease, doctor_id, patient_type, entry_date from patient where patient_id = "+patientId);


			// execute query
			
			LOGGER.debug("No of rows found: " + rows);

			while (rows.next()) {		
				String name = rows.getString("patient_name");
				int age = rows.getInt("age");
				int weight = rows.getInt("weight");
				String address = rows.getString("address");
				String phoneNumber = rows.getString("phone_number");
				String gender = rows.getString("gender");
				String disease = rows.getString("disease");
				int docId = rows.getInt("doctor_id");
				String patientType = rows.getString("patient_type");
				String eDate = rows.getString("entry_date");
				LOGGER.debug(name +","+ age +"," + weight +","+ address +"," + phoneNumber +"," + gender +"," + disease +"," + docId +"," + patientType +"," + eDate);
				Patients d2 = new Patients();
				list.add(d2);

			}
		} catch (Exception e) {
			LOGGER.debug(e);
		}
		return list;
	}
	
	public String[] joinDepartmentsDoctors() throws SQLException, ClassNotFoundException  {//to display doctor name nd id during doctor id entry
		
		String sql = ("select d.doctor_name,s.department_name,d.doctor_id from doctors d join departments s on d.department_id = s.department_id ");
		
		
		
		try(Connection con = ConnectionUtil.getconnection(); Statement stmt = con.createStatement(); ResultSet rows = stmt.executeQuery(sql);) {
			
			
			while (rows.next())
			{
				String doctorName = rows.getString("doctor_name") ;
				int doctorId = rows.getInt("doctor_id");
				String departmentName = rows.getString("department_name") ;
				LOGGER.debug(doctorId+"-"+doctorName+"-"+departmentName);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
		}
		return null;
	}

}
