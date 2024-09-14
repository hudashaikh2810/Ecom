
package com.quitq.ECom.exception;

public class InputValidateionException extends Exception {
	private static final long serialVersionUID = 1L;

	private String message;

	public InputValidateionException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	} 

}
