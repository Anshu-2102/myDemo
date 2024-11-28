package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.model.Employee;

public interface IEmployeeService {
	
	public List<Employee> findAll(Employee e);
	
	public Employee listEmployee(Employee e);
	
	public Optional<Employee> findEmpById(int id);
	
	public boolean deleteById(int id);
	
	public Employee update(Employee e);
}
 