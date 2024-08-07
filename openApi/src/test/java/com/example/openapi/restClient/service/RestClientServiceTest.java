package com.example.openapi.restClient.service;

import com.example.openapi.restClient.dto.ResponseData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestClientServiceTest {

    @Autowired
    RestClientService restClientService;

    @Test
    public void getAreaCodeTest() {
        ResponseData responseDto = restClientService.getAreaCode();

        assertNotNull(responseDto);
        assertEquals(responseDto.getResponse().getHeader().getResultMsg(), "OK");
        assertNotNull(responseDto.getResponse().getBody().getItems().getItem());
    }

}