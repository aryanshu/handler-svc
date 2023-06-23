package com.profile.handlersvc.profilecontroller;


import com.profile.handlersvc.profile.S3Service;
import lombok.AllArgsConstructor;
import org.apache.http.protocol.HTTP;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/images")
@AllArgsConstructor
public class FileUploadController {

    private final S3Service s3service;
    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        String message;
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            message = s3service.uploadFile(file);
        } else {
            message="No file uploaded";
        }

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}

