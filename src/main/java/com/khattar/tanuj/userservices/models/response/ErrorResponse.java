package com.khattar.tanuj.userservices.models.response;

public class ErrorResponse extends BaseResponse{


    public ErrorResponse(Object data, String error) {
        super(null, error);
    }
}
