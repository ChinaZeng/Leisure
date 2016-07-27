package com.zzw.MyApp.joke.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zzw.MyApp.R;
import com.zzw.MyApp.base.BaseRecyAdapter;
import com.zzw.MyApp.joke.model.JokeTextModel;

import java.util.List;

/**
 * Created by zzw on 2016/6/13.
 * 描述:
 */
public class JokeTextRecyAdapter extends BaseRecyAdapter<JokeTextModel> {

    private LayoutInflater inflater;

    public JokeTextRecyAdapter(Activity context) {
        super(context);
        inflater = LayoutInflater.from(context);
    }


    @Override
    public void addItems(List<JokeTextModel> list) {
        mData.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new JokeTextViewHolder(inflater.inflate(R.layout.item_joke_text, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof JokeTextViewHolder) {
            JokeTextViewHolder viewHolder = (JokeTextViewHolder) holder;
            JokeTextModel jokeTextModel = mData.get(position);
            viewHolder.contentText.setText(jokeTextModel.getContent() + "");
            viewHolder.timeText.setText(jokeTextModel.getUpdatetime() + "");
        }
    }


    public static class JokeTextViewHolder extends RecyclerView.ViewHolder {

        public TextView contentText, timeText;

        public JokeTextViewHolder(View itemView) {
            super(itemView);
            contentText = (TextView) itemView.findViewById(R.id.item_joke_text_content);
            timeText = (TextView) itemView.findViewById(R.id.item_joke_text_time);
        }
    }
}
