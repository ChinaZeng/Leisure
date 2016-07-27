package com.zzw.MyApp.joke;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.zzw.MyApp.R;
import com.zzw.MyApp.base.BaseFragment;
import com.zzw.MyApp.joke.presenter.IJokePresenter;
import com.zzw.MyApp.joke.presenter.IJokePresenterCompl;
import com.zzw.MyApp.joke.view.IJokeView;
import com.zzw.MyApp.wedgit.DampingViewPager;

/**
 * Created by zzw on 2016/6/13.
 * 描述:
 */
public class JokeFragment extends BaseFragment implements IJokeView {

    private DampingViewPager viewPager;
    private TabLayout tabLayout;
    private IJokePresenter iJokePresenter;

    public static JokeFragment newInstance() {
        return new JokeFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_tab_vp;
    }

    @Override
    protected void initView(View view) {
        iJokePresenter = new IJokePresenterCompl(getActivity(), getChildFragmentManager(), this);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        tabLayout.setTabGravity(TabLayout.MODE_SCROLLABLE);
        viewPager = (DampingViewPager) view.findViewById(R.id.viewPager);
    }

    @Override
    protected void initData() {
        super.initData();
        iJokePresenter.addJokePageFragment();
    }

    @Override
    public void initJokePager(PagerAdapter pagerAdapter) {

        viewPager.setpagerCount(pagerAdapter.getCount());
        viewPager.setOffscreenPageLimit(pagerAdapter.getCount());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewPager.setCurrentIndex(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
