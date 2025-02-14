package com.example.TestingApp2025.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeDto
{
    private Long id;

    private String email;

    private String name;

    private Long salary;
}
