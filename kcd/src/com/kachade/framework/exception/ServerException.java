package com.kachade.framework.exception;

/**
 * æœåŠ¡ç«¯å¼‚å¸?
 * @author Bob
 *
 */
public class ServerException extends NetworkException {

	private static final long serialVersionUID = 1L;

	/**
	 * é»˜è®¤æ„é??
	 */
	public ServerException() {
		super();
	}

	/**
	 * æ„é? æ–¹æ³?
	 * @param exception
	 */
	public ServerException(Exception exception) {
		super(exception);
	}

	/**
	 * æ„é? æ–¹æ³?
	 * @param errorCode
	 */
	public ServerException(String errorCode) {
		this.errCode = errorCode;
	}

	/**
	 * æ„é? æ–¹æ³?
	 * @param errCode
	 * @param errMsg
	 */
	public ServerException(String errCode, String errMsg) {
		super(errCode, errMsg);
	}

	/**
	 * æ„é? æ–¹æ³?
	 * @param msg
	 * @param exception
	 */
	public ServerException(String msg, Exception exception) {
		super(msg, exception);
	}

}
