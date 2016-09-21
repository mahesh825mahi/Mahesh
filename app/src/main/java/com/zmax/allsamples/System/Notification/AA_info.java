package com.zmax.allsamples.System.Notification;

import android.support.v4.app.NotificationCompat;

/**
 * Created by Kasturi on 18-Sep-16.
 */
public class AA_info {
    //Notification
            //http://www.theappguruz.com/blog/easy-way-to-send-local-notification-to-user-in-android





    /*NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);\
                                    mBuilder.setSmallIcon(R.drawable.notification_icon);
                                    mBuilder.setContentTitle("Notification Alert, Click Me!");
                                    mBuilder.setContentText("Hi, This is Android Notification Detail!");


        Pending INtent:

        A PendingIntent object helps you to perform an action on your applications behalf,
        often at a later time, without caring of whether or not your application is running.

        TaskStackBuilder:

        We take help of stack builder object which will contain an artificial back stack for the started Activity.
        This ensures that navigating backward from the Activity leads out of your application to the Home screen.

                    Intent resultIntent = new Intent(this, ResultActivity.class);
                    TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
                    stackBuilder.addParentStack(ResultActivity.class);

                    // Adds the Intent that starts the Activity to the top of the stack
                    stackBuilder.addNextIntent(resultIntent);
                      //PendingIntent pendingIntent = PendingIntent.getActivity(context, NOTIFICATION_ID, targetIntent, 0);
                      //PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 234324243, intent, 0);
                            1.getActivity() ---to start an activity
                            2.getBroadcast()
                            3. getservice()
                    PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
                    mBuilder.setContentIntent(resultPendingIntent)

                    Issue the notification

                    NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    // notificationID allows you to update the notification later on.
                    mNotificationManager.notify(notificationID, mBuilder.build());

    */

}
