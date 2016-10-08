package com.zzw.MyApp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zzw.MyApp.base.BaseActivity;
import com.zzw.MyApp.history.HistoryFragment;
import com.zzw.MyApp.joke.JokeFragment;
import com.zzw.MyApp.life.mainFragment.LifeFragment;
import com.zzw.MyApp.luck.mainFragment.LuckFragment;
import com.zzw.MyApp.news.NewsFragment;
import com.zzw.MyApp.picture.GalleryClassFragment;


public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private final static String FLOG = "flog";

    private DrawerLayout drawer;
    private NavigationView navigationView;

    private ImageView toolbarLeftImage;
    private TextView toolbarTitleText;

    private Fragment newsFragment, jokeFragment, luckFragment, lifeFragment, historyFragment, galleryClassFragment;


    private int flag = 0;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        if (savedInstanceState == null) {
            setDefault(navigationView);
        } else {
            newsFragment = getSupportFragmentManager().findFragmentByTag(NewsFragment.class.getName());
            jokeFragment = getSupportFragmentManager().findFragmentByTag(JokeFragment.class.getName());
            luckFragment = getSupportFragmentManager().findFragmentByTag(LuckFragment.class.getName());
            historyFragment = getSupportFragmentManager().findFragmentByTag(HistoryFragment.class.getName());
            galleryClassFragment = getSupportFragmentManager().findFragmentByTag(GalleryClassFragment.class.getName());
            setMenuSelection(savedInstanceState.getInt(FLOG));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(FLOG, flag);
    }

    @Override
    protected void initView() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbarLeftImage = (ImageView) findViewById(R.id.toolbar_left);
        toolbarTitleText = (TextView) findViewById(R.id.toolbar_title);
        toolbarLeftImage.setOnClickListener(this);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    private void setToolbar(int flog) {
        switch (flog) {
            case 0:
                toolbarTitleText.setText(R.string.news);
                break;

            case 1:
                toolbarTitleText.setText(R.string.smile_a_smile);
                break;

            case 2:
                toolbarTitleText.setText(R.string.luck);
                break;

            case 3:
                toolbarTitleText.setText(R.string.life);
                break;

            case 4:
                toolbarTitleText.setText(R.string.today_in_history);
                break;

            case 5:
                toolbarTitleText.setText(R.string.picture);
                break;
        }

    }

    private void setDefault(NavigationView navigationView) {
        setMenuSelection(0);
        navigationView.getMenu().getItem(0).setChecked(true);
    }


    long exitTime = 0;

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            return;
        }
        long currtTime = System.currentTimeMillis();
        if (currtTime - exitTime > 2000) {
            Toast.makeText(this, R.string.gank_hint_exit_app, Toast.LENGTH_SHORT).show();
            exitTime = currtTime;
            return;
        }
        finish();
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_news:
                setMenuSelection(0);
                break;
            case R.id.nav_smile_a_smile:
                setMenuSelection(1);
                break;
            case R.id.nav_luck:
                setMenuSelection(2);
                break;
            case R.id.nav_life:
                setMenuSelection(3);
                break;
            case R.id.nav_today_in_history:
                setMenuSelection(4);
                break;
            case R.id.nav_picture:
                setMenuSelection(5);
                break;
            case R.id.nav_share:
                UI.shareText(this, getString(R.string.github_name));
                break;
            case R.id.nav_about:
                UI.showAboutActivity(this);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.toolbar_left:
                drawer.openDrawer(GravityCompat.START);
                break;
        }
    }

    private void setMenuSelection(int flag) {

        this.flag = flag;
        setToolbar(flag);

        // 开启一个Fragment事务
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(fragmentTransaction);
        switch (flag) {
            case 0:
                if (newsFragment == null) {
                    newsFragment = NewsFragment.newInstance();
                    fragmentTransaction.add(R.id.main_frame, newsFragment, NewsFragment.class.getName());
                } else {
                    fragmentTransaction.show(newsFragment);
                }
                break;
            case 1:
                if (jokeFragment == null) {
                    jokeFragment = JokeFragment.newInstance();
                    fragmentTransaction.add(R.id.main_frame, jokeFragment, JokeFragment.class.getName());
                } else {
                    fragmentTransaction.show(jokeFragment);
                }
                break;

            case 2:
                if (luckFragment == null) {
                    luckFragment = LuckFragment.newInstance();
                    fragmentTransaction.add(R.id.main_frame, luckFragment, LuckFragment.class.getName());
                } else {
                    fragmentTransaction.show(luckFragment);
                }
                break;

            case 3:
                if (lifeFragment == null) {
                    lifeFragment = LifeFragment.newInstance();
                    fragmentTransaction.add(R.id.main_frame, lifeFragment, LifeFragment.class.getName());
                } else {
                    fragmentTransaction.show(lifeFragment);
                }
                break;

            case 4:
                if (historyFragment == null) {
                    historyFragment = HistoryFragment.newInstance();
                    fragmentTransaction.add(R.id.main_frame, historyFragment, HistoryFragment.class.getName());
                } else {
                    fragmentTransaction.show(historyFragment);
                }
                break;

            case 5:
                if (galleryClassFragment == null) {
                    galleryClassFragment = GalleryClassFragment.newInstance();
                    fragmentTransaction.add(R.id.main_frame, galleryClassFragment, GalleryClassFragment.class.getName());
                } else {
                    fragmentTransaction.show(galleryClassFragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }

    private void hideFragments(android.support.v4.app.FragmentTransaction transaction) {
        if (newsFragment != null) {
            transaction.hide(newsFragment);
        }
        if (jokeFragment != null) {
            transaction.hide(jokeFragment);
        }
        if (luckFragment != null) {
            transaction.hide(luckFragment);
        }
        if (lifeFragment != null) {
            transaction.hide(lifeFragment);
        }
        if (historyFragment != null) {
            transaction.hide(historyFragment);
        }
        if (galleryClassFragment != null) {
            transaction.hide(galleryClassFragment);
        }
    }
}
