package com.kachade.kcd.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kachade.callback.IFragmentCallBack;
import com.kachade.kcd.R;
import com.kachade.kcd.fragment.CartFragment;
import com.kachade.kcd.fragment.CategoryFragment;
import com.kachade.kcd.fragment.DiscoveryFragment;
import com.kachade.kcd.fragment.KcdFragment;
import com.kachade.kcd.fragment.MyKcdFragment;
import com.kachade.popview.ChatListView;
import com.kachade.popview.SelectImage;
import com.kachade.popview.ShareView;
import com.kachade.popview.SharePopView;

public class MainActivity0502 extends FragmentActivity {
	public static int REQUSET = 1;
	private Fragment mContent;

	private RadioButton mBtnKcd;
	private RadioButton mBtnDiscovery;
	private RadioButton mBtnCategory;
	private RadioButton mBtnCart;
	private RadioButton mBtnMyKcd;

	private RadioGroup mGroup;
	private boolean mIsPopView = false;

	private TextView mText;
	private RelativeLayout mParent;
	private SelectImage mSelectImage;
	private ChatListView mChatListView;
	private ShareView mShareView;
	private SharePopView mShareView1;
	private IFragmentCallBack mIfragmentConnect = new IFragmentCallBack() {

		@Override
		public void AlbumsOpenClick() {
			// TODO Auto-generated method stub
			mIsPopView = true;
			mShareView.setVisibility(View.GONE);
			mChatListView.setVisibility(View.GONE);
			mSelectImage.setVisibility(View.VISIBLE);
			mGroup.setVisibility(View.INVISIBLE);
		}

		@Override
		public void AlbumsCloseClick() {
			mIsPopView = false;
			mShareView.setVisibility(View.GONE);
			mChatListView.setVisibility(View.GONE);
			mSelectImage.setVisibility(View.GONE);
			mGroup.setVisibility(View.VISIBLE);
		}

		@Override
		public void AlbumsDoneClick() {
			mShareView.setVisibility(View.GONE);
			mIsPopView = false;
			mChatListView.setVisibility(View.GONE);
			mSelectImage.setVisibility(View.GONE);
			mGroup.setVisibility(View.VISIBLE);
		}

		@Override
		public void ChatListViewOpenClick() {
			mShareView.setVisibility(View.GONE);
			mIsPopView = true;
			mChatListView.setVisibility(View.VISIBLE);
			mSelectImage.setVisibility(View.GONE);
			mGroup.setVisibility(View.INVISIBLE);
		}

		@Override
		public void ChatListViewCloseClick() {
			mShareView.setVisibility(View.GONE);
			mIsPopView = false;
			mChatListView.setVisibility(View.GONE);
			mSelectImage.setVisibility(View.GONE);
			mGroup.setVisibility(View.VISIBLE);
		}

		@Override
		public void ChatListViewDoneClick() {
			mShareView.setVisibility(View.GONE);
			mIsPopView = false;
			mChatListView.setVisibility(View.GONE);
			mSelectImage.setVisibility(View.GONE);
			mGroup.setVisibility(View.VISIBLE);
		}

		@Override
		public void ShareViewOpenClick() {
			// TODO Auto-generated method stub
			mIsPopView = true;
			mShareView.setVisibility(View.VISIBLE);
			mChatListView.setVisibility(View.GONE);
			mSelectImage.setVisibility(View.GONE);
			mGroup.setVisibility(View.INVISIBLE);

		}

		@Override
		public void ShareViewCloseClick() {
			// TODO Auto-generated method stub
			mText.setText("ShareViewCloseClick");
			mShareView.setVisibility(View.GONE);
			mIsPopView = false;
			mChatListView.setVisibility(View.GONE);
			mSelectImage.setVisibility(View.GONE);
			mGroup.setVisibility(View.VISIBLE);

		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState != null) {
			mContent = getSupportFragmentManager().getFragment(
					savedInstanceState, "mContent");
		}

		if (mContent == null) {
			mContent = new KcdFragment();
		}

		KcdFragment fragment = KcdFragment.getInstance();
		fragment.setIFragmentConnect(mIfragmentConnect);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.layout_container, fragment).commit();

		mParent = (RelativeLayout) this.findViewById(R.id.parent_view);
		;
		mText = (TextView) this.findViewById(R.id.text);
		mBtnKcd = (RadioButton) this.findViewById(R.id.btn_kcd);
		mBtnCategory = (RadioButton) this.findViewById(R.id.btn_category);
		mBtnDiscovery = (RadioButton) this.findViewById(R.id.btn_discovery);
		mBtnCart = (RadioButton) this.findViewById(R.id.btn_cart);
		mBtnMyKcd = (RadioButton) this.findViewById(R.id.btn_my_kcd);
		mGroup = (RadioGroup) this.findViewById(R.id.btn_group);

		mSelectImage = (SelectImage) this.findViewById(R.id.select_image_group);
		mSelectImage.setIFragmentCallBack(mIfragmentConnect);

		mChatListView = (ChatListView) this
				.findViewById(R.id.chat_list_view_group);
		mChatListView.setIFragmentCallBack(mIfragmentConnect);

		mShareView = (ShareView) this.findViewById(R.id.share_view_group);
		mShareView.setIFragmentCallBack(mIfragmentConnect);

		setListener();
	}

	private void setListener() {
		mGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				int radioButtonId = arg0.getCheckedRadioButtonId();

				switch (radioButtonId) {
				case R.id.btn_kcd:
					mText.setText("KcdFragment");
					KcdFragment fragment = KcdFragment.getInstance();
					fragment.setIFragmentConnect(mIfragmentConnect);
					getSupportFragmentManager().beginTransaction()
							.replace(R.id.layout_container, fragment).commit();
					break;
				case R.id.btn_category:

					mShareView1 = new SharePopView(MainActivity0502.this);
					mShareView1.showShareView(mParent);
					/*
					 * mText.setText("CategoryFragment");
					 * getSupportFragmentManager() .beginTransaction()
					 * .replace(R.id.layout_container,
					 * CategoryFragment.getInstance()).commit();
					 */
					break;
				case R.id.btn_discovery:
					mText.setText("DiscoveryFragment");
					getSupportFragmentManager()
							.beginTransaction()
							.replace(R.id.layout_container,
									DiscoveryFragment.getInstance()).commit();
					break;
				case R.id.btn_cart:
					mText.setText("CartFragment");
					getSupportFragmentManager()
							.beginTransaction()
							.replace(R.id.layout_container,
									CartFragment.getInstance()).commit();
					break;
				case R.id.btn_my_kcd:
					mText.setText("MyKcdFragment");
					getSupportFragmentManager()
							.beginTransaction()
							.replace(R.id.layout_container,
									MyKcdFragment.getInstance()).commit();
					break;
				}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onBackPressed() {
		if (mIsPopView) {
			mIsPopView = false;
			mShareView.setVisibility(View.GONE);
			mChatListView.setVisibility(View.GONE);
			mSelectImage.setVisibility(View.GONE);
			mGroup.setVisibility(View.VISIBLE);
			return;
		}

		super.onBackPressed();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == MainActivity0502.REQUSET && resultCode == RESULT_OK) {
		}
	}

}
