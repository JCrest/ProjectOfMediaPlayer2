package com.example.jiangchuanfa.projectofmediaplayer2.CustomView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by crest on 2017/5/23.
 */

public class VitamioVideoView extends io.vov.vitamio.widget.VideoView{

    public VitamioVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //保存测量的结果
        setMeasuredDimension(widthMeasureSpec,heightMeasureSpec);
    }

    /**
     * 设置视频的宽和高的方法
     * @param width
     * @param height
     */
    public void setVideoSize(int width,int height){
        ViewGroup.LayoutParams l = getLayoutParams();
        l.width = width;
        l.height = height;
        setLayoutParams(l);
    }
}
