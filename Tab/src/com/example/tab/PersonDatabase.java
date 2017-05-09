package com.example.tab;

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PersonDatabase extends SQLiteOpenHelper {

	static String DB = "db_location";
	static String NAME = "tbl_location";

	public PersonDatabase(Context context) {
		super(context, DB, null, 1);
		//
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql = "CREATE TABLE "+NAME+"(id integer primary key autoincrement,name varchar(50))";
		db.execSQL(sql);
	}
	
	
	public long AddPerson(String name){
		long result = 0;
		ContentValues cv = new ContentValues();
		cv.put("name", name);
		
		SQLiteDatabase db = this.getWritableDatabase();
		result = db.insert(NAME, null, cv);
		db.close();
		return result;
		
	}
	public ArrayList<Person> getAllPerson(){
		ArrayList<Person> list = new ArrayList<Person>();
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.query(NAME, null, null, null, null, null,"name");
		c.moveToFirst();
		while(!c.isAfterLast()){
			int id = c.getInt(c.getColumnIndex("id"));
			String name = c.getString(c.getColumnIndex("name"));
			Person p = new Person(name);
			list.add(p);
			c.moveToNext();
			
		}
		db.close();
		return list;
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}
	public int getCount(){
		return getAllPerson().size();
		
	}
	
}
