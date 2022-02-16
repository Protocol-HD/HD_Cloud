package com.cloud.file_management_system_backend.client.service;

import com.cloud.file_management_system_backend.client.model.Client;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ClientServiceTest {
    @SpyBean
    private ClientService clientService;

    @Test
    void saveTest() {
        clientService.saveClient(
                Client.builder()
                        .email("test@test.com")
                        .gender('M')
                        .birthYear(2000)
                        .clientName("tester")
                        .build()
        );
    }

    @Test
    void findTest() {
        Client client = Client.builder()
                .email("test@test.com")
                .gender('M')
                .birthYear(2000)
                .clientName("tester")
                .build();
        assertEquals(clientService.findClient(1L).getClientName(), client.getClientName());
        assertEquals(clientService.findClient(1L).getGender(), client.getGender());
        assertEquals(clientService.findClient(1L).getEmail(), client.getEmail());
        assertEquals(clientService.findClient(1L).getBirthYear(), client.getBirthYear());
    }

    @Test
    void findAllTest() {
        assertEquals(clientService.findAllClient().size(), 4);
    }

    @Test
    void deleteTest() {
        assertEquals(clientService.findAllClient().size(), 4);
        clientService.deleteClient(1L);
        assertEquals(clientService.findAllClient().size(), 3);

    }

    @Test
    void searchTest() {
        Client client1 = Client.builder()
                .email("user@test.com")
                .gender('M')
                .birthYear(2000)
                .clientName("user")
                .build();
        clientService.saveClient(client1);
        Client client2 = Client.builder()
                .email("user@test.com")
                .gender('M')
                .birthYear(2000)
                .clientName("admin")
                .build();
        clientService.saveClient(client2);
        Client client3 = Client.builder()
                .email("good@test.com")
                .gender('M')
                .birthYear(2000)
                .clientName("good")
                .build();
        clientService.saveClient(client3);


        assertEquals(clientService.searchClient("admin").size(), 1);
        assertEquals(clientService.searchClient("user@test.com").size(), 2);
    }
}