package com.kachade.framework.exception;

/**
 * 自定义异常的基类
 * @author Bob
 *
 */
public class IException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 默认构�??
	 */
	public IException() {
		super();
	}

	/**
	 * 构�?�方�?
	 * @param msg
	 */
	public IException(String msg) {
		super(msg);
	}

	/**
	 * 构�?�方�?
	 * @param msg
	 * @param exception
	 */
	public IException(String msg, Exception exception) {
		super(msg, exception);
	}

	/**
	 * 构�?�方�?
	 * @param exception
	 */
	public IException(Exception exception) {
		super(exception);
	}

}
