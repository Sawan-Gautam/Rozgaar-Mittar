package com.jobportal.dto;

public class CommonApiResponse {

	private String responseMessage;
	private boolean isSuccess;

	// 1. Default Constructor (Empty wala)
	public CommonApiResponse() {
	}

	
	public CommonApiResponse(boolean isSuccess, String responseMessage) {
		this.isSuccess = isSuccess;
		this.responseMessage = responseMessage;
	}

	// Getters and Setters
	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

}








/*
package com.jobportal.dto;

public class CommonApiResponse {

	private String responseMessage;

	private boolean isSuccess;

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

}
*/