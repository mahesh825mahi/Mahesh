package com.zmax.allsamples.activity;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import com.zmax.allsamples.R;
public class NotificaitonActivity extends Activity
{

   // http://android.wonderhowto.com/how-to/fix-notification-delays-android-0161387/
   // http://www.guidingtech.com/42129/fix-delayed-notification-android/
    // A integer, that identifies each notification uniquely
    //http://www.technorms.com/44486/fix-delayed-notifications-issue-on-android
    public static final int NOTIFICATION_ID = 1;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Your application layout file
        setContentView(R.layout.webview);
        sendNotification();
    }

    /**
     * Send simple notification using the NotificationCompat API.
     */

    public void sendNotification()
    {
        // Use NotificationCompat.Builder to set up our notification.
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        //icon appears in device notification bar and right hand corner of notification
        builder.setSmallIcon(R.drawable.ic_tab_favourite);

        // This intent is fired when notification is clicked
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://javatechig.com/"));
        Intent intent = new Intent(this, NotificaitonActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        // Set the intent that will fire when the user taps the notification.
        builder.setContentIntent(pendingIntent);

        // Large icon appears on the left of the notification
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_tab_contacts));

        // Content title, which appears in large type at the top of the notification
        builder.setContentTitle("Notifications Title");

        // Content text, which appears in smaller text below the title
        builder.setContentText("Your notification content here.");

        // The subtext, which appears under the text on newer devices.
        // This will show-up in the devices with Android 4.2 and above only
        builder.setSubText("Tap to view documentation about notifications.");

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Will display the notification in the notification bar
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}