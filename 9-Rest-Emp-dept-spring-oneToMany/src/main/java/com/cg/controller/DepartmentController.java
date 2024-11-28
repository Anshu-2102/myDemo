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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Department;
import com.cg.service.IDepartmentService;

@RequestMapping("/dept")
@RestController
public class DepartmentController {
	
	@Autowired
	IDepartmentService departmentService;
	//@GetMapping(path="/products", produces = {MediaType.APPLICATION_XML_VALUE})
	@GetMapping("/deptlist")
	public List<Department> getDepartments()
	{
		return departmentService.findAll();
		
	}
	
	
	//http://localhost:9090/api/products/101
	@GetMapping("/depts/{id}")
	public Optional<Department>getDepartmentById(@PathVariable int id)
	{
		return departmentService.findDepartmentById(id);
	}
	

	
	//http://localhost:9090/api/products/myProduct?id=101 use when sending data through form
	@GetMapping("/depts/myDept")
	public Optional<Department>getDepartmentId(@RequestParam int id)
	{
		return departmentService.findDepartmentById(id);
	}
	
	
	
	@PostMapping("/depts1")
	public Department createmyDepartment(@RequestBody Department p)
	{
		return departmentService.createDepartment(p);
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public String myDelete(@PathVariable int id)
	{
		if(departmentService.deleteDepartment(id))
		{
			return "deleted";
		}else
		{
			return "not found";
		}
		
	}
	
	@PutMapping("/update")
	public Department myUpdate(@RequestBody Department p)
	{
		return departmentService.update(p);
		
	}
	

}