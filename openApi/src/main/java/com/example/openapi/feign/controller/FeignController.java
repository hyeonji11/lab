package com.example.openapi.feign.controller;

import com.example.openapi.feign.dto.ResponseData;
import com.example.openapi.feign.service.FeignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FeignController {

    private final FeignService feignService;

    @GetMapping("/petDetail")
    public ResponseEntity<Object> getDetail() {
        ResponseData response = feignService.getDetail();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
