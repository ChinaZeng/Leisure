package com.zzw.MyApp.history.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zzw.MyApp.R;
import com.zzw.MyApp.UI;
import com.zzw.MyApp.base.BaseRecyAdapter;
import com.zzw.MyApp.history.model.HistoryModel;
import com.zzw.MyApp.operate.Image.ImageLoadClass;

/**
 * Created by zzw on 2016/6/30.
 * 描述:
 */
public class HistoryFragmentAdapter extends BaseRecyAdapter<HistoryModel> {

    private LayoutInflater inflater;

    public HistoryFragmentAdapter(Activity context) {
        super(context);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HistoryViewHolder(inflater.inflate(R.layout.item_his, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HistoryViewHolder) {
            HistoryViewHolder viewHolder = (HistoryViewHolder) holder;
            final HistoryModel model = mData.get(position);
            viewHolder.date.setText(model.getDate());
            viewHolder.title.setText(model.getTitle());
            String imageUrl = "http://images.juheapi.com/history/" + model.getE_id() + "_1.jpg";
            ImageLoadClass.loadImage(context, imageUrl, viewHolder.imageView);


            viewHolder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    UI.showHistoryActivity(context, model.getE_id());
                }
            });
        }
    }


    public static class HistoryViewHolder extends RecyclerView.ViewHolder {

        public TextView date, title;
        public ImageView imageView;
        public View view;


        public HistoryViewHolder(View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.item_his_date);
            title = (TextView) itemView.findViewById(R.id.item_his_title);
            imageView = (ImageView) itemView.findViewById(R.id.item_his_image);
            view = itemView.findViewById(R.id.item_his_cardView);
        }
    }
}
