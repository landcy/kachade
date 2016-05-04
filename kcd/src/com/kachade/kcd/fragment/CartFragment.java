package com.kachade.kcd.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;

import com.kachade.adapter.HorizontalListViewAdapter;
import com.kachade.framework.app.BaseFragment;
import com.kachade.kcd.R;
import com.kachade.view.HorizontalListView;

public class CartFragment extends BaseFragment {
	private static CartFragment mInstance;
	private Context mContext;

	public static CartFragment getInstance() {
		if (mInstance == null)
			mInstance = new CartFragment();
		return mInstance;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mContext = getActivity();

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_cart, null);
		initView(view);
		return view;
	}

	private void initView(View view) {

	}

}
