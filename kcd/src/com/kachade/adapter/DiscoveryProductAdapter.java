package com.kachade.adapter;

import com.kachade.kcd.R;
import com.kachade.util.BitmapUtil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DiscoveryProductAdapter extends BaseAdapter {
	private Context mContext;
	private LayoutInflater mInflater;
	private int size = 10;

	public DiscoveryProductAdapter(Context context) {
		this.mContext = context;
		mInflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);// LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		return size;
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

		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.discovery_item, null);
			holder.feature = (TextView) convertView
					.findViewById(R.id.feature_iv);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.feature.setText("原创&广播");
		return convertView;
	}

	private static class ViewHolder {
		TextView feature;
	}

}
