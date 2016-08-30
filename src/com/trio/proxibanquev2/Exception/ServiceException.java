package com.trio.proxibanquev2.Exception;

public class ServiceException extends Exception {
	private String Message;

	public ServiceException(String string) {
		super();
		this.Message=string;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
}
