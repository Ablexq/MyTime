package com.xq.mytime.countdown;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.xq.mytime.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountDownActivity5 extends AppCompatActivity {

    @BindView(R.id.item_tv)
    TextView itemTv;

    private int recLen = 11;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        ButterKnife.bind(this);

        handler.postDelayed(runnable, 1000);
    }

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @SuppressLint("SetTextI18n")
        @Override
        public void run() {
            recLen--;
            if (recLen == 0) {
                return;
            }
            itemTv.setText("" + recLen);
            handler.postDelayed(this, 1000);
        }
    };

}