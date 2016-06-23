/*
package com.zmax.allsamples.db.urbanair;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.app.bfonics.smartcity.App.model.OffersAll;
import com.app.bfonics.smartcity.sdksupport.Util.Util;

import java.util.ArrayList;

*/
/**
 * Created by varghesekutty on 1/19/2016.
 *//*

public class DBFuntion
{
    private String TAG="DBFunction";

    public void AddToOffersTable(Context context, String md_dealid, String md_dealtitle, String md_business_title, String notify_image, String md_org_logo, String deal_featureid, String md_subscribe_id, String md_dealmap_lat,String md_dealmaplong,String offertime,String md_dealend_date) {
        try {
            SQLiteDatabase db = initDB(context);
            ContentValues values = new ContentValues();
            values.put("md_dealid", md_dealid);
            values.put("md_dealtitle", md_dealtitle);
            values.put("md_business_title", md_business_title);
            values.put("notify_image", notify_image);
            values.put("md_org_logo", md_org_logo);
            values.put("deal_featureid", deal_featureid);
            values.put("md_subscribe_id", md_subscribe_id);
            values.put("md_dealmap_lat", md_dealmap_lat);
            values.put("md_dealmaplong", md_dealmaplong);
            values.put("offertime", offertime);
            values.put("md_dealend_date", md_dealend_date);
            db.insert(DatabaseHelper.OFFERS_TABLE_NAME, null, values);
            db.close();
        } catch (Exception e) {

        }
    }

    public ArrayList<OffersAll> GetOffers(Context context) {
        ArrayList<OffersAll>  all_offers_All_list = new ArrayList<OffersAll>();
        try {
            SQLiteDatabase db = initDB(context);
            // String selectQuery = "SELECT * FROM " + DatabaseHelper.SHOWN_MESSAGES_TABLE_NAME;
            Cursor cursor = db.query(DatabaseHelper.OFFERS_TABLE_NAME, null, null, null, null, null, null);
            // Cursor cursor = db.rawQuery(selectQuery, null);
            if (Util.LOG) Log.i(TAG,"GetOffers :"+ cursor.getCount());
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        String md_dealid = cursor.getString(1);
                        String md_dealtitle = cursor.getString(2);
                        String md_business_title = cursor.getString(3);
                        String notify_image = cursor.getString(4);
                        String md_org_logo = cursor.getString(5);
                        String deal_featureid = cursor.getString(6);
                        String md_subscribe_id = cursor.getString(7);
                        String md_dealmap_lat = cursor.getString(8);
                        String md_dealmaplong = cursor.getString(9);
                        String offertime = cursor.getString(10);
                        String md_dealend_date = cursor.getString(11);


                        OffersAll offersAll = new OffersAll();
                        offersAll.setMd_dealid(md_dealid);
                        offersAll.setMd_dealtitle(md_dealtitle);
                        offersAll.setMd_business_title(md_business_title);
                        offersAll.setNotify_image(notify_image);
                        offersAll.setMd_org_logo(md_org_logo);
                        offersAll.setDeal_featureid(deal_featureid);
                        offersAll.setMd_subscribe_id(md_subscribe_id);
                        offersAll.setMd_dealmap_lat(md_dealmap_lat);
                        offersAll.setMd_dealmaplong(md_dealmaplong);
                        offersAll.setOffertime(offertime);
                        offersAll.setMd_dealend_date(md_dealend_date);
                        all_offers_All_list.add(offersAll);

                    } while (cursor.moveToNext());
                }
            }
            db.close();
        } catch (Exception e) {
            if (Util.LOG) Log.e(TAG,"GetOffers :" + e);
        }
        return all_offers_All_list;
    }


    public ArrayList<OffersAll> GetSavedOffers(Context context) {
        ArrayList<OffersAll>  all_offers_All_list = new ArrayList<OffersAll>();
        try {
            SQLiteDatabase db = initDB(context);
            // String selectQuery = "SELECT * FROM " + DatabaseHelper.SHOWN_MESSAGES_TABLE_NAME;
            Cursor cursor = db.rawQuery("SELECT * FROM OFFERS_MESSAGE_TABLE WHERE md_subscribe_id in (" + "1" + ")", null);
            // Cursor cursor = db.rawQuery(selectQuery, null);
            if (Util.LOG) Log.i(TAG,"GetOffers :"+ cursor.getCount());
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        String md_dealid = cursor.getString(1);
                        String md_dealtitle = cursor.getString(2);
                        String md_business_title = cursor.getString(3);
                        String notify_image = cursor.getString(4);
                        String md_org_logo = cursor.getString(5);
                        String deal_featureid = cursor.getString(6);
                        String md_subscribe_id = cursor.getString(7);
                        String md_dealmap_lat = cursor.getString(8);
                        String md_dealmaplong = cursor.getString(9);
                        String offertime = cursor.getString(10);
                        String md_dealend_date = cursor.getString(11);


                        OffersAll offersAll = new OffersAll();
                        offersAll.setMd_dealid(md_dealid);
                        offersAll.setMd_dealtitle(md_dealtitle);
                        offersAll.setMd_business_title(md_business_title);
                        offersAll.setNotify_image(notify_image);
                        offersAll.setMd_org_logo(md_org_logo);
                        offersAll.setDeal_featureid(deal_featureid);
                        offersAll.setMd_subscribe_id(md_subscribe_id);
                        offersAll.setMd_dealmap_lat(md_dealmap_lat);
                        offersAll.setMd_dealmaplong(md_dealmaplong);
                        offersAll.setOffertime(offertime);
                        offersAll.setMd_dealend_date(md_dealend_date);
                        all_offers_All_list.add(offersAll);

                    } while (cursor.moveToNext());
                }
            }
            db.close();
        } catch (Exception e) {
            if (Util.LOG) Log.e(TAG,"GetOffers :" + e);
        }
        return all_offers_All_list;
    }


    public ArrayList<OffersAll> GetFeaturedOffers(Context context) {
        ArrayList<OffersAll>  all_offers_All_list = new ArrayList<OffersAll>();
        try {
            SQLiteDatabase db = initDB(context);
            // String selectQuery = "SELECT * FROM " + DatabaseHelper.SHOWN_MESSAGES_TABLE_NAME;
            Cursor cursor = db.rawQuery("SELECT * FROM OFFERS_MESSAGE_TABLE WHERE deal_featureid in (" + "1" + ")", null);
            // Cursor cursor = db.rawQuery(selectQuery, null);
            if (Util.LOG) Log.i(TAG,"GetOffers :"+ cursor.getCount());
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        String md_dealid = cursor.getString(1);
                        String md_dealtitle = cursor.getString(2);
                        String md_business_title = cursor.getString(3);
                        String notify_image = cursor.getString(4);
                        String md_org_logo = cursor.getString(5);
                        String deal_featureid = cursor.getString(6);
                        String md_subscribe_id = cursor.getString(7);
                        String md_dealmap_lat = cursor.getString(8);
                        String md_dealmaplong = cursor.getString(9);
                        String offertime = cursor.getString(10);
                        String md_dealend_date = cursor.getString(11);


                        OffersAll offersAll = new OffersAll();
                        offersAll.setMd_dealid(md_dealid);
                        offersAll.setMd_dealtitle(md_dealtitle);
                        offersAll.setMd_business_title(md_business_title);
                        offersAll.setNotify_image(notify_image);
                        offersAll.setMd_org_logo(md_org_logo);
                        offersAll.setDeal_featureid(deal_featureid);
                        offersAll.setMd_subscribe_id(md_subscribe_id);
                        offersAll.setMd_dealmap_lat(md_dealmap_lat);
                        offersAll.setMd_dealmaplong(md_dealmaplong);
                        offersAll.setOffertime(offertime);
                        offersAll.setMd_dealend_date(md_dealend_date);
                        all_offers_All_list.add(offersAll);

                    } while (cursor.moveToNext());
                }
            }
            db.close();
        } catch (Exception e) {
            if (Util.LOG) Log.e(TAG,"GetOffers :" + e);
        }
        return all_offers_All_list;
    }

    public void SaveOffers(Context context, String dealId) {
        try {
            SQLiteDatabase db = initDB(context);
            ContentValues values = new ContentValues();
            values.put("md_subscribe_id", "1");
            //"md_subscribe_id="+
            //"md_subscribe_id in (" + dealId + ")"
            //db.update(DatabaseHelper.OFFERS_TABLE_NAME, values,"md_subscribe_id="+dealId , null);
            int status = db.update(DatabaseHelper.OFFERS_TABLE_NAME, values, "md_dealid" + " = ?", new String[] { String.valueOf(dealId) });
            System.out.println("SaveOffers"+status);
            db.close();
        } catch (Exception e) {
            System.out.println("SaveOffers"+e);
        }
    }

 */
/*   public int updateContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_PH_NO, contact.getPhoneNumber());

        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?", new String[] { String.valueOf(contact.getID()) });
    }*//*



    public SQLiteDatabase initDB(Context context) {
        SQLiteDatabase db = null;
        try {
            DatabaseHelper DBHelper = new DatabaseHelper(context, "URBAN_APP_DB", null, 1);
            db = DBHelper.getWritableDatabase();
        } catch (Exception e) {

        }
        return db;
    }

    public void Delete_OffersTable(Context context) {
        try {
            SQLiteDatabase db = initDB(context);
            db.delete(DatabaseHelper.OFFERS_TABLE_NAME, null, null);
            db.close();
        } catch (Exception e) {

        }
    }

}
*/
