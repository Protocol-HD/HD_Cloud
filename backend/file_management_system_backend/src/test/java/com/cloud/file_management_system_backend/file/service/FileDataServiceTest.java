package com.cloud.file_management_system_backend.file.service;

import com.cloud.file_management_system_backend.file.model.FileData;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FileDataServiceTest {
    @SpyBean
    private FileDataService fileDataService;

    @Test
    void saveTest() {
        fileDataService.saveFileData(
                FileData.builder()
                        .hashName("sfe876s6df567we8f7")
                        .fileName("test.exe")
                        .filePath("c:\\test\\sfe876s6df567we8f7")
                        .build()
        );
    }

    @Test
    void findTest() {
        FileData fileData = FileData.builder()
                .hashName("sfe876s6df567we8f7")
                .fileName("test.exe")
                .filePath("c:\\test\\sfe876s6df567we8f7")
                .build();
        assertEquals(fileDataService.findFileData(1L).getFilePath(), fileData.getFilePath());
        assertEquals(fileDataService.findFileData(1L).getFileName(), fileData.getFileName());
        assertEquals(fileDataService.findFileData(1L).getHashName(), fileData.getHashName());
    }

    @Test
    void findAllTest() {
        assertEquals(fileDataService.findAllFileData().size(), 1);
    }

    @Test
    void deleteTest() {
        assertEquals(fileDataService.findAllFileData().size(), 1);
        fileDataService.deleteFileData(1L);
        assertEquals(fileDataService.findAllFileData().size(), 0);
    }
}