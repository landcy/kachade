package com.kachade.adapter;

import java.util.HashMap;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.kachade.kcd.R;

public class SelectImageListAdapter extends BaseAdapter {
	private static final String TAG = "SelectImageListAdapter";
	private int mSize;
	private Context mContext;
	private int[] mIconIDs;
	private LayoutInflater mInflater;
	class ViewHolder {
		public ImageView mImage;
		public ImageView mCheck;
	}

	public SelectImageListAdapter(Context context, int[] ids) {
		this.mContext = context;
		this.mSize = ids.length;
		this.mIconIDs = ids;
		mInflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

	private View getImageView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.select_image_album_view,
					null);
			holder.mCheck = (ImageView) convertView
					.findViewById(R.id.select_iv);
			holder.mImage = (ImageView) convertView.findViewById(R.id.image_iv);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		try {
			holder.mImage.setImageDrawable(getDrawable(mIconIDs[position]));
		} catch (Exception e) {
			Log.e(TAG,
					"Position : " + position + "   Exception : "
							+ e.getMessage());
		}
		return convertView;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return getImageView(position, convertView, parent);
	}

	private Drawable getDrawable(int id) {
		return mContext.getResources().getDrawable(id);
	}

}
