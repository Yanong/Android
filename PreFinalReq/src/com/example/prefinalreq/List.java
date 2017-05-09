package com.example.prefinalreq;


import java.util.ArrayList;



import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class List extends Activity{
	LocationAdapter adapter;
	ListView lv;
	public static ArrayList<Location> source = new ArrayList<Location>();
	AdapterView.AdapterContextMenuInfo info;
	EditText txtSearch;
	TextView empty;
	LocationDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		db = new LocationDatabase(this);
	        if(db.getCount() > 0){      	
	        	source = db.getAllLocation();
	        }	
		this.lv = (ListView) this.findViewById(R.id.listView1);
	    this.adapter = new LocationAdapter(source,this);
	    this.lv.setAdapter(adapter); 
	   
	    adapter.notifyDataSetChanged();
	}

}
