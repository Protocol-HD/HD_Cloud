package com.cloud.file_management_system_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FileManagementSystemBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileManagementSystemBackendApplication.class, args);
    }

}
