package com.zmax.allsamples.activity;

import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by bfonics on 12/24/2015.
 */
public class Intent
{

    //parceler library
    //https://github.com/johncarl81/parceler

    //God
    //http://stackoverflow.com/questions/768969/passing-a-bundle-on-startactivity
    //god

    //passing my data from one activity to another activity
    //http://stackoverflow.com/questions/21250339/how-to-pass-arraylistcustomeobject-from-one-activity-to-another

    //Serializable
    //http://stackoverflow.com/questions/13601883/how-to-pass-arraylist-of-objects-from-one-to-another-activity-using-intent-in-an
    //http://stackoverflow.com/questions/2736389/how-to-pass-an-object-from-one-activity-to-another-on-android
    //Serializable  using Bundle
    //http://stackoverflow.com/questions/2736389/how-to-pass-an-object-from-one-activity-to-another-on-android

    //Passing data from one activity to other in android
    /*Intent intent = new Intent(context, YourActivityClass.class);
    intent.putExtra(KEY, <your value here>);
    startActivity(intent);*/

    // Retrieving bundle data from android activity
   /* Intent intent = getIntent();
    if (null != intent) {
    String stringData= intent.getStringExtra(KEY);
    int numberData = intent.getIntExtra(KEY, defaultValue);
    boolean booleanData = intent.getBooleanExtra(KEY, defaultValue);
    char charData = intent.getCharExtra(KEY, defaultValue);*/

    //sending Message to whats App

    /*Intent sendIntent = new Intent();
    sendIntent.setAction(Intent.ACTION_SEND);
    sendIntent.putExtra(Intent.EXTRA_TEXT, "Sending Data from My Application");
    sendIntent.setType("text/plain");
    // Do not forget to add this to open whatsApp App specifically
    sendIntent.setPackage("com.whatsapp");
    startActivity(sendIntent);*/


    //Fragment


    //Sender

    /*bundle = new Bundle();
    bundle.putSerializable("all_offers_list", (ArrayList<OffersAll>) all_offers_All_list);
    allFragment = new AllFragment();
    ft = getFragmentManager().beginTransaction();
    allFragment.setArguments(bundle);
    ft.replace(R.id.home_content_container, allFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
*/
    //Receiver

    /*all_offers_All_list = (ArrayList<OffersAll>) getArguments().getSerializable("all_offers_list");
    getArguments().remove("all_offers_list");*/


//---------------------------------- success museum

   /* Bundle bundle = new Bundle();
    bundle.putString("filetype","i");
    bundle.putSerializable("iav", (ArrayList<ExhibitAllStop>)exhibitAll_image);

    //bundle.putSerializable("audioArray",(ArrayList<ExhibitAllStop>) exhibits_List.get(position).getExhibitAll_audio());
    //bundle.putSerializable("videoArray", (ArrayList<ExhibitAllStop>)exhibits_List.get(position).getExhibitAll_video());
    //bundle.putSerializable("videoUrlArray", (ArrayList<ExhibitAllStop>)exhibits_List.get(position).getExhibitAll_videoUrl());

    android.content.Intent i = new android.content.Intent(ctx,ExhibitsIAVlist.class);
    i.putExtra("bundle",bundle);
    startActivity(i);
    overridePendingTransition(0, 0);



    android.content.Intent intent = getIntent();
    Bundle args = intent.getBundleExtra("bundle");
    //String myString = args.getString("title");
    iav_list = (ArrayList<ExhibitAllStop>) args.getSerializable("iav");
    //System.out.println("exhibitAll_video"+iav_list.size());
    filetype = args.getString("filetype");

    */

    ///--------------------------------suc

  /*  android.content.Intent i = new android.content.Intent(context,ReportActivity.class);
    i.putExtra("currentObject",report);
    context.startActivity(i);


    android.content.Intent intent = getIntent();
    report = (Report)intent.getSerializableExtra("currentObject");*/

}
