package com.cloud.file_management_system_backend.client.service;

import com.cloud.file_management_system_backend.client.model.Client;

import java.util.List;

public interface ClientService {
    Client saveClient(Client client);

    Client findClient(Long id);

    List<Client> findAllClient();

    void deleteClient(Long id);

    List<Client> searchClient(String keyword);
}
