package com.example.tab;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

	TabHost tabhost;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        
        tabhost=this.getTabHost();
        
        Intent listIntent = new Intent(this,PersonList.class);
        Intent addIntent = new Intent(this,PersonAdd.class);
        
        
        Drawable listicon = this.getResources().getDrawable(R.drawable.gallery);
        Drawable addicon = this.getResources().getDrawable(R.drawable.add);
        
        TabSpec namelist = tabhost.newTabSpec("namelist");
        	namelist.setIndicator("",listicon);
        	namelist.setContent(listIntent);
        
        TabSpec addlist = tabhost.newTabSpec("addlist");
        	addlist.setIndicator("",addicon);
        	addlist.setContent(addIntent);
        	
        	tabhost.addTab(namelist);
        	tabhost.addTab(addlist);
        
        	
	}

    
}
