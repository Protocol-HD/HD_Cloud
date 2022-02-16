package com.cloud.file_management_system_backend.file.service;

import com.cloud.file_management_system_backend.file.model.FileData;
import com.cloud.file_management_system_backend.file.repository.FileDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileDataServiceImpl implements FileDataService {
    private final FileDataRepository fileDataRepository;

    @Override
    public FileData saveFileData(FileData fileData) {
        try {
            log.info("FileData save service: {}", fileData);
            return fileDataRepository.save(fileData);
        } catch (Exception e) {
            log.error("FileData save service failure: {}", e.getMessage());
            return null;
        } finally {
            log.info("FileData save service end");
        }
    }

    @Override
    public FileData findFileData(Long id) {
        try {
            log.info("FileData find service: FileData id is {}", id);
            return fileDataRepository.findById(id).get();
        } catch (Exception e) {
            log.error("FileData find service failure: {}", e.getMessage());
            return null;
        } finally {
            log.info("FileData find service end");
        }
    }

    @Override
    public List<FileData> findAllFileData() {
        try {
            log.info("FileData find all service");
            return fileDataRepository.findAll();
        } catch (Exception e) {
            log.error("FileData find all service failure: {}", e.getMessage());
            return null;
        } finally {
            log.info("FileData find all service end");
        }
    }

    @Override
    public void deleteFileData(Long id) {
        try {
            log.info("FileData delete service: FileData id is {}", id);
            fileDataRepository.deleteById(id);
        } catch (Exception e) {
            log.error("FileData delete service failure: {}", e.getMessage());
        } finally {
            log.info("FileData delete service end");
        }
    }
}
