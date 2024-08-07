package com.example.openapi.restClient.service;

import com.example.openapi.restClient.dto.ResponseData;
import com.example.openapi.restClient.httpInterface.ApiHttpInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestClientService {

    @Value("${openapi.serviceKey}")
    private String serviceKey;

    private final ApiHttpInterface apiHttpInterface;

    public ResponseData getAreaCode() {
        ResponseData result = apiHttpInterface.getAreaCode(serviceKey, "ETC", "test", "json", 1, 10);

        return result;
    }
}
