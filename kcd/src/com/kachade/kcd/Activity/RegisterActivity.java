package com.kachade.kcd.Activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.kachade.framework.app.BaseActivity;
import com.kachade.kcd.R;
import com.kachade.view.PageTiltleView;

public class RegisterActivity extends BaseActivity {
	private PageTiltleView mTilte;
	private TextView mDoneBtn;
	private EditText mPhoneNumEditText;
	private EditText mIdentifyEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		mTilte = (PageTiltleView) this.findViewById(R.id.title);
		mPhoneNumEditText = (EditText) this.findViewById(R.id.num_ed);
		mIdentifyEditText = (EditText) this.findViewById(R.id.identify_ed);
		mDoneBtn = (TextView) this.findViewById(R.id.btn_done);
		setLis();
	}

	private void setLis() {
		OnClickListener onClickLis = new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				int id = arg0.getId();
				switch (id) {

				case R.id.back_iv: {
					finish();
					break;
				}
				case R.id.btn_done: {
					finish();
					break;
				}
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
		mIdentifyEditText.addTextChangedListener(new TextWatcher() {
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
		mDoneBtn.setOnClickListener(onClickLis);
		mTilte.setBackListener(onClickLis);
	}
}