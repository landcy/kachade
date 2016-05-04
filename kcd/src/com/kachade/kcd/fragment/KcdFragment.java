package com.kachade.kcd.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.kachade.adapter.HorizontalListViewAdapter;
import com.kachade.callback.IFragmentCallBack;
import com.kachade.framework.app.BaseFragment;
import com.kachade.kcd.R;
import com.kachade.kcd.Activity.SearchActivity;
import com.kachade.view.CircleImageView;
import com.kachade.view.HorizontalListView;

public class KcdFragment extends BaseFragment {
	private static String TAG = "KcdFragment";
	public static int REQUSET = 1;
	private String[] mTitles = { "孙中山0", "故居1", "纪念馆2", "位于3", "广东省4", "中山市5",
			"翠亨村6", "南、北、西7", "三面环山8", "东临珠江口9" };
	private final int[] mIds = { R.drawable.image0, R.drawable.image1,
			R.drawable.image2, R.drawable.image3, R.drawable.image4,
			R.drawable.image5, R.drawable.image6, R.drawable.image7,
			R.drawable.image8, R.drawable.image9 };
	private Context mContext;
	private HorizontalListView mHListView;
	private HorizontalListViewAdapter mHListViewAdapter;
	private ImageView previewImg;
	private EditText mSearchEditText;
	private ImageView mSearchIcon;
	private Button mChatMessage;
	private Button mShare;
	private Button mAdd2Chart;
	private Button mBuy;
	public boolean mTouch2Search = false;
	public long mLastTouch2Search = 0;

	private static KcdFragment mInstance;
	private CircleImageView mAlbums;
	private IFragmentCallBack mFragmentConnect;

	public static KcdFragment getInstance() {
		if (mInstance == null)
			mInstance = new KcdFragment();
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
		View view = inflater.inflate(R.layout.fragment_kcd, null);
		initView(view);
		return view;
	}

	private void initView(View view) {
		mSearchEditText = (EditText) view.findViewById(R.id.search_ed);
		mSearchIcon = (ImageView) view.findViewById(R.id.search_iv);
		mAlbums = (CircleImageView) view.findViewById(R.id.photo_edit);

		mHListView = (HorizontalListView) view
				.findViewById(R.id.horizon_listview);
		previewImg = (ImageView) view.findViewById(R.id.image_preview);

		mChatMessage = (Button) view.findViewById(R.id.btn_chat_message);
		mShare = (Button) view.findViewById(R.id.btn_share);
		mAdd2Chart = (Button) view.findViewById(R.id.btn_add2chart);
		mBuy = (Button) view.findViewById(R.id.btn_buy);

		mChatMessage.setText("@ta");

		mHListViewAdapter = new HorizontalListViewAdapter(mContext, mTitles,
				mIds);
		mHListView.setAdapter(mHListViewAdapter);
		setListener();
		previewImg.setImageResource(mIds[0]);

	}

	private void setListener() {
		OnTouchListener touch2search = new OnTouchListener() {
			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
				if (!mTouch2Search) {
					mLastTouch2Search = System.currentTimeMillis();
					mTouch2Search = true;
					Intent intent = new Intent(mContext, SearchActivity.class);
					startActivity(intent);
				} else if (System.currentTimeMillis() - mLastTouch2Search > 1 * 1000) {
					mLastTouch2Search = System.currentTimeMillis();
					mTouch2Search = true;
					Intent intent = new Intent(mContext, SearchActivity.class);
					startActivity(intent);
				}
				return true;
			}
		};

		mSearchEditText.setOnTouchListener(touch2search);
		mSearchIcon.setOnTouchListener(touch2search);
		mHListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				previewImg.setImageResource(mIds[position]);
				mHListViewAdapter.setSelectIndex(position);
				mHListViewAdapter.notifyDataSetChanged();

			}
		});

		OnClickListener onClickLis = new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int id = arg0.getId();
				switch (id) {

				case R.id.photo_edit:
					if (mFragmentConnect != null) {
						mFragmentConnect.AlbumsOpenClick();
					}
					break;
				case R.id.btn_chat_message:
					if (mFragmentConnect != null) {
						mFragmentConnect.ChatListViewOpenClick();
					}
					break;
				case R.id.btn_share:
					if (mFragmentConnect != null) {
						mFragmentConnect.ShareViewOpenClick();
					}
					break;
				case R.id.btn_add2chart:
					if (mFragmentConnect != null) {
						mFragmentConnect.AlbumsOpenClick();
					}
					break;
				case R.id.btn_buy:
					if (mFragmentConnect != null) {
						mFragmentConnect.AlbumsOpenClick();
					}
					break;

				}

			}
		};
		mAlbums.setOnClickListener(onClickLis);
		mChatMessage.setOnClickListener(onClickLis);
		mShare.setOnClickListener(onClickLis);
		mAdd2Chart.setOnClickListener(onClickLis);
		mBuy.setOnClickListener(onClickLis);

	}

	public void setIFragmentConnect(IFragmentCallBack f) {
		mFragmentConnect = f;
	}

}
