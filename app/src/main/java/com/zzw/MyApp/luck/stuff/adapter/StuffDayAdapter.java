package com.zzw.MyApp.luck.stuff.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zzw.MyApp.R;
import com.zzw.MyApp.UI;
import com.zzw.MyApp.base.BaseRecyAdapter;
import com.zzw.MyApp.luck.stuff.model.StuffModel;

/**
 * Created by zzw on 2016/7/7.
 * 描述:
 */
public class StuffDayAdapter extends BaseRecyAdapter<StuffModel> {

    private LayoutInflater inflater;

    public StuffDayAdapter(Activity context) {
        super(context);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StuffDayViewHolder(inflater.inflate(R.layout.item_stuff_luck, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof StuffDayViewHolder) {
            StuffDayViewHolder viewHolder = (StuffDayViewHolder) holder;
            final StuffModel model = mData.get(position);
            viewHolder.itemStuffLuckYangli.setText(context.getString(R.string.yang_li_, model.getYangli()));
            viewHolder.itemStuffLuckYinli.setText(context.getString(R.string.yinli_, model.getYinli()));
            viewHolder.itemStuffLuckWuxing.setText(context.getString(R.string.wuxing_, model.getWuxing()));
            viewHolder.itemStuffLuckChongsha.setText(context.getString(R.string.chongsha_, model.getChongsha()));
            viewHolder.itemStuffLuckBaiji.setText(context.getString(R.string.baiji_, model.getBaiji()));
            viewHolder.itemStuffLuckJishen.setText(context.getString(R.string.jishen_, model.getJishen()));
            viewHolder.itemStuffLuckYi.setText(context.getString(R.string.yi_, model.getYi()));
            viewHolder.itemStuffLuckXiongshen.setText(context.getString(R.string.xiongshen_, model.getXiongshen()));
            viewHolder.itemStuffLuckJi.setText(context.getString(R.string.ji_, model.getJi()));

            viewHolder.itemStuffLuckIntoHour.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UI.showStuffHourActivity(context, model.getYangli());
                }
            });
        }

    }

    static class StuffDayViewHolder extends RecyclerView.ViewHolder {

        public TextView itemStuffLuckYangli;
        public TextView itemStuffLuckYinli;
        public TextView itemStuffLuckWuxing;
        public TextView itemStuffLuckChongsha;
        public TextView itemStuffLuckBaiji;
        public TextView itemStuffLuckJishen;
        public TextView itemStuffLuckYi;
        public TextView itemStuffLuckXiongshen;
        public TextView itemStuffLuckJi;
        public TextView itemStuffLuckIntoHour;

        public StuffDayViewHolder(View view) {
            super(view);
            itemStuffLuckYangli = (TextView) view.findViewById(R.id.item_stuff_luck_yangli);
            itemStuffLuckYinli = (TextView) view.findViewById(R.id.item_stuff_luck_yinli);
            itemStuffLuckWuxing = (TextView) view.findViewById(R.id.item_stuff_luck_wuxing);
            itemStuffLuckChongsha = (TextView) view.findViewById(R.id.item_stuff_luck_chongsha);
            itemStuffLuckBaiji = (TextView) view.findViewById(R.id.item_stuff_luck_baiji);
            itemStuffLuckJishen = (TextView) view.findViewById(R.id.item_stuff_luck_jishen);
            itemStuffLuckYi = (TextView) view.findViewById(R.id.item_stuff_luck_yi);
            itemStuffLuckXiongshen = (TextView) view.findViewById(R.id.item_stuff_luck_xiongshen);
            itemStuffLuckJi = (TextView) view.findViewById(R.id.item_stuff_luck_ji);
            itemStuffLuckIntoHour = (TextView) view.findViewById(R.id.item_stuff_luck_into_hour);
        }
    }
}
