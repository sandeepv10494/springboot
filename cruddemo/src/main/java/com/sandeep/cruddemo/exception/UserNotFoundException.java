package com.sandeep.cruddemo.exception;

public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String exception) {
		super(exception);
	}

}
