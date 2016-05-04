package com.kachade.view;

//com.kachade.view.HistoryListView
import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.kachade.kcd.R;
import com.kachade.kcd.Activity.SearchActivity.ClickLis;

@SuppressLint({ "NewApi", "ResourceAsColor" })
public class HistoryListView extends RelativeLayout {
	private Context mContext;
	private static final int mMaxHistorySize = 10;
	private static final int mIDs = 0x7f000000;
	private List<String> mHistory;

	private static final float LEFTMARGIN = 5.0f;
	private static final float TOPMARGIN = 5.0f;
	private static final float PAGEMARGIN = 10.0F;
	private int mLeftMargin = 5;
	private int mTopMargin = 5;
	private Paint mPaint;
	private int mWidth = 0;
	private int mHeight = 0;
	private boolean mIsDraw = false;

	interface HistoryLis {
		void onClick(String text);
	}

	private ClickLis mClickLis;
	private HistoryLis mHistoryLis = new HistoryLis() {

		@Override
		public void onClick(String text) {
			// TODO Auto-generated method stub
			Log.e("nana", "HistoryListView " + text);
			if (mClickLis != null)
				mClickLis.HistoryClick(text);
		}

	};

	public void setClickLis(ClickLis lis) {
		mClickLis = lis;
	}

	public HistoryListView(Context context) {
		super(context);
		init(context);
	}

	public HistoryListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public HistoryListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	private void init(Context context) {
		mHistory = new ArrayList<String>();
		mContext = context;
		mLeftMargin = dip2px(LEFTMARGIN);
		mTopMargin = dip2px(TOPMARGIN);

		Resources r = getResources();
		TypedValue tv = new TypedValue();
		r.getValue(R.dimen.search_history_text_size, tv, true);
		float textSize = r.getDimension(R.dimen.search_history_text_size);

		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaint.setStyle(Paint.Style.FILL);
		mPaint.setAntiAlias(true);
		mPaint.setTextSize(textSize);
		mPaint.setStrokeWidth(1);

		WindowManager wm = (WindowManager) mContext
				.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		mWidth = size.x;
		mHeight = size.y;
		reDraw();
	}

	public void setHistories(List<String> lis) {
		mHistory.clear();
		mHistory = new ArrayList<String>(lis);
	}

	public void reDrawLayout() {
		if (mIsDraw) {
			this.removeAllViewsInLayout();
			mIsDraw = false;
		}
		reDraw();
	}

	private void reDraw() {
		if (mHistory == null || mHistory.size() <= 0)
			return;
		float width = 0;
		float temp = 0;
		int len = Math.min(mMaxHistorySize, mHistory.size());
		width = ReLayout(mHistory.get(0), 0);
		int preLeftId = 0;
		int preAboveId = 0;
		int fullWidth = mWidth;
		fullWidth -= dip2px(PAGEMARGIN) + dip2px(PAGEMARGIN);
		for (int i = 1; i < len; i++) {
			temp = TestReLayoutRightOf(mHistory.get(i));
			if (width + temp < fullWidth) {
				width += temp;
				ReLayoutRightOf(mHistory.get(i), i, preLeftId);
				preLeftId = i;
			} else {
				width = temp;
				ReLayoutBelow(mHistory.get(i), i, preAboveId);
				preLeftId = i;
				preAboveId = i;
			}
		}
		mIsDraw = true;
	}

	private float ReLayout(String tt, int id) {
		RoundTextView trt = new RoundTextView(mContext);
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
		lp.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
		trt.setText(tt);
		trt.setText0(tt);
		trt.setLayoutParams(lp);
		trt.setId(id + mIDs);
		trt.setHistoryLis(mHistoryLis);
		this.addView(trt);
		return measure(tt);
	}

	private float TestReLayoutRightOf(String tt) {
		return measure(tt) + mLeftMargin;
	}

	private float measure(String text) {
		return mPaint.measureText(text + "a");
	}

	private void ReLayoutRightOf(String tt, int id, int preId) {
		RoundTextView trt = new RoundTextView(mContext);
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		lp.addRule(RelativeLayout.RIGHT_OF, preId + mIDs);
		lp.addRule(RelativeLayout.ALIGN_BOTTOM, preId + mIDs);
		lp.leftMargin = mLeftMargin;
		trt.setText(tt);
		trt.setText0(tt);
		trt.setLayoutParams(lp);
		trt.setId(id + mIDs);
		trt.setHistoryLis(mHistoryLis);
		this.addView(trt);
	}

	private void ReLayoutBelow(String tt, int id, int preId) {
		RoundTextView trt = new RoundTextView(mContext);
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		lp.addRule(RelativeLayout.BELOW, preId + mIDs);
		lp.topMargin = mTopMargin;
		trt.setText(tt);
		trt.setText0(tt);
		trt.setHistoryLis(mHistoryLis);
		trt.setLayoutParams(lp);
		this.addView(trt);
		trt.setId(id + mIDs);
	}

	public int dip2px(float dpValue) {
		final float scale = mContext.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

}
