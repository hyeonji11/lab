package com.example.openapi.feign.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseData {

    private Response response;

    @Getter
    @Setter
    public static class Response {
        private Header header;
        private Body body;
    }


    @Getter
    @Setter
    public static class Header {
        private String resultMsg;
        private String resultCode;
    }

    @Getter
    @Setter
    public static class Body {
        private String totalCount;
        private String numOfRows;
        private String pageNo;
        private Items items;
    }

    @Getter
    @Setter
    public static class Items {
        private List<PetResponse> item;
    }
}
