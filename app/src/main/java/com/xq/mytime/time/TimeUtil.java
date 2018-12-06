package com.xq.mytime.time;


import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@SuppressLint("WrongConstant")
public class TimeUtil {//测试时间20181206-0923

    /*============================================本周===============================================*/

    //获得本周一0点时间戳s
    public static int getTimesWeekmorning() {//2018-12-03 00:00:00
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return (int) (cal.getTimeInMillis() / 1000);
    }

    //获得本周日24点时间戳s
    public static int getTimesWeeknight() {//2018-12-10 00:00:00
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return (int) ((cal.getTime().getTime() + (7 * 24 * 60 * 60 * 1000)) / 1000);
    }

    /*============================================本月===============================================*/

    //获得本月第一天0点时间戳s
    public static int getTimesMonthmorning() {//2018-12-01 00:00:00
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return (int) (cal.getTimeInMillis() / 1000);
    }

    //获得本月最后一天24点时间戳s
    public static int getTimesMonthnight() {//2019-01-01 00:00:00
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 24);
        return (int) (cal.getTimeInMillis() / 1000);
    }

    /*============================================当天===============================================*/
    //获得当天0点时间戳s
    public static int getTimesmorning() {//2018-12-06 00:00:00
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (int) (cal.getTimeInMillis() / 1000);
    }

    //获得当天24点时间戳s
    public static int getTimesnight() {//2018-12-07 00:00:00
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (int) (cal.getTimeInMillis() / 1000);
    }

    //获得当天5点时间戳s
    public static int getTimesmorning5() {//2018-12-06 05:00:00
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 5);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (int) (cal.getTimeInMillis() / 1000);
    }

    /*==============================================================================================*/


    public static long getNowTime(){
        return Calendar.getInstance().getTimeInMillis();
    }



    /*================================================================================================*/

    /**
     * 判断是否为今天(效率比较高)
     *
     * @param day 传入的 时间  "2016-06-28 10:10:30" "2016-06-28" 都可以
     * @return true今天 false不是
     * @throws ParseException
     */
    public static boolean isToday(String day) throws ParseException {
        Calendar current = Calendar.getInstance();
        Date predate = new Date(System.currentTimeMillis());
        current.setTime(predate);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        Date date = simpleDateFormat.parse(day);
        cal.setTime(date);

        if (cal.get(Calendar.YEAR) == (current.get(Calendar.YEAR))) {
            int diffDay = cal.get(Calendar.DAY_OF_YEAR) - current.get(Calendar.DAY_OF_YEAR);

            if (diffDay == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否为昨天(效率比较高)
     *
     * @param day 传入的 时间  "2016-06-28 10:10:30" "2016-06-28" 都可以
     * @return true今天 false不是
     * @throws ParseException
     */
    public static boolean isYesterday(String day) throws ParseException {
        Calendar current = Calendar.getInstance();
        Date predate = new Date(System.currentTimeMillis());
        current.setTime(predate);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        Date date = simpleDateFormat.parse(day);
        cal.setTime(date);

        if (cal.get(Calendar.YEAR) == (current.get(Calendar.YEAR))) {
            int diffDay = cal.get(Calendar.DAY_OF_YEAR) - current.get(Calendar.DAY_OF_YEAR);

            if (diffDay == -1) {
                return true;
            }
        }
        return false;
    }

    /*=======================================================================================*/

    private static long second = 1000;
    private static long minute = second * 60;
    private static long hour = minute * 60;
    private static long day = hour * 24;
    private static long halfamonth = day * 15;
    private static long month = day * 30;

    public static String getDateDiff(long dateTimeStamp) {
        String result;
        long now = new Date().getTime();
        long diffValue = now - dateTimeStamp;
        if (diffValue < 0) {
            //toast("结束日期不能小于开始日期！");
        }
        long monthC = diffValue / month;
        long weekC = diffValue / (7 * day);
        long dayC = diffValue / day;
        long hourC = diffValue / hour;
        long minC = diffValue / minute;
        if (monthC >= 1) {
            result = "发表于" + Integer.parseInt(monthC + "") + "个月前";
            return result;
        } else if (weekC >= 1) {
            result = "发表于" + Integer.parseInt(weekC + "") + "周前";
            return result;
        } else if (dayC >= 1) {
            result = "发表于" + Integer.parseInt(dayC + "") + "天前";
            return result;
        } else if (hourC >= 1) {
            result = "发表于" + Integer.parseInt(hourC + "") + "个小时前";
            return result;
        } else if (minC >= 1) {
            result = "发表于" + Integer.parseInt(minC + "") + "分钟前";
            return result;
        } else {
            result = "刚刚发表";
            return result;
        }
    }

}
