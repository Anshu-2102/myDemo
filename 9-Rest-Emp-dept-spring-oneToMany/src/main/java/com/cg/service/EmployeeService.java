package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Department;
import com.cg.entity.Employee;
import com.cg.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService{
	@Autowired
	EmployeeRepository employeeRepository;


	public List<Employee> findAll()
	{
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findEmployeeById(int empId) {
		// TODO Auto-generated method stub
		return  employeeRepository.findById(empId);
	}

	@Override
	public Employee createEmployee(Employee e) {
		// TODO Auto-generated method stub
		return  employeeRepository.save(e);
	}

	@Override
	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		try {
			employeeRepository.deleteById(id);
			System.out.println("deleted"+id);
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public Employee update(Employee e) {
		// TODO Auto-generated method stub
		return  employeeRepository.save(e);
	}
	
}
