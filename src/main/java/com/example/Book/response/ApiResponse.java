package com.example.Book.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
public class ApiResponse implements Serializable {

    private HttpStatus status;
    private Object data;



    public static ApiResponse ok() {
        ApiResponse response = new ApiResponse();
        response.status = HttpStatus.OK;
        return response;
    }


    public static ApiResponse ok(Object data) {
        ApiResponse response = new ApiResponse();
        response.status = HttpStatus.OK;
        response.data = data;
        return response;
    }

    public static ApiResponse of( HttpStatus status , String msg) {
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.status= status ;
        apiResponse.data=msg;
        return apiResponse;


    }


}
