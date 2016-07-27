package com.zzw.MyApp.joke.presenter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.zzw.MyApp.R;
import com.zzw.MyApp.joke.JokePicFragment;
import com.zzw.MyApp.joke.JokeTextFragment;
import com.zzw.MyApp.joke.adapter.JokeFragmentPagerAdapter;
import com.zzw.MyApp.joke.view.IJokeView;

/**
 * Created by zzw on 2016/6/13.
 * 描述:
 */
public class IJokePresenterCompl implements IJokePresenter {

    private IJokeView iJokeView;
    private Activity activity;
    private FragmentManager fragmentManager;
    private Fragment[] fragments;
    private String[] titles;
    private JokeFragmentPagerAdapter pagerAdapter;

    public IJokePresenterCompl(Activity activity, FragmentManager fragmentManager, IJokeView iJokeView) {
        this.activity = activity;
        this.iJokeView = iJokeView;
        this.fragmentManager = fragmentManager;
        init();
    }

    private void init() {
        if (fragments == null) {
            fragments = new Fragment[]{JokeTextFragment.newInstance(), JokePicFragment.newInstance()};
        }
        if (titles == null) {
            titles = new String[]{activity.getString(R.string.joke_text), activity.getString(R.string.joke_pic)};
        }
    }

    @Override
    public void addJokePageFragment() {
        if (fragments == null || titles == null)
            return;
        if (pagerAdapter == null) {
            pagerAdapter = new JokeFragmentPagerAdapter(activity, fragmentManager);
            pagerAdapter.addItem(fragments[0], titles[0]);
            pagerAdapter.addItem(fragments[1], titles[1]);
        }
        iJokeView.initJokePager(pagerAdapter);
    }
}
