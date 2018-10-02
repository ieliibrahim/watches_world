package com.ieli.ww.exception;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

	private static Logger daoLogger = Logger.getLogger(ExceptionControllerAdvice.class);

	@Autowired
	private MessageSource messageSource;

	private static final Locale LOCALE_EN = new Locale("en");
	private static final Locale LOCALE_AR = new Locale("ar");

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> exceptionHandler(Exception ex) {
		Map<String, Object> responseMap = new LinkedHashMap<>();
		StatusResponse error = new StatusResponse();
		error.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		error.setStatusMsgEn(messageSource.getMessage("general_err_msg", null, LOCALE_EN));
		error.setStatusMsgAr(messageSource.getMessage("general_err_msg", null, LOCALE_AR));
		error.setApiError(ex.getMessage());
		responseMap.put("Status", error);
		daoLogger.error(ex.getMessage());
		return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
	}
}
