package com.kachade.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kachade.kcd.R;
import com.kachade.view.HistoryListView.HistoryLis;
import com.kachade.view.HotTopicListView.HotTopicLis;

@SuppressLint({ "ResourceAsColor", "NewApi" })
public class DoubleTextView extends LinearLayout {
	private Context mContext;
	private TextView mTextView1;
	private TextView mTextView2;
	private String mText1;
	private String mText2;
	private HotTopicLis mHotTopicLis;

	public DoubleTextView(Context context) {
		super(context);
		init(context);
	}

	public DoubleTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public DoubleTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	private void init(Context context) {
		mContext = context;
		View view = LayoutInflater.from(mContext).inflate(
				R.layout.double_text_view, this);
		mTextView1 = (TextView) view.findViewById(R.id.top1);
		mTextView2 = (TextView) view.findViewById(R.id.top2);
		mTextView1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (mHotTopicLis != null) {
					mHotTopicLis.onClick(mText1);
				}
			}
		});
		mTextView2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (mHotTopicLis != null) {
					mHotTopicLis.onClick(mText2);
				}
			}
		});
	}

	public void setText(String t1, String t2) {
		mTextView1.setText(t1);
		mTextView2.setText(t2);
		mText2 = t2;
		mText1 = t1;
	}

	public void setHotTopicLis(HotTopicLis lis) {
		mHotTopicLis = lis;
	}
}
