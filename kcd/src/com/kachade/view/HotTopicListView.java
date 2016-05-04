package com.kachade.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

import com.kachade.kcd.Activity.SearchActivity.ClickLis;

@SuppressLint({ "NewApi", "ResourceAsColor" })
public class HotTopicListView extends RelativeLayout {
	private Context mContext;
	private ClickLis mClickLis;
	private static final int mIDs = 0x6f000000;
	private boolean mIsDraw = false;
	private static final int mMaxHotTopicSize = 3 * 2;
	private String[] mTopics = { "孙中山", "故居", "纪念馆", "位于", "广东省", "中山市", "翠亨村",
			"南、北、西", "三面环山", "东临珠江口", "城区20公里" };
	private HotTopicLis mHotTopicLis = new HotTopicLis() {

		@Override
		public void onClick(String text) {
			// TODO Auto-generated method stub
			if (mClickLis != null) {
				mClickLis.HotTopicClick(text);
			}
		}
	};

	interface HotTopicLis {
		void onClick(String text);
	}

	public void setClickLis(ClickLis lis) {
		mClickLis = lis;
	}

	public HotTopicListView(Context context) {
		super(context);
		init(context);
	}

	public HotTopicListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public HotTopicListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	private void init(Context context) {
		mContext = context;
		reDraw();
	}

	public void setTopics(String[] lis) {
		mTopics = lis;

	}

	public void reDrawLayout() {
		if (mIsDraw) {
			this.removeAllViewsInLayout();
			mIsDraw = false;
		}
		reDraw();
	}

	public void reDraw() {
		if (mTopics == null || mTopics.length <= 0)
			return;
		int len = Math.min(((int) mTopics.length / 2), mMaxHotTopicSize / 2);
		Log.e("nana", "len " + len);
		ReLayout(mTopics[0], mTopics[1], 0);
		int preId = 0;
		for (int i = 1; i < len; i++) {
			ReLayout(mTopics[2 * i], mTopics[2 * i + 1], i, preId);
			preId = i;
		}
		mIsDraw = true;
	}

	private void ReLayout(String tt1, String tt2, int id) {
		DoubleTextView trt = new DoubleTextView(mContext);
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
		lp.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
		trt.setText(tt1, tt2);
		trt.setLayoutParams(lp);
		trt.setId(id + mIDs);
		trt.setHotTopicLis(mHotTopicLis);
		this.addView(trt);

	}

	private void ReLayout(String tt1, String tt2, int id, int preId) {
		DoubleTextView trt = new DoubleTextView(mContext);
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		lp.addRule(RelativeLayout.BELOW, preId + mIDs);
		trt.setText(tt1, tt2);
		trt.setLayoutParams(lp);
		trt.setId(id + mIDs);
		trt.setHotTopicLis(mHotTopicLis);
		this.addView(trt);
	}

	public int dip2px(float dpValue) {
		final float scale = mContext.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

}
