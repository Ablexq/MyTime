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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GetTimeActivity1 extends AppCompatActivity {

    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.tv4)
    TextView tv4;
    @BindView(R.id.btn4)
    Button btn4;
    @BindView(R.id.tv5)
    TextView tv5;
    @BindView(R.id.btn5)
    Button btn5;
    @BindView(R.id.tv6)
    TextView tv6;
    @BindView(R.id.btn6)
    Button btn6;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time1);
        ButterKnife.bind(this);


        //月
        int timesMonthmorning = TimeUtil.getTimesMonthmorning();
        int timesMonthnight = TimeUtil.getTimesMonthnight();
        //日
        int timesmorning = TimeUtil.getTimesmorning();
        int timesnight = TimeUtil.getTimesnight();
        //周
        int timesWeekmorning = TimeUtil.getTimesWeekmorning();
        int timesWeeknight = TimeUtil.getTimesWeeknight();
        System.out.println("timesMonthmorning========================" + timesMonthmorning);
        System.out.println("timesMonthnight========================" + timesMonthnight);
        System.out.println("timesmorning========================" + timesmorning);
        System.out.println("timesnight========================" + timesnight);
        System.out.println("timesWeekmorning========================" + timesWeekmorning);
        System.out.println("timesWeeknight========================" + timesWeeknight);

        int timesmorning5 = TimeUtil.getTimesmorning5();
        System.out.println("timesmorning5======================" + timesmorning5);
        long nowTime = TimeUtil.getNowTime();
        System.out.println("nowTime====================================" + nowTime);

        try {
            boolean today1 = TimeUtil.isToday("2018-12-6 10:10:30");
            System.out.println("today1===================" + today1);//

            boolean today2 = TimeUtil.isToday("2018-12-5 10:10:30");
            System.out.println("today2===================" + today2);

            boolean today3 = TimeUtil.isToday("2018-12-7 10:10:30");
            System.out.println("today3===================" + today3);

            boolean today4 = TimeUtil.isToday("2018-12-5");
            System.out.println("today4===================" + today4);

            /*--------------------------------------------------------------*/

            boolean today5 = TimeUtil.isYesterday("2018-12-6 10:10:30");
            System.out.println("today5===================" + today5);

            boolean today6 = TimeUtil.isYesterday("2018-12-5 10:10:30");//
            System.out.println("today6===================" + today6);

            boolean today7 = TimeUtil.isYesterday("2018-12-7 10:10:30");
            System.out.println("today7===================" + today7);

            boolean today8 = TimeUtil.isYesterday("2018-12-5");
            System.out.println("today8===================" + today8);//
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /*======================================================================*/
        try {
            Date date = string2Date("2018-12-6 9:33:10", "yyyy-MM-dd HH:mm:ss");
            String dateDiff = TimeUtil.getDateDiff(date.getTime());
            System.out.println("dateDiff========================" + dateDiff);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*=====================================================================*/


    }

    @SuppressLint("SetTextI18n")
    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1: {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
                calendar.setTimeInMillis(System.currentTimeMillis());

                //年
                int year = calendar.get(Calendar.YEAR);
                //月
                int month = calendar.get(Calendar.MONTH) + 1;
                //日
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                //小时
                // 24小时表示
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
//                int hour = calendar.get(Calendar.HOUR);
                //分钟
                int minute = calendar.get(Calendar.MINUTE);
                //秒
                int second = calendar.get(Calendar.SECOND);

                long timeInMillis = calendar.getTimeInMillis();
                System.out.println("timeInMillis=====================" + timeInMillis);

                String my_time = "" + year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
                tv1.setText(my_time);
            }
            break;


            case R.id.btn2: {
                System.out.println("date.currentTimeMillis==============" + new Date(System.currentTimeMillis()));
                tv2.setText(date2String(new Date(System.currentTimeMillis()), "yyyy年MM月dd日 EEE HH:mm:ss"));
            }
            break;

            case R.id.btn3: {
                System.out.println("date==============" + new Date());
                tv3.setText(date2String(Calendar.getInstance().getTime(), "yyyy-MM-dd EEE HH:mm:ss"));
            }
            break;

            case R.id.btn4:
                try {
                    long time = string2Date("2012-1-13 星期二 17:26:33", "yyyy-MM-dd EEE HH:mm:ss").getTime();
                    System.out.println("time============================" + time);
                    tv4.setText("" + time);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case R.id.btn5: {
                Time t = new Time();
                t.setToNow(); // 取得系统时间。
                int year = t.year;
                int month = t.month + 1;
                int day = t.monthDay;
                int hour = t.hour; // 0-23
                int minute = t.minute;
                int second = t.second;
                String my_time = "" + year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
                tv5.setText(my_time);
            }
            break;

            case R.id.btn6: {
                Calendar calendar = Calendar.getInstance();

                {//一年后的今天
                    calendar.add(Calendar.YEAR, 1);
                    // 获取年
                    int year = calendar.get(Calendar.YEAR);
                    // 获取月
                    int month = calendar.get(Calendar.MONTH) + 1;
                    // 获取日
                    int day = calendar.get(Calendar.DAY_OF_MONTH);
                    System.out.println("===========一年后的今天：" + year + "年" + month + "月" + day + "日");
                }

                {//获取任意一个月的最后一天
                    // 假设求6月的最后一天
                    int currentMonth = 6;
                    // 先求出7月份的第一天，实际中这里6为外部传递进来的currentMonth变量
                    // 1
                    calendar.set(calendar.get(Calendar.YEAR), currentMonth, 1);

                    calendar.add(Calendar.DATE, -1);

                    // 获取日
                    int day = calendar.get(Calendar.DAY_OF_MONTH);

                    System.out.println("=============6月份的最后一天为" + day + "号");
                }

                {// 设置日期
                    calendar.set(Calendar.YEAR, 2000);
                    System.out.println("===========现在是" + calendar.get(Calendar.YEAR) + "年");

                    calendar.set(2008, 8, 8);//2018 9 8
                    // 获取年
                    int year = calendar.get(Calendar.YEAR);
                    // 获取月
                    int month = calendar.get(Calendar.MONTH);//少了一个月
                    // 获取日
                    int day = calendar.get(Calendar.DAY_OF_MONTH);
                    System.out.println("==========现在是" + year + "年" + month + "月" + day + "日");
                }
            }
            break;
        }
    }

    private String date2String(Date date, String format) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.CHINA);
        return simpleDateFormat.format(date);
    }

    private Date string2Date(String string, String format) throws Exception {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.parse(string);
    }

}
