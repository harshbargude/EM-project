package com.harshEM.EM.project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	private int id;
	private String name;
	private String phone;
	private String email;
	

	// No getter setter required if we use @Data
	
}
