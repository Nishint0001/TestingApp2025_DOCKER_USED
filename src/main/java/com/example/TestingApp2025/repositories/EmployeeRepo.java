package com.example.TestingApp2025.repositories;

import com.example.TestingApp2025.dtos.EmployeeDto;
import com.example.TestingApp2025.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity,Long>
{
    List<EmployeeEntity> findByEmail(String email);

}
