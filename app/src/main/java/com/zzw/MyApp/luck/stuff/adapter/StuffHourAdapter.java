package com.zzw.MyApp.luck.stuff.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zzw.MyApp.R;
import com.zzw.MyApp.base.BaseRecyAdapter;
import com.zzw.MyApp.luck.stuff.model.StuffHourModel;

/**
 * Created by zzw on 2016/7/7.
 * 描述:
 */
public class StuffHourAdapter extends BaseRecyAdapter<StuffHourModel> {

    private LayoutInflater inflater;

    public StuffHourAdapter(Activity context) {
        super(context);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StuffHourViewHolder(inflater.inflate(R.layout.item_stuff_hour_luck, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof StuffHourViewHolder) {
            StuffHourViewHolder viewHolder = (StuffHourViewHolder) holder;
            StuffHourModel model = mData.get(position);
            viewHolder.itemStuffHourLuckDate.setText(model.getYangli());
            viewHolder.itemStuffHourLuckHours.setText(context.getString(R.string.hours_, model.getHours()));
            viewHolder.itemStuffHourLuckDes.setText(context.getString(R.string.des_, model.getDes()));
            viewHolder.itemStuffHourLuckYi.setText(context.getString(R.string.yi_, model.getYi()));
            viewHolder.itemStuffHourLuckJi.setText(context.getString(R.string.ji_, model.getJi()));
        }
    }


    static class StuffHourViewHolder extends RecyclerView.ViewHolder {
        public TextView itemStuffHourLuckDate;
        public TextView itemStuffHourLuckHours;
        public TextView itemStuffHourLuckDes;
        public TextView itemStuffHourLuckYi;
        public TextView itemStuffHourLuckJi;

        public StuffHourViewHolder(View view) {
            super(view);
            itemStuffHourLuckDate = (TextView) view.findViewById(R.id.item_stuff_hour_luck_date);
            itemStuffHourLuckHours = (TextView) view.findViewById(R.id.item_stuff_hour_luck_hours);
            itemStuffHourLuckDes = (TextView) view.findViewById(R.id.item_stuff_hour_luck_des);
            itemStuffHourLuckYi = (TextView) view.findViewById(R.id.item_stuff_hour_luck_yi);
            itemStuffHourLuckJi = (TextView) view.findViewById(R.id.item_stuff_hour_luck_ji);
        }
    }
}
