package com.dpl.cart.constant;

public final class HttpResponseCodeConstant {
 
  private HttpResponseCodeConstant(){
    throw new IllegalStateException("HttpResponseCodeConstant class");
  }
  public static final String BAD_REQUEST ="Bad Request";
  public static final String UNAUTHORIZED ="UnAuthorized Request";
  public static final String FORBIDDEN ="Forbidden Request";
  public static final String NOT_FOUND ="Not found Request";
  public static final String METHOD_NOT_ALLOWED ="Method not allowed";
  public static final String NOT_ACCEPTABLE ="not acceptable Request";
  public static final String CONFLICT ="Conflict";
  public static final String GONE ="Gone";
  public static final String UNSUPPORTED_MEDIA_TYPE ="Unsupported media type";
  public static final String TOO_MANY_REQUEST ="Too many Request";
  public static final String UNPROCESSABLE_ENTITY ="Unprocessable Entity";
  public static final String SUCCESS ="Success";
  public static final String CREATED ="Created";
}
