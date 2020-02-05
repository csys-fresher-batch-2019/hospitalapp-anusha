package com.hospital.DAO;

import java.sql.SQLException;
import java.util.List;

import com.hospital.Departments;

public interface DepartmentsDAO {
	
	//insert
	void addDepartment(Departments dept);
	
	//select
	List<Departments> displayDepartments() throws Exception;
	
	//update
	void updateDepartment(int active, int departmentID ) throws ClassNotFoundException, SQLException;
	
	//delete
	//void deleteDepartment(int DepartmentID) throws SQLException, ClassNotFoundException;

}
