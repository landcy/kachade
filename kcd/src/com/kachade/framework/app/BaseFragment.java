package com.kachade.framework.app;

import com.kachade.framework.exception.IException;
import com.kachade.kcd.R;
import com.kachade.kcd.R.id;
import com.kachade.kcd.R.layout;
import com.kachade.util.ExceptionHelper;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class BaseFragment extends Fragment {

	protected ExceptionHelper exceptionHelper = null;
	protected Activity mActivity;
	protected ProgressDialog mProgressDialog;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		exceptionHelper = new ExceptionHelper(getActivity());
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mActivity = this.getActivity();
		View view = super.onCreateView(inflater, container, savedInstanceState);
		// FontUtils.setFonts(mActivity, FontTypes.DROIDSANSFALLBACK, view, new
		// int[]{});
		return view;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		// mActivity = this.getActivity();
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mActivity = null;
	}

	protected void showMsgToast(String text) {
		Toast.makeText(KachadeApplication.getContext(), text,
				Toast.LENGTH_SHORT).show();
	}

	protected void showErrorToast(IException ie) {
		exceptionHelper.showErrorToast(ie);
	}

	public void showProgressDialog(String title) {
//		if (null != mProgressDialog) {
//			mProgressDialog.dismiss();
//			mProgressDialog = null;
//		}
//
//		LayoutInflater mLayoutInflater = LayoutInflater.from(getActivity());
//		View dialogView = mLayoutInflater.inflate(
//				R.layout.customized_progressbar, null);
//		TextView tvTitle = (TextView) dialogView.findViewById(R.id.tv_title);
//		if (!TextUtils.isEmpty(title)) {
//			tvTitle.setText(title);
//		} else {
//			tvTitle.setVisibility(View.GONE);
//		}
//		mProgressDialog = new ProgressDialog(getActivity());
//		mProgressDialog.show();
//		mProgressDialog.setContentView(dialogView);
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
