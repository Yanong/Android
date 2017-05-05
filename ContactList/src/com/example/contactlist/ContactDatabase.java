package com.example.contactlist;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class ContactDatabase extends SQLiteOpenHelper {
	

	static String DATABASE="db_contact";
	static String TBL_CONTACT="tbl_contact";
	
	public ContactDatabase(Context context) {
		super(context, DATABASE, null, 1);			// create database
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// create table tbl_contact
		String sql="CREATE TABLE "+TBL_CONTACT+"(id integer primary key autoincrement,image varchar(50),name varchar(50),phone varchar(25))";
		arg0.execSQL(sql);
	}

	public long addContact(String image,String name,String phone){
		SQLiteDatabase db=this.getWritableDatabase();
		long result=0;
		ContentValues cv=new ContentValues();
			cv.put("image", image);
			cv.put("name", name);
			cv.put("phone", phone);		
		result=db.insert(TBL_CONTACT, null, cv);
		db.close();
		return result;
	}
	
	public ArrayList<Contact> getAllContact(){
		SQLiteDatabase db=this.getReadableDatabase();
		ArrayList<Contact> list=new ArrayList<Contact>();
			Cursor c = db.query(TBL_CONTACT, null, null, null, null, null, "name");
			//reposition the record pointer
			c.moveToFirst();
			while(!c.isAfterLast()){
				
				String image=c.getString(c.getColumnIndex("image"));
				String name=c.getString(c.getColumnIndex("name"));
				String phone=c.getString(c.getColumnIndex("phone"));
				list.add(new Contact(Uri.parse(image),name,phone));
				
				c.moveToNext();	//iterate the record pointer
			}		
			db.close();
		return list;
	}
	
	public int deleteContact(String phone){
		SQLiteDatabase db=this.getWritableDatabase();
		return db.delete(TBL_CONTACT, "phone=?",new String[]{phone});
	}
	
	
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
