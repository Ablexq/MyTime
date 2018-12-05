package com.xq.mytime.countdown;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.xq.mytime.R;

import java.util.Timer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountDownActivity4 extends AppCompatActivity {


    @BindView(R.id.item_tv)
    TextView itemTv;
    @BindView(R.id.cardView)
    CardView cardView;

    private Timer timer;
    private int recLen = 11;
    @SuppressLint("HandlerLeak")
    private final Handler handler = new Handler() {

        @SuppressLint("SetTextI18n")
        public void handleMessage(Message msg) {         // handle message
            switch (msg.what) {
                case 1:
                    recLen--;
                    itemTv.setText("" + recLen);

                    if (recLen > 0) {
                        Message message = handler.obtainMessage(1);
                        handler.sendMessageDelayed(message, 1000);      // send message
                    } else {
                        itemTv.setVisibility(View.GONE);
                    }
            }

            super.handleMessage(msg);
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        ButterKnife.bind(this);

        Message message = handler.obtainMessage(1);     // Message
        handler.sendMessageDelayed(message, 1000);
    }


}