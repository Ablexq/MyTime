package com.xq.mytime.time;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xq.mytime.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GetTimeActivity2 extends AppCompatActivity {

    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;

    private final DateFormat defaultFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    private final DateFormat mFormat = new SimpleDateFormat("yyyy MM dd HH:mm:ss", Locale.getDefault());

    private final long timeMillis = 1493887049000L;// 2017-05-04 16:37:29
    private final Date timeDate = new Date(timeMillis);
    private final String timeString = defaultFormat.format(timeDate);
    private final String timeStringFormat = mFormat.format(timeDate);
    private final long tomorrowTimeMillis = 1493973449000L;
    private final Date tomorrowTimeDate = new Date(tomorrowTimeMillis);
    private final String tomorrowTimeString = defaultFormat.format(tomorrowTimeDate);
    private final String tomorrowTimeStringFormat = mFormat.format(tomorrowTimeDate);
    private final long delta = 8;// 允许误差8ms

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time2);
        ButterKnife.bind(this);
    }

    @SuppressLint("SetTextI18n")
    @OnClick({R.id.btn1, R.id.btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1: {
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.SECOND, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.MILLISECOND, 0);
                long timeInMillis = cal.getTimeInMillis();

                long todayTimeMillis = System.currentTimeMillis();
                String todayTimeString = TimeUtils.millis2String(todayTimeMillis);
                String todayTimeStringFormat = TimeUtils.millis2String(todayTimeMillis, mFormat);
                Date todayTimeDate = TimeUtils.millis2Date(todayTimeMillis);
                long tomorrowTimeMillis = todayTimeMillis + TimeConstants.DAY;
                String tomorrowTimeString = TimeUtils.millis2String(tomorrowTimeMillis);
                Date tomorrowTimeDate = TimeUtils.millis2Date(tomorrowTimeMillis);

                System.out.println("=============" + TimeUtils.isToday(todayTimeString));
                System.out.println("=============" + TimeUtils.isToday(todayTimeStringFormat, mFormat));
                System.out.println("=============" + TimeUtils.isToday(todayTimeDate));
                System.out.println("=============" + TimeUtils.isToday(todayTimeMillis));

                System.out.println("=============" + TimeUtils.isToday(tomorrowTimeString));
                System.out.println("=============" + TimeUtils.isToday(tomorrowTimeStringFormat, mFormat));
                System.out.println("=============" + TimeUtils.isToday(tomorrowTimeDate));
                System.out.println("=============" + TimeUtils.isToday(tomorrowTimeMillis));
            }
            break;


            case R.id.btn2: {
                System.out.println("=============" + TimeUtils.getTimeSpanByNow(TimeUtils.getNowString(), TimeConstants.MSEC));
                System.out.println("=============" + TimeUtils.getTimeSpanByNow(TimeUtils.getNowString(mFormat), mFormat, TimeConstants.MSEC));
                System.out.println("=============" + TimeUtils.getTimeSpanByNow(TimeUtils.getNowDate(), TimeConstants.MSEC));
                System.out.println("=============" + TimeUtils.getTimeSpanByNow(TimeUtils.getNowMills(), TimeConstants.MSEC));
            }
            break;
        }
    }


}
