package com.cydeo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class ResponseWrapper {

    private boolean success;
    private String message;
    private Integer code;

    private Object data; // This can accept ANY DTO - we can use this class as a template

    public ResponseWrapper(String message, Object data){
        this.message= message;
        this.data= data;
        this.code= HttpStatus.OK.value();
        this.success=true;
    }

    public ResponseWrapper(String message){ // If you delete you won't be sending data back
        this.message=message;
        this.code= HttpStatus.OK.value();
        this.success=true;
    }



}
