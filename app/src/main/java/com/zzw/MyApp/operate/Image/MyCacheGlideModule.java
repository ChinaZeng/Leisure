package com.zzw.MyApp.operate.Image;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.module.GlideModule;
import com.zzw.MyApp.Constans;

/**
 * Created by zzw on 2016/8/1.
 * 描述:
 */
public class MyCacheGlideModule implements GlideModule {

    @Override
    public void applyOptions(Context context, GlideBuilder glideBuilder) {
//        glideBuilder.setDiskCache(new DiskLruCacheFactory(Constans.GLIDE_CACHE_DIR, Constans.GLIDE_CACHE_SIZE));
        glideBuilder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
