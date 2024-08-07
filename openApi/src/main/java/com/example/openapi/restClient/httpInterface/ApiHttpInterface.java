package com.example.openapi.restClient.httpInterface;

import com.example.openapi.restClient.dto.ResponseData;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@Component
@HttpExchange
public interface ApiHttpInterface {

    @GetExchange("/B551011/KorService1/areaCode1")
    ResponseData getAreaCode(@RequestParam("serviceKey") String serviceKey,
                             @RequestParam("MobileOS") String mobileOS,
                             @RequestParam("MobileApp") String mobileApp,
                             @RequestParam("_type") String dataType,
                             @RequestParam("pageNo") int page,
                             @RequestParam("numOfRows") int pageSize
    );
}
