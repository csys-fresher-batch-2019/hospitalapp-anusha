package com.hospital.dao;

import java.sql.SQLException;
import java.util.List;

import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.hospital.Departments;

public interface DepartmentsDAO {
	
	//insert
	@SqlUpdate("insert into departments (department_id,department_name)values (department_id_sq.nextval,?)")
	void addDepartment(Departments dept) throws ClassNotFoundException, SQLException;
	
	//select
	@SqlUpdate("select department_id,department_name from departments")
	List<Departments> displayDepartments() throws ClassNotFoundException, SQLException;
	
	//update
	@SqlUpdate("Update departments set active_departments = ? where department_id = ?")
	void updateDepartment(int active, int departmentID ) throws ClassNotFoundException, SQLException;

	@SqlUpdate("select department_id,department_name from departments")
	List<Departments> adminDisplayDepartments() throws ClassNotFoundException, SQLException;
}
