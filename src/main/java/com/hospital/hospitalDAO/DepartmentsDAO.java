package com.hospital.hospitalDAO;

import java.sql.SQLException;
import java.util.List;

import com.hospital.Departments;

public interface DepartmentsDAO {
	
	//insert
	void addDepartment(Departments dept) throws ClassNotFoundException, SQLException;
	
	//select
	List<Departments> displayDepartments() throws Exception;
	
	//update
	void updateDepartment(int active, int departmentID ) throws ClassNotFoundException, SQLException;

}
