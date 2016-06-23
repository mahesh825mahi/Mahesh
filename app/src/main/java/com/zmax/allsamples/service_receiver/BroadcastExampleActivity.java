package com.zmax.allsamples.service_receiver;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import com.zmax.allsamples.R;
public class BroadcastExampleActivity extends Activity
{
    //http://sohailaziz05.blogspot.in/2012/05/broadcast-receiver-two-ways-to_28.html
    // Communicate broadcastreceiver to activity to notify internet lost
    //http://stackoverflow.com/questions/22241705/calling-a-activity-method-from-broadcastreceiver-in-android
    //http://viralpatel.net/blogs/android-internet-connection-status-network-change/
    /**
     * Called when the activity is first created.
     */
    private Myreceiver reMyreceive;
    private IntentFilter filter;

    @Override
    protected void onPause()
    {
        super.onPause();
        unregisterReceiver(reMyreceive);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        registerReceiver(reMyreceive, filter);
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        Log.d("sohail", "onCreate called");

        reMyreceive = new Myreceiver();

        //typo mistake
        //Edited after pointing out by a reader, thanks
        // IntentFilter filter=new IntentFilter("sohail.aziz");

        filter = new IntentFilter("sohail.aziz");
        Intent i = new Intent(this, MyIntentService.class);
        Log.d("sohail", "starting MyIntentservice");
        startService(i);
    }

    public class Myreceiver extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            Log.d("sohail", "MyReceiver: broadcast received");
        }
    }
} 