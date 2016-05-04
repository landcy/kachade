package com.kachade.kcd.Activity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;

import com.kachade.framework.app.BaseActivity;
import com.kachade.kcd.R;
import com.kachade.view.PageTiltleView;

public class LoginActivity extends BaseActivity {
	private static final String TAG = "LoginActivity";
	private PageTiltleView mTilte;
	private EditText mPhoneNum;
	private EditText mPassword;
	private TextView mPasswordReset;
	private TextView mRegister;
	private TextView mDone;
	private CheckBox mAutoLogin;

	private String mAccountPhoneNum;
	private String mAccountPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		mTilte = (PageTiltleView) this.findViewById(R.id.title);
		mPhoneNum = (EditText) this.findViewById(R.id.num_ed);
		mPassword = (EditText) this.findViewById(R.id.password_ed);
		mPasswordReset = (TextView) this.findViewById(R.id.password_reset);
		mRegister = (TextView) this.findViewById(R.id.register);
		mDone = (TextView) this.findViewById(R.id.btn_done);
		mAutoLogin = (CheckBox) this.findViewById(R.id.auto_login);
		setLis();

		mAccountPhoneNum = null;
		mAccountPassword = null;
		mPasswordReset.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
		mRegister.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
	}

	private void setLis() {
		OnClickListener onClickLis = new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				int id = arg0.getId();
				switch (id) {
				case R.id.back_iv:
					finish();
					break;
				case R.id.password_reset: {
					Intent intent = new Intent(LoginActivity.this,
							ResetPasswordActivity.class);
					startActivity(intent);
					break;
				}
				case R.id.register: {
					Intent intent = new Intent(LoginActivity.this,
							RegisterActivity.class);
					startActivity(intent);
					break;
				}
				case R.id.btn_done: {
					finish();
					break;
				}

				}
			}
		};

		mPhoneNum.addTextChangedListener(new TextWatcher() {
			@Override
			public void afterTextChanged(Editable s) {
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				mAccountPhoneNum = s.toString();
				mRegister.setText(mAccountPhoneNum);
			}

		});

		mPassword.addTextChangedListener(new TextWatcher() {
			@Override
			public void afterTextChanged(Editable s) {
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {

				mAccountPassword = s.toString();
				mDone.setText(mAccountPassword);

			}

		});
		mAutoLogin.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub
				if (arg1) {
					mPasswordReset.setText("自动登录");
				} else {
					mPasswordReset.setText("不自动登录");
				}
			}
		});
		mTilte.setBackListener(onClickLis);
		mPasswordReset.setOnClickListener(onClickLis);
		mRegister.setOnClickListener(onClickLis);
		mDone.setOnClickListener(onClickLis);
	}
}