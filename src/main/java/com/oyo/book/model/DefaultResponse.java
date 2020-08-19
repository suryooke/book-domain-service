package com.oyo.book.model;

public class DefaultResponse {
	
	private String statusCode;
	private String message;
	
	public DefaultResponse(String message) {
		this.message = message;
		this.statusCode = "00";
	}
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
