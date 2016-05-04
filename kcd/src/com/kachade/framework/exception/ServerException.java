package com.kachade.framework.exception;

/**
 * 服务端异�?
 * @author Bob
 *
 */
public class ServerException extends NetworkException {

	private static final long serialVersionUID = 1L;

	/**
	 * 默认构�??
	 */
	public ServerException() {
		super();
	}

	/**
	 * 构�?�方�?
	 * @param exception
	 */
	public ServerException(Exception exception) {
		super(exception);
	}

	/**
	 * 构�?�方�?
	 * @param errorCode
	 */
	public ServerException(String errorCode) {
		this.errCode = errorCode;
	}

	/**
	 * 构�?�方�?
	 * @param errCode
	 * @param errMsg
	 */
	public ServerException(String errCode, String errMsg) {
		super(errCode, errMsg);
	}

	/**
	 * 构�?�方�?
	 * @param msg
	 * @param exception
	 */
	public ServerException(String msg, Exception exception) {
		super(msg, exception);
	}

}
