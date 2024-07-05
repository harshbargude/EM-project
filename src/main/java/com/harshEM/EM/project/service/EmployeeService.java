package com.harshEM.EM.project.service;

import java.util.List;

import com.harshEM.EM.project.Employee;


public interface EmployeeService {

    String createEmployee(Employee employee);
    List<Employee> readEmployees();//List<Employee> readEmployees();
    boolean deleteEmployee(int id);
    String updateEmployee(int id, Employee employee);
    Employee readEmployee(int id);

}
