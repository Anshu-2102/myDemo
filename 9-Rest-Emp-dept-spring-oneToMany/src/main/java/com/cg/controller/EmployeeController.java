package com.cg.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Employee;
import com.cg.service.IEmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	IEmployeeService employeeService;
	
	@GetMapping("/emplist")
	public List<Employee> getAllEmployee(Employee o)
	{
		return employeeService.findAll();
	}

	@GetMapping("/find/{id}")
	public Optional<Employee> findEmployeeById(@PathVariable int id)
	{
		return employeeService.findEmployeeById(id);
	}
	
	@PostMapping("/create")
	public Employee createEmployees(@RequestBody Employee o)
	{
		return employeeService.createEmployee(o);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id)
	{
		employeeService.deleteEmployee(id);
		return "deleted";
	}
	                     
    
	@PutMapping("/update")
	public Employee update(@RequestBody Employee o)
	{
		return employeeService.update(o);
	}
}
