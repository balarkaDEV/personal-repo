package com.brahma.bookmaster.service.exception;

public class BookDetailBusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1116261226880513600L;
	private String errorCode;
	private String errorMessage;
	
	public BookDetailBusinessException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
	
	public BookDetailBusinessException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
