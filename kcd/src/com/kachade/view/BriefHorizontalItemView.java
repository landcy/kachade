package com.kachade.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kachade.kcd.R;

public class BriefHorizontalItemView extends RelativeLayout {
	private int mMidTextColor = 0x262a2d;
	private Context mContext;
	private CircleImageView mLeftIcon;
	private ImageView mRightIcon;
	private CircleImageView mMidIcon;
	private TextView mLeftText;
	private TextView mMidText;

	public BriefHorizontalItemView(Context context) {
		this(context, null);
	}

	public BriefHorizontalItemView(Context context, AttributeSet attrs) {
		this(context, attrs, R.attr.BH_MidText);
	}

	public BriefHorizontalItemView(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		mContext = context;
		TypedArray a = context.obtainStyledAttributes(attrs,
				R.styleable.Brief_horizontal_Item_View, defStyle, 0);
		String leftText = a
				.getString(R.styleable.Brief_horizontal_Item_View_BH_LeftText);
		String MidText = a
				.getString(R.styleable.Brief_horizontal_Item_View_BH_MidText);

		boolean midText = a.getBoolean(
				R.styleable.Brief_horizontal_Item_View_BH_MidTextVis, true);
		boolean leftIcon = a.getBoolean(
				R.styleable.Brief_horizontal_Item_View_BH_LeftIconVis, false);
		boolean midIcon = a.getBoolean(
				R.styleable.Brief_horizontal_Item_View_BH_MidIconVis, true);

		boolean rightIcon = a.getBoolean(
				R.styleable.Brief_horizontal_Item_View_BH_RightIconVis, true);

		Drawable mLeftDrawable = a
				.getDrawable(R.styleable.Brief_horizontal_Item_View_BH_LeftIconSrc);

		Drawable mMidDrawable = a
				.getDrawable(R.styleable.Brief_horizontal_Item_View_BH_MidIconSrc);

		int color = a.getColor(
				R.styleable.Brief_horizontal_Item_View_BH_MidTextColor,
				mMidTextColor);

		a.recycle();

		View view = LayoutInflater.from(mContext).inflate(
				R.layout.brief_horizontal_item, this);

		mLeftText = (TextView) view.findViewById(R.id.left_tv);
		mMidText = (TextView) view.findViewById(R.id.mid_tv);
		mLeftIcon = (CircleImageView) view.findViewById(R.id.left_iv);
		mRightIcon = (ImageView) view.findViewById(R.id.right_iv);
		mMidIcon = (CircleImageView) view.findViewById(R.id.mid_iv);

		mLeftText.setText(leftText);

		if (!midText)
			mMidText.setVisibility(View.INVISIBLE);
		else {
			mMidText.setVisibility(View.VISIBLE);
			mMidText.setText(MidText);
			mMidText.setTextColor(color);
		}

		if (!leftIcon)
			mLeftIcon.setVisibility(View.GONE);
		else {
			mLeftIcon.setVisibility(View.VISIBLE);
			mLeftIcon.setImageDrawable(mLeftDrawable);
		}
		if (!midIcon)
			mMidIcon.setVisibility(View.INVISIBLE);
		else {
			mMidIcon.setVisibility(View.VISIBLE);
			mMidIcon.setImageDrawable(mMidDrawable);
		}

		if (!rightIcon)
			mRightIcon.setVisibility(View.INVISIBLE);
		else
			mRightIcon.setVisibility(View.VISIBLE);
	}

	public void setLeftText(String text) {
		mLeftText.setText(text);
	}

	public void setMidText(String text) {
		mMidText.setText(text);
	}

	public void setRightClickListener(OnClickListener lis) {
		mRightIcon.setOnClickListener(lis);
	}

}
