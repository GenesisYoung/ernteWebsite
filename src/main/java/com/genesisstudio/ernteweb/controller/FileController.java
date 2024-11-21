package com.genesisstudio.ernteweb.controller;

import com.genesisstudio.ernteweb.domain.File;
import com.genesisstudio.ernteweb.service.FileService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;

    @GetMapping("/download")
    public void fileDownload(@RequestParam String id, HttpServletResponse response) {
        File file = fileService.getById(id);
        if (file == null) {
            throw new RuntimeException("File not found with id: " + id);
        }
        String fileName = file.getFileName();
        if (fileName == null) {
            throw new RuntimeException("File name is missing for file with id: " + id);
        }

        try {
            String encodedFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString());
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedFileName + "\"");
            response.getOutputStream().write(file.getFile());
            response.flushBuffer();
        } catch (IOException e) {
            throw new RuntimeException("Error writing file to response", e);
        }
    }
}
