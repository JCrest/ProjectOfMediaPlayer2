package com.example.jiangchuanfa.projectofmediaplayer2.MiddleView.Fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.jiangchuanfa.projectofmediaplayer2.MiddleView.BaseFragment;

/**
 * Created by crest on 2017/5/20.
 */

public class LocalAudioFragment extends BaseFragment {
    private TextView textView;
    @Override
    public View initView() {
        Log.e("TAG","LocalAudioPager-initView");
        textView = new TextView(context);
        textView.setTextSize(30);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        return textView;


    }
    @Override
    public void initData(){
        super.initData();
        Log.e("TAG","LocalAudioPager-initData");
        textView.setText("本地音乐的内容");
    }
}
