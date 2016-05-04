package com.kachade.popview;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.kachade.callback.IFragmentCallBack;
import com.kachade.kcd.R;

//com.kachade.popview.SelectImage

public class ChatListPopView {
	private PopupWindow popupWindow;
	private Context mContext;
	private IFragmentCallBack mFragmentConnect;

	private LinearLayout mGroupLay;
	private LinearLayout mContractLay;
	private LinearLayout mRecevieLay;

	private Button mSync;
	private TextView mCancel;

	public ChatListPopView(Context context) {
		mContext = context;
		initPopupWindow();
	}

	private void setLis() {
		OnClickListener clickLis = new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int id = arg0.getId();
				switch (id) {
				case R.id.group_lay:
					break;
				case R.id.contract_lay:
					break;
				case R.id.recevie_lay:
					break;
				case R.id.btn_sync:
					if (mFragmentConnect != null)
						mFragmentConnect.ChatListViewDoneClick();
					break;
				case R.id.btn_cancel:
					if (mFragmentConnect != null)
						mFragmentConnect.ChatListViewCloseClick();
					break;
				}
			}
		};

		mGroupLay.setOnClickListener(clickLis);
		mContractLay.setOnClickListener(clickLis);
		mRecevieLay.setOnClickListener(clickLis);
		mSync.setOnClickListener(clickLis);
		mCancel.setOnClickListener(clickLis);

	}

	public void setIFragmentCallBack(IFragmentCallBack f) {
		mFragmentConnect = f;
	}

	private void initPopupWindow() {
		View view = LayoutInflater.from(mContext).inflate(
				R.layout.chat_list_view, null);

		mGroupLay = (LinearLayout) view.findViewById(R.id.group_lay);
		mContractLay = (LinearLayout) view.findViewById(R.id.contract_lay);
		mRecevieLay = (LinearLayout) view.findViewById(R.id.recevie_lay);

		mSync = (Button) view.findViewById(R.id.btn_sync);
		mCancel = (TextView) view.findViewById(R.id.btn_cancel);
		popupWindow = new PopupWindow(view,
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		setLis();
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
