package com.harshEM.EM.project.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.harshEM.EM.project.Employee;
import com.harshEM.EM.project.EmployeeEntity;
import com.harshEM.EM.project.repository.EmployeeRepository;


@Service
public class EmployeeServiceIMP implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    // List<Employee> employees = new ArrayList<>();

    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);

        employeeRepository.save(employeeEntity);
        // employees.add(employee);
        return "Data saved successfully";
    }

    @Override
    public Employee readEmployee(int id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);

        return employee;
    }

    
    @Override
    public List<Employee> readEmployees() {
        List<EmployeeEntity> employeesList = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeesList) {
            Employee emp = new Employee();
            emp.setName(employeeEntity.getName());
            emp.setEmail(employeeEntity.getEmail());
            emp.setId(employeeEntity.getId());
            emp.setPhone(employeeEntity.getPhone());
            employees.add(emp);
        }
        return employees;
    }
    
    @Override
    public boolean deleteEmployee(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;   
    }


    @Override
    public String updateEmployee(int id, Employee employee) {
        EmployeeEntity existingEmployee = employeeRepository.findById(id).get();

        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhone(employee.getPhone());
        existingEmployee.setName(employee.getName());
        
        employeeRepository.save(existingEmployee);
        return "Data Updated Successfully";
    }


    
}
