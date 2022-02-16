package com.cloud.file_management_system_backend.client.repository;

import com.cloud.file_management_system_backend.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByClientNameContaining(String clientName);

    List<Client> findByEmailContaining(String email);
}
