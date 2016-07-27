package com.zzw.MyApp.luck.duke.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.zzw.MyApp.R;
import com.zzw.MyApp.base.BaseRecyAdapter;
import com.zzw.MyApp.luck.duke.model.DuckLuckModel;
import com.zzw.MyApp.utils.StringUtils;

/**
 * Created by zzw on 2016/7/7.
 * 描述:
 */
public class DuckLuckAdapter extends BaseRecyAdapter<DuckLuckModel> {

    private LayoutInflater inflater;

    public DuckLuckAdapter(Activity context) {
        super(context);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DuckLuckAdapter.DuckLuckViewHolder(inflater.inflate(R.layout.item_duck_luck, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof DuckLuckViewHolder) {
            DuckLuckAdapter.DuckLuckViewHolder viewHolder = (DuckLuckAdapter.DuckLuckViewHolder) holder;
            DuckLuckModel model = mData.get(position);
            viewHolder.itemDuckluckTitle.setText(model.getTitle());
            viewHolder.itemDuckluckList.setText(StringUtils.getStringFromList(context,model.getList()).trim());
        }
    }


    static class DuckLuckViewHolder extends RecyclerView.ViewHolder {

        public TextView itemDuckluckTitle;
        public TextView itemDuckluckList;

        public DuckLuckViewHolder(View view) {
            super(view);
            itemDuckluckTitle = (TextView) view.findViewById(R.id.item_duckluck_title);
            itemDuckluckList = (TextView) view.findViewById(R.id.item_duckluck_list);
        }

    }

}
