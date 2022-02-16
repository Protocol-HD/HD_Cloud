package com.cloud.file_management_system_backend.file.repository;

import com.cloud.file_management_system_backend.file.model.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDataRepository extends JpaRepository<FileData, Long> {
}
