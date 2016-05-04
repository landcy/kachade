package com.kachade.kcd.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.kachade.framework.app.BaseFragment;
import com.kachade.kcd.R;
import com.kachade.kcd.Activity.AccountInfoActivity;
import com.kachade.kcd.Activity.LoginActivity;
import com.kachade.kcd.Activity.NewAddressActivity;
import com.kachade.kcd.Activity.RecevierActivity;
import com.kachade.kcd.Activity.RegisterActivity;
import com.kachade.kcd.Activity.ResetPasswordActivity;
import com.kachade.kcd.Activity.WhoBuyActivity;
import com.kachade.sharepreference.SP_AppStatus;
import com.kachade.view.MyKcdItemView;

public class MyKcdFragment extends BaseFragment {
	private static MyKcdFragment mInstance;
	private Context mContext;
	private MyKcdItemView mOrders;
	private MyKcdItemView mPics;
	private MyKcdItemView mMessage2Me;
	private MyKcdItemView mMessage2Other;
	private MyKcdItemView mRecevier;
	private RelativeLayout mAccountLay;

	public static MyKcdFragment getInstance() {
		if (mInstance == null)
			mInstance = new MyKcdFragment();
		return mInstance;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mContext = getActivity();

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_my_kcd, null);
		initView(view);
		return view;
	}

	private void initView(View view) {
		mOrders = (MyKcdItemView) view.findViewById(R.id.my_orders);
		mMessage2Me = (MyKcdItemView) view.findViewById(R.id.m2m);
		mMessage2Other = (MyKcdItemView) view.findViewById(R.id.m2o);
		mPics = (MyKcdItemView) view.findViewById(R.id.my_pictures);
		mRecevier = (MyKcdItemView) view.findViewById(R.id.my_receiver);

		mAccountLay = (RelativeLayout) view.findViewById(R.id.account_lay);

		mMessage2Me.setLeftText("@我的");
		mMessage2Other.setLeftText("我@的");
		checkAccountStatus();
		setLis();

	}

	private void checkAccountStatus() {
		if (!SP_AppStatus.isLogin()) {
			if (!SP_AppStatus.isAutoLogin()) {
				Intent intent = new Intent(mContext, LoginActivity.class);
				startActivity(intent);
			}
		}

	}

	private void setLis() {
		OnClickListener onClickLis = new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int id = arg0.getId();
				switch (id) {
				case R.id.account_lay: {
					Intent intent = new Intent(mContext,
							AccountInfoActivity.class);
					startActivity(intent);
					break;
				}
				case R.id.my_orders: {
					Intent intent = new Intent(mContext, WhoBuyActivity.class);
					startActivity(intent);
					break;
				}

				case R.id.m2m: {
					Intent intent = new Intent(mContext,
							NewAddressActivity.class);
					startActivity(intent);
					break;
				}
				case R.id.m2o: {
					Intent intent = new Intent(mContext, RegisterActivity.class);
					startActivity(intent);
					break;
				}
				case R.id.my_pictures: {
					Intent intent = new Intent(mContext,
							ResetPasswordActivity.class);
					startActivity(intent);
					break;
				}
				case R.id.my_receiver: {
					Intent intent = new Intent(mContext, RecevierActivity.class);
					startActivity(intent);
					break;
				}
				}
			}
		};
		mAccountLay.setOnClickListener(onClickLis);
		mOrders.setOnClickListener(onClickLis);
		mMessage2Me.setOnClickListener(onClickLis);
		mMessage2Other.setOnClickListener(onClickLis);
		mPics.setOnClickListener(onClickLis);
		mRecevier.setOnClickListener(onClickLis);
	}

}
