package com.CodeBuffer.SpringBootTute1.entity;
//hello wrold
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long deptartmentId;
	
	@NotBlank(message="Please Add Department Name")
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
	
	

}
