package com.zzw.MyApp.picture.adapter;

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
import com.zzw.MyApp.picture.model.GalleryModel;
import com.zzw.MyApp.operate.Image.ImageLoadClass;
import com.zzw.MyApp.utils.TDevice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzw on 2016/7/8.
 * 描述:
 */
public class GalleryAdapter extends BaseRecyAdapter<GalleryModel> {

    private List<Integer> mHeights = new ArrayList<>();
    private LayoutInflater inflater;
    private int ScreenHeight;

    public GalleryAdapter(Activity context) {
        super(context);
        inflater = LayoutInflater.from(context);
        ScreenHeight = TDevice.getDisplayMetrics(context).heightPixels;
    }

    private void addHeights(List<GalleryModel> list) {
        for (int i = 0; i < list.size(); i++) {
            mHeights.add((int) (ScreenHeight * 0.25 + Math.random() * ScreenHeight * 0.25));
        }
    }

    @Override
    public void addItems(List<GalleryModel> list) {
        mData.addAll(list);
        addHeights(list);
        notifyDataSetChanged();
    }

    @Override
    public void clear() {
        mData.clear();
        mHeights.clear();
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GalleryViewHolder(inflater.inflate(R.layout.item_gallery, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof GalleryViewHolder) {
            GalleryViewHolder viewHolder = (GalleryViewHolder) holder;
            final GalleryModel model = mData.get(position);
            viewHolder.item_gallery_title.setText(model.getTitle());
            ImageLoadClass.loadImage(context, model.getImg(), viewHolder.item_gallery_img);
            ViewGroup.LayoutParams layoutParams = viewHolder.item_gallery_root.getLayoutParams();
            layoutParams.height = mHeights.get(position);


            viewHolder.item_gallery_root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UI.showImageActivity(context, model.getImg());
                }
            });
        }
    }


    static class GalleryViewHolder extends RecyclerView.ViewHolder {
        public ImageView item_gallery_img;
        public TextView item_gallery_title;
        public View item_gallery_root;

        public GalleryViewHolder(View itemView) {
            super(itemView);
            item_gallery_root = itemView.findViewById(R.id.item_gallery_root);
            item_gallery_img = (ImageView) itemView.findViewById(R.id.item_gallery_img);
            item_gallery_title = (TextView) itemView.findViewById(R.id.item_gallery_title);
        }
    }
}
