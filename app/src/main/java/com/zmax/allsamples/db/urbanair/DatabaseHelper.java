package com.zmax.allsamples.db.urbanair;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
    public final static String OFFERS_TABLE_NAME = "OFFERS_MESSAGE_TABLE";
    private static String OFFERS_TABLE_CREATE = "create table if not exists " + OFFERS_TABLE_NAME + "( _id integer primary key autoincrement, md_dealid text not null, md_dealtitle text, md_business_title text, notify_image text, md_org_logo text, deal_featureid text, md_subscribe_id text, md_dealmap_lat text,md_dealmaplong text,offertime text,md_dealend_date text)";
    public DatabaseHelper(Context context, String name, CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(OFFERS_TABLE_CREATE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}