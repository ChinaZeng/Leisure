package com.zzw.MyApp.life.mainFragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.zzw.MyApp.R;
import com.zzw.MyApp.base.BaseFragment;
import com.zzw.MyApp.life.mainFragment.presenter.ILifePresenter;
import com.zzw.MyApp.life.mainFragment.presenter.ILifePresenterCompl;
import com.zzw.MyApp.life.mainFragment.view.ILifeView;
import com.zzw.MyApp.wedgit.DampingViewPager;

/**
 * Created by zzw on 2016/6/15.
 * 描述:
 */
public class LifeFragment extends BaseFragment implements ILifeView {

    private DampingViewPager viewPager;
    private TabLayout tabLayout;
    private ILifePresenter iLifePresenter;

    public static LifeFragment newInstance() {
        return new LifeFragment();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.layout_tab_vp;
    }


    @Override
    protected void initView(View view) {
        iLifePresenter = new ILifePresenterCompl(getActivity(), getChildFragmentManager(), this);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        viewPager = (DampingViewPager) view.findViewById(R.id.viewPager);
    }

    @Override
    protected void initData() {
        super.initData();
        iLifePresenter.addLifePageFragment();
    }


    @Override
    public void initLifePager(PagerAdapter pagerAdapter) {
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
