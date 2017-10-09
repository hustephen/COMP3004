package com.example.androidtemplate.utils;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.text.format.Time;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.androidtemplate.common.Constants;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class Utils {

    /**
     * 保存图片到本地
     * @param bmp
     * @param file
     */
    public static void saveToLocal(Bitmap bmp , File file){
        try {
            file.createNewFile();
            FileOutputStream iStream = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 70, iStream);
            iStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从本地获取图片
     * @param pathString
     * @return
     */
    public static Bitmap getDiskBitmap(String pathString)
    {
        Bitmap bitmap = null;
        try
        {
            File file = new File(pathString);
            if(file.exists())
            {
                bitmap = BitmapFactory.decodeFile(pathString);
            }
        } catch (Exception e)
        {
            // TODO: handle exception
        }

        return bitmap;
    }


    private static SimpleDateFormat sdf=null;

    public static String getCurrentDateStr(){
        sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }
    public static String getCurrentDateTimeStr(){
        sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
    public static String getDateCompleteStr(){
        sdf=new SimpleDateFormat("yyyy 年 MM 月 dd 日 HH 时 mm 分 ss 秒 SSS 毫秒");
        return sdf.format(new Date());
    }
    public static String getCurrentTimeStamp(){
        sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(new Date());
    }

    public static String getWeek(Date date){
        String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if(week_index<0){
            week_index = 0;
        }
        return weeks[week_index];
    }

    /**
     * 两个时间相差距离多少天多少小时多少分多少秒
     * @return String 返回值为：xx天xx小时xx分xx秒
     */
    public static Long getDistanceTime(String startDate, String endDate) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        Date one;
        Date two;
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        try {
            one = df.parse(startDate);
            two = df.parse(endDate);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff ;
            if(time1<time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }


            day = diff / (24 * 60 * 60 * 1000);
            hour = (diff / (60 * 60 * 1000) - day * 24);
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            sec = (diff/1000-day*24*60*60-hour*60*60-min*60);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return min + hour*60 + day*60*24;
    }

    /**
     *  时间切割工具
     * @param startDateStr
     * @param endDateStr
     * @param gapTime
     * @return
     */
    public static List<String> dateSplit(String startDateStr, String endDateStr, long gapTime)  {

        gapTime = gapTime * 1000 * 60;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = sdf.parse(startDateStr);
            endDate = sdf.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date startDateBak = startDate;
        if (!startDate.before(endDate)){
            startDate = endDate;
            endDate = startDateBak;
        }
        Long spi = endDate.getTime() - startDate.getTime();
        System.out.println(spi);
        Long step = spi / gapTime;
        System.out.println(step);


        List<String> dateList = new ArrayList<String>();

        dateList.add(sdf.format(startDate));
        for (int i = 1; i <= step; i++) {
            dateList.add(sdf.format(new Date(startDate.getTime() + gapTime*i)));
        }
        return dateList;
    }

    /**
     * 判断是否为ip
     * @param addr
     * @return
     */
    public static boolean isIp(String addr){
        if(TextUtils.isEmpty(addr)){
            return false;
        }
        if(addr.length() < 7 || addr.length() > 15 || "".equals(addr))
        {
            return false;
        }
        /**
         * 判断IP格式和范围
         */
        String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";

        Pattern pat = Pattern.compile(rexp);

        Matcher mat = pat.matcher(addr);

        boolean ipAddress = mat.find();

        return ipAddress;
    }
    /**
     * 日期选择
     * @param context
     * @param editText
     */
    public static void datePicker(Context context, final EditText editText){

        int mYear, mMonth, mDay;

        Calendar ca = Calendar.getInstance();
        mYear = ca.get(Calendar.YEAR);
        mMonth = ca.get(Calendar.MONTH);
        mDay = ca.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String monthOfYearNew = String.format("%02d", (monthOfYear+1));
                String dayOfMonthNew = String.format("%02d", (dayOfMonth));
                editText.setText(year + "/" + monthOfYearNew + "/" + dayOfMonthNew);
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();

    }

    /**
     * 时间选择
     * @param context
     * @param editText
     */
    public static void timePicker(Context context, final EditText editText){

        int hour,minute;

        Calendar ca = Calendar.getInstance();
        hour = ca.get(Calendar.HOUR_OF_DAY);
        minute = ca.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hour, int minute) {
                String hourNew = String.format("%02d", (hour));
                String minuteNew = String.format("%02d", (minute));
                editText.setText(hourNew + ":" + minuteNew);
            }
        }, hour, minute,true);
        timePickerDialog.show();

    }

}
