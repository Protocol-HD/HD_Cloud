package com.cloud.file_management_system_backend.file.repository;

import com.cloud.file_management_system_backend.file.model.FileData;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class FileDataRepositoryTest {
    @SpyBean
    private FileDataRepository fileDataRepository;

    @Test
    void saveTest() {
        fileDataRepository.save(
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

        assertEquals(fileDataRepository.findById(1L).get().getFileName(), fileData.getFileName());
        assertEquals(fileDataRepository.findById(1L).get().getHashName(), fileData.getHashName());
        assertEquals(fileDataRepository.findById(1L).get().getFilePath(), fileData.getFilePath());
    }

    @Test
    void findAllTest() {
        assertEquals(fileDataRepository.findAll().size(), 1);
    }

    @Test
    void deleteTest() {
        assertEquals(fileDataRepository.findAll().size(), 1);
        fileDataRepository.deleteById(1L);
        assertEquals(fileDataRepository.findAll().size(), 0);
    }
}