package com.zzw.MyApp.base;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzw on 2016/6/13.
 * 描述:
 */
public abstract class BaseRecyAdapter<Item> extends RecyclerView.Adapter {

    protected final List<Item> mData = new ArrayList<Item>();

    protected Activity context;

    public BaseRecyAdapter(Activity context) {
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public void addItem(Item item) {
        mData.add(item);
        notifyItemInserted(mData.size() - 1);
    }

    public void addItemToTop(Item item) {
        mData.add(0, item);
        notifyItemInserted(0);
    }

    public void addItems(List<Item> items) {
        mData.addAll(items);
        notifyItemInserted(mData.size() - items.size() - 1);
    }

    public void addItemsToTop(List<Item> items) {
        mData.addAll(0, items);
        notifyItemInserted(0);
    }

    public void updateItem(int pos, Item item) {
        if (mData != null && mData.size() > pos) {
            mData.set(pos, item);
            notifyItemChanged(pos);
        }
    }

    public void removeItem(int pos, Item item) {
        mData.remove(item);
        notifyItemRemoved(pos);
    }

    public void clear() {
        mData.clear();
        notifyDataSetChanged();
    }
}
