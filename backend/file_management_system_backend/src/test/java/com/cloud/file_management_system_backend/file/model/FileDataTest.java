package com.cloud.file_management_system_backend.file.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileDataTest {
    @Test
    void name() {
        FileData fileData = FileData.builder()
                .hashName("sfe876s6df567we8f7")
                .fileName("test.exe")
                .filePath("c:\\test\\sfe876s6df567we8f7")
                .id(55L)
                .build();

        assertEquals(fileData.getHashName(), "sfe876s6df567we8f7");
        assertEquals(fileData.getFileName(), "test.exe");
        assertEquals(fileData.getFilePath(), "c:\\test\\sfe876s6df567we8f7");
        assertEquals(fileData.getId(), 55L);
    }
}