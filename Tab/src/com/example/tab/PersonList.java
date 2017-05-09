package com.example.tab;


import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class PersonList extends Activity {

	PersonDatabase db;
	ArrayList<Person> list = new ArrayList<Person>();
	ListView lv;
	TextView tv;
	ItemAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.namelist);
		
		db = new PersonDatabase(this);
		if(db.getCount()>0){
			list = db.getAllPerson();
		}
		
		this.lv = (ListView) this.findViewById(R.id.listView1);
		this.adapter = new ItemAdapter(this,list);
		this.lv.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}

	
	
}
