package com.zmax.allsamples.Time_Date;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zmax.allsamples.R;
public class Date_Time extends AppCompatActivity
{
Context ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctx = Date_Time.this;
        //Date formate Example
        //http://stackoverflow.com/questions/10426492/change-date-string-format-in-android
        //http://stackoverflow.com/questions/18480633/java-util-date-format-conversion-yyyy-mm-dd-to-mm-dd-yyyy

        //Double Digit Formate
        //http://stackoverflow.com/questions/10203924/displaying-date-in-a-double-digit-format


        //All Reprentation
        //https://www.google.co.in/imgres?imgurl=http://i.stack.imgur.com/lkYVY.png&imgrefurl=http://stackoverflow.com/questions/28016578/swift-how-to-create-a-date-time-stamp-and-format-as-iso-8601-rfc-3339-utc-tim&h=800&w=1306&tbnid=Bp8sB8bj6-kGkM:&docid=vQYc3Tx9fwDjpM&ei=W8OpVu6bN4PhmAXw7rHYCw&tbm=isch&ved=0ahUKEwiutcSJ_svKAhWDMKYKHXB3DLsQMwgfKAMwAw

    }
}