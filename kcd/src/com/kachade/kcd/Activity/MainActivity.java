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
import com.kachade.popview.ChatListPopView;
import com.kachade.popview.SelectImagePopView;
import com.kachade.popview.SharePopView;

public class MainActivity extends FragmentActivity {
	public static int REQUSET = 1;
	private Fragment mContent;

	private RadioGroup mGroup;
	private boolean mIsPopView = false;

	private TextView mText;
	private RelativeLayout mParent;
	private SelectImagePopView mSelectImage;
	private ChatListPopView mChatListView;
	private SharePopView mShareView;
	private IFragmentCallBack mIfragmentConnect = new IFragmentCallBack() {

		@Override
		public void AlbumsOpenClick() {
			// TODO Auto-generated method stub
			mIsPopView = true;
			mShareView.closeShareView();
			mChatListView.closeShareView();
			mSelectImage.showShareView(mParent);
		}

		@Override
		public void AlbumsCloseClick() {
			mIsPopView = false;
			mShareView.closeShareView();
			mChatListView.closeShareView();
			mSelectImage.closeShareView();

		}

		@Override
		public void AlbumsDoneClick() {
			mIsPopView = false;
			mShareView.closeShareView();
			mChatListView.closeShareView();
			mSelectImage.closeShareView();

		}

		@Override
		public void ChatListViewOpenClick() {
			mShareView.closeShareView();
			mIsPopView = true;
			mSelectImage.closeShareView();
			mChatListView.showShareView(mParent);

		}

		@Override
		public void ChatListViewCloseClick() {
			mShareView.closeShareView();
			mIsPopView = false;
			mChatListView.closeShareView();
			mSelectImage.closeShareView();

		}

		@Override
		public void ChatListViewDoneClick() {
			mShareView.closeShareView();
			mIsPopView = false;
			mChatListView.closeShareView();
			mSelectImage.closeShareView();

		}

		@Override
		public void ShareViewOpenClick() {
			// TODO Auto-generated method stub
			mIsPopView = true;
			mShareView.showShareView(mParent);
			mChatListView.closeShareView();
			mSelectImage.closeShareView();

		}

		@Override
		public void ShareViewCloseClick() {
			// TODO Auto-generated method stub
			mIsPopView = false;
			mShareView.closeShareView();
			mChatListView.closeShareView();
			mSelectImage.closeShareView();
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
		mText = (TextView) this.findViewById(R.id.text);
		mGroup = (RadioGroup) this.findViewById(R.id.btn_group);

		mSelectImage = new SelectImagePopView(MainActivity.this);
		mSelectImage.setIFragmentCallBack(mIfragmentConnect);

		mChatListView = new ChatListPopView(MainActivity.this);
		mChatListView.setIFragmentCallBack(mIfragmentConnect);
		mShareView = new SharePopView(MainActivity.this);
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

					mText.setText("CategoryFragment");
					getSupportFragmentManager()
							.beginTransaction()
							.replace(R.id.layout_container,
									CategoryFragment.getInstance()).commit();

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
			mShareView.closeShareView();
			mChatListView.closeShareView();
			mSelectImage.closeShareView();
			return;
		}
		super.onBackPressed();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == MainActivity.REQUSET && resultCode == RESULT_OK) {
		}
	}

}
