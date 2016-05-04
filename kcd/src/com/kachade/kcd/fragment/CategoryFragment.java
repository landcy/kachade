package com.kachade.kcd.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.view.animation.AlphaAnimation;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.kachade.adapter.HorizontalListViewAdapter;
import com.kachade.adapter.ImageAdapter;
import com.kachade.framework.app.BaseFragment;
import com.kachade.image.ImageWorker;
import com.kachade.image.LoadLoacalPhotoCursorTask;
import com.kachade.kcd.R;
import com.kachade.kcd.Activity.SearchActivity;
import com.kachade.view.HorizontalListView;

public class CategoryFragment extends BaseFragment {
	public static int REQUSET = 1;
	private static CategoryFragment mInstance;
	private Context mContext;
	private String[] mTitles = { "孙中山", "故居", "纪念馆", "位于", "广东省", "中山市", "翠亨村",
			"南、北、西", "三面环山", "东临珠江口", "城区20公里" };
	private HorizontalListView mHListView;
	private EditText mSearchEditText;
	private ImageView mSearchIcon;
	private GridView mGridView;

	private ImageWorker imageWorker;

	private ArrayList<Uri> uriArray = new ArrayList<Uri>();
	private ArrayList<Long> origIdArray = new ArrayList<Long>();

	private ImageAdapter adapter;

	private LoadLoacalPhotoCursorTask cursorTask;

	private AlphaAnimation inAlphaAni;
	private AlphaAnimation outAlphaAni;
	public boolean mTouch2Search = false;
	public long mLastTouch2Search = 0;

	public static CategoryFragment getInstance() {
		if (mInstance == null)
			mInstance = new CategoryFragment();
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
		View view = inflater.inflate(R.layout.fragment_category, null);
		initView(view);
		init();
		return view;
	}

	private void initView(View view) {
		mGridView = (GridView) view.findViewById(R.id.gridView);
		mSearchEditText = (EditText) view.findViewById(R.id.search_ed);
		mSearchIcon = (ImageView) view.findViewById(R.id.search_iv);

		mHListView = (HorizontalListView) view
				.findViewById(R.id.horizon_listview);

		SimpleAdapter adapter = new SimpleAdapter(mContext, getData(),
				R.layout.round_text_view, new String[] { "key" },
				new int[] { R.id.key });
		mHListView.setAdapter(adapter);

		setListener();
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < mTitles.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("key", mTitles[i]);
			list.add(map);
		}

		return list;
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

	}

	/**
	 * 初始化
	 */
	private void init() {
		imageWorker = new ImageWorker(mContext);
		Bitmap b = Bitmap.createBitmap(new int[] { 0x00000000 }, 1, 1,
				Bitmap.Config.ARGB_8888);
		imageWorker.setLoadBitmap(b);
		adapter = new ImageAdapter(imageWorker, mContext);
		mGridView.setAdapter(adapter);
		loadData();
		initAnimation();
		onItemClick();
		onScroll();
		doneClick();
	}

	/**
	 * 初始化动画
	 */
	private void initAnimation() {
		float fromAlpha = 0;
		float toAlpha = 1;
		int duration = 200;
		inAlphaAni = new AlphaAnimation(fromAlpha, toAlpha);
		inAlphaAni.setDuration(duration);
		inAlphaAni.setFillAfter(true);
		outAlphaAni = new AlphaAnimation(toAlpha, fromAlpha);
		outAlphaAni.setDuration(duration);
		outAlphaAni.setFillAfter(true);
	}

	/**
	 * 加载数据
	 */
	private void loadData() {
		cursorTask = new LoadLoacalPhotoCursorTask(mContext);
		cursorTask
				.setOnLoadPhotoCursor(new LoadLoacalPhotoCursorTask.OnLoadPhotoCursor() {
					@Override
					public void onLoadPhotoSursorResult(
							ArrayList<Uri> uriArray, ArrayList<Long> origIdArray) {
						if (isNotNull(uriArray) & isNotNull(origIdArray)) {
							CategoryFragment.this.uriArray = uriArray;
							CategoryFragment.this.origIdArray = origIdArray;
							adapter.setOrigIdArray(origIdArray);
							adapter.notifyDataSetChanged();
						}
					}
				});
		cursorTask.execute();
	}

	/**
	 * 选择图片
	 */
	private void onItemClick() {
		mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

			}
		});
	}

	/**
	 * 滚动的时候不加载图片
	 */
	private void onScroll() {
		mGridView.setOnScrollListener(new AbsListView.OnScrollListener() {
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
					imageWorker.setPauseWork(false);
				} else {
					imageWorker.setPauseWork(true);
				}
			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
			}
		});
	}

	/**
	 * 图片完成事件
	 */
	private void doneClick() {

	}

	/**
	 * 判断list不为空
	 * 
	 * @param list
	 * @return
	 */
	private static boolean isNotNull(ArrayList list) {
		return list != null && list.size() > 0;
	}

	// @Override
	// protected void onDestroy() {
	// super.onDestroy();
	// cursorTask.setExitTasksEarly(true);
	// imageWorker.setExitTasksEarly(true);
	// }

}
