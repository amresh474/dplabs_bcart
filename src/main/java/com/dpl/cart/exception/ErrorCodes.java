package com.dpl.cart.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCodes {
	Sso_Unauthorized(HttpStatus.UNAUTHORIZED, "x-secret or x-sid is missing"),
	Sso_InvalidToken(HttpStatus.FORBIDDEN, "x-sid is missing"),
	Sso_UserNotExist(HttpStatus.NOT_FOUND, "User does not exist"),
	Sso_SessionNotExist(HttpStatus.NOT_FOUND, "Session does not exist"),
	Sso_validationError(HttpStatus.BAD_REQUEST, "Mobile , first name and Email is Compulsory"),
	Sso_OTPNotExist(HttpStatus.NOT_FOUND, "Otp is Invalid or does not exist"),
	Sso_InvalidMobileNo(HttpStatus.NOT_FOUND, "Mobile No is not valid"),
	Sso_EmptyMobileNo(HttpStatus.NOT_FOUND, "Mobile is compulsory"),
	Sso_EmptyFirstName(HttpStatus.NOT_FOUND, "FirstName is compulsory"),
	Sso_InvalidEmail(HttpStatus.NOT_FOUND, "Email is invalid");

	private HttpStatus httpStatus;

	private String message;

	ErrorCodes(HttpStatus httpStatus, String message) {
		this.httpStatus = httpStatus;
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getErrorCode() {
		return this.message;
	}

}
