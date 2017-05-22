package com.example.jiangchuanfa.projectofmediaplayer2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.example.jiangchuanfa.projectofmediaplayer2.MiddleView.BaseFragment;
import com.example.jiangchuanfa.projectofmediaplayer2.MiddleView.Fragment.LocalAudioFragment;
import com.example.jiangchuanfa.projectofmediaplayer2.MiddleView.Fragment.LocalVideoFragment;
import com.example.jiangchuanfa.projectofmediaplayer2.MiddleView.Fragment.NetAudioFragment;
import com.example.jiangchuanfa.projectofmediaplayer2.MiddleView.Fragment.NetVideoFragment;

import java.util.ArrayList;

/**
 * Created by crest on 2017/5/20.
 *
 *
 */

public class MainActivity extends AppCompatActivity {

    private RadioGroup rg_main;
    private ArrayList<BaseFragment> fragments;
    private int position;
    private Fragment tempFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        rg_main = (RadioGroup) findViewById(R.id.rg_main);
        initFragment();
        rg_main.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        rg_main.check(R.id.rb_local_video);


    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new LocalVideoFragment());
        fragments.add(new LocalAudioFragment());
        fragments.add(new NetAudioFragment());
        fragments.add(new NetVideoFragment());


    }

    private class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_local_video:
                    position = 0;
                    break;
                case R.id.rb_local_audio:
                    position = 1;
                    break;
                case R.id.rb_net_audio:
                    position = 2;
                    break;
                case R.id.rb_net_video:
                    position = 3;
                    break;
            }
            BaseFragment currentFragment = fragments.get(position);
            addFragment(currentFragment);
        }

    }

    private void addFragment(BaseFragment currentFragment) {
        if (tempFragment != currentFragment) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            if (!currentFragment.isAdded()) {
                if (tempFragment != null) {
                    ft.hide(tempFragment);
                }
                ft.add(R.id.fl_content, currentFragment);
            } else {
                if (tempFragment != null) {
                    ft.hide(tempFragment);
                }
                ft.show(currentFragment);
            }
            ft.commit();
            tempFragment = currentFragment;
        }
    }

}
