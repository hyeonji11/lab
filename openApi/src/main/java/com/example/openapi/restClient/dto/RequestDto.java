package com.example.openapi.restClient.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDto {
    private String serviceKey;
    private String MobileOS;
    private String MobileApp;
    private String _type;
    private int pageNo;
    private int numOfRows;

    public RequestDto(String serviceKey, String mobileOS, String mobileApp, String dataType, int page, int pageSize) {
        this.serviceKey = serviceKey;
        this.MobileOS = mobileOS;
        this.MobileApp = mobileApp;
        this._type = dataType;
        this.pageNo = page;
        this.numOfRows = pageSize;
    }
}
