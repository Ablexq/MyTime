package com.xq.mytime.countdown;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.xq.mytime.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountDownActivity2 extends AppCompatActivity {


    @BindView(R.id.item_tv)
    TextView itemTv;
    @BindView(R.id.cardView)
    CardView cardView;
    private int recLen = 11;
    private Timer timer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        ButterKnife.bind(this);

        timer = new Timer();
        timer.schedule(task, 1000, 1000); // 1s后执行task,经过1s再次执行
    }

    TimerTask task = new TimerTask() {

        @Override
        public void run() {
            runOnUiThread(new Runnable() {      // UI thread
                @SuppressLint("SetTextI18n")
                @Override
                public void run() {
                    recLen--;
                    itemTv.setText("" + recLen);
                    if (recLen < 1) {
                        timer.cancel();
                        itemTv.setVisibility(View.GONE);
                    }
                }
            });
        }
    };

}