package com.app.demo.custom_exception;

public class AuthenticationFailedException extends RuntimeException {
	public AuthenticationFailedException(String mesg) {
		super(mesg);
	}

}
