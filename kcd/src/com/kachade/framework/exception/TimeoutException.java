package com.kachade.framework.exception;

/**
 * è¶…æ—¶å¼‚å¸¸
 * @author Bob
 *
 */
public class TimeoutException extends NetworkException {
	private static final long serialVersionUID = 1L;

	/**
	 * é»˜è®¤æž„é??
	 */
	public TimeoutException() {
		super();
	}

	/**
	 * æž„é? æ–¹æ³?
	 * @param detailMessage
	 */
	public TimeoutException(String detailMessage) {
		super(detailMessage);
	}

	/**
	 * æž„é? æ–¹æ³?
	 * @param detailMessage
	 * @param exception
	 */
	public TimeoutException(String detailMessage, Exception exception) {
		super(detailMessage, exception);
	}
}
