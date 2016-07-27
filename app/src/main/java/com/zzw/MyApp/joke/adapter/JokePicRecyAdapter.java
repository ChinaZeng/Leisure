package com.zzw.MyApp.joke.adapter;

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
import com.zzw.MyApp.joke.model.JokePicModel;
import com.zzw.MyApp.operate.Image.ImageLoadClass;

/**
 * Created by zzw on 2016/6/13.
 * 描述:
 */
public class JokePicRecyAdapter extends BaseRecyAdapter<JokePicModel> {

    private LayoutInflater inflater;

    public JokePicRecyAdapter(Activity context) {
        super(context);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new JokePicRecyAdapter.JokePicViewHolder(inflater.inflate(R.layout.item_joke_pic, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof JokePicViewHolder) {
            final JokePicViewHolder viewHolder = (JokePicViewHolder) holder;
            final JokePicModel jokePicModel = mData.get(position);
            viewHolder.titleText.setText(jokePicModel.getContent() + "");
            viewHolder.timeText.setText(jokePicModel.getUpdatetime() + "");
            ImageLoadClass.loadImage(context, jokePicModel.getUrl(), viewHolder.imageView);
            viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UI.showImageActivity(context, jokePicModel.getUrl());
                }
            });
        }
    }


    public static class JokePicViewHolder extends RecyclerView.ViewHolder {

        public TextView titleText, timeText;
        public ImageView imageView;

        public JokePicViewHolder(View itemView) {
            super(itemView);
            titleText = (TextView) itemView.findViewById(R.id.item_joke_pic_title);
            timeText = (TextView) itemView.findViewById(R.id.item_joke_pic_time);
            imageView = (ImageView) itemView.findViewById(R.id.item_joke_pic_image);
        }
    }
}
