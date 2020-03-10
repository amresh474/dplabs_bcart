package com.dpl.cart.response;

import java.util.Map;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

/**
 * @author rpandey
 *
 */
@Getter
@Setter
public class Response<T> {
    private String statusCode = "10000";
    private boolean status = false;
    private String msg = "FAILURE";
    private int httpCode = 404;
//  private HttpStatus httpStatus;
    private T data = null;

    public Response(Map<String, ?> codes, int httpCode, T data) {
        this.statusCode = codes.get("statusCode") != null ? codes.get("statusCode").toString() : "10000";
        this.status = codes.get("status") != null ? Boolean.parseBoolean(codes.get("status").toString()) : false;
        this.msg = codes.get("msg") != null ? codes.get("msg").toString() : "FAILURE";
        this.httpCode = httpCode >= 200 ? httpCode : 404;
        this.data = data;
    }

    public Response(Map<String, ?> codes, int httpCode) {
        this.statusCode = codes.get("statusCode") != null ? codes.get("statusCode").toString() : "10000";
        this.status = codes.get("status") != null ? Boolean.parseBoolean(codes.get("status").toString()) : false;
        this.msg = codes.get("msg") != null ? codes.get("msg").toString() : "FAILURE";
        this.httpCode = httpCode >= 200 ? httpCode : 404;
        this.data = null;
    }
    
    public Response(HttpStatus httpStatus, int code ,T data) {
//       this.httpStatus = httpStatus;
        this.httpCode = code ;
        this.data = data;
        this.statusCode = "10"+httpStatus.value();
      }

    public Response() {
    }

}