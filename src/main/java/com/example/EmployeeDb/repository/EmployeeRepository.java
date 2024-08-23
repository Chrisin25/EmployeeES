package com.example.EmployeeDb.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeDb.models.Employee;
@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee,String>{
    
    public Employee findAllById(String id);
    
    public List<Employee> findByDesignation(String designation);

    public List<Employee> findAllByManagerId(String managerId);
    
    public List<Employee> findAllByManagerIdAndYearOfExperienceGreaterThanEqual(String id, Long yearOfExperience);

    public List<Employee> findAllByDesignationAndDepartment(String string, String department);

    public List<Employee> findAllByDepartment(String department);

    
}
