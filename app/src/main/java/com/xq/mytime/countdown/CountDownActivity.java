package com.xq.mytime.countdown;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xq.mytime.MyAdapter;
import com.xq.mytime.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountDownActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ArrayList<String> list = new ArrayList<>();
        list.add("倒计时handler.postDelayed");
        list.add("倒计时Timer与TimerTask");
        list.add("倒计时Timer+TimerTask+Handler");
        list.add("倒计时Handler与Message");
        list.add("倒计时Handler与Runnable（最简洁）");
        MyAdapter myAdapter = new MyAdapter(R.layout.activity_item, list);
        recyclerview.setAdapter(myAdapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        myAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (position == 0) {
                    toDetail(CountDownActivity1.class);
                } else if (position == 1) {
                    toDetail(CountDownActivity2.class);
                } else if (position == 2) {
                    toDetail(CountDownActivity3.class);
                } else if (position == 3) {
                    toDetail(CountDownActivity4.class);
                } else if (position == 4) {
                    toDetail(CountDownActivity5.class);
                }
            }
        });

    }

    private void toDetail(Class<?> cls) {
        final Intent intent = new Intent();
        intent.setClass(CountDownActivity.this, cls);
        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}