package com.kachade.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kachade.kcd.R;

public class MyKcdItemView extends RelativeLayout {
	private int mMidTextColor = 0x262a2d;
	private Context mContext;
	private ImageView mRightIcon;
	private TextView mLeftText;
	private TextView mRightText;

	public MyKcdItemView(Context context) {
		this(context, null);
	}

	public MyKcdItemView(Context context, AttributeSet attrs) {
		this(context, attrs, R.attr.MK_LeftText);
	}

	public MyKcdItemView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mContext = context;
		TypedArray a = context.obtainStyledAttributes(attrs,
				R.styleable.My_Kcd_Item_View, defStyle, 0);
		String leftText = a.getString(R.styleable.My_Kcd_Item_View_MK_LeftText);
		String rightText = a
				.getString(R.styleable.My_Kcd_Item_View_MK_RightText);

		boolean rightTextVis = a.getBoolean(
				R.styleable.My_Kcd_Item_View_MK_RightTextVis, false);

		int textColor = a.getColor(
				R.styleable.My_Kcd_Item_View_MK_RightTextColor, mMidTextColor);
		a.recycle();

		View view = LayoutInflater.from(mContext).inflate(R.layout.my_kcd_item,
				this);

		mLeftText = (TextView) view.findViewById(R.id.left_tv);
		mRightText = (TextView) view.findViewById(R.id.right_tv);
		mRightIcon = (ImageView) view.findViewById(R.id.right_iv);

		mLeftText.setText(leftText);

		if (!rightTextVis)
			mRightText.setVisibility(View.INVISIBLE);
		else {
			mRightText.setVisibility(View.VISIBLE);
			mRightText.setText(rightText);
			mRightText.setTextColor(textColor);
		}

	}

	public void setLeftText(String text) {
		mLeftText.setText(text);
	}

	public void setRightText(String text) {
		mRightText.setText(text);
	}

	public void setRightClickListener(OnClickListener lis) {
		mRightIcon.setOnClickListener(lis);
	}

}
