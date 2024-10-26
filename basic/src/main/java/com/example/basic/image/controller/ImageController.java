package com.example.basic.image.controller;

import com.example.basic.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/image/create")
    public void saveImage(MultipartFile image) throws IOException {
        imageService.imageSave(image);
    }

}
