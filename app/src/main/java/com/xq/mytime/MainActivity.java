package com.xq.mytime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xq.mytime.countdown.CountDownActivity;
import com.xq.mytime.countdown.CountDownActivity3;
import com.xq.mytime.countdown.CountDownActivity4;
import com.xq.mytime.countdown.CountDownActivity5;
import com.xq.mytime.time.GetTimeActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ArrayList<String> list = new ArrayList<>();
        list.add("倒计时");
        list.add("获取时间");
        MyAdapter myAdapter = new MyAdapter(R.layout.activity_item, list);
        recyclerview.setAdapter(myAdapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        myAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (position == 0) {
                    toDetail(CountDownActivity.class);
                } else if (position == 1) {
                    toDetail(GetTimeActivity.class);
                } else if (position == 2) {
//                    toDetail(CountDownActivity3.class);
                } else if (position == 3) {
//                    toDetail(CountDownActivity4.class);
                } else if (position == 4) {
//                    toDetail(CountDownActivity5.class);
                }
            }
        });

    }

    private void toDetail(Class<?> cls) {
        final Intent intent = new Intent();
        intent.setClass(MainActivity.this, cls);
        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}