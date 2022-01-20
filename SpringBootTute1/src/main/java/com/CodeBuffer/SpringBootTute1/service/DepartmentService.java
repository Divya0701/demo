package com.CodeBuffer.SpringBootTute1.service;

import java.util.List;

import com.CodeBuffer.SpringBootTute1.entity.Department;
import com.CodeBuffer.SpringBootTute1.error.DepartmentNotFoundException;

public interface DepartmentService {

	Department saveDepartment(Department department);

	List<Department> fetchDepartmentList();

	Department fetchDepartById(Long departmentId) throws DepartmentNotFoundException;

	void deleteDepartmentById(Long departmentId);

	Department updateDepartment(Long departmentId, Department department);

	Department fetchDepartmentByName(String departmentName);


}
