package com.zmax.allsamples.service_receiver;

/**
 * Created by bfonics on 1/25/2016.
 */
public class Notificaiton
{
    //Lanch Modeeeee
//http://stackoverflow.com/questions/1198558/how-to-send-parameters-from-a-notification-click-to-an-activity
// http://stackoverflow.com/questions/21871454/android-push-notification-get-data-store-and-display-on-new-activity-on-click



   /* public void pushDeal(String md_dealid, String dealtitle, String business_name) {
        int id = Integer.parseInt("2000");
        int requestID = (int) System.currentTimeMillis();
        if (!shownNotifications.contains(md_dealid)) {
            int color = 0xff45ab48;
            int vibrate = mPrefs.getInt("vibrate", 1);
            int sound = mPrefs.getInt("sound", 1);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                    getApplicationContext())
                    .setSmallIcon(R.drawable.ac_icon)
                    .setContentTitle(dealtitle).setAutoCancel(true)
                    .setColor(color)
                    .setContentText(business_name);

            Intent resultIntent = new Intent(getApplicationContext(), Tickets.class);
            resultIntent.setAction(md_dealid);
            resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            resultIntent.putExtra("deal_id", md_dealid);
            PendingIntent resultPendingIntent = PendingIntent.getActivity(this, requestID, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            mBuilder.setContentIntent(resultPendingIntent);
            if (sound == 1) {
                try {
                    mBuilder.setLights(Color.WHITE, 500, 3000);
                    Uri uri_def = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                    mBuilder.setSound(uri_def);
                } catch (Exception e) {
                    System.out.println("Exception : " + e);
                }
            }
            if (vibrate == 1) {
                mBuilder.setVibrate(new long[]{0, 200, 500, 200});
            }
            NotificationManager mNotificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.notify(id, mBuilder.build());
            mBuilder.setAutoCancel(true);
            shownNotifications.add(md_dealid);



        } else {
            System.out.println("shownNotifications");
        }
    }*/
}
