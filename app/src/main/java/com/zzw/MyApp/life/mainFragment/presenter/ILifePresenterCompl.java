package com.zzw.MyApp.life.mainFragment.presenter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.zzw.MyApp.R;
import com.zzw.MyApp.joke.adapter.JokeFragmentPagerAdapter;
import com.zzw.MyApp.life.TvTime.TvTimeFragment;
import com.zzw.MyApp.life.longBusQuery.LongBusFragment;
import com.zzw.MyApp.life.mainFragment.view.ILifeView;
import com.zzw.MyApp.life.postalcode.PostalCodeFragment;

/**
 * Created by zzw on 2016/6/15.
 * 描述:
 */
public class ILifePresenterCompl implements ILifePresenter {
    private ILifeView iLifeView;
    private Activity activity;
    private FragmentManager fragmentManager;
    private Fragment[] fragments;
    private String[] titles;
    private JokeFragmentPagerAdapter pagerAdapter;


    public ILifePresenterCompl(Activity activity, FragmentManager fragmentManager, ILifeView iLifeView) {
        this.activity = activity;
        this.iLifeView = iLifeView;
        this.fragmentManager = fragmentManager;
        init();
    }

    private void init() {
        if (fragments == null) {
            fragments = new Fragment[]{
                    LongBusFragment.newInstance(),
                    PostalCodeFragment.newInstance(),
                    TvTimeFragment.newInstance()};
        }
        if (titles == null) {
            titles = new String[]{
                    activity.getString(R.string.long_bus_query),
                    activity.getString(R.string.postalcode),
                    activity.getString(R.string.TV_time_table),
            };
        }
    }

    @Override
    public void addLifePageFragment() {
        if (fragments == null || titles == null)
            return;
        if (pagerAdapter == null) {
            pagerAdapter = new JokeFragmentPagerAdapter(activity, fragmentManager);
            for (int i = 0; i < fragments.length; i++) {
                pagerAdapter.addItem(fragments[i], titles[i]);
            }
        }
        iLifeView.initLifePager(pagerAdapter);
    }
}
