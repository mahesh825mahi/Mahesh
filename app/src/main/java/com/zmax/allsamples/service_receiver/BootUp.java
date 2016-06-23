package com.zmax.allsamples.service_receiver;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import com.zmax.allsamples.R;
import com.zmax.allsamples.activity.MainActivity;
/**
 * Created by bfonics on 1/29/2016.
 */
public class BootUp extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {

       /* Intent i = new Intent(context, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);*/

        int requestID = (int) System.currentTimeMillis();
        int color = 0xff45ab48;
        String business_name = "";
        String md_dealid ="1";
        int id = Integer.parseInt("2000");

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle("setContentTitle").setAutoCancel(true)
                .setColor(color)
                .setContentText("setContentText");

        Intent resultIntent = new Intent(context, MainActivity.class);
        resultIntent.setAction(md_dealid);
        resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        resultIntent.putExtra("deal_id", md_dealid);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(context, requestID, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);
        if (1 == 1)
        {
            try
            {
                mBuilder.setLights(Color.WHITE, 500, 3000);
                Uri uri_def = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                mBuilder.setSound(uri_def);
            }
            catch (Exception e)
            {
                System.out.println("Exception : " + e);
            }
        }
        if (1 == 1)
        {
            mBuilder.setVibrate(new long[]{0, 200, 500, 200});
        }
        NotificationManager mNotificationManager = (NotificationManager) context.getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(id, mBuilder.build());
        mBuilder.setAutoCancel(true);
    }
}