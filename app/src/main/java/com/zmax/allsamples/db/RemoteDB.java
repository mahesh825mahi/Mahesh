/*
package com.zmax.allsamples.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.zmax.allsamples.model.EmpModel;
import com.zmax.allsamples.model.GetSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RemoteDB extends SQLiteOpenHelper
{
    //https://www.developerfeed.com/building-todo-list-app-android-using-sqlite/
    public static String DB_Name = "bfonics_DB2";
    public static String Table_Name = "Deals";
    public static String Table_Name2 = "PriorityDeals";
    public static String Table_Name3 = "Empregister";
    Context ctx;
    public RemoteDB(Context context)
    {
        super(context, DB_Name, null, 30);
        this.ctx=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String table1 = "CREATE TABLE "
                + Table_Name
                + " ( ID INTEGER PRIMARY KEY AUTOINCREMENT, Deal_ID TEXT, Start_Date TEXT, End_Date TEXT, Location TEXT, Description TEXT, Deal_Title TEXT, Business_Id TEXT, Deal_Type TEXT,ENTIRE TEXT, IMAGE_NAME TEXT, STATUS TEXT,SHARE_FB BOOLEAN, PHONE_NO TEXT, Is_Deleted TEXT, UNIQUE(Deal_ID)) ";
        db.execSQL(table1);
        String table2 = "CREATE TABLE " + Table_Name2
        + " ( ID INTEGER PRIMARY KEY AUTOINCREMENT, Deal_ID TEXT, Deal_Order TEXT, Deal_Date TEXT, Deal_Time TEXT, Deal_Title TEXT, Business_Title TEXT, Is_Shown TEXT, UNIQUE(Deal_ID)) ";
        db.execSQL(table2);


        String table3 = "CREATE TABLE "
                + Table_Name3
                + " ( ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT, emailid TEXT) ";
        db.execSQL(table3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name2);
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name3);
        onCreate(db);
    }


    public String insertEmp(String username, String password, String emailid)
    {

        String  response = "0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor;

        //Cursor findEntry = db.query("Table_Name3", , "emailid=?", new String[]{emailid}, null, null, null);

        String sql = "SELECT * FROM " + Table_Name3 + " WHERE emailid = '" + emailid + "'";
        cursor = db.rawQuery(sql, null);
        if(cursor.getCount()>0)
        {
            response = "exist";
        }
        else
        {
            ContentValues values = new ContentValues();
            values.put("username", username);
            values.put("password", password);
            values.put("emailid", emailid);

            try
            {
              long   response1 = db.insertOrThrow(Table_Name3, null, values);
                response = ""+ response1;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Caught.... " + e);
            }
            cursor.close();
            db.close();
        }
        return ""+response;
    }

    public List<EmpModel> selectEmp ()
    {
        List<EmpModel> emparray = new ArrayList<EmpModel>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor;
        String selectQuery = "SELECT  * FROM " + Table_Name3;
        cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst())
        {
            do
            {
                EmpModel empModel = new EmpModel();
                empModel.setUsername(cursor.getString(1));
                empModel.setPassword(cursor.getString(2));
                empModel.setEmail(cursor.getString(3));
                emparray.add(empModel);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return emparray;
    }

    public long insertDeal(String Deal_ID, String Start_Date, String End_Date, String Location, String Description, String Deal_Title, String Business_Id, String deal_type, String entire) {
        long response = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Deal_ID", Deal_ID);
        values.put("Start_Date", Start_Date);
        values.put("End_Date", End_Date);
        values.put("Location", Location);
        values.put("Description", Description);
        values.put("Deal_Title", Deal_Title);
        values.put("Business_Id", Business_Id);
        values.put("Deal_Type", deal_type);
        values.put("ENTIRE", entire);
        values.put("SHARE_FB", false);
        values.put("Is_Deleted", "0");

        try
        {
            response = db.insertOrThrow(Table_Name, null, values);
        } catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Caught.... " + e);
        }
        db.close();
        return response;
    }

    public ArrayList<GetSet> takeDeals()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<GetSet> deals = new ArrayList<GetSet>();
        Cursor cursor;
        String sql = "SELECT Deal_ID, Deal_Title, Description, STATUS, PHONE_NO, IMAGE_NAME,Location,Start_Date, End_Date FROM " + Table_Name + " WHERE Is_Deleted = '0'";
        cursor = db.rawQuery(sql, null);


        // String sql =
        // "SELECT Deal_ID, Deal_Title, Description, STATUS, PHONE_NO, IMAGE_NAME FROM "
        // + Table_Name
        // + " WHERE End_Date >='"
        // + rightnow
        // + "' ORDER BY End_Date";
        cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext())
        {
            GetSet deal_type = new GetSet();
            deal_type.setId(cursor.getString(0));
            deal_type.setTitle(cursor.getString(1));
            deal_type.setDescription(cursor.getString(6));
            deal_type.setStatus(cursor.getString(3));
            deal_type.setPh_no(cursor.getString(4));
            deal_type.setImage_name(cursor.getString(0) + ".png");
            deal_type.setStart_date(cursor.getString(7));
            deal_type.setEnd_date(cursor.getString(8));
            deals.add(deal_type);
        }
        cursor.close();
        db.close();
        return deals;
    }

    public String takeDealDetails_temp(String deal_id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor;
        String entire = null;
        String sql = "SELECT ENTIRE FROM " + Table_Name + " WHERE Deal_ID = '" + deal_id + "'";
        System.out.println("SQLLL ::: " + sql);
        cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext())
        {
            entire = cursor.getString(0);
        }
        cursor.close();
        db.close();
        return entire;
    }

    public String status(String deal_id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor;
        String status = null;
        String sql = "SELECT STATUS FROM " + Table_Name + " WHERE Deal_ID = '" + deal_id + "'";
        System.out.println("SQLLL ::: " + sql);
        cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext())
        {
            status = cursor.getString(0);
        }
        cursor.close();
        db.close();
        return status;
    }

    public String set_Status(String deal_id, String status)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<GetSet> deals = new ArrayList<GetSet>();
        String entire = null;
        String sql = "UPDATE " + Table_Name + " SET STATUS = '" + status + "' WHERE Deal_ID = '" + deal_id + "'";
        System.out.println("SQLLL ::: " + sql);
        db.execSQL(sql);
        db.close();
        return entire;
    }

    public String delete(ArrayList<String> marked)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String entire = null;

        String ids = marked.toString().replace("[", "(").replace("]", ")");
//        String sql = "DELETE FROM " + Table_Name + " WHERE Deal_ID IN " + ids
//                + "";
        String sql = "UPDATE " + Table_Name + " SET Is_Deleted='1' WHERE Deal_ID IN " + ids + "";
        System.out.println("SQLLL ::: " + sql);
        db.execSQL(sql);
        db.close();
        return entire;
    }

    public boolean dealFound(String deal_id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor;
        boolean response;
        String sql_query = "SELECT COUNT(*) FROM " + Table_Name + " WHERE Deal_ID ='" + deal_id + "'";
        SQLiteStatement s = db.compileStatement(sql_query);

        long count = s.simpleQueryForLong();
        if (count > 0) {
            response = true;
        } else {
            response = false;
        }
        db.close();
        return response;
    }

    public boolean inboxFound() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor;
        boolean response;
        String sql = "SELECT * FROM " + Table_Name;
        cursor = db.rawQuery(sql, null);
        if (cursor.getCount() == 0) {
            response = false;
        } else {
            response = true;
        }
        cursor.close();
        db.close();
        return response;
    }

    public boolean isSharedInFB(String deal_id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor;
        boolean response = false;
        String sql = "SELECT SHARE_FB FROM " + Table_Name
                + " WHERE Deal_ID = '" + deal_id + "'";
        cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            response = cursor.getString(0).equals("true");
        }
        cursor.close();
        db.close();
        return response;
    }

    public String shareStatus(String deal_id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String entire = null;
        String sql = "UPDATE " + Table_Name + " SET SHARE_FB = '" + true + "' WHERE Deal_ID = '" + deal_id + "'";
        db.execSQL(sql);
        db.close();
        return entire;
    }

    public long insertPriorityDeal(String Deal_ID, String Deal_Order, String Deal_Date, String Deal_Time, String Deal_Title, String Business_Title) {
        long response = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Deal_ID", Deal_ID);
        values.put("Deal_Order", Deal_Order);
        values.put("Deal_Date", Deal_Date);
        values.put("Deal_Time", Deal_Time);
        values.put("Deal_Title", Deal_Title);
        values.put("Business_Title", Business_Title);

        values.put("Is_Shown", "0");

        String sql = "select Deal_ID from " + Table_Name2 + " where Deal_ID = " + Deal_ID;
        Cursor cur = db.rawQuery(sql, new String[0]);

        if (cur.getCount() == 0) {
            try {
                response = db.insertWithOnConflict(Table_Name2, null, values, SQLiteDatabase.CONFLICT_IGNORE);
                System.out.println("Deal Details::" + Deal_ID + "::" + Deal_Order + "::" + Deal_Time + "::" + Deal_Title + "::" + Business_Title);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Caught.... " + e);
            }
        }

        db.close();
        return response;
    }

    public int getTotalPriorityCount() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + Table_Name2 + " WHERE Is_Shown = '0'";
        Log.d("QUERY", query);
        Cursor cursor = db.rawQuery(query, null);
        return cursor.getCount();
    }

    public String[] getNextTime() {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = ("SELECT Deal_ID, Deal_Time FROM " + Table_Name2 + " WHERE Is_Shown = '0' ORDER BY Deal_Time DESC ");
        String[] op = new String[2];
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            op[0] = (cursor.getString(0));
            op[1] = (cursor.getString(1));
        }
        return op;
    }

    public ArrayList<String> takeAddToNotify() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<String> deals = new ArrayList<String>();
        Cursor cursor;
        String sql = "SELECT Deal_ID, Deal_Time FROM "
                + Table_Name2 + " ORDER BY Deal_Order ASC ";
//        String sql = " SELECT Deal_ID, Deal_Time FROM "
//                + Table_Name2 + " WHERE Deal_Status='true' ORDER BY Deal_Order ASC ";
        cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            deals.add(cursor.getString(0));
            deals.add(cursor.getString(1));
        }
        cursor.close();
        db.close();
        return deals;
    }

    public ArrayList<HashMap<String, String>> takeAddToNotifyNew() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> deals = new ArrayList<HashMap<String, String>>();
        Cursor cursor;
        String sql = "SELECT Deal_ID, Deal_Time FROM "
                + Table_Name2 + " ORDER BY Deal_Order ASC ";
//        String sql = " SELECT Deal_ID, Deal_Time FROM "
//                + Table_Name2 + " WHERE Deal_Status='true' ORDER BY Deal_Order ASC ";
        cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("ID", cursor.getString(0));
            System.out.println("IDed :: " + cursor.getString(0));
            hashMap.put("TIME", cursor.getString(1));
            deals.add(hashMap);
        }

        cursor.close();
        db.close();
        return deals;
    }

    public ArrayList<String> takeToNotify(String md_dealid) {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<String> deals = new ArrayList<String>();
        Cursor cursor;
        String sql = "SELECT Deal_Title, Business_Title FROM "
                + Table_Name2 + " WHERE Deal_ID='" + md_dealid + "'";
        cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            deals.add(cursor.getString(0));
            Log.d("opop", cursor.getString(0) + "");
            deals.add(cursor.getString(1));
        }
        cursor.close();
        db.close();
        return deals;
    }

    public void deleteShownPriority(String deal_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String entire = null;
        String sql = "UPDATE " + Table_Name2 + " SET Is_Shown = '1' WHERE Deal_ID ='" + deal_id + "'";
        //String sql = "DELETE FROM " + Table_Name2 + " WHERE Deal_ID ='" + deal_id + "'";
        System.out.println("SQLLL ::: " + sql);
        db.execSQL(sql);
        db.close();
    }
}
*/
