package com.kachade.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kachade.kcd.R;

public class SelectImageListAdapter1 extends BaseAdapter {
	private int mSize;
	private Context mContext;
	private LayoutInflater mInflater;
	private static final int CAMERA = 0x7f000000;
	private static final int IMAGE = 0x7f000001;

	class ViewHolder0 {
		public ImageView mImage;
		public TextView mText;
		public RelativeLayout mLay;

	}

	class ViewHolder1 {
		public ImageView mImage;
		public ImageView mCheck;
	}

	public SelectImageListAdapter1(Context context, int length) {
		this.mContext = context;
		this.mSize = length;
		mInflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);// LayoutInflater.from(mContext);
	}

	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		if (position == 0)
			return CAMERA;
		else
			return IMAGE;
	}

	@Override
	public int getCount() {
		return mSize;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder0 holder0 = null;
		ViewHolder1 holder1 = null;
		int type = getItemViewType(position);
		if (convertView == null)
			switch (type) {
			case CAMERA:
				holder0 = new ViewHolder0();
				convertView = mInflater.inflate(
						R.layout.select_image_camera_view, null);
//				holder0.mImage = (ImageView) convertView
//						.findViewById(R.id.image_iv);
//				holder0.mText = (TextView) convertView.findViewById(R.id.text);
//				holder0.mLay = (RelativeLayout) convertView
//						.findViewById(R.id.camera_lay);
//				convertView.setTag(CAMERA, holder0);
				break;
			case IMAGE:
				holder1 = new ViewHolder1();
				convertView = mInflater.inflate(
						R.layout.select_image_album_view, null);

//				holder1.mCheck = (ImageView) convertView
//						.findViewById(R.id.select_iv);
//				holder1.mImage = (ImageView) convertView
//						.findViewById(R.id.image_iv);
//				holder1.mCheck.setTag(0);
				convertView.setTag(IMAGE, holder1);
				break;
			}
		else {
			switch (type) {
			case CAMERA:
				holder0 = (ViewHolder0) convertView.getTag(CAMERA);
				break;
			case IMAGE:
				holder1 = (ViewHolder1) convertView.getTag(IMAGE);
				break;
			}
		}
//		switch (type) {
//		case CAMERA:
//			holder0.mLay.setOnClickListener(new OnClickListener() {
//
//				@Override
//				public void onClick(View arg0) {
//					// TODO Auto-generated method stub
//
//				}
//			});
//			break;
//		case IMAGE:
//			holder1.mCheck.setOnClickListener(new OnClickListener() {
//
//				@Override
//				public void onClick(View arg0) {
//					// TODO Auto-generated method stub
//
//				}
//			});
//			break;
//		}
		return convertView;

	}
}
