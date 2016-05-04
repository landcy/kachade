package com.kachade.kcd.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.kachade.adapter.DiscoveryProductAdapter;
import com.kachade.adapter.HorizontalListViewAdapter;
import com.kachade.framework.app.BaseFragment;
import com.kachade.kcd.R;

public class DiscoveryFragment extends BaseFragment {
	private static DiscoveryFragment mInstance;
	private Context mContext;
	private ListView mList;
	private DiscoveryProductAdapter mAdapter;

	public static DiscoveryFragment getInstance() {
		if (mInstance == null)
			mInstance = new DiscoveryFragment();
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
		View view = inflater.inflate(R.layout.fragment_discovery, null);
		initView(view);
		return view;
	}

	private void initView(View view) {
		mList = (ListView) view.findViewById(R.id.listView);
		mAdapter = new DiscoveryProductAdapter(mContext);
		mList.setAdapter(mAdapter);
		mList.setDividerHeight(0);

	}

}
