package com.example.basic.image.service;

import com.example.basic.image.entity.Image;
import com.example.basic.image.repository.ImageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    public void imageSave(MultipartFile image) throws IOException {

        String projectDir = System.getProperty("user.dir");

        String uploadsDir = projectDir+"/basic/src/main/resources/static/uploads/images/";

        String fileName = UUID.randomUUID().toString().replace("-", "") + "_" + image.getOriginalFilename();
        // 실제 파일이 저장될 경로
        String filePath = uploadsDir + fileName;
        // DB에 저장할 경로 문자열
        String dbFilePath = "/uploads/images/" + fileName;

        Path path = Paths.get(filePath);
        Files.createDirectories(path.getParent()); // 디렉토리 생성
        Files.write(path, image.getBytes()); // 디렉토리에 파일 저장

        Image image1 = new Image(dbFilePath, image.getOriginalFilename(), fileName);

        imageRepository.save(image1);

    }
}
