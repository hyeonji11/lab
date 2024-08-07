package com.example.openapi.feign.client;

import com.example.openapi.feign.model.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="${feign.svc1.name}", url="${feign.svc1.url}")
public interface OpenFeignClient {

    @GetMapping("/B551011/KorService1/detailPetTour1")
    ResponseData getDetailPetTour(@RequestParam("serviceKey") String serviceKey,
                                       @RequestParam("pageNo") int pageNo,
                                       @RequestParam("numOfRows") int numOfRows,
                                       @RequestParam("MobileOS") String MobileOS,
                                       @RequestParam("MobileApp") String MobileApp,
                                       @RequestParam("_type") String type);
}
