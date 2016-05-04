package com.kachade.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.kachade.kcd.R;
import com.kachade.popview.SelectImage.SelectImageCallBack;

public class SelectImageListAdapter2 extends BaseAdapter {
	private static final String TAG = "SelectImageListAdapter";
	private int mSize;
	private Context mContext;
	private int[] mIconIDs;
	private LayoutInflater mInflater;
	private static final int CAMERA_KEY = 0x7F000000;
	private static final int IMAGE_KEY = 0x7F000001;
	private static final int CAMERA_TYPE = 0;
	private static final int IMAGE_TYPE = 1;

	private static final int CHECK_INDEX_KEY = 0x7f000002;
	private static final int CHECK_FLAG_KEY = 0x7f000003;

	private int MAX_NUM = 5;
	private SelectImageCallBack mSelectCalBack;

	private int mSelectNum = 0;

	class CameraHolder {
		public RelativeLayout mLay;
	}

	class ViewHolder {
		public ImageView mImage;
		public ImageView mCheck;
	}

	public SelectImageListAdapter2(Context context, int[] ids) {
		this.mContext = context;
		this.mSize = ids.length;
		this.mIconIDs = ids;
		mInflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);// LayoutInflater.from(mContext);
	}

	public void setSelectCallBack(SelectImageCallBack callback) {
		mSelectCalBack = callback;
	}

	public void setMaxSelectNum(int num) {
		this.MAX_NUM = num;
	}

	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		if (position == 0)
			return CAMERA_TYPE;
		else
			return IMAGE_TYPE;
	}

	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 2;
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

	private View getCameraView(View convertView, ViewGroup parent) {
		CameraHolder holder = null;
		if (convertView == null) {
			holder = new CameraHolder();
			convertView = mInflater.inflate(R.layout.select_image_camera_view,
					null);

			holder.mLay = (RelativeLayout) convertView
					.findViewById(R.id.camera_lay);
			convertView.setTag(CAMERA_KEY, holder);
		} else {
			holder = (CameraHolder) convertView.getTag(CAMERA_KEY);

		}
		holder.mLay.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

			}
		});
		return convertView;
	}

	private View getImageView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.select_image_album_view,
					null);

			holder.mCheck = (ImageView) convertView
					.findViewById(R.id.select_iv);
			holder.mImage = (ImageView) convertView.findViewById(R.id.image_iv);
			holder.mCheck.setTag(CHECK_INDEX_KEY, position);
			holder.mCheck.setTag(CHECK_FLAG_KEY, 0);
			convertView.setTag(IMAGE_KEY, holder);
		} else {
			holder = (ViewHolder) convertView.getTag(IMAGE_KEY);
		}
		try {
			holder.mImage.setImageDrawable(getDrawable(mIconIDs[position]));
			if ((Integer) holder.mCheck.getTag(CHECK_FLAG_KEY) == 0)
				holder.mCheck
						.setImageDrawable(getDrawable(R.drawable.btn_un_chose));
			else
				holder.mCheck
						.setImageDrawable(getDrawable(R.drawable.btn_selected));

			holder.mCheck.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					ImageView view = (ImageView) arg0;
					int flag = (Integer) view.getTag(CHECK_FLAG_KEY);
					if (flag == 0) {
						if (addSelect()) {
							view.setTag(CHECK_FLAG_KEY, 1);
							view.setImageDrawable(getDrawable(R.drawable.btn_selected));
						}
					} else if (minusSelect()) {
						view.setTag(CHECK_FLAG_KEY, 0);
						view.setImageDrawable(getDrawable(R.drawable.btn_un_chose));
					}
				}
			});
		} catch (Exception e) {
			Log.e(TAG,
					"Position : " + position + "   Exception : "
							+ e.getMessage());
		}
		return convertView;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// int type = getItemViewType(position);
		// switch (type) {
		// case CAMERA_TYPE:
		// return getCameraView(convertView, parent);
		// case IMAGE_TYPE:
		return getImageView(position, convertView, parent);
		// }
		// return convertView;
	}

	private boolean addSelect() {
		if (mSelectNum >= this.MAX_NUM)
			return false;
		mSelectNum++;
		mSelectCalBack.selectNum(mSelectNum);
		return true;
	}

	private boolean minusSelect() {
		if (mSelectNum <= 0)
			return false;
		mSelectNum--;
		mSelectCalBack.selectNum(mSelectNum);
		return true;

	}

	private Drawable getDrawable(int id) {
		return mContext.getResources().getDrawable(id);
	}

}
