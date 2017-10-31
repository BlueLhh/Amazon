package com.lhh.amazon.common;

//�Զ��������ҵ���߼��㣨Service�㣩�׳����쳣
public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4092335709325073433L;

	public ServiceException() {
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
