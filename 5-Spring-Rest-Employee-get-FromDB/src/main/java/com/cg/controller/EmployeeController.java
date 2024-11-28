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

import com.cg.model.Employee;
import com.cg.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/emplist")
	public List<Employee> myEmpList(Employee e)
	{
		return employeeService.findAll(e);
	}
	
	@PostMapping("/emplist")
	public Employee listOfEmployee(@RequestBody Employee e)
	{
		return employeeService.listEmployee(e);
	}
	
	@GetMapping("/empbyid/{id}")
	public Optional<Employee> findMyEmpById( @PathVariable int id)
	{
		return employeeService.findEmpById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmpById(@PathVariable int id)
	{
		employeeService.deleteById(id);
		return "deleted";
	}
	
	@PutMapping("/update")
	public Employee updateEmp(@RequestBody Employee e)
	{
		return employeeService.update(e);
	}
}
