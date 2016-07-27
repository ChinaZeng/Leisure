package com.zzw.MyApp.luck.mainFragment.presenter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.zzw.MyApp.R;
import com.zzw.MyApp.joke.adapter.JokeFragmentPagerAdapter;
import com.zzw.MyApp.luck.constellation.ConLuckFragment;
import com.zzw.MyApp.luck.duke.DukeLuckFragment;
import com.zzw.MyApp.luck.mainFragment.view.ILuckView;
import com.zzw.MyApp.luck.stuff.StuffLuckFragment;

/**
 * Created by zzw on 2016/7/4.
 * 描述:
 */
public class ILuckPresenterCompl implements ILuckPresenter {

    private ILuckView iLuckView;
    private Activity activity;
    private FragmentManager fragmentManager;
    private Fragment[] fragments;
    private String[] titles;
    private JokeFragmentPagerAdapter pagerAdapter;

    public ILuckPresenterCompl(Activity activity, FragmentManager fragmentManager, ILuckView iLuckView) {
        this.activity = activity;
        this.iLuckView = iLuckView;
        this.fragmentManager = fragmentManager;
        init();
    }


    private void init() {
        if (fragments == null) {
            fragments = new Fragment[]{ConLuckFragment.newInstance(), DukeLuckFragment.newInstance(),
                    StuffLuckFragment.newInstance()};
        }
        if (titles == null) {
            titles = new String[]{activity.getString(R.string.constellation),
                    activity.getString(R.string.duke_of_zhou_interprets),
                    activity.getString(R.string.stuff)};
        }
    }


    @Override
    public void addLuckPageFragment() {
        if (fragments == null || titles == null)
            return;
        if (pagerAdapter == null) {
            pagerAdapter = new JokeFragmentPagerAdapter(activity, fragmentManager);
            pagerAdapter.addItem(fragments[0], titles[0]);
            pagerAdapter.addItem(fragments[1], titles[1]);
            pagerAdapter.addItem(fragments[2], titles[2]);
        }
        iLuckView.initLuckPager(pagerAdapter);
    }
}
