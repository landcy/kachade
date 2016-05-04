/**
 * @Description: TODO
 * @author: Zhou Haitao(zhouhaitao@yazuo.com)
 * @create: 2012-7-9
 */

package com.kachade.framework.exception;
/**
 * 没有WIFI网络异常
 * @author Bob
 *
 */
public class NoWiFiNetworkException extends NetworkException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -802029342838151250L;

	/**
	 * 默认构�??
	 */
	public NoWiFiNetworkException() {
		super();
	}

	/**
	 * 构�?�方�?
	 * @param detailMessage
	 */
	public NoWiFiNetworkException(String detailMessage) {
		super(detailMessage);
	}
}
