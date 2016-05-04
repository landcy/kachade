package com.kachade.framework.util;

import android.util.Log;

/**
 * ��װĬ�ϵ�Log��
 * 
 * @author Bob
 * 
 */
public class Loger {
	private static boolean CLOSE = false;

	public static void setLogClose(boolean logClose) {
		CLOSE = logClose;
	}

	public static boolean isLogCLose() {
		return CLOSE;
	}

	/**
	 * ��ӦLog.v
	 * 
	 * @param msg
	 */
	public static void v(String msg) {
		if (CLOSE)
			return;

		final StackTraceElement[] stack = new Throwable().getStackTrace();
		final int i = 1;
		final StackTraceElement ste = stack[i];

		Log.v(ste.getClassName(),
				String.format("[%s][%d]%s", ste.getMethodName(),
						ste.getLineNumber(), msg));
	}

	/**
	 * ��ӦLog.d
	 * 
	 * @param msg
	 */
	public static void d(String msg) {
		if (CLOSE)
			return;

		final StackTraceElement[] stack = new Throwable().getStackTrace();
		final int i = 1;
		final StackTraceElement ste = stack[i];

		Log.d(ste.getClassName(),
				String.format("[%s][%d]%s", ste.getMethodName(),
						ste.getLineNumber(), msg));
	}

	/**
	 * ��ӦLog.i
	 * 
	 * @param msg
	 */
	public static void i(String msg) {
		if (CLOSE)
			return;

		final StackTraceElement[] stack = new Throwable().getStackTrace();
		final int i = 1;
		final StackTraceElement ste = stack[i];

		Log.i(ste.getClassName(),
				String.format("[%s][%d]%s", ste.getMethodName(),
						ste.getLineNumber(), msg));
	}

	/**
	 * ��ӦLog.w
	 * 
	 * @param msg
	 */
	public static void w(String msg) {
		if (CLOSE)
			return;

		final StackTraceElement[] stack = new Throwable().getStackTrace();
		final int i = 1;
		final StackTraceElement ste = stack[i];

		Log.w(ste.getClassName(),
				String.format("[%s][%d]%s", ste.getMethodName(),
						ste.getLineNumber(), msg));
	}

	/**
	 * ��ӦLog.e
	 * 
	 * @param msg
	 */
	public static void e(String msg) {
		if (CLOSE)
			return;

		final StackTraceElement[] stack = new Throwable().getStackTrace();
		final int i = 1;
		final StackTraceElement ste = stack[i];

		Log.e(ste.getClassName(),
				String.format("[%s][%d]%s", ste.getMethodName(),
						ste.getLineNumber(), msg));
	}

	public static final String TAG = "getData";

	public static void print(String message) {
		Log.i(TAG, message);
	}

	public static void print(String message, Object... params) {
		String ms = String.format(message, params);
		Log.i(TAG, ms);
	}

}
