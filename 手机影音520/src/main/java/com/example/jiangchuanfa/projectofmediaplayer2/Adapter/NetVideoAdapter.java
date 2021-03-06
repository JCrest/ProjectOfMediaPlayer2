package com.example.jiangchuanfa.projectofmediaplayer2.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

import com.example.jiangchuanfa.projectofmediaplayer2.DoMain.MoveInfo;
import com.example.jiangchuanfa.projectofmediaplayer2.R;
import com.example.jiangchuanfa.projectofmediaplayer2.Utils.Utils;




/**
 * Created by crest on 2017/5/23.
 *
 *
 */

public class NetVideoAdapter extends BaseAdapter {

    private final Context context;
    private List<MoveInfo.TrailersBean> datas;
    private Utils utils;
    private ImageOptions imageOptions;

    public NetVideoAdapter(Context context, List<MoveInfo.TrailersBean> datas) {
        this.context = context;
        this.datas = datas;
        utils = new Utils();
        imageOptions = new ImageOptions.Builder()
                .setIgnoreGif(false)//是否忽略gif图。false表示不忽略。不写这句，默认是true
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                .setFailureDrawableId(R.drawable.video_default)
                .setLoadingDrawableId(R.drawable.video_default)
                .build();
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public MoveInfo.TrailersBean getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = View.inflate(context, R.layout.item_net_video,null);
            viewHolder = new ViewHolder();
            viewHolder.tv_duration = (TextView) convertView.findViewById(R.id.tv_duration);
            viewHolder.iv_icon = (ImageView) convertView.findViewById(R.id.iv_icon);
            viewHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.tv_size = (TextView) convertView.findViewById(R.id.tv_size);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //根据位置得到对应的数据
        MoveInfo.TrailersBean trailersBean = datas.get(position);
        viewHolder.tv_name.setText(trailersBean.getMovieName());
        viewHolder.tv_size.setText(trailersBean.getVideoLength()+"秒");
        viewHolder.tv_duration.setText(trailersBean.getVideoTitle());
        x.image().bind(viewHolder.iv_icon, trailersBean.getCoverImg(),imageOptions);


        return convertView;
    }

    static class ViewHolder{
        ImageView iv_icon;
        TextView tv_name;
        TextView tv_duration;
        TextView tv_size;
    }
}
