package com.cloud.file_management_system_backend.client.service;

import com.cloud.file_management_system_backend.client.model.Client;
import com.cloud.file_management_system_backend.client.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public Client saveClient(Client client) {
        try {
            log.info("Client save service: {}", client);
            return clientRepository.save(client);
        } catch (Exception e) {
            log.error("Client save service failure: {}", e.getMessage());
            return null;
        } finally {
            log.info("Client save service end");
        }
    }

    @Override
    public Client findClient(Long id) {
        try {
            log.info("Client find service: Client id is {}", id);
            return clientRepository.findById(id).get();
        } catch (Exception e) {
            log.error("Client find service failure: {}", e.getMessage());
            return null;
        } finally {
            log.info("Client find service end");
        }
    }

    @Override
    public List<Client> findAllClient() {
        try {
            log.info("Client find all service");
            return clientRepository.findAll();
        } catch (Exception e) {
            log.error("Client find all service failure: {}", e.getMessage());
            return null;
        } finally {
            log.info("Client find all service end");
        }
    }

    @Override
    public void deleteClient(Long id) {
        try {
            log.info("Client delete service: Client id is {}", id);
            clientRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Client delete service failure: {}", e.getMessage());
        } finally {
            log.info("Client delete service end");
        }
    }

    @Override
    public List<Client> searchClient(String keyword) {
        try {
            log.info("Client search service: Keyword is {}", keyword);
            log.info("Search in client name");
            List<Client> clients = new ArrayList<>(clientRepository.findByClientNameContaining(keyword));

            log.info("Search in client email");
            clientRepository.findByEmailContaining(keyword).forEach(client -> {
                if (!clients.contains(client)) clients.add(client);
            });

            return clients;
        } catch (Exception e) {
            log.error("Client search service failure: {}", e.getMessage());
            return null;
        } finally {
            log.info("Client search service end");
        }
    }
}
