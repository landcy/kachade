package com.kachade.kcd.Activity;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kachade.Dao.HistoryDbController;
import com.kachade.framework.app.BaseActivity;
import com.kachade.kcd.R;
import com.kachade.view.HistoryListView;
import com.kachade.view.HotTopicListView;

public class SearchActivity extends BaseActivity {
	private LinearLayout mHisLay;
	private View mHisLayGap;
	private LinearLayout mTopLay;
	private EditText mSearchEditText;
	private TextView mCancle;
	private HistoryListView mHistory;
	private HotTopicListView mTop;
	private TextView mClean;
	private String mSearchText;

	private List<String> mHisKeyWords;

	private HistoryDbController mHisDb;

	private ClickLis mClickLis = new ClickLis() {

		@Override
		public void HistoryClick(String text) {
			// TODO Auto-generated method stub
			mSearchEditText.setText(text);
			mSearchText = text;
		}

		@Override
		public void HotTopicClick(String text) {
			// TODO Auto-generated method stub
			mSearchEditText.setText(text);
			mSearchText = text;
		}
	};

	public interface ClickLis {
		void HistoryClick(String text);

		void HotTopicClick(String text);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		mHisLayGap = (View) this.findViewById(R.id.history_lay_gap);

		mTopLay = (LinearLayout) this.findViewById(R.id.hottopic_lay);
		mHisLay = (LinearLayout) this.findViewById(R.id.history_lay);
		mHistory = (HistoryListView) this.findViewById(R.id.history);
		mTop = (HotTopicListView) this.findViewById(R.id.hot);
		mSearchEditText = (EditText) this.findViewById(R.id.search_ed);
		mCancle = (TextView) this.findViewById(R.id.search_tv);
		mClean = (TextView) this.findViewById(R.id.clean_btn);
		mSearchText = "";

		mHisDb = new HistoryDbController();
		showHistoryLay();
		setLis();
	}

	private void showHistoryLay() {
		mHisKeyWords = mHisDb.getKeyWords();
		if (mHisKeyWords != null && mHisKeyWords.size() > 0) {
			showHistoryLay(true);
			mHistory.setHistories(mHisKeyWords);
		} else
			showHistoryLay(false);
	}

	private void showHistoryLay(boolean isShow) {
		if (isShow) {
			mHisLay.setVisibility(View.VISIBLE);
			mHisLayGap.setVisibility(View.VISIBLE);
		} else {
			mHisLay.setVisibility(View.GONE);
			mHisLayGap.setVisibility(View.GONE);
		}
	}

	private void setLis() {
		mSearchEditText.addTextChangedListener(new TextWatcher() {
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
				mSearchText = s.toString();
			}

		});
		mSearchEditText
				.setOnEditorActionListener(new TextView.OnEditorActionListener() {
					public boolean onEditorAction(TextView v, int actionId,
							KeyEvent event) {
						if (actionId == EditorInfo.IME_ACTION_SEND
								|| (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
							mHisDb.insertKeyWords(mSearchText);
							// showHistoryLay();
							finish();
							return true;
						}
						return false;
					}
				});

		mCancle.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// Intent intent = new Intent();
				// setResult(RESULT_OK, intent);
				finish();
			}
		});
		mClean.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				mHisDb.deleteKeyWords();
				mHisLay.setVisibility(View.GONE);
				mHisLayGap.setVisibility(View.GONE);
			}
		});

		mTop.setClickLis(mClickLis);
		mHistory.setClickLis(mClickLis);
		mTop.reDrawLayout();
		mHistory.reDrawLayout();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
