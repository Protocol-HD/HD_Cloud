package com.cloud.file_management_system_backend.client.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientTest {
    @Test
    void createTest() {
        Client client = Client.builder()
                .clientName("tester")
                .birthYear(1990)
                .gender('M')
                .email("test@test.com")
                .id(1001L)
                .build();

        assertEquals(client.getClientName(), "tester");
        assertEquals(client.getBirthYear(), 1990);
        assertEquals(client.getGender(), 'M');
        assertEquals(client.getEmail(), "test@test.com");
        assertEquals(client.getId(), 1001L) ;
    }
}