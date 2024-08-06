package com.example.openapi.feign.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseData {

    Response response;

    @Getter
    @Setter
    public static class Response {
        Header header;
        Body body;
    }


    @Getter
    @Setter
    public static class Header {
        String resultMsg;
        String resultCode;
    }

    @Getter
    @Setter
    public static class Body {
        String totalCount;
        String numOfRows;
        String pageNo;
        Items items;
    }

    @Getter
    @Setter
    public static class Items {
        List<PetResponseModel> item;
    }
}
