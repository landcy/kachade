package com.kachade.popview;

//com.kachade.popview.SelectImage
import java.util.HashMap;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kachade.adapter.SelectImageListAdapter;
import com.kachade.callback.IFragmentCallBack;
import com.kachade.kcd.R;
import com.kachade.view.HorizontalListView;

public class SelectImage extends RelativeLayout {
	private static final int MAX_SELECTED_NUM = 5;
	private int mSelectNum = 0;
	private int MAX_NUM = 5;
	private Context mContext;
	private ImageView mClose;
	private TextView mAlbum;
	private TextView mEdit;
	private Button mOK;

	private HorizontalListView mHListView;
	private IFragmentCallBack mFragmentConnect;
	private HashMap<Integer, Boolean> seletedMap = new HashMap<Integer, Boolean>();
	private final int[] mIds = { R.drawable.image0, R.drawable.image1,
			R.drawable.image2, R.drawable.image3, R.drawable.image4,
			R.drawable.image5, R.drawable.image6, R.drawable.image7,
			R.drawable.image8, R.drawable.image9 };
	private SelectImageListAdapter mHListViewAdapter;

	private SelectImageCallBack mSelectedCallBack = new SelectImageCallBack() {

		@Override
		public void selectNum(int num) {
			// TODO Auto-generated method stub
			mOK.setText("确定(" + num + "/" + MAX_SELECTED_NUM + ")");
		}
	};

	public interface SelectImageCallBack {
		void selectNum(int num);
	}

	public SelectImage(Context context) {
		super(context);
		init(context);
	}

	public SelectImage(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public SelectImage(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);

	}

	private void init(Context context) {
		mContext = context;
		View view = LayoutInflater.from(mContext).inflate(
				R.layout.select_image_view, this);
		mClose = (ImageView) view.findViewById(R.id.close_iv);
		mAlbum = (TextView) view.findViewById(R.id.btn_album);
		mEdit = (TextView) view.findViewById(R.id.btn_edit);
		mOK = (Button) view.findViewById(R.id.btn_ok);
		mHListView = (HorizontalListView) view
				.findViewById(R.id.horizon_listview);
		mHListViewAdapter = new SelectImageListAdapter(mContext, mIds);
		mHListView.setAdapter(mHListViewAdapter);
		setLis();
	}

	private void setLis() {
		OnClickListener clickLis = new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int id = arg0.getId();
				switch (id) {
				case R.id.close_iv:
					if (mFragmentConnect != null)
						mFragmentConnect.AlbumsCloseClick();
					break;
				case R.id.btn_album:
					break;
				case R.id.btn_ok:
					if (mFragmentConnect != null)
						mFragmentConnect.AlbumsDoneClick();
					break;
				case R.id.btn_edit:
					break;

				}
			}
		};
		mClose.setOnClickListener(clickLis);
		mEdit.setOnClickListener(clickLis);
		mOK.setOnClickListener(clickLis);
		mAlbum.setOnClickListener(clickLis);
		
		mHListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						ImageView selectBtn = (ImageView) view.findViewById(R.id.select_iv);
						if (seletedMap.containsKey(position)) {
							boolean flag = seletedMap.get(position);
							if (!flag && addSelect()) {
								seletedMap.put(position, true);
								selectBtn.setImageDrawable(getDrawable(R.drawable.btn_selected));
							} else if (flag && minusSelect()) {
								seletedMap.put(position, false);
								selectBtn.setImageDrawable(getDrawable(R.drawable.btn_un_chose));
							}
						} else {
							if (addSelect()) {
								seletedMap.put(position, true);
								selectBtn.setImageDrawable(getDrawable(R.drawable.btn_selected));
							}
						}
					}
				});

	}

	private Drawable getDrawable(int id) {
		return mContext.getResources().getDrawable(id);
	}

	private boolean addSelect() {
		if (mSelectNum >= this.MAX_NUM)
			return false;
		mSelectNum++;
		mSelectedCallBack.selectNum(mSelectNum);
		return true;
	}

	private boolean minusSelect() {
		if (mSelectNum <= 0)
			return false;
		mSelectNum--;
		mSelectedCallBack.selectNum(mSelectNum);
		return true;
	}

	public void setIFragmentCallBack(IFragmentCallBack f) {
		mFragmentConnect = f;
	}

}
