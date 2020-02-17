package com.hospital.dao;

import java.sql.SQLException;
import java.util.List;

import com.hospital.Departments;

public interface DepartmentsDAO {
	
	//insert
	void addDepartment(Departments dept) throws ClassNotFoundException, SQLException;
	
	//select
	List<Departments> displayDepartments() throws ClassNotFoundException, SQLException;
	
	//update
	void updateDepartment(int active, int departmentID ) throws ClassNotFoundException, SQLException;

	//admin view
	public List<Departments> adminDisplayDepartments() throws ClassNotFoundException, SQLException ;

}
