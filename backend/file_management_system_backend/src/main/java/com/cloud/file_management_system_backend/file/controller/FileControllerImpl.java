package com.cloud.file_management_system_backend.file.controller;

import com.cloud.file_management_system_backend.file.model.FileData;
import com.cloud.file_management_system_backend.file.service.FileDataService;
import com.cloud.file_management_system_backend.util.MD5Generator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
@Slf4j
@RequiredArgsConstructor
public class FileControllerImpl implements FileController {
    private final FileDataService fileDataService;
        private static final String UPLOAD_PATH = "/root/";
//    private static final String UPLOAD_PATH = "d:\\HD\\test\\";

    @Override
    @GetMapping("/findAllFileData")
    public List<FileData> findAllFileData() {
        try {
            log.info("FileData find all controller");
            return fileDataService.findAllFileData();
        } catch (Exception e) {
            log.error("FileData find all controller failure: {}", e.getMessage());
            return null;
        } finally {
            log.info("FileData find all controller end");
        }
    }

    @Override
    @DeleteMapping("/deleteFileData/{id}")
    public void deleteFileData(@PathVariable Long id) {
        try {
            fileDataService.deleteFileData(id);
            log.info("FileData delete controller: FileData id is {}", id);
        } catch (Exception e) {
            log.error("FileData delete controller failure: {}", e.getMessage());
        } finally {
            log.info("FileData delete controller end");
        }
    }

    @Override
    @PostMapping("/upload")
    public FileData upload(@RequestParam("file") MultipartFile files) {
        log.info("FileData upload controller start");
        try {
            log.info("create salt");
            double salt = Math.random();
            log.info("get file name");
            String name = files.getOriginalFilename();
            log.info("hasing file name");
            String hash = new MD5Generator(files.getOriginalFilename() + salt).toString();
            String path = UPLOAD_PATH + hash;
            log.info("FileData transfer to: {}", UPLOAD_PATH + hash);
            files.transferTo(new File(UPLOAD_PATH + hash));
            log.info("FileData save controller: {}, {}, {}", name, path, hash);
            return fileDataService.saveFileData(FileData.builder()
                    .filePath(path)
                    .fileName(name)
                    .hashName(hash)
                    .build());
        } catch (Exception e) {
            log.error("FileData upload controller failure: {}", e.getMessage());
            return null;
        } finally {
            log.info("FileData upload controller end");
        }
    }

    @Override
    @GetMapping("/download/{id}")
    public void download(HttpServletResponse response, @PathVariable Long id) {
        log.info("FileData download controller start");
        try {
            log.info("Get file path");
            String path = fileDataService.findFileData(id).getFilePath();
            log.info("Get file name");
            String name = fileDataService.findFileData(id).getFileName();

            log.info("FileData: path-{}, name-{}", path, name);

            try {
                log.info("FileData name encoding for chrome");
                name = new String(name.getBytes("UTF-8"), "ISO-8859-1");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            log.info("Set http header");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + name + "\";");
            response.setHeader("Content-Transfer-Encoding", "binary");
            response.setHeader("Pragma", "no-cache;");
            response.setHeader("Expires", "-1;");

            log.info("FileData download: {}", path);
            try (
                    FileInputStream fis = new FileInputStream(path);
                    OutputStream out = response.getOutputStream();
            ) {
                int readCount = 0;
                byte[] buffer = new byte[1024];
                while ((readCount = fis.read(buffer)) != -1) {
                    out.write(buffer, 0, readCount);
                }
            } catch (Exception e) {
                throw new RuntimeException("FileData download failure");
            }
        } catch (Exception e) {
            log.error("FileData download controller failure: {}", e.getMessage());
        } finally {
            log.info("FileData download controller end");
        }
    }
}
