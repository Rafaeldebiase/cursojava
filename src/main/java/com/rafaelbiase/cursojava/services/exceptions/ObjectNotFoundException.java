package com.rafaelbiase.cursojava.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String msn) {
		super(msn);
	}
	
	public ObjectNotFoundException(String msn, Throwable cause) {
		super(msn, cause);
	}
	
	

}
