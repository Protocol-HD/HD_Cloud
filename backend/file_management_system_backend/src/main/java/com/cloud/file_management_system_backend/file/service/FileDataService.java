package com.cloud.file_management_system_backend.file.service;

import com.cloud.file_management_system_backend.file.model.FileData;

import java.util.List;

public interface FileDataService {
    FileData saveFileData(FileData fileData);

    FileData findFileData(Long id);

    List<FileData> findAllFileData();

    void deleteFileData(Long id);
}
