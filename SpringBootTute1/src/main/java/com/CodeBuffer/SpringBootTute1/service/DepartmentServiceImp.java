package com.CodeBuffer.SpringBootTute1.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CodeBuffer.SpringBootTute1.entity.Department;
import com.CodeBuffer.SpringBootTute1.error.DepartmentNotFoundException;
import com.CodeBuffer.SpringBootTute1.repository.DepartmentRepository;

@Service
public class DepartmentServiceImp implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentrepository;
	@Override
	
	public Department saveDepartment(Department department) {
		return departmentrepository.save(department);
	}
	
	@Override
	public List<Department> fetchDepartmentList() {
		return departmentrepository.findAll();
	}

	@Override
	public Department fetchDepartById(Long departmentId) throws DepartmentNotFoundException {
		Optional<Department> department = departmentrepository.findById(departmentId);
		if(!department.isPresent()) {
			throw new DepartmentNotFoundException("Department not available");
		}
		
		return department.get();
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		 departmentrepository.deleteById(departmentId);
	}

	@Override
	public Department updateDepartment(Long departmentId, Department department) {
		Department depDB = departmentrepository.findById(departmentId).get();
	
		if(Objects.nonNull(department.getDepartmentName())&&! "".equalsIgnoreCase(department.getDepartmentName())) {
			depDB.setDepartmentName(department.getDepartmentName());
		}
		
		if(Objects.nonNull(department.getDepartmentCode())&&! "".equalsIgnoreCase(department.getDepartmentCode())) {
			depDB.setDepartmentCode(department.getDepartmentCode());
		}
		
		if(Objects.nonNull(department.getDepartmentAddress())&& !"".equalsIgnoreCase(department.getDepartmentAddress())) {
			depDB.setDepartmentAddress(department.getDepartmentAddress());
		}
		return departmentrepository.save(depDB);
	}

	@Override
	public Department fetchDepartmentByName(String departmentName) {
		return departmentrepository.findByDepartmentNameIgnoreCase(departmentName);
	}


}
