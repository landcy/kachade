package com.kachade.kcd.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

import com.kachade.adapter.WhoBuyListAdapter;
import com.kachade.framework.app.BaseActivity;
import com.kachade.kcd.R;
import com.kachade.view.PageTiltleView;

public class WhoBuyActivity extends BaseActivity {
	private PageTiltleView mTilte;
	private ListView mList;
	private WhoBuyListAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_who_buy);
		mTilte = (PageTiltleView) this.findViewById(R.id.title);
		mList = (ListView) this.findViewById(R.id.listView);
		mAdapter = new WhoBuyListAdapter(this);
		mList.setAdapter(mAdapter);
		mList.setDividerHeight(1);
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