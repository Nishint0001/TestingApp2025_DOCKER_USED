package com.example.TestingApp2025.services;

import com.example.TestingApp2025.dtos.EmployeeDto;
import com.example.TestingApp2025.entities.EmployeeEntity;
import com.example.TestingApp2025.repositories.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService
{
    private final EmployeeRepo employeeRepo;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepo employeeRepo, ModelMapper modelMapper)
    {
        this.employeeRepo = employeeRepo;
        this.modelMapper = modelMapper;
    }

    //CRUD OPERATION PERFORM

    //CREATE

    public EmployeeDto createEmployee(EmployeeDto employeeDto)
    {
        EmployeeEntity employeeEntity=modelMapper.map(employeeDto, EmployeeEntity.class);

        EmployeeEntity savedEntity=employeeRepo.save(employeeEntity);

        EmployeeDto employeeDto1=modelMapper.map(savedEntity, EmployeeDto.class);

        return employeeDto1;
    }

    //READ
    //GET + GET ALL

    public EmployeeDto getEmployeeById(Long id)
    {
        EmployeeEntity employeeEntity=employeeRepo.findById(id).orElse(null);

        EmployeeDto convertToDTO=modelMapper.map(employeeEntity, EmployeeDto.class);

        return convertToDTO;
    }

    public List<EmployeeDto> getAllEmployee()
    {
        List<EmployeeEntity> employeeEntityList=employeeRepo.findAll();

        List<EmployeeDto> employeeDtoList=employeeEntityList.stream()
                .map(record->modelMapper.map(record, EmployeeDto.class)).toList();

        return employeeDtoList;
    }

    //UPDATE

    public EmployeeDto updateEmployee(Long id ,EmployeeDto employeeDto)
    {
        EmployeeEntity employeeEntity=employeeRepo.findById(id).orElse(null);

        modelMapper.map(employeeDto, employeeEntity);

        EmployeeEntity savedEntity=employeeRepo.save(employeeEntity);

        EmployeeDto employeeDto1=modelMapper.map(savedEntity, EmployeeDto.class);

        return employeeDto1;
    }

    //Delete

    public String deleteEmployee(Long id)
    {
        employeeRepo.deleteById(id);

        return "SuccessFully Deleted the employee with "+id+" ";
    }

    //DeleteALl

    public String deleteAllEmployee()
    {
        employeeRepo.deleteAll();

        return "SuccessFully Deleted All The Employee in the DataBase";
    }


    //GetByEmail

    public List<EmployeeDto> getByEmail(String email)
    {
        List<EmployeeEntity> employeeEntityList=employeeRepo.findByEmail(email);

        List<EmployeeDto> employeeDtoList=employeeEntityList.stream()
                .map(record->modelMapper.map(record, EmployeeDto.class)).toList();

        return employeeDtoList;
    }

}
