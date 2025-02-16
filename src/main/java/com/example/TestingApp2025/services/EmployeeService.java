package com.example.TestingApp2025.services;

import com.example.TestingApp2025.dtos.EmployeeDto;

import java.util.List;

public interface EmployeeService
{
    public EmployeeDto createEmployee(EmployeeDto employeeDto);


    public EmployeeDto getEmployeeById(Long id);

    public List<EmployeeDto> getAllEmployee();

    public EmployeeDto updateEmployee(Long id ,EmployeeDto employeeDto);

    public String deleteEmployee(Long id);

    public String deleteAllEmployee();

    public List<EmployeeDto> getByEmail(String email);
}
