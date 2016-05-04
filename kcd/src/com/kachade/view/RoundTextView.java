package com.kachade.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.kachade.kcd.R;
import com.kachade.view.HistoryListView.HistoryLis;

@SuppressLint({ "ResourceAsColor", "NewApi" })
public class RoundTextView extends TextView {
	private Context mContext;
	private HistoryLis mHistoryLis;
	private String mText;
	private Paint mPaint;

	public void setText0(String text) {
		mText = text;
	}

	public RoundTextView(Context context) {
		super(context);
		init(context);
	}

	public RoundTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public RoundTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mContext = context;
	}

	private void init(Context context) {
		mContext = context;
		this.setTextColor(this.getResources().getColor(R.color.font_black));
		this.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources()
				.getDimensionPixelSize(R.dimen.search_history_text_size));
		this.setBackground(getDrawable(R.drawable.text_bound_bg));
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaint.setStyle(Paint.Style.FILL);
		mPaint.setAntiAlias(true);// 去锯齿
		mPaint.setTextSize(this.getTextSize()); // 设置轴文字大小
		mPaint.setStrokeWidth(1);
		this.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (mHistoryLis != null) {
					mHistoryLis.onClick(mText);
				}
			}
		});
	}

	private Drawable getDrawable(int id) {
		return mContext.getResources().getDrawable(id);
	}

	public void setHistoryLis(HistoryLis lis) {
		mHistoryLis = lis;
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

}
