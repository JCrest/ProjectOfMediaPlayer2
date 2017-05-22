package com.example.jiangchuanfa.projectofmediaplayer2.app;


import android.app.Application;

import org.xutils.x;

import io.vov.vitamio.BuildConfig;


/**
 * Created by crest on 2017/5/22.
 *
 *
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
