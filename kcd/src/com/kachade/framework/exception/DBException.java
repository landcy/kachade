package com.kachade.framework.exception;

/**
 * æ•°æ®åº“ç›¸å…³å¼‚å¸?
 * @author Bob
 *
 */
public class DBException extends IException {

	private static final long serialVersionUID = 1L;

	/**
	 * é»˜è®¤æ„é??
	 */
	public DBException() {
		super();
	}

	/**
	 * æ„é? æ–¹æ³?
	 * @param msg
	 */
	public DBException(String msg) {
		super(msg);
	}

	/**
	 * æ„é? æ–¹æ³?
	 * @param msg
	 * @param exception
	 */
	public DBException(String msg, Exception exception) {
		super(msg, exception);
	}

	/**
	 * æ„é? æ–¹æ³?
	 * @param exception
	 */
	public DBException(Exception exception) {
		super(exception);
	}
}
