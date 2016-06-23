package com.zmax.allsamples.service_receiver;
import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
public class MyIntentService extends IntentService
{
    public MyIntentService()
    {
        super("MyIntentService");
    }
    @Override
    protected void onHandleIntent(Intent arg0)
    {
       /* try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }*/
        
        Intent in= new Intent();
        in.setAction("sohail.aziz");
        Log.d("sohail", "onHandleIntent: sending broadcast");
        sendBroadcast(in);
    }
}