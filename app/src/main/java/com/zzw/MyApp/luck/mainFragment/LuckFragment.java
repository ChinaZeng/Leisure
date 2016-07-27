package com.zzw.MyApp.luck.mainFragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.zzw.MyApp.R;
import com.zzw.MyApp.base.BaseFragment;
import com.zzw.MyApp.joke.presenter.IJokePresenter;
import com.zzw.MyApp.joke.presenter.IJokePresenterCompl;
import com.zzw.MyApp.life.mainFragment.presenter.ILifePresenter;
import com.zzw.MyApp.luck.mainFragment.presenter.ILuckPresenter;
import com.zzw.MyApp.luck.mainFragment.presenter.ILuckPresenterCompl;
import com.zzw.MyApp.luck.mainFragment.view.ILuckView;
import com.zzw.MyApp.wedgit.DampingViewPager;

/**
 * Created by zzw on 2016/6/15.
 * 描述:
 */
public class LuckFragment extends BaseFragment implements ILuckView {

    private DampingViewPager viewPager;
    private TabLayout tabLayout;
    private ILuckPresenter iLuckPresenter;


    public static LuckFragment newInstance() {
        return new LuckFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_tab_vp;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        iLuckPresenter = new ILuckPresenterCompl(getActivity(), getChildFragmentManager(), this);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        tabLayout.setTabGravity(TabLayout.MODE_SCROLLABLE);
        viewPager = (DampingViewPager) view.findViewById(R.id.viewPager);
    }

    @Override
    protected void initData() {
        super.initData();
        iLuckPresenter.addLuckPageFragment();
    }

    @Override
    public void initLuckPager(PagerAdapter pagerAdapter) {
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
