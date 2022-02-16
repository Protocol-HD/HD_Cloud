package com.cloud.file_management_system_backend.client.repository;

import com.cloud.file_management_system_backend.client.model.Client;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ClientRepositoryTest {
    @SpyBean
    private ClientRepository clientRepository;

    @Test
    void saveTest() {
        clientRepository.save(Client.builder()
                .email("test@test.com")
                .gender('M')
                .birthYear(2000)
                .clientName("tester")
                .build());
    }

    @Test
    void findTest() {
        Client client = Client.builder()
                .email("test@test.com")
                .gender('M')
                .birthYear(2000)
                .clientName("tester")
                .build();
        assertEquals(clientRepository.findById(1L).get().getClientName(), client.getClientName());
        assertEquals(clientRepository.findById(1L).get().getGender(), client.getGender());
        assertEquals(clientRepository.findById(1L).get().getEmail(), client.getEmail());
        assertEquals(clientRepository.findById(1L).get().getBirthYear(), client.getBirthYear());
    }

    @Test
    void findAllTest() {
        assertEquals(clientRepository.findAll().size(), 4);
    }

    @Test
    void deleteTest() {
        assertEquals(clientRepository.findAll().size(), 4);
        clientRepository.deleteById(1L);
        assertEquals(clientRepository.findAll().size(), 3);
    }

    @Test
    void searchTest() {
        Client client1 = Client.builder()
                .email("test@test.com")
                .gender('M')
                .birthYear(2000)
                .clientName("tester")
                .build();
        clientRepository.save(client1);
        Client client2 = Client.builder()
                .email("admin@test.com")
                .gender('M')
                .birthYear(2000)
                .clientName("admin")
                .build();
        clientRepository.save(client2);
        Client client3 = Client.builder()
                .email("good@test.com")
                .gender('M')
                .birthYear(2000)
                .clientName("admin")
                .build();
        clientRepository.save(client3);

        assertEquals(clientRepository.findByClientNameContaining("admin").size(), 2);
        assertEquals(clientRepository.findByEmailContaining("good@test.com").size(), 1);
    }
}