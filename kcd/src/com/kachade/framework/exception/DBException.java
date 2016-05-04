package com.kachade.framework.exception;

/**
 * 数据库相关异�?
 * @author Bob
 *
 */
public class DBException extends IException {

	private static final long serialVersionUID = 1L;

	/**
	 * 默认构�??
	 */
	public DBException() {
		super();
	}

	/**
	 * 构�?�方�?
	 * @param msg
	 */
	public DBException(String msg) {
		super(msg);
	}

	/**
	 * 构�?�方�?
	 * @param msg
	 * @param exception
	 */
	public DBException(String msg, Exception exception) {
		super(msg, exception);
	}

	/**
	 * 构�?�方�?
	 * @param exception
	 */
	public DBException(Exception exception) {
		super(exception);
	}
}
