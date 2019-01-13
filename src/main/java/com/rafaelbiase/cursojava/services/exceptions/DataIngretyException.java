package com.rafaelbiase.cursojava.services.exceptions;

public class DataIngretyException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DataIngretyException(String msn) {
		super(msn);
	}
	
	public DataIngretyException(String msn, Throwable cause) {
		super(msn, cause);
	}
	
	

}
