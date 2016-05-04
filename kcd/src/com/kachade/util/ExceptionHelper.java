package com.kachade.util;

import android.content.Context;
import android.widget.Toast;

import com.kachade.framework.exception.IException;
import com.kachade.framework.exception.JsonServerException;
import com.kachade.framework.exception.NetworkException;
import com.kachade.framework.exception.NoNetworkException;
import com.kachade.framework.exception.NoWiFiNetworkException;
import com.kachade.framework.exception.ServerException;
import com.kachade.framework.exception.TimeoutException;
import com.kachade.kcd.R;

/**
 * Exception帮助类
 * 
 */
public class ExceptionHelper {

	private Context mContext = null;

	public ExceptionHelper(Context context) {
		mContext = context;
	}

	/**
	 * 根据异常类型和异常Code获取异常内容
	 * 
	 * @param ie
	 * @return 返数组第一项表示异常提示文字，第二项表示异常code，供上层个别处理
	 */
	public String[] getErrorInfo(IException ie) {
		final String timeoutExceptionMsg = mContext
				.getString(R.string.err_request_timeout);
		final String serverExceptionMsg = mContext
				.getString(R.string.err_server_error);
		final String noNetworkExceptionMsg = mContext
				.getString(R.string.err_no_internet);
		final String noWIFIworkExceptionMsg = mContext
				.getString(R.string.err_wifi_internet);

		String errorMsg = null;
		String errCode = null;

		if (ie == null) {
			return null;
		}
		if (ie instanceof NoNetworkException) {
			errCode = "";
			errorMsg = noNetworkExceptionMsg;
		} else if (ie instanceof NoWiFiNetworkException) {

			errCode = "";
			errorMsg = noWIFIworkExceptionMsg;
		} else if (ie instanceof JsonServerException) {
			errCode = "";
			errorMsg = serverExceptionMsg;
		} else if (ie instanceof ServerException) {
			errCode = ((ServerException) ie).getErrorCode();
			// 服务端异常需要根据对应Code给出提示信息
			// errorMsg = getServerExceptionMsg(ie);
			errorMsg = serverExceptionMsg; // 直接读取服务端异常提示
		} else if (ie instanceof TimeoutException) {
			errorMsg = timeoutExceptionMsg;
		} else if (ie instanceof NetworkException) {
			errCode = ((NetworkException) ie).getErrorCode();
			errorMsg = serverExceptionMsg;
		}

		return new String[] { errorMsg, errCode };
	}

	/**
	 * Toast形式提示异常
	 * 
	 * @param ie
	 */
	public void showErrorToast(IException ie) {
		String errorMsg = getErrorInfo(ie)[0];
		if (null != errorMsg) {
			Toast.makeText(mContext, errorMsg, Toast.LENGTH_SHORT).show();
		}
	}

	/**
	 * Toast 提示
	 * 
	 * @param string
	 */
	public void showCustomToast(String string) {
		// TODO Auto-generated method stub
		Toast.makeText(mContext, string, Toast.LENGTH_SHORT).show();
	}
}
