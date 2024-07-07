package com.harshEM.EM.project.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import com.harshEM.EM.project.Employee;
import com.harshEM.EM.project.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@CrossOrigin
@RestController
public class EMcontroller {

	// EmployeeService employeeService = new EmployeeServiceIMP();
	//Dependency Injection
	@Autowired
	private EmployeeService employeeService;

	
	@GetMapping("employees")
	public List<Employee> getAllEmployees(){
		return employeeService.readEmployees();
	}

	@GetMapping("employees/{id}")
	public Employee getAllEmployeesById(@PathVariable int id){
		return employeeService.readEmployee(id);
	}

	@PostMapping("employees")
	public String CreateEmployee(@RequestBody Employee employee) {
		// employees.add(employee1);
		return employeeService.createEmployee(employee);
	}

	@PutMapping("employees/{id}")
	public String updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		return employeeService.updateEmployee(id,employee);
	}
	

	@DeleteMapping("employees/{id}")
	public String deleteEmployee(@PathVariable int id){
		if(employeeService.deleteEmployee(id)){
			return "Delete Successfully";
		}
		return "Not Found";
	}
	
	
}
