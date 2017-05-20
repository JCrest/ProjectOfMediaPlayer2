package com.example.jiangchuanfa.projectofmediaplayer2.MiddleView.Fragment;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jiangchuanfa.projectofmediaplayer2.DoMain.MediaItem;
import com.example.jiangchuanfa.projectofmediaplayer2.MiddleView.BaseFragment;
import com.example.jiangchuanfa.projectofmediaplayer2.R;

import java.util.ArrayList;

/**
 * Created by crest on 2017/5/20.
 */

public class LocalVideoFragment extends BaseFragment {

    private ListView lv;
    private TextView tv_nodata;
    private ArrayList<MediaItem> mediaItems;

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.fragment_local_video, null);
        lv = (ListView) view.findViewById(R.id.lv);
        tv_nodata = (TextView) view.findViewById(R.id.tv_nodata);
        return view;
    }

    @Override
    public void initData() {
        getData();
    }

    private void getData() {
        new Thread() {
            public void run() {
                mediaItems = new ArrayList<MediaItem>();
                ContentResolver resolver = context.getContentResolver();
                Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                String[] objs = {
                        MediaStore.Video.Media.DISPLAY_NAME,
                        MediaStore.Video.Media.DURATION,
                        MediaStore.Video.Media.SIZE,
                        MediaStore.Video.Media.DATA
                };
                Cursor cursor = resolver.query(uri, objs, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String name = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DISPLAY_NAME));
                        long duration = cursor.getLong(cursor.getColumnIndex(MediaStore.Video.Media.DURATION));
                        long size = cursor.getLong(cursor.getColumnIndex(MediaStore.Video.Media.SIZE));
                        String data = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DATA));
                        mediaItems.add(new MediaItem(name, duration, size, data));
                    }
                    cursor.close();
                }
            }
        }.start();
    }
}
