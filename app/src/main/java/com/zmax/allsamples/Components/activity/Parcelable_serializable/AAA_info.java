package com.zmax.allsamples.Components.activity.Parcelable_serializable;

/**
 * Created by Kasturi on 22-Aug-16.
 */
public class AAA_info {
    //http://www.3pillarglobal.com/insights/parcelable-vs-java-serialization-in-android-app-development
    //http://www.sanfoundry.com/java-android-program-send-data-service-activity/
    //http://shri.blog.kraya.co.uk/2010/04/26/android-parcel-data-to-pass-between-activities-using-parcelable-classes/
    //http://wptrafficanalyzer.in/blog/android-parcelable-example-passing-data-between-activities/

    //Site Point
    //https://www.sitepoint.com/transfer-data-between-activities-with-android-parcelable/

    //-------------------------------Parcelable android Example
    ////android Parcel: unable to marshal value
    //http://stackoverflow.com/questions/25791787/unable-to-marshal-value-on-serializable-data

    /* private void sendNotification(String msg) {
		*//*Report report = (Report) v.getTag();
		Intent i = new Intent(context,ReportActivity.class);
		i.putExtra("currentObject",report);
		context.startActivity(i);*//*

		*//*Intent intent = getIntent();
		report = (Report) intent.getSerializableExtra("currentObject");*//*

		*//*Intent msgIntent = new Intent(this, SimpleIntentService.class);
		msgIntent.putExtra(SimpleIntentService.PARAM_IN_MSG, strInputMsg);
		startService(msgIntent);*//*
    }*/
}
