package com.xq.mytime.countdown;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.widget.TextView;

import com.xq.mytime.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CountDownActivity1 extends AppCompatActivity {


    @BindView(R.id.item_tv)
    TextView itemTv;
    @BindView(R.id.cardView)
    CardView cardView;
    private Handler handler;
    private int DELAYTIME = 1000;
    private int i = 10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        ButterKnife.bind(this);

        handler = new Handler();
        handler.postDelayed(runnable, DELAYTIME);
    }

    Runnable runnable = new Runnable() {

        @SuppressLint("SetTextI18n")
        @Override
        public void run() {
            try {
                if (i > 0) {
                    handler.postDelayed(this, DELAYTIME);
                    itemTv.setText("" + i);
                    i--;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

}