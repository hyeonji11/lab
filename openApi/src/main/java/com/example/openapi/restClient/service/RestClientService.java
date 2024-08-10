package com.example.openapi.restClient.service;

import com.example.openapi.restClient.dto.RequestDto;
import com.example.openapi.restClient.dto.ResponseData;
import com.example.openapi.restClient.httpInterface.ApiHttpInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class RestClientService {

    @Value("${openapi.serviceKey}")
    private String serviceKey;

    ObjectMapper objectMapper = new ObjectMapper();

    private final ApiHttpInterface apiHttpInterface;

    public ResponseData getAreaCode() {
        ResponseData result = apiHttpInterface.getAreaCode(serviceKey, "ETC", "test", "json", 1, 10);

        return result;
    }

    public ResponseData getAreaCode2() {
        RequestDto requestDto = new RequestDto(serviceKey, "ETC", "test", "json", 1, 10);
        Map<String, Object> requestParam = objectMapper.convertValue(requestDto, Map.class);

        ResponseData result = apiHttpInterface.getAreaCodeObject(requestParam);

        return result;
    }
}
