package com.kachade.framework.app;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import com.kachade.framework.exception.IException;
import com.kachade.framework.util.ExitHandler;
import com.kachade.util.ExceptionHelper;

public class BaseActivity extends Activity {

	/**
	 * 处理应用退出
	 */
	protected ExitHandler exitHandler = null;
	protected ExceptionHelper exceptionHelper = null;
	protected ProgressDialog mProgressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		exitHandler = new ExitHandler(this);
		exceptionHelper = new ExceptionHelper(this);
		exitHandler.register();
	}

	@Override
	public void setContentView(int layoutResID) {
		super.setContentView(layoutResID);
		init();
	}

	private void init() {
		// FontUtils.setFonts(this, FontTypes.DROIDSANSFALLBACK,
		// this.getWindow()
		// .getDecorView(), new int[] {});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		exitHandler.unregister();
	}

	/**
	 * 显示提示消息
	 * 
	 * @param text
	 */
	protected void showMsgToast(String text) {
		Toast.makeText(KachadeApplication.getContext(), text,
				Toast.LENGTH_SHORT).show();
	}

	protected void showErrorToast(IException ie) {
		exceptionHelper.showErrorToast(ie);
	}

	/**
	 * 退出应用
	 */
	protected void exitApp() {
		KachadeApplication.getApplication().exitApp();
	}

	public void showProgressDialog(String title) {
		// if (null != mProgressDialog) {
		// mProgressDialog.dismiss();
		// mProgressDialog = null;
		// }
		//
		// LayoutInflater mLayoutInflater = LayoutInflater.from(this);
		// View dialogView = mLayoutInflater.inflate(
		// R.layout.customized_progressbar, null);
		// TextView tvTitle = (TextView) dialogView.findViewById(R.id.tv_title);
		// if (!TextUtils.isEmpty(title)) {
		// tvTitle.setText(title);
		// } else {
		// tvTitle.setVisibility(View.GONE);
		// }
		// mProgressDialog = new ProgressDialog(this);
		// mProgressDialog.show();
		// mProgressDialog.setContentView(dialogView);
	}

	public void showProgressDialogCancel(String title,
			OnCancelListener onCancelListener) {
		showProgressDialog(title);
		mProgressDialog.setOnCancelListener(onCancelListener);
	}

	public void showProgressDialogUnCancel(String title) {
		showProgressDialog(title);
		mProgressDialog.setCancelable(false);
	}

	public void dismissProgressDialog() {
		if (null != mProgressDialog) {
			mProgressDialog.dismiss();
			mProgressDialog = null;
		}
	}
}
