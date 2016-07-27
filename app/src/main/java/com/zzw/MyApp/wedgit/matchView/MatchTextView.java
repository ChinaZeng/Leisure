package com.zzw.MyApp.wedgit.matchView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;

import com.zzw.MyApp.R;
import com.zzw.MyApp.utils.TDevice;
import com.zzw.MyApp.wedgit.matchView.util.MatchView;


/**
 * Description:MatchTextView
 * User: Lj
 * Date: 2014-12-03
 * Time: 10:48
 * FIXME
 */
public class MatchTextView extends MatchView {

    String mContent;
    float mTextSize;
    int mTextColor;

    public MatchTextView(Context context) {
        super(context);
        init();
    }

    public MatchTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
    }

    public MatchTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs);
    }

    void initAttrs(Context context, AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.match);
        mTextSize = TDevice.px2sp(context, a.getDimension(R.styleable.match_textSize, 20));
        mTextColor = a.getColor(R.styleable.match_textColor, Color.WHITE);
        mContent = a.getString(R.styleable.match_text);
        init();
    }

    void init() {
        this.setBackgroundColor(Color.TRANSPARENT);
        if (!TextUtils.isEmpty(mContent)) {
            setTextColor(mTextColor);
            setTextSize(mTextSize);
            initWithString(mContent);
            show();
        }
    }


    public void setText(String text) {
        this.mContent = text;
        init();
    }

}
