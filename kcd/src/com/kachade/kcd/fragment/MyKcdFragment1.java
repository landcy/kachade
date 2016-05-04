package com.kachade.kcd.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.kachade.framework.app.BaseFragment;
import com.kachade.kcd.R;
import com.kachade.kcd.Activity.AccountInfoActivity;
import com.kachade.kcd.Activity.AddressManagerActivity;
import com.kachade.kcd.Activity.CashierActivity;
import com.kachade.kcd.Activity.NewAddressActivity;
import com.kachade.kcd.Activity.RecevierActivity;
import com.kachade.kcd.Activity.RegisterActivity;
import com.kachade.kcd.Activity.ResetPasswordActivity;
import com.kachade.kcd.Activity.WhoBuyActivity;

public class MyKcdFragment1 extends BaseFragment {
	private static MyKcdFragment1 mInstance;
	private Context mContext;
	private Button mBtn;
	private Button mBtn1;
	private Button mBtn2;
	private Button mBtn3;
	private Button mBtn4;
	private Button mBtn5;
	private Button mBtn6;
	private Button mBtn7;

	public static MyKcdFragment1 getInstance() {
		if (mInstance == null)
			mInstance = new MyKcdFragment1();
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
		View view = inflater.inflate(R.layout.fragment_my_kcd1, null);
		initView(view);
		return view;
	}

	private void initView(View view) {
		mBtn = (Button) view.findViewById(R.id.btn);
		mBtn1 = (Button) view.findViewById(R.id.btn1);
		mBtn2 = (Button) view.findViewById(R.id.btn2);
		mBtn3 = (Button) view.findViewById(R.id.btn3);
		mBtn4 = (Button) view.findViewById(R.id.btn4);
		mBtn5 = (Button) view.findViewById(R.id.btn5);
		mBtn6 = (Button) view.findViewById(R.id.btn6);
		mBtn7 = (Button) view.findViewById(R.id.btn7);
		OnClickListener onClickLis = new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int id = arg0.getId();
				switch (id) {
				case R.id.btn: {
					Intent intent = new Intent(mContext,
							AccountInfoActivity.class);
					startActivity(intent);
					break;
				}

				case R.id.btn1: {
					Intent intent = new Intent(mContext,
							NewAddressActivity.class);
					startActivity(intent);
					break;
				}
				case R.id.btn2: {
					Intent intent = new Intent(mContext,
							ResetPasswordActivity.class);
					startActivity(intent);
					break;
				}
				case R.id.btn3: {
					Intent intent = new Intent(mContext, RegisterActivity.class);
					startActivity(intent);
					break;
				}

				case R.id.btn4: {
					Intent intent = new Intent(mContext,
							AddressManagerActivity.class);
					startActivity(intent);
					break;
				}
				case R.id.btn5: {
					Intent intent = new Intent(mContext, WhoBuyActivity.class);
					startActivity(intent);
					break;
				}
				case R.id.btn6: {
					Intent intent = new Intent(mContext, CashierActivity.class);
					startActivity(intent);
					break;
				}
				case R.id.btn7: {
					Intent intent = new Intent(mContext, RecevierActivity.class);
					startActivity(intent);
					break;
				}

				}
			}
		};

		mBtn.setOnClickListener(onClickLis);
		mBtn1.setOnClickListener(onClickLis);
		mBtn2.setOnClickListener(onClickLis);
		mBtn3.setOnClickListener(onClickLis);
		mBtn4.setOnClickListener(onClickLis);
		mBtn5.setOnClickListener(onClickLis);
		mBtn6.setOnClickListener(onClickLis);
		mBtn7.setOnClickListener(onClickLis);
	}

}
