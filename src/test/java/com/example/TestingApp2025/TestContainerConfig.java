package com.example.TestingApp2025;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

public class TestContainerConfig
{
    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgreSQLContainer()
    {
        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"));
    }

}
