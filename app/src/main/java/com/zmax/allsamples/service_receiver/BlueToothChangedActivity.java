package com.zmax.allsamples.service_receiver;
import android.app.Activity;
import android.os.Bundle;
import com.zmax.allsamples.R;
/**
 * Created by bfonics on 1/13/2016.
 */
public class BlueToothChangedActivity extends Activity
{
    //http://blog.phonedeveloper.com/2015/04/how-to-receive-bluetooth-broadcast.html
    //http://stackoverflow.com/questions/30222409/android-broadcast-receiver-bluetooth-events-catching
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb);

    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

    }
}
