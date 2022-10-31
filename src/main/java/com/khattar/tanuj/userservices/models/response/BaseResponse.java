package com.khattar.tanuj.userservices.models.response;

import lombok.Data;

@Data
public class BaseResponse {

    protected Object data;
    protected String error;

    public BaseResponse(Object data,String error){
        this.data=data;
        this.error=error;
    }
}
