package com.ieli.ww.exception;

public class StatusResponse {

	private String statusCode;
	private String statusMsgEn;
	private String statusMsgAr;
	private String apiError;

	public StatusResponse() {

	}

	public StatusResponse(String statusCode) {
		super();
		this.statusCode = statusCode;
	}

	public StatusResponse(String statusCode, String statusMsgEn, String statusMsgAr) {
		super();
		this.statusCode = statusCode;
		this.statusMsgEn = statusMsgEn;
		this.statusMsgAr = statusMsgAr;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMsgEn() {
		return statusMsgEn;
	}

	public void setStatusMsgEn(String statusMsgEn) {
		this.statusMsgEn = statusMsgEn;
	}

	public String getStatusMsgAr() {
		return statusMsgAr;
	}

	public void setStatusMsgAr(String statusMsgAr) {
		this.statusMsgAr = statusMsgAr;
	}

	public String getApiError() {
		return apiError;
	}

	public void setApiError(String apiError) {
		this.apiError = apiError;
	}

}