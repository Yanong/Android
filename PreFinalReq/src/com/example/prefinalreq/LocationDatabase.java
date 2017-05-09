package com.example.prefinalreq;

import java.util.ArrayList;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class LocationDatabase extends SQLiteOpenHelper{
	static String DB = "db_location";
	static String LOCATION = "tbl_location";
	public LocationDatabase(Context context) {
		super(context, DB, null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE "+LOCATION+"(id integer primary key autoincrement,lat varchar(50),lng varchar(50))";
		db.execSQL(sql);		
	}
	
	public long addLocation(String lat, String lng){
		long result = 0;
		ContentValues cv = new ContentValues();
		//cv.put("name", name);
		cv.put("lat", lat);
		cv.put("lng", lng);
		
		SQLiteDatabase db = this.getWritableDatabase();
		result = db.insert(LOCATION, null, cv);
		db.close();
		return result;
	}
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	public ArrayList<Location> getAllLocation(){
		ArrayList<Location> list = new ArrayList<Location>();
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.query(LOCATION, null, null, null, null, null, "lng");
		
			c.moveToFirst();
			
			while(!c.isAfterLast()){
				int id = c.getInt(c.getColumnIndex("id"));
				//String name = c.getString(c.getColumnIndex("name"));
				String lat = c.getString(c.getColumnIndex("lat"));
				String lng = c.getString(c.getColumnIndex("lng"));			
				Location l = new Location(lat,lng,id);				
				list.add(l);
				c.moveToNext();
			}
			db.close();
		return list; 
	}
	
	public int getCount(){
		return getAllLocation().size();
	}
}
