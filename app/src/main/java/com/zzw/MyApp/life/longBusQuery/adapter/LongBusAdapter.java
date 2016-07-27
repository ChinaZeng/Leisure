package com.zzw.MyApp.life.longBusQuery.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zzw.MyApp.R;
import com.zzw.MyApp.base.BaseRecyAdapter;
import com.zzw.MyApp.life.longBusQuery.model.LongBusModel;

import java.util.List;

/**
 * Created by zzw on 2016/7/5.
 * 描述:
 */
public class LongBusAdapter extends BaseRecyAdapter<LongBusModel.ListBean> {

    private LayoutInflater inflater;

    public LongBusAdapter(Activity context) {
        super(context);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LongBusViewHolder(inflater.inflate(R.layout.item_long_bus, parent, false));
    }

    @Override
    public void addItems(List<LongBusModel.ListBean> listBeans) {
        mData.addAll(listBeans);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof LongBusViewHolder) {
            LongBusModel.ListBean bean = mData.get(position);
            LongBusViewHolder longBusViewHolder = (LongBusViewHolder) holder;
            longBusViewHolder.itemLongBusArrive.setText(context.getString(R.string.long_bus_arrive_, bean.getArrive()));
            longBusViewHolder.itemLongBusDate.setText(context.getString(R.string.long_bus_date_, bean.getDate()));
            longBusViewHolder.itemLongBusPrice.setText(context.getString(R.string.long_bus_price_, bean.getPrice()));
            longBusViewHolder.itemLongBusStart.setText(context.getString(R.string.long_bus_start_, bean.getStart()));
        }
    }


    public static class LongBusViewHolder extends RecyclerView.ViewHolder {

        public TextView itemLongBusStart;
        public TextView itemLongBusArrive;
        public TextView itemLongBusDate;
        public TextView itemLongBusPrice;

        public LongBusViewHolder(View view) {
            super(view);
            itemLongBusStart = (TextView) view.findViewById(R.id.item_long_bus_start);
            itemLongBusArrive = (TextView) view.findViewById(R.id.item_long_bus_arrive);
            itemLongBusDate = (TextView) view.findViewById(R.id.item_long_bus_date);
            itemLongBusPrice = (TextView) view.findViewById(R.id.item_long_bus_price);
        }
    }

}
