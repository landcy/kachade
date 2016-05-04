package com.kachade.kcd.Activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import com.kachade.framework.app.BaseActivity;
import com.kachade.kcd.R;
import com.kachade.view.PageTiltleView;

public class ResetPasswordActivity extends BaseActivity {
	private PageTiltleView mTilte;
	private EditText mPhoneNumEditText;
	private EditText mIdentifyCodeEditText;

	private TextView mNext;
	private TextView mGain;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reset_password);
		mTilte = (PageTiltleView) this.findViewById(R.id.title);
		mPhoneNumEditText = (EditText) this.findViewById(R.id.num_ed);
		mIdentifyCodeEditText = (EditText) this.findViewById(R.id.identify_ed);

		mNext = (TextView) this.findViewById(R.id.btn_next);
		mGain = (TextView) this.findViewById(R.id.btn_gain);

		setLis();
	}

	private void setLis() {

		OnClickListener onClickLis = new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				int id = arg0.getId();
				switch (id) {
				case R.id.btn_next:
					break;
				case R.id.btn_gain:
					break;
				case R.id.back_iv:
					finish();
					break;
				}
			}
		};

		mPhoneNumEditText.addTextChangedListener(new TextWatcher() {
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

			}

		});
		mIdentifyCodeEditText.addTextChangedListener(new TextWatcher() {
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

			}

		});
		mNext.setOnClickListener(onClickLis);
		mGain.setOnClickListener(onClickLis);
		mTilte.setBackListener(onClickLis);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
