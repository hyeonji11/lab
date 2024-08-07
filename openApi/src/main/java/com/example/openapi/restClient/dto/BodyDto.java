package com.example.openapi.restClient.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BodyDto {
    private String numOfRows;
    private String pageNo;
    private String totalCount;
    private ItemsDto items;
}
