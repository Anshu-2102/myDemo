package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.model.Employee;
import com.cg.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {


	@Autowired
	EmployeeRepository employeeRepository;
	@Override
	public List<Employee> findAll(Employee e) {
		return employeeRepository.findAll();
	}
	@Override
	public Employee listEmployee(Employee e) {
		// TODO Auto-generated method stub
		return employeeRepository.save(e);
	}
	
	public Optional<Employee> findEmpById(int id)
	{
		return employeeRepository.findById(id);
	}
	
	public boolean deleteById(int id)
	{
		try {
			employeeRepository.deleteById(id);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	@Override
	public Employee update(Employee e) {
		// TODO Auto-generated method stub
		return employeeRepository.save(e);
	}
}
