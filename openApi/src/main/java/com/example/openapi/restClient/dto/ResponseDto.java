package com.example.openapi.restClient.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {
    private HeaderDto header;
    private BodyDto body;
}
