package com.zmax.allsamples.System.Alarms;

/**
 * Created by Kasturi on 18-Sep-16.
 */
public class AAA_info {

     /*
    Alarms

    1.creating alarms
      Not:
      the following only for api 18<=
      begining with api 19 alarm delivery is inexact
      //https://developer.android.com/reference/android/app/AlarmManager.html

     a. set(int type, long triggerATTime, PendingIntent operation)
     b. setrepeating()
     c. setInexactrepeating()
    2. Alarms are canceled on device while shutdown or restart

    */


    /*
    Tye of Alarms
    1.
     */

    //Alarm Type Constants
    /*

    1.RTC_WAKEUP ---> It will wake up the device fire the alarm immediatly
    2. RTC ---> when device come to wake up mode it will fire the alarm
    3. ELAPSED_REALTIME
    4. ELAPSED_REALTIME_WAKEUP

    * */


   /* //PENDINGINTENT

   A PendingIntent object helps you to perform an action on your applications behalf,
   often at a later time, without caring of whether or not your application is running.

    //3  methods used to create the pending intent

    1.getActivity() ---to start an activity
    2.getBroadcast()
    3. getservice()

    */


}
