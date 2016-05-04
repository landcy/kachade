package com.kachade.popview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kachade.callback.IFragmentCallBack;
import com.kachade.kcd.R;

//com.kachade.popview.SelectImage

public class ChatListView extends RelativeLayout {

	private Context mContext;
	private IFragmentCallBack mFragmentConnect;

	private LinearLayout mGroupLay;
	private LinearLayout mContractLay;
	private LinearLayout mRecevieLay;

	private Button mSync;
	private TextView mCancel;

	public ChatListView(Context context) {
		super(context);
		init(context);
	}

	public ChatListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public ChatListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);

	}

	private void init(Context context) {
		try {
			mContext = context;
			View view = LayoutInflater.from(mContext).inflate(
					R.layout.chat_list_view, this);

			mGroupLay = (LinearLayout) view.findViewById(R.id.group_lay);
			mContractLay = (LinearLayout) view.findViewById(R.id.contract_lay);
			mRecevieLay = (LinearLayout) view.findViewById(R.id.recevie_lay);

			mSync = (Button) view.findViewById(R.id.btn_sync);
			mCancel = (TextView) view.findViewById(R.id.btn_cancel);
			setLis();
		} catch (Exception e) {
		}
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

	private Drawable getDrawable(int id) {
		return mContext.getResources().getDrawable(id);
	}

	public void setIFragmentCallBack(IFragmentCallBack f) {
		mFragmentConnect = f;
	}

}
