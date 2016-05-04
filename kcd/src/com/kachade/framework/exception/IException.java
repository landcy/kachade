package com.kachade.framework.exception;

/**
 * è‡ªå®šä¹‰å¼‚å¸¸çš„åŸºç±»
 * @author Bob
 *
 */
public class IException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * é»˜è®¤æž„é??
	 */
	public IException() {
		super();
	}

	/**
	 * æž„é? æ–¹æ³?
	 * @param msg
	 */
	public IException(String msg) {
		super(msg);
	}

	/**
	 * æž„é? æ–¹æ³?
	 * @param msg
	 * @param exception
	 */
	public IException(String msg, Exception exception) {
		super(msg, exception);
	}

	/**
	 * æž„é? æ–¹æ³?
	 * @param exception
	 */
	public IException(Exception exception) {
		super(exception);
	}

}
