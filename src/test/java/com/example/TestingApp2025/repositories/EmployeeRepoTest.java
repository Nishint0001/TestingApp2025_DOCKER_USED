package com.example.TestingApp2025.repositories;

import com.example.TestingApp2025.TestContainerConfig;
import com.example.TestingApp2025.entities.EmployeeEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
@Import(TestContainerConfig.class)
@DataJpaTest //yeh puri file ko load nii karta kevel important wali ko and h2 database dependency ko khudh inbuilt karlenga.
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)

class EmployeeRepoTest
{
    @Autowired
    private EmployeeRepo employeeRepo;

    private EmployeeEntity employeeEntity;

    @BeforeEach
    void setUp() {
        employeeEntity= EmployeeEntity.builder()
                .name("Nishint")
                .email("Nishintgoyal001@gmail.com")
                .salary(100000000000L)
                .build();
    }

    @Test
    void testFindByEmail_whenEmailIsValid_thenReturnEmployee()
    {
        //        Arrange, Given
        employeeRepo.save(employeeEntity);

//        Act, When
        List<EmployeeEntity> employeeList = employeeRepo.findByEmail(employeeEntity.getEmail());

//        Assert, Then

        assertThat(employeeList).isNotNull();
        assertThat(employeeList).isNotEmpty();
        assertThat(employeeList.get(0).getEmail()).isEqualTo(employeeEntity.getEmail());

    }

    @Test
    void testFindByEmail_whenEmailIsNotFound_thenReturnEmptyEmployeeList()
    {
        // Given
        String email = "notPresent.123@gmail.com";
//        When
        List<EmployeeEntity> employeeList = employeeRepo.findByEmail(email);
//        Then
        assertThat(employeeList).isNotNull();
        assertThat(employeeList).isEmpty();
    }
}