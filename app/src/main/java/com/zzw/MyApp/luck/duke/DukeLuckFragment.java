package com.zzw.MyApp.luck.duke;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.zzw.MyApp.R;
import com.zzw.MyApp.UI;
import com.zzw.MyApp.base.BaseFragment;
import com.zzw.MyApp.luck.duke.adapter.DuckLuckAdapter;
import com.zzw.MyApp.luck.duke.model.DuckLuckModel;
import com.zzw.MyApp.luck.duke.presenter.IDuckLuckPresenter;
import com.zzw.MyApp.luck.duke.presenter.IDuckLuckPresenterCompl;
import com.zzw.MyApp.luck.duke.view.IDuckLuckView;
import com.zzw.MyApp.utils.TDevice;

import java.util.List;

/**
 * Created by zzw on 2016/6/15.
 * 描述:
 */
public class DukeLuckFragment extends BaseFragment implements IDuckLuckView {

    private EditText editText;

    private RecyclerView recyclerView;
    private IDuckLuckPresenter iDuckLuckPresenterCompl;
    private DuckLuckAdapter adapter;


    public static DukeLuckFragment newInstance() {
        return new DukeLuckFragment();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_duckluck;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        iDuckLuckPresenterCompl = new IDuckLuckPresenterCompl(this);
        adapter = new DuckLuckAdapter(getActivity());
        editText = (EditText) view.findViewById(R.id.fragment_duck_et);
        view.findViewById(R.id.fragment_duck_bt).setOnClickListener(this);
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_duck_recy);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }


    @Override
    protected void initData() {
        super.initData();
        getDuckLuckData(getContext().getString(R.string.shake));
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.fragment_duck_bt:
                if (TextUtils.isEmpty(editText.getText())) {
                    UI.showToast(getContext(), R.string.please_edit_key_string);
                    return;
                }
                getDuckLuckData((editText.getText() + "").trim());
                TDevice.hideSoftKeyboard(getContext(), v);
                break;
        }
    }

    private void getDuckLuckData(String str) {
        iDuckLuckPresenterCompl.getDuckLuckModel(str);
    }

    @Override
    public void getDuckLuckModelResult(Boolean isSuccess, List<DuckLuckModel> models, String strMsg) {
        if (isSuccess) {
            if (models != null) {
                adapter.clear();
                adapter.addItems(models);
            } else {
                UI.showToast(getContext(), getContext().getString(R.string.no_this_information));
            }
        } else {
            UI.showToast(getContext(), strMsg);
        }
    }
}
