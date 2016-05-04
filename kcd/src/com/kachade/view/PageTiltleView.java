package com.kachade.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kachade.kcd.R;
import com.kachade.kcd.Activity.MainActivity;
import com.kachade.kcd.Activity.SearchActivity;

public class PageTiltleView extends RelativeLayout {
	private Context mContext;
	private ImageView mBack;
	private TextView mTitle;
	private ImageView mSearch;
	private int mPageId = -1;

	public PageTiltleView(Context context) {
		this(context, null);
	}

	public PageTiltleView(Context context, AttributeSet attrs) {
		this(context, attrs, R.attr.MidText);
	}

	public PageTiltleView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mContext = context;
		TypedArray a = context.obtainStyledAttributes(attrs,
				R.styleable.Page_Title_View, defStyle, 0);// �������ļ��л�ȡ�������
		CharSequence text = a.getText(R.styleable.Page_Title_View_MidText);

		boolean left = a.getBoolean(R.styleable.Page_Title_View_LeftVis, true);
		boolean right = a
				.getBoolean(R.styleable.Page_Title_View_RightVis, true);
		a.recycle();
		View view = LayoutInflater.from(mContext).inflate(
				R.layout.page_title_view, this);

		mTitle = (TextView) view.findViewById(R.id.title_tv);
		mSearch = (ImageView) view.findViewById(R.id.search_iv);
		mBack = (ImageView) view.findViewById(R.id.back_iv);
		if (text != null && text.length() > 0)
			mTitle.setText(text);
		if (!left)
			mBack.setVisibility(View.INVISIBLE);
		else
			mBack.setVisibility(View.VISIBLE);

		if (!right)
			mSearch.setVisibility(View.INVISIBLE);
		else
			mSearch.setVisibility(View.VISIBLE);
		// mTitle.setText("haha");
		setSearchListener();
	}

	public void setTitle(String text) {
		mTitle.setText(text);
	}

	public void setSearchListener(OnClickListener lis) {
		mSearch.setOnClickListener(lis);
	}

	public void setBackListener(OnClickListener lis) {
		mBack.setOnClickListener(lis);
	}

	public void setSearchListener(int id) {
		mPageId = id;
		mSearch.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(mContext, SearchActivity.class);
				mContext.startActivity(intent);
			}
		});
	}

	private void setSearchListener() {
		mSearch.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(mContext, SearchActivity.class);
				mContext.startActivity(intent);
			}
		});
	}

}
