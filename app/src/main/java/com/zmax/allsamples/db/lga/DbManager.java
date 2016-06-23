/*
package com.zmax.allsamples.db.lga;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbManager extends SQLiteOpenHelper 
{
	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "lgacloud_task_list";
	// Contacts table name
	private static final String TABLE_TASK_LIST = "task_list";

	public static String CLEANDB = "notReady";

	// Contacts Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_TASK_ID = "TaskID";
	private static final String KEY_TASK_DESCRIPTION = "TaskDescription";
	private static final String KEY_ASSET_DESCRIPTION = "AssetDescription";
	private static final String KEY_ESTIMATED_START_DATE = "EstimatedStartDateTime";
	private static final String KEY_TASKSTATUS = "taskStarted";
	private static final String KEY_TASK_NARRATION = "taskNarration";
	private static final String KEY_PRIORITY = "priority";
	private static final String KEY_TASK_ASSETID = "TaskAsset_ID";
	public DbManager(Context context) 
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		// deleteDatabse();
		// System.out.println("----------------db clean----------------");
		// TODO Auto-generated method stub
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		// TODO Auto-generated method stub
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASK_LIST);

		// Create tables again
		onCreate(db);
	}

	public void insertPlace(TaskListDetails place) 
	{
		SQLiteDatabase db = this.getWritableDatabase();
		String CREATE_CONTACTS_TABLE = "CREATE TABLE IF NOT EXISTS "
				+ TABLE_TASK_LIST + "(" + KEY_ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_TASK_DESCRIPTION
				+ " TEXT," + KEY_TASK_NARRATION + " TEXT,"
				+ KEY_ESTIMATED_START_DATE + " TEXT, "
				+ KEY_ASSET_DESCRIPTION + " TEXT, "
				+ KEY_PRIORITY + " TEXT, " + KEY_TASK_ASSETID
				+ " TEXT, " + KEY_TASKSTATUS + " TEXT, " + KEY_TASK_ID
				+ " INTEGER" + ")";
		db.execSQL(CREATE_CONTACTS_TABLE);
		ContentValues values = new ContentValues();
		values.put(KEY_TASK_DESCRIPTION, place.getmTaskDescription());
		values.put(KEY_TASK_NARRATION, place.getmTaskNaration());
		values.put(KEY_ESTIMATED_START_DATE, place.getmEstimatedStartDateTime());
		
		values.put(KEY_ASSET_DESCRIPTION, place.getmAssetDescription());
		values.put(KEY_PRIORITY, place.getmPriority());
		
		values.put(KEY_TASK_ASSETID, place.getmTaskAssetId());
		values.put(KEY_TASKSTATUS, place.getmtaskStatus());
		values.put(KEY_TASK_ID, place.getmTaskID());

		// Inserting Row
		db.insert(TABLE_TASK_LIST, null, values);
		db.close();
	}

	public void deleteDatabse() 
	{
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_TASK_LIST, "1", new String[] {});
		Log.d("Database stuff", "Database table succesfully deleted");
		db.close();
	}

	// Getting All places
	public ArrayList<TaskListDetails> getAllPlaces() 
	{
		ArrayList<TaskListDetails> placeList = new ArrayList<TaskListDetails>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_TASK_LIST;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) 
		{
			do 
			{
				TaskListDetails contact = new TaskListDetails();
				try 
				{
					contact.setmTaskDescription(cursor.getString(1));
					contact.setmTaskNaration(cursor.getString(2));
					contact.setmEstimatedStartDateTime(cursor.getString(3));
				
					contact.setmAssetDescription(cursor.getString(4));
					contact.setmPriority(cursor.getString(5));
					
					contact.setmTaskAssetId(cursor.getString(6));
					contact.setmtaskStatus(cursor.getString(7));
					contact.setmTaskID(cursor.getString(8));

				} catch (Exception e) 
				{
					// TODO Auto-generated catch block
				}
				// Adding contact to list
				placeList.add(contact);
			} while (cursor.moveToNext());
		}
		cursor.close();
		db.close();
		// return contact list

		for (TaskListDetails recentOrFavoriteDetails : placeList) 
		{
			System.out.println(recentOrFavoriteDetails.getmAssetDescription());
			System.out.println(recentOrFavoriteDetails.getmtaskStatus());
			System.out.println(recentOrFavoriteDetails.getmPriority());
			System.out.println(recentOrFavoriteDetails.getmTaskAssetId());
		}

		return placeList;
	}

	
	public ArrayList<String> getAllPlacesIds() 
	{
		ArrayList<String> placeList = new ArrayList<String>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_TASK_LIST;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) 
		{
			do 
			{
				 
				try 
				{
					placeList.add(cursor.getString(6));
				} catch (Exception e) 
				{
					// TODO Auto-generated catch block
				}
				// Adding contact to list
				
			} while (cursor.moveToNext());
		}
		cursor.close();
		db.close();
		// return contact list

 

		return placeList;
	}
	
	// Updating single place
	public int updatePlace(TaskListDetails place) {
		int x = -1;

		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_TASK_DESCRIPTION, place.getmTaskDescription());
		values.put(KEY_TASK_NARRATION, place.getmTaskNaration());
		values.put(KEY_ESTIMATED_START_DATE, place.getmEstimatedStartDateTime());
	
		values.put(KEY_ASSET_DESCRIPTION, place.getmAssetDescription());
		values.put(KEY_PRIORITY, place.getmPriority());
		values.put(KEY_TASK_ASSETID, place.getmTaskAssetId());
		values.put(KEY_TASKSTATUS, place.getmtaskStatus());
		values.put(KEY_TASK_ID, place.getmTaskID());

		// updating row

		x = db.update(TABLE_TASK_LIST, values, KEY_TASK_ASSETID + " = ?",
				new String[] { String.valueOf(place.getmTaskAssetId()) });

		System.out.println("update row  " + place.getmTaskAssetId() + " val "
				+ x);
		return x;

	}

	public void deleteTask(TaskListDetails place) {
		int x = -1;
		try {

			SQLiteDatabase db = this.getWritableDatabase();
			x = db.delete(TABLE_TASK_LIST, KEY_TASK_ASSETID + " = ?",
					new String[] { String.valueOf(place.getmTaskAssetId()) });
			db.close();

			System.out.println("delete row  " + place.getmTaskAssetId()
					+ " val " + x);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int deleteTask(String assetId) {
		int x = -1;
		try {

			SQLiteDatabase db = this.getWritableDatabase();
			x = db.delete(TABLE_TASK_LIST, KEY_TASK_ASSETID + " = ?",
					new String[] { String.valueOf(assetId) });
			db.close();

			System.out.println("delete row  " + assetId
					+ " val " + x);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return x;
	}

	public void truncateTable() {
		SQLiteDatabase db = this.getWritableDatabase();
		if (isTableExists(db, TABLE_TASK_LIST))
			db.delete(TABLE_TASK_LIST, null, null);

	}

	boolean isTableExists(SQLiteDatabase db, String tableName) 
	{
		if (tableName == null || db == null || !db.isOpen()) 
		{
			return false;
		}
		Cursor cursor = db
				.rawQuery(
						"SELECT COUNT(*) FROM sqlite_master WHERE type = ? AND name = ?",
						new String[] { "table", tableName });
		if (!cursor.moveToFirst()) {
			return false;
		}
		int count = cursor.getInt(0);
		cursor.close();
		return count > 0;
	}

}
*/
