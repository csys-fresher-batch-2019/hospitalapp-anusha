package com.hospital;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import com.hospital.manage.ConnectionUtil;
import com.hospital.manage.Logger;

public class Patients {

	private static final Logger LOGGER = Logger.getInstance();
	public String getpGender() {
		return pGender;
	}
	public void setpGender(String pGender) {
		this.pGender = pGender;
	}

	private int patientId;
	private String patientName;
	private int age;
	private String pGender;
	private String address;
	private String pPhoneNumber;
	private String patientPassword;
	private int activePatient;
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return pGender;
	}
	public void setGender(String gender) {
		this.pGender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getpPhoneNumber() {
		return pPhoneNumber;
	}
	public void setpPhoneNumber(String phoneNumber) {
		this.pPhoneNumber = phoneNumber;
	}
	public String getPatientPassword() {
		return patientPassword;
	}
	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}
	public int getActivePatient() {
		return activePatient;
	}
	public void setActivePatient(int activePatient) {
		this.activePatient = activePatient;
	}
	
	public boolean login(Patients user) {
		try(Connection con = ConnectionUtil.getconnection();
				CallableStatement stmt=con.prepareCall("{call patient_login(?,?,?)}")) {
		stmt.setString(1,user.getpPhoneNumber());
		stmt.setString(2, user.getPatientPassword());
		stmt.registerOutParameter(3, Types.VARCHAR);
		stmt.executeUpdate();
		String status=stmt.getString(3);
		LOGGER.info("Status = "+status);
		if(status.equals("Success")) {
		LOGGER.debug("Logged In");
		return true;
		}
		else {
		LOGGER.debug("Logged out");
		return false;
		}
		} catch (Exception e) {
		LOGGER.debug(e);
		}

		return false;
		}

	
}
