package com.kachade.framework.exception;

/**
 * 超时异常
 * @author Bob
 *
 */
public class TimeoutException extends NetworkException {
	private static final long serialVersionUID = 1L;

	/**
	 * 默认构�??
	 */
	public TimeoutException() {
		super();
	}

	/**
	 * 构�?�方�?
	 * @param detailMessage
	 */
	public TimeoutException(String detailMessage) {
		super(detailMessage);
	}

	/**
	 * 构�?�方�?
	 * @param detailMessage
	 * @param exception
	 */
	public TimeoutException(String detailMessage, Exception exception) {
		super(detailMessage, exception);
	}
}
