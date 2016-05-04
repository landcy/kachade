package com.kachade.popview;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.kachade.callback.IFragmentCallBack;
import com.kachade.kcd.R;

public class SharePopView {
	private Context mContext;
	private IFragmentCallBack mFragmentConnect;
	private TextView mCancel;
	private LinearLayout mWechat;
	private LinearLayout mFriends;
	private LinearLayout mMessage;
	private LinearLayout mCopy;
	private LinearLayout mShare;
	private PopupWindow popupWindow;

	public void setIFragmentCallBack(IFragmentCallBack f) {
		mFragmentConnect = f;
	}

	public SharePopView(Context context) {
		this.mContext = context;
		initPopupWindow();
	}

	private void setListener() {
		OnClickListener onClickLis = new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				int id = arg0.getId();
				switch (id) {
				case R.id.btn_cancel: {
					popupWindow.dismiss();
					if (mFragmentConnect != null)
						mFragmentConnect.ShareViewCloseClick();
					break;
				}
				}
			}
		};
		mCancel.setOnClickListener(onClickLis);
	}

	private void initPopupWindow() {
		View popView = LayoutInflater.from(mContext).inflate(
				R.layout.share_view, null);
		popupWindow = new PopupWindow(popView,
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		mCancel = (TextView) popView.findViewById(R.id.btn_cancel);
		mWechat = (LinearLayout) popView.findViewById(R.id.wechat_lay);
		mFriends = (LinearLayout) popView.findViewById(R.id.friends_lay);
		mMessage = (LinearLayout) popView.findViewById(R.id.message_lay);
		mCopy = (LinearLayout) popView.findViewById(R.id.copy_lay);
		mShare = (LinearLayout) popView.findViewById(R.id.share_lay);
		setListener();
		popupWindow.setFocusable(true);
		popupWindow.setBackgroundDrawable(new BitmapDrawable());
		popupWindow.setOutsideTouchable(false);

	}

	public void showShareView(View parent) {
		// 为popWindow添加动画效果
		popupWindow.setAnimationStyle(R.style.popWindow_animation);
		// 点击弹出泡泡窗口
		popupWindow.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
	}

	public void closeShareView() {
		popupWindow.dismiss();
	}
}
