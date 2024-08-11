package com.example.openapi.feign.service;

import com.example.openapi.feign.client.OpenFeignClient;
import com.example.openapi.feign.dto.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeignService {

    private final OpenFeignClient feignClient;

    @Value("${openapi.serviceKey}")
    private String serviceKey;

    public ResponseData getDetail() {
        ResponseData feignData = feignClient.getDetailPetTour(serviceKey, 1, 10, "ETC", "test", "json");

        return feignData;
    }
}
