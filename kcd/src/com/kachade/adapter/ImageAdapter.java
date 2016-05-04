package com.kachade.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.kachade.image.ImageWorker;
import com.kachade.kcd.R;

/**
 * Created with IntelliJ IDEA. User: tc Date: 13-7-9 Time: 上午9:57
 */
public class ImageAdapter extends BaseAdapter {
	private ImageWorker imageWorker;

	private HashMap<Long, Boolean> seletedMap = new HashMap<Long, Boolean>();
	private ArrayList<Long> origIdArray = new ArrayList<Long>();

	private LayoutInflater mInflater;

	public ImageAdapter(ImageWorker imageWorker, Context context) {
		this.imageWorker = imageWorker;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return origIdArray.size();
	}

	@Override
	public Object getItem(int position) {
		return origIdArray.get(position);
	}

	@Override
	public long getItemId(int position) {
		return origIdArray.get(position);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(
					R.layout.category_product_image_view, parent, false);

			holder = new ViewHolder();
			holder.img = (ImageView) convertView
					.findViewById(R.id.product_price_tv);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		final long origId = origIdArray.get(position);

		// 加载图片
		// imageWorker.loadImage(origId, holder.img);
		return convertView;
	}

	public ImageAdapter putSelectMap(Long origId, Boolean isChecked) {
		seletedMap.put(origId, isChecked);
		return this;
	}

	public ImageAdapter setOrigIdArray(ArrayList<Long> origIdArray) {
		this.origIdArray = origIdArray;
		return this;
	}

	public static class ViewHolder {
		ImageView img;
	}
}
