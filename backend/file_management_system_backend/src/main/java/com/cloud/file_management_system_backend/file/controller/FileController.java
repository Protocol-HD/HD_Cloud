package com.cloud.file_management_system_backend.file.controller;

import com.cloud.file_management_system_backend.file.model.FileData;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface FileController {
    FileData upload(MultipartFile files);

    void download(HttpServletResponse response, Long id);

    List<FileData> findAllFileData();

    void deleteFileData(Long id);
}
