package com.example.EmployeeDb.repository.elasticsearch;
import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.EmployeeDb.models.Employee;

public interface ESRepo extends ElasticsearchRepository<Employee,String>{
    
    public Employee findAllById(String id);
    
    public List<Employee> findByDesignation(String designation);

    public List<Employee> findAllByManagerId(String managerId);
    
    public List<Employee> findAllByManagerIdAndYearOfExperienceGreaterThanEqual(String id, Long yearOfExperience);

    public List<Employee> findAllByDesignationAndDepartment(String string, String department);

    public List<Employee> findAllByDepartment(String department);

    public void deleteById(String id);

    public <S extends Employee> S save(S entity);
}
