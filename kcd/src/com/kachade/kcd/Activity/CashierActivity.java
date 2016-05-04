package com.kachade.kcd.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.kachade.framework.app.BaseActivity;
import com.kachade.kcd.R;
import com.kachade.view.PageTiltleView;

public class CashierActivity extends BaseActivity {
	private PageTiltleView mTilte;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cashier);
		mTilte = (PageTiltleView) this.findViewById(R.id.title);

		setLis();
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
				}
			}
		};
		mTilte.setBackListener(onClickLis);
	}
}