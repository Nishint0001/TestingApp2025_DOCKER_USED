package com.example.TestingApp2025.controllers;

import com.example.TestingApp2025.dtos.EmployeeDto;
import com.example.TestingApp2025.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController
{
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    //Create
    @PostMapping
    public EmployeeDto createEmployeeById(@RequestBody EmployeeDto employeeDto)
    {
        return employeeService.createEmployee(employeeDto);
    }

    //READ

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Long id)
    {
    return employeeService.getEmployeeById(id);
    }

    @GetMapping("/all")
    public List<EmployeeDto> getAllEmployee()
    {
        return employeeService.getAllEmployee();
    }

    //Update
    @PutMapping
    public EmployeeDto updateEmployeeById(@PathVariable Long id,@RequestBody EmployeeDto employeeDto)
    {
    return employeeService.updateEmployee(id,employeeDto);
    }

    //Delete
    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable Long id)
    {
        return employeeService.deleteEmployee(id);
    }
    //Delete all
    public String deleteAll()
    {
        return employeeService.deleteAllEmployee();
    }

}
