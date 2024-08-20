package com.example.EmployeeDb.repository.elasticsearch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.example.EmployeeDb.models.Employee;
import com.example.EmployeeDb.repository.EmployeeRepository;

@Repository
public class ESEmployeeImplementation implements EmployeeRepository{
    
    @Autowired
    ESRepo esRepo;
    @Override
    public Employee findById(String id)
    {
        return esRepo.findAllById(id);
    }
    @Override
    public List<Employee> findByDesignation(String designation)
    {
        return esRepo.findByDesignation(designation);
    }
    @Override
    public List<Employee> findAllByManagerId(String managerId)
    {
        return esRepo.findAllByManagerId(managerId);
    }
    @Override
    public List<Employee> findAllByManagerIdAndYearOfExperienceGreaterThanEqual(String id, Long yearOfExperience)
    {
        return esRepo.findAllByManagerIdAndYearOfExperienceGreaterThanEqual(id,yearOfExperience);
    }
    @Override
    public List<Employee> findAllByDesignationAndDepartment(String string, String department){
        return esRepo.findAllByDesignationAndDepartment(string,department);
    }
    @Override
    public List<Employee> findAllByDepartment(String department){
        return esRepo.findAllByDepartment(department);
    }
    @Override
    public void deleteById(String id){
        esRepo.deleteById(id);
    }
    public void save(Employee e){
        esRepo.save(e);
    }
}
