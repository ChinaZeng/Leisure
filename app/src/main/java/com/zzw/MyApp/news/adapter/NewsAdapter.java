package com.zzw.MyApp.news.adapter;

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
import com.zzw.MyApp.news.model.NewsModel;
import com.zzw.MyApp.operate.Image.ImageLoadClass;

/**
 * Created by zzw on 2016/6/15.
 * 描述:
 */
public class NewsAdapter extends BaseRecyAdapter<NewsModel> {
    private LayoutInflater inflater;

    public NewsAdapter(Activity context) {
        super(context);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsViewHolder(inflater.inflate(R.layout.item_news, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof NewsViewHolder) {
            NewsViewHolder viewHolder = (NewsViewHolder) holder;
            NewsModel newsModel = mData.get(position);
            viewHolder.titleText.setText(newsModel.getTitle() + "");
            viewHolder.sourceText.setText(newsModel.getSource() + "");
            ImageLoadClass.loadImage(context, newsModel.getFirstImg() + "", viewHolder.imageView);

            final String url = newsModel.getUrl();
            viewHolder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UI.showWebActivity(context, url);
                }
            });
        }
    }


    public static class NewsViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView titleText, sourceText;
        public View view;

        public NewsViewHolder(View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.item_news_cardView);
            imageView = (ImageView) itemView.findViewById(R.id.item_news_image);
            titleText = (TextView) itemView.findViewById(R.id.item_news_title);
            sourceText = (TextView) itemView.findViewById(R.id.item_news_source);
        }
    }


}
