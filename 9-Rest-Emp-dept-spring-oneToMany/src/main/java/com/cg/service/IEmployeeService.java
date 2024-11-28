package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.entity.Employee;

public interface IEmployeeService {
	public List<Employee> findAll();
	public Optional<Employee> findEmployeeById(int empId);
	public Employee createEmployee(Employee e);
	public boolean deleteEmployee(int id);
	public Employee update(Employee e);
}
