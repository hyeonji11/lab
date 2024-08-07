package com.example.openapi.restClient.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemsDto {
    private List<AreaCodeItem> item;
}

