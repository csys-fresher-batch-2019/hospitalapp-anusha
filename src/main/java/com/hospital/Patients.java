package com.hospital;

public class Patients {

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
	public String getPhoneNumber() {
		return pPhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
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
	
}
