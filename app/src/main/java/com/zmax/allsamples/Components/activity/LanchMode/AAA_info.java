package com.zmax.allsamples.Components.activity.LanchMode;

import android.text.style.AlignmentSpan;

/**
 * Created by Kasturi on 17-Sep-16.
 */
public class AAA_info
{
    //https://android.jlelse.eu/android-activity-launchmode-explained-cbc6cf996802#.lqfqoavkm

   /* Android lanchMode
   1. Standard ------>(Same Task)
   2. Single Top --->(Same Task and no duplecate item)old instance get extra data through onNewIntent(Intent intent)
   3. Single Task ----> (Same Task It will destory all top element) old instance get extra data through onNewIntent(Intent intent)
   4. Single Instance ---->(New Task) old instance get extra data through onNewIntent(Intent intent)

    Flag:
    1. FLAG_NEW_TASK -------> (New task will be created)
    2. FLAG_CLEAR_TASK -----> (It will destory all) It will create new instance
    3. FLAG_SINGLE_TOP ------>As usual
    4. FLAG_CLEAR_TOP ----> old instance get extra data through onNewIntent(Intent intent)

    FLAG_ACTIVITY_CLEAR_TASK
    FLAG_ACTIVITY_CLEAR_TOP
    FLAG_ACTIVITY_NEW_TASK

    targetIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

   */

}
