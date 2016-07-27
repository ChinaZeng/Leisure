package com.zzw.MyApp.base;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzw on 2016/6/13.
 * 描述:
 */
public class BaseFragmentPageAdapter extends FragmentStatePagerAdapter {

    protected final List<Fragment> mData = new ArrayList<>();
    protected final List<String> mDataTitles = new ArrayList<>();
    protected Activity activity;

    public BaseFragmentPageAdapter(Activity activity, FragmentManager fm) {
        super(fm);
        this.activity = activity;
    }


    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }


    @Override
    public Fragment getItem(int position) {
        return mData.get(position);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return mDataTitles.size() - 1 < position ? "" : mDataTitles.get(position);
    }

    public void addItem(Fragment item, String title) {
        mData.add(item);
        mDataTitles.add(title);
        notifyDataSetChanged();
    }

    public void addTopItem(Fragment item, String title) {
        mData.add(0, item);
        mDataTitles.add(0, title);
        notifyDataSetChanged();
    }

    public void clean(){
        mData.clear();
        notifyDataSetChanged();
    }

}
