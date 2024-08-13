package com.example.openapi.feign.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ResponseData {

    private Response response;

    @Getter
    public static class Response {
        private Header header;
        private Body body;
    }


    @Getter
    public static class Header {
        private String resultMsg;
        private String resultCode;
    }

    @Getter
    public static class Body {
        private String totalCount;
        private String numOfRows;
        private String pageNo;
        private Items items;
    }

    @Getter
    public static class Items {
        private List<PetResponse> item;
    }
}
