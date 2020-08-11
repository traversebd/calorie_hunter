package com.traversebd.calorie_hunter.utils;

import android.content.Context;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Environment;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.github.lzyzsd.circleprogress.ArcProgress;
import com.traversebd.calorie_hunter.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import static com.traversebd.calorie_hunter.utils.Constants.DB_NAME;

public class Tools {
    private Context context;

    public Tools(Context context) {
        this.context = context;
    }

    /**
     * This method will provide animation
     *
     * @param view
     */
    public void setAnimation(View view){
        Animation a = AnimationUtils.loadAnimation(context, R.anim.fadein);
        view.startAnimation(a);
    }

    /**
     * This method will provide the date formatter
     */
    private DateFormat getAndroidDateFormat(){
        DateFormat dateFormatter = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            dateFormatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
        }
        return dateFormatter;
    }

    /**
     * This method will convert string to a date value
     *
     * @param strDate
     */
    public Date convertStrToDate(String strDate){
        Date date = null;
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                date = getAndroidDateFormat().parse(strDate);
                System.out.println("Current Date Time : " + date);
            }
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    /**
     * This method will convert date to a string value
     *
     * @param date
     */
    public String dateToStr(Date date){
        String dateStr = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            dateStr = getAndroidDateFormat().format(date);
        }
        System.out.println("Current Date Time : " + dateStr);

        return dateStr;
    }

    /**
     * This method will convert date to a long value
     *
     * @param date
     */
    public Long convertDateToLong(Date date) {
        if (date != null) {
            return date.getTime();
        }
        return null;
    }

    /**
     * This method will convert long to a date value
     *
     * @param dateInLong
     */
    public String longToDateString(long dateInLong){
        // or you already have long value of date, use this instead of milliseconds variable.
        String dateString = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            dateString = getAndroidDateFormat().format(new Date(dateInLong));
        }
        return dateString;
    }

    /**
     * This method will exit the app
     */
    public void exitApp(){
        Intent exitIntent = new Intent(Intent.ACTION_MAIN);
        exitIntent.addCategory(Intent.CATEGORY_HOME);
        exitIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(exitIntent);
    }

    /**
     * This method will export the db file
     */
    public void exportDB(){
        File sd = Environment.getExternalStorageDirectory();
        File data = Environment.getDataDirectory();
        FileChannel source=null;
        FileChannel destination=null;
        String currentDBPath = "/data/"+ "com.traversebd.calorie_hunter" +"/databases/"+DB_NAME;
        String backupDBPath = DB_NAME;
        File currentDB = new File(data, currentDBPath);
        File backupDB = new File(sd, backupDBPath);
        try {
            source = new FileInputStream(currentDB).getChannel();
            destination = new FileOutputStream(backupDB).getChannel();
            destination.transferFrom(source, 0, source.size());
            source.close();
            destination.close();
            Toast.makeText(context, "DB Exported!", Toast.LENGTH_LONG).show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will set max value for progress
     */
    public void setArcMaxProgress(ArcProgress[] arcProgresses, int max){
        for (int start = 0; start < arcProgresses.length; start++) {
            arcProgresses[start].setMax(max);
        }
    }
}
