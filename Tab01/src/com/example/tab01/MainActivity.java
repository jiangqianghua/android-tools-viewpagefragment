package com.example.tab01;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class MainActivity extends Activity implements OnClickListener {

	private ViewPager mViewPager ;
	private PagerAdapter mAdapter ; 
	private List<View> mViews = new ArrayList<View>();
	
	private LinearLayout mTabWeixin;
	private LinearLayout mTabFrd ; 
	private LinearLayout mTabAddress ; 
	private LinearLayout mTabSet ;
	
	private ImageButton mTabWeixinImg;
	private ImageButton mTabFrdImg ; 
	private ImageButton mTabAddressImg ; 
	private ImageButton mTabSetImg ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initDatas();
		initEvent();
	}
	
	private void initEvent() {
		// TODO Auto-generated method stub
		mTabWeixin.setOnClickListener(this);
		mTabFrd.setOnClickListener(this);
		mTabAddress.setOnClickListener(this);
		mTabSet.setOnClickListener(this);
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				int currentItem = mViewPager.getCurrentItem();
				resetImg();
				switch (currentItem) {
				case 0:
					mTabWeixinImg.setImageResource(R.drawable.tab_weixin_pressed);
					break;
				case 1:
					mTabFrdImg.setImageResource(R.drawable.tab_find_frd_pressed);
					break;
				case 2:
					mTabAddressImg.setImageResource(R.drawable.tab_address_pressed);
					break;
				case 3:
					mTabSetImg.setImageResource(R.drawable.tab_settings_pressed);
					break;
				default:
					break;
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		resetImg();
		switch (v.getId()) {
		case R.id.id_tab_weixin_ll:
			mViewPager.setCurrentItem(0);
			mTabWeixinImg.setImageResource(R.drawable.tab_weixin_pressed);
			break;
		case R.id.id_tab_frd:
			mViewPager.setCurrentItem(1);
			mTabFrdImg.setImageResource(R.drawable.tab_find_frd_pressed);
			break;
		case R.id.id_tab_adress:
			mViewPager.setCurrentItem(2);
			mTabAddressImg.setImageResource(R.drawable.tab_address_pressed);
			break;
		case R.id.id_tab_set:
			mViewPager.setCurrentItem(3);
			mTabSetImg.setImageResource(R.drawable.tab_settings_pressed);
			break;
		default:
			break;
		}
	}
	/**
	 * ÖØÖÃtabÍ¼Æ¬ÇÐ»»Îª°µÉ«
	 */
	private void resetImg() {
		// TODO Auto-generated method stub
		mTabWeixinImg.setImageResource(R.drawable.tab_weixin_normal);
		mTabFrdImg.setImageResource(R.drawable.tab_find_frd_normal);
		mTabAddressImg.setImageResource(R.drawable.tab_address_normal);
		mTabSetImg.setImageResource(R.drawable.tab_settings_normal);
	}

	private void initView()
	{

		mViewPager = (ViewPager) findViewById(R.id.id_viewPage);
		mTabWeixin = (LinearLayout) findViewById(R.id.id_tab_weixin_ll);
		mTabFrd = (LinearLayout) findViewById(R.id.id_tab_frd);
		mTabSet = (LinearLayout) findViewById(R.id.id_tab_set);
		mTabAddress = (LinearLayout) findViewById(R.id.id_tab_adress);
		
		mTabWeixinImg = (ImageButton) findViewById(R.id.id_tab_weixin_img);
		mTabFrdImg = (ImageButton) findViewById(R.id.id_tab_frd_img);
		mTabSetImg = (ImageButton) findViewById(R.id.id_tab_set_img);
		mTabAddressImg = (ImageButton) findViewById(R.id.id_tab_address_img);
		mTabWeixinImg.setImageResource(R.drawable.tab_weixin_pressed);
		
		LayoutInflater mInflater = LayoutInflater.from(this);
		View Tab01 = mInflater.inflate(R.layout.tab01, null);
		View Tab02 = mInflater.inflate(R.layout.tab02, null);
		View Tab03 = mInflater.inflate(R.layout.tab03, null);
		View Tab04 = mInflater.inflate(R.layout.tab04, null);
		
		mViews.add(Tab01);
		mViews.add(Tab02);
		mViews.add(Tab03);
		mViews.add(Tab04);
		
		mAdapter = new PagerAdapter() {
			
			
			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				// TODO Auto-generated method stub
				container.removeView(mViews.get(position));
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				// TODO Auto-generated method stub
				View view = mViews.get(position);
				container.addView(view);
				return view;
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO Auto-generated method stub
				return arg0 == arg1;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return mViews.size();
			}
		};
		mViewPager.setAdapter(mAdapter);
		
	}
	
	private void initDatas()
	{
		
	}

}
