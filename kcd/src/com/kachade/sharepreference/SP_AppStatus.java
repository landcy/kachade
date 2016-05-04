package com.kachade.sharepreference;

import com.kachade.framework.app.KachadeApplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * @ClassName: SP_AppStatus
 * @Description: 应用级别的状态，持久化到 SharedPreferences
 * 
 */
public class SP_AppStatus {
	public static final String ACCOUNT_IS_LOGIN = "account_is_login";
	public static final String ACCOUNT_IS_AUTO_LOGIN = "account_is_auto_login";

	/** 是否登录 */
	public static boolean isLogin() {
		return getBoolean(ACCOUNT_IS_LOGIN, false);
	}

	/** 登录 */
	public static void Login(boolean isLogin) {
		setBoolean(ACCOUNT_IS_LOGIN, isLogin);
	}

	/** 是否登录 */
	public static boolean isAutoLogin() {
		return getBoolean(ACCOUNT_IS_AUTO_LOGIN, false);
	}

	/** 登录 */
	public static void AutoLogin(boolean isAutoLogin) {
		setBoolean(ACCOUNT_IS_AUTO_LOGIN, isAutoLogin);
	}

	/** 设置监听函数 */
	public static void registerOnSharedPreferenceChangeListener(
			SharedPreferences.OnSharedPreferenceChangeListener listener) {
		if (sessionSp != null || sessionSp.getPreferences() != null) {
			sessionSp.getPreferences()
					.registerOnSharedPreferenceChangeListener(listener);
		}
	}

	public static void unregisterOnSharedPreferenceChangeListener(
			SharedPreferences.OnSharedPreferenceChangeListener listener) {
		if (sessionSp != null || sessionSp.getPreferences() != null) {
			sessionSp.getPreferences()
					.unregisterOnSharedPreferenceChangeListener(listener);
		}
	}

	/******************************************************************/
	/** 以下内容不要修改 */
	/******************************************************************/

	/** 保存session的SharedPreference的文件名 */
	public static final String SESSION_FILE = "UAir_SP_AppStatus";
	private static SharePrefsHelper sessionSp = null;

	// ///////////////////////以下为基础方法////////////////////////////////
	static {
		init();
	}

	private static void init() {
		if (sessionSp == null) {
			sessionSp = new SharePrefsHelper(KachadeApplication.getContext(),
					SESSION_FILE, Context.MODE_MULTI_PROCESS);
		}
	}

	public static String getString(String key, String def) {
		init();
		return sessionSp.getString(key, def);
	}

	public static void setString(String key, String value) {
		init();
		if (TextUtils.isEmpty(value)) {
			value = "";
		}
		sessionSp.setString(key, value);
	}

	public static long getLong(String key, long def) {
		init();
		return sessionSp.getLong(key, def);
	}

	public static void setLong(String key, long def) {
		init();
		sessionSp.setLong(key, def);
	}

	public static boolean getBoolean(String key, boolean def) {
		init();
		return sessionSp.getBoolean(key, def);
	}

	public static void setBoolean(String key, boolean value) {
		init();
		sessionSp.setBoolean(key, value);
	}

	public static int getInteger(String key, int def) {
		init();
		return sessionSp.getInt(key, def);
	}

	public static void setInteger(String key, int value) {
		init();
		sessionSp.setInt(key, value);
	}

	public static float getFloat(String key, float def) {
		init();
		return sessionSp.getFloat(key, def);
	}

	public static void setFloat(String key, float value) {
		init();
		sessionSp.setFloat(key, value);
	}

}
