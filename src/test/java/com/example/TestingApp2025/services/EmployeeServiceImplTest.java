package com.example.TestingApp2025.services;

import com.example.TestingApp2025.TestContainerConfig;
import com.example.TestingApp2025.dtos.EmployeeDto;
import com.example.TestingApp2025.entities.EmployeeEntity;
import com.example.TestingApp2025.repositories.EmployeeRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Import;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@Import(TestContainerConfig.class)
@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest
{
    @Mock
    private EmployeeRepo employeeRepo;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private EmployeeEntity mockEmployee;
    private EmployeeDto mockEmployeeDto;

    @BeforeEach
    void setUp()
    {
        mockEmployee=EmployeeEntity.builder()
                .id(1L)
                .email("Nishintgoyal001@gmail.com")
                .name("Nishint")
                .salary(10000000000L)
                .build();

        mockEmployeeDto=modelMapper.map(mockEmployee, EmployeeDto.class);

    }

    @Test
    void testGetEmployeeById_WhenEmployeeIdIsPresent_ThenReturnEmployeeDto()
    {
        //assign
        Long id=mockEmployee.getId();

        when(employeeRepo.findById(id)).thenReturn(Optional.of(mockEmployee));

        //act
        EmployeeDto employeeDto=employeeService.getEmployeeById(id);

        //assert
        assertThat(employeeDto.getId()).isEqualTo(id);
        assertThat(employeeDto.getEmail()).isEqualTo(mockEmployee.getEmail());

        //verify
        verify(employeeRepo,atLeast(1)).findById(id); //others method atleast ,only,etc
    }

    @Test
    void testCreateNewEmployee_WhenValidEmployee_ThenCreateNewEmployee()
    {
        //assign
        when(employeeRepo.save(any(EmployeeEntity.class))).thenReturn(mockEmployee);
        //act
        EmployeeDto employeeDto=employeeService.createEmployee(mockEmployeeDto);
        //assert
        assertThat(employeeDto).isNotNull();
        assertThat(employeeDto.getEmail()).isEqualTo(mockEmployeeDto.getEmail());
        //
        verify(employeeRepo).save(any(EmployeeEntity.class));
    }
}
