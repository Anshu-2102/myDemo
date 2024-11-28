package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.entity.Department;


public interface IDepartmentService {
	
	public List<Department> findAll();
	public Optional<Department> findDepartmentById(int deptId);
	public Department createDepartment(Department d);
	public boolean deleteDepartment(int id);
	public Department update(Department d);
}
 