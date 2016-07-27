package com.zzw.MyApp.history.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zzw.MyApp.R;
import com.zzw.MyApp.UI;
import com.zzw.MyApp.base.BaseRecyAdapter;
import com.zzw.MyApp.history.model.HistoryDetailsModel;
import com.zzw.MyApp.operate.Image.ImageLoadClass;

/**
 * Created by zzw on 2016/7/1.
 * 描述:
 */
public class HistoryActivityMidAdapter extends BaseRecyAdapter<HistoryDetailsModel.PicUrlBean> {

    private LayoutInflater inflater;
    private String title, content;

    //item类型
    public static final int ITEM_TYPE_HEADER = 0;
    public static final int ITEM_TYPE_CONTENT = 1;
    public static final int ITEM_TYPE_BOTTOM = 2;

    private int mHeaderCount = 1;//头部View个数
    private int mBottomCount = 1;//底部View个数

    public HistoryActivityMidAdapter(String title, Activity context, String content) {
        super(context);
        inflater = LayoutInflater.from(context);
        this.title = title;
        this.content = content;
    }


    //内容长度
    public int getContentItemCount() {
        return mData.size();
    }

    //判断当前item是否是HeadView
    public boolean isHeaderView(int position) {
        return mHeaderCount != 0 && position < mHeaderCount;
    }

    //判断当前item是否是FooterView
    public boolean isBottomView(int position) {
        return mBottomCount != 0 && position >= (mHeaderCount + getContentItemCount());
    }

    @Override
    public int getItemCount() {
        return mHeaderCount + getContentItemCount() + mBottomCount;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case ITEM_TYPE_HEADER:
                return new TitleViewHolder(inflater.inflate(R.layout.item_text, parent, false));
            case ITEM_TYPE_BOTTOM:
                return new BottomViewHolder(inflater.inflate(R.layout.item_text, parent, false));
            default:
                return new HistoryActivityViewHolder(inflater.inflate(R.layout.item_his_activity, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HistoryActivityViewHolder) {
            HistoryActivityViewHolder viewHolder = (HistoryActivityViewHolder) holder;
            final HistoryDetailsModel.PicUrlBean bean = mData.get(position - mHeaderCount);
            viewHolder.imTitle.setText(bean.getPic_title());
            ImageLoadClass.loadImage(context, bean.getUrl(), viewHolder.imageView);
            viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    UI.showImageActivity(context, bean.getUrl());
                }
            });
        } else if (holder instanceof TitleViewHolder) {
            TitleViewHolder viewHolder = (TitleViewHolder) holder;
            viewHolder.titleText.setText(title + "");
        } else if (holder instanceof BottomViewHolder) {
            BottomViewHolder viewHolder = (BottomViewHolder) holder;
            viewHolder.contentText.setText(content + "");
        }
    }

    //判断当前item类型
    @Override
    public int getItemViewType(int position) {
        if (isHeaderView(position)) {
            //头部View
            return ITEM_TYPE_HEADER;
        } else if (isBottomView(position)) {
            //底部View
            return ITEM_TYPE_BOTTOM;
        } else {
            //内容View
            return ITEM_TYPE_CONTENT;
        }
    }


    public static class TitleViewHolder extends RecyclerView.ViewHolder {
        public TextView titleText;

        public TitleViewHolder(View itemView) {
            super(itemView);
            titleText = (TextView) itemView.findViewById(R.id.text);
            titleText.setGravity(Gravity.CENTER);
            titleText.setPadding(3, 5, 3, 5);
        }
    }

    public static class BottomViewHolder extends RecyclerView.ViewHolder {
        public TextView contentText;

        public BottomViewHolder(View itemView) {
            super(itemView);
            contentText = (TextView) itemView.findViewById(R.id.text);
        }
    }


    public static class HistoryActivityViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView imTitle;

        public HistoryActivityViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_his_activity_image);
            imTitle = (TextView) itemView.findViewById(R.id.item_his_activity_text);
        }
    }
}
