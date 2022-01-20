package com.CodeBuffer.SpringBootTute1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CodeBuffer.SpringBootTute1.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>{

	public Department findByDepartmentName(String departmentName);
	
	public Department findByDepartmentNameIgnoreCase(String departmentName);
	
}
