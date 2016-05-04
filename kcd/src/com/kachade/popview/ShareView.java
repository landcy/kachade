package com.kachade.popview;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kachade.callback.IFragmentCallBack;
import com.kachade.kcd.R;
import com.kachade.kcd.Activity.MainActivity;
import com.kachade.kcd.Activity.SearchActivity;

public class ShareView extends RelativeLayout {
	private Context mContext;
	private IFragmentCallBack mFragmentConnect;
	private TextView mCancel;
	private LinearLayout mWechat;
	private LinearLayout mFriends;
	private LinearLayout mMessage;
	private LinearLayout mCopy;
	private LinearLayout mShare;

	public ShareView(Context context) {
		this(context, null);
	}

	public ShareView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public ShareView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mContext = context;

		try {
			View view = LayoutInflater.from(mContext).inflate(
					R.layout.share_view, this);

			mCancel = (TextView) view.findViewById(R.id.btn_cancel);
			mWechat = (LinearLayout) view.findViewById(R.id.wechat_lay);
			mFriends = (LinearLayout) view.findViewById(R.id.friends_lay);
			mMessage = (LinearLayout) view.findViewById(R.id.message_lay);
			mCopy = (LinearLayout) view.findViewById(R.id.copy_lay);
			mShare = (LinearLayout) view.findViewById(R.id.share_lay);
			setListener();
		} catch (Exception e) {

		}
	}

	public void setIFragmentCallBack(IFragmentCallBack f) {
		mFragmentConnect = f;
	}

	private void setListener() {
		OnClickListener onClickLis = new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				int id = arg0.getId();
				switch (id) {
				case R.id.btn_cancel: {
					if (mFragmentConnect != null)
						mFragmentConnect.ShareViewCloseClick();
					break;
				}
				}
			}
		};
		mCancel.setOnClickListener(onClickLis);
	}

}
