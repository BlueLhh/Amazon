package com.lhh.amazon.common;

public class DataAccessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 526772281826109606L;

	public DataAccessException() {
	}

	public DataAccessException(String arg0) {
		super(arg0);
	}

	public DataAccessException(Throwable arg0) {
		super(arg0);
	}

	public DataAccessException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public DataAccessException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
