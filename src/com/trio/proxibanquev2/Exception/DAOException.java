package com.trio.proxibanquev2.Exception;

import java.io.IOException;

public class DAOException extends Exception {
	
	private String Message;
	
	public DAOException(String string) {
		super();
		this.Message=string;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage( );
	}
	
}
