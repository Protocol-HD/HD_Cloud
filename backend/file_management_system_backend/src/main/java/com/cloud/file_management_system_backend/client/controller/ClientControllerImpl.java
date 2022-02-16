package com.cloud.file_management_system_backend.client.controller;

import com.cloud.file_management_system_backend.client.model.Client;
import com.cloud.file_management_system_backend.client.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
public class ClientControllerImpl implements ClientController {
    private final ClientService clientService;

    @Override
    @PostMapping("/addClient")
    public Client addClient(@RequestBody Client client) {
        try {
            log.info("Client add controller: {}", client);
            return clientService.saveClient(client);
        } catch (Exception e) {
            log.error("Client add controller failure: {}", e.getMessage());
            return null;
        } finally {
            log.info("Client add controller end");
        }
    }

    @Override
    @PutMapping("/editClient")
    public Client editClient(@RequestBody Client client) {
        try {
            log.info("Client edit controller: {}", client);
            return clientService.saveClient(client);
        } catch (Exception e) {
            log.error("Client edit controller failure: {}", e.getMessage());
            return null;
        } finally {
            log.info("Client edit controller end");
        }
    }

    @Override
    @GetMapping("/findClient/{id}")
    public Client findClient(@PathVariable Long id) {
        try {
            log.info("Client find controller: Client id is {}", id);
            return clientService.findClient(id);
        } catch (Exception e) {
            log.error("Client find controller failure: {}", e.getMessage());
            return null;
        } finally {
            log.info("Client find controller end");
        }
    }

    @Override
    @GetMapping("/findAllClient")
    public List<Client> findAllClient() {
        try {
            log.info("Client find all controller");
            return clientService.findAllClient();
        } catch (Exception e) {
            log.error("Client find all controller failure: {}", e.getMessage());
            return null;
        } finally {
            log.info("Client find all controller end");
        }
    }

    @Override
    @DeleteMapping("/deleteClient/{id}")
    public void deleteClient(@PathVariable Long id) {
        try {
            log.info("Client delete controller: Client id is {}", id);
            clientService.deleteClient(id);
        } catch (Exception e) {
            log.error("Client delete controller failure: {}", e.getMessage());
        } finally {
            log.info("Client delete controller end");
        }
    }

    @Override
    @GetMapping("/searchClient/{keyword}")
    public List<Client> searchClient(@PathVariable String keyword) {
        try {
            log.info("Client search controller: Keyword is {}", keyword);
            return clientService.searchClient(keyword);
        } catch (Exception e) {
            log.error("Client search controller failure: {}", e.getMessage());
            return null;
        } finally {
            log.info("Client search controller end");
        }
    }
}
