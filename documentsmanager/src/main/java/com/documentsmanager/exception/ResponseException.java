package com.documentsmanager.exception;

/**
 * 
 * @author Kaan
 * 
 * This is a custom exception class for business rules
 */
public class ResponseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String exceptionCode;

	private String exceptionDescription;

	private String developerMessage;

	public ResponseException(String exceptionCode) {
		super();
		this.exceptionCode = exceptionCode;
	}

	public ResponseException(String exceptionCode, String exceptionDescription) {
		super();
		this.exceptionCode = exceptionCode;
		this.exceptionDescription = exceptionDescription;
	}

	public ResponseException(String exceptionCode, String exceptionDescription,String developerMessage) {
		super();
		this.exceptionCode = exceptionCode;
		this.exceptionDescription = exceptionDescription;
		this.developerMessage = developerMessage;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public String getExceptionDescription() {
		return exceptionDescription;
	}

	public void setExceptionDescription(String exceptionDescription) {
		this.exceptionDescription = exceptionDescription;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

}
