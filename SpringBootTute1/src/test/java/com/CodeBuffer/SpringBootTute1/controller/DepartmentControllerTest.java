package com.CodeBuffer.SpringBootTute1.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.CodeBuffer.SpringBootTute1.entity.Department;
import com.CodeBuffer.SpringBootTute1.error.DepartmentNotFoundException;
import com.CodeBuffer.SpringBootTute1.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
	
	@Autowired
	private MockMvc mocMvc;
	
	@MockBean
	private DepartmentService departmentService;

	private Department department;
	
	@BeforeEach
	void setUp(){
		
		department = Department.builder()
				.departmentAddress("AMD")
				.departmentCode("1BD")
				.departmentName("IT")
				.deptartmentId(1L)
				.build();
		
	}

	@Test
	void saveDepartment() throws Exception {
		Department InputDepartment = Department.builder()
				.departmentAddress("AMD")
				.departmentCode("1BD")
				.departmentName("IT")
				.build();
		Mockito.when(departmentService.saveDepartment(InputDepartment)).thenReturn(department);
		
		mocMvc.perform(post("/departments")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "    \"departmentName\":\"IT\",\r\n"
						+ "    \"departmentAddress\":\"AMD\",\r\n"
						+ "    \"departmentCode\":\"1BD\"\r\n"
						+ "\r\n"
						+ "}")).andExpect(status().isOk());
	}
	
	@Test
	void fetchDepartmentById() throws Exception {
		Mockito.when(departmentService.fetchDepartById(1L)).thenReturn(department);
		mocMvc.perform(get("/departments/1")
				.contentType(MediaType.APPLICATION_JSON))
		         .andExpect(status().isOk())
		         .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
		
	}

}
