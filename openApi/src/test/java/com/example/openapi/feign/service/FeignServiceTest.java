package com.example.openapi.feign.service;

import com.example.openapi.feign.dto.ResponseData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class FeignServiceTest {

    @Autowired
    FeignService feignService;

    @Test
    public void getDetailTest() {
        ResponseData data = feignService.getDetail();

        assertNotNull(data);
        assertNotNull(data.getResponse().getBody().getItems().getItem());
    }

}