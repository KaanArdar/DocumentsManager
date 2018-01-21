package com.documentsmanager.exception;


/**
 * @author Kaan
 *
 * This is a Exception handler
 */
public class ExceptionHandler {
	
	public static ResponseError errorResponse(Exception e) {
		ResponseError ex = null;
		if(e instanceof ResponseException){
			ex = new ResponseError();
			ex.setErrorCode(((ResponseException) e).getExceptionCode());
			ex.setErrorDescription(((ResponseException) e).getExceptionDescription());
			ex.setDeveloperMessage(((ResponseException) e).getDeveloperMessage());
		} else {
			ex = new ResponseError();
			ex.setErrorCode("ERR-GNR-01");
			ex.setErrorDescription("Generic Error");
			ex.setDeveloperMessage(e.getMessage());
		}
		return ex;
	}
}