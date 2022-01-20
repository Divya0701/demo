package com.CodeBuffer.SpringBootTute1.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CodeBuffer.SpringBootTute1.entity.Department;
import com.CodeBuffer.SpringBootTute1.error.DepartmentNotFoundException;
import com.CodeBuffer.SpringBootTute1.service.DepartmentService;

@RestController
@RequestMapping("/api")
public class DepartmentController {
	
	@Autowired
	 private DepartmentService departmentservice;
	
	 private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		LOGGER.info("Inside  saveDepartment of DepartmentController");
		return departmentservice.saveDepartment(department);
	}

	@GetMapping("/departments")
	public List<Department> fetchDepartmentList(){
		LOGGER.info("Inside  fetchDepartment of DepartmentController");
		return departmentservice.fetchDepartmentList();
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId)  throws DepartmentNotFoundException{
		return departmentservice.fetchDepartById(departmentId);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		departmentservice.deleteDepartmentById(departmentId);
		return "Department deleted successfully";
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department) {
		return departmentservice.updateDepartment(departmentId,department);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
		return departmentservice.fetchDepartmentByName(departmentName);
	}
	
}
