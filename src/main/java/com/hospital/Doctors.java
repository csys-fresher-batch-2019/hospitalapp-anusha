package com.hospital;

public class Doctors {

	private int doctorId;
	private String doctorName;
	private int departmentId;
	private String doctorPassword;
	private int active=1;
	private int doctorPresent=0;
	private String dGender;
	private String dPhoneNumber;
	private int noOfAppointment;
	public String getdPhoneNumber() {
		return dPhoneNumber;
	}
	public void setdPhoneNumber(String dPhoneNumber) {
		this.dPhoneNumber = dPhoneNumber;
	}
	public int getDoctorPresent() {
		return doctorPresent;
	}
	public void setDoctorPresent(int doctorPresent) {
		this.doctorPresent = doctorPresent;
	}
	public String getdGender() {
		return dGender;
	}
	public void setdGender(String dGender) {
		this.dGender = dGender;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getDoctorPassword() {
		return doctorPassword;
	}
	public void setDoctorPassword(String doctorPassword) {
		this.doctorPassword = doctorPassword;
	}
	public int getNoOfAppointment() {
		return noOfAppointment;
	}
	public void setNoOfAppointment(int noOfAppointment) {
		this.noOfAppointment = noOfAppointment;
	}
	
}
