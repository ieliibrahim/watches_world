package com.ieli.ww.exception;

import org.springframework.http.ResponseEntity;

public class UserException extends Exception {

	private static final long serialVersionUID = 1L;

	private String statusCode;
	private String statusMsgEn;
	private String statusMsgAr;
	private ResponseEntity<StatusResponse> err;

	public UserException() {

	}

	public UserException(ResponseEntity<StatusResponse> err) {
		this.err = err;
	}

	public UserException(String statusCode) {
		super();
		this.statusCode = statusCode;
	}

	public UserException(String statusCode, String statusMsgEn, String statusMsgAr) {
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

	public ResponseEntity<StatusResponse> getErr() {
		return err;
	}

	public void setErr(ResponseEntity<StatusResponse> err) {
		this.err = err;
	}

}
