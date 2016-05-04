package com.kachade.framework.exception;

/**
 * 网络异常
 * @author Bob
 *
 */
public class NetworkException extends IException {

	private static final long serialVersionUID = 1L;

	protected String errCode = null;

	/**
	 * 默认构�?�方�?
	 */
	public NetworkException() {
		super();
	}

	/**
	 * 构�?�方�?
	 * @param exception
	 */
	public NetworkException(Exception exception) {
		super(exception);
	}

	/**
	 * 构�?�方�?
	 * @param errorCode
	 */
	public NetworkException(String errorCode) {
		this.errCode = errorCode;
	}

	/**
	 * 构�?�方�?
	 * @param errorCode
	 * @param errMsg
	 */
	public NetworkException(String errorCode, String errMsg) {
		super(errMsg);
		this.errCode = errorCode;
	}

	/**
	 * 构�?�方�?
	 * @param errorCode
	 * @param exception
	 */
	public NetworkException(String errorCode, Exception exception) {
		super(errorCode, exception);
	}

	/**
	 * 发生网络异常时返回errorCode，如果异常不带code值，返回-1
	 * 
	 * @Title: getErrorCode
	 * @return error code�?
	 */
	public String getErrorCode() {
		return errCode;
	}
}
