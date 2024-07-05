package com.harshEM.EM.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harshEM.EM.project.EmployeeEntity;



@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{

    
    
}
