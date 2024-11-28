package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Department;
import com.cg.entity.Employee;
import com.cg.repository.DepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public List<Department> findAll(){
		return departmentRepository.findAll();
	}
	@Override
	public Optional<Department> findDepartmentById(int deptId) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(deptId);
	}
	@Override
	public Department createDepartment(Department d) {
		// TODO Auto-generated method stub
		return departmentRepository.save(d);
	}
	@Override
	public boolean deleteDepartment(int id) {
		// TODO Auto-generated method stub
		try {
			departmentRepository.deleteById(id);
			System.out.println("deleted"+id);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	@Override
	public Department update(Department d) {
		// TODO Auto-generated method stub
		return departmentRepository.save(d);
	}
	
}
