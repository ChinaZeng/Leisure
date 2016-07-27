package com.zzw.MyApp.life.longBusQuery;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.zzw.MyApp.Constans;
import com.zzw.MyApp.R;
import com.zzw.MyApp.UI;
import com.zzw.MyApp.base.BaseFragment;
import com.zzw.MyApp.life.longBusQuery.adapter.LongBusAdapter;
import com.zzw.MyApp.life.longBusQuery.model.LongBusModel;
import com.zzw.MyApp.life.longBusQuery.presenter.ILongBusPresenter;
import com.zzw.MyApp.life.longBusQuery.presenter.ILongBusPresenterCompl;
import com.zzw.MyApp.life.longBusQuery.view.ILongBusView;
import com.zzw.MyApp.utils.TDevice;

import java.util.List;

/**
 * Created by zzw on 2016/6/15.
 * 描述:
 */
public class LongBusFragment extends BaseFragment implements ILongBusView {

    private LongBusAdapter adapter;
    private RecyclerView recyclerView;
    private TextView textView;
    private ILongBusPresenter iLongBusPresenterCompl;
    private EditText fromEdit, toEdit;

    public static LongBusFragment newInstance() {
        return new LongBusFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_long_bus;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        iLongBusPresenterCompl = new ILongBusPresenterCompl(this);
        adapter = new LongBusAdapter(getActivity());
        textView = (TextView) view.findViewById(R.id.long_bus_title);
        fromEdit = (EditText) view.findViewById(R.id.long_bus_from_city_edit);
        toEdit = (EditText) view.findViewById(R.id.long_bus_to_city_edit);
        recyclerView = (RecyclerView) view.findViewById(R.id.long_bus_recy);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        view.findViewById(R.id.long_bus_query_bt).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);

        switch (v.getId()) {
            case R.id.long_bus_query_bt:
                String from = fromEdit.getText() + "";
                String to = toEdit.getText() + "";
                if (from.length() == 0 || to.length() == 0) {
                    UI.showToast(getContext(), R.string.please_edit_long_bus);
                    return;
                }
                queryLongBusTime(from.trim(), to.trim());
                TDevice.hideSoftKeyboard(getContext(), v);
                break;
        }
    }

    private void queryLongBusTime(String fromCity, String toCity) {
        if (fromCity == null || toCity == null)
            return;
        iLongBusPresenterCompl.queryLongBusTime(fromCity, toCity);
    }

    @Override
    public void queryLongBusTimeResult(final Boolean isSuccess, final LongBusModel model, final String strMsg) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isSuccess) {
                    if (model != null) {
                        textView.setText(model.getTitle());
                        List<LongBusModel.ListBean> busModels = model.getList();
                        adapter.clear();
                        adapter.addItems(busModels);
                    }
                } else {
                    UI.showToast(getContext(), strMsg);
                }
            }
        }, Constans.HANDLER_POSt_TIME);
    }
}
