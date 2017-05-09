package com.example.prefinalreq;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {
	TabHost tabhost;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabhost = this.getTabHost();
        
        Intent intentL = new Intent(this,List.class);
        Intent intentA = new Intent(this,Add.class);
        Intent intentAb = new Intent(this,About.class);
        
        TabSpec namelist = tabhost.newTabSpec("namelist");
        	namelist.setIndicator("ADD");
        	namelist.setContent(intentL);
        	
        TabSpec addlist = tabhost.newTabSpec("addlist");	
        	addlist.setIndicator("MAP MODE");
        	addlist.setContent(intentA);
        	
        	TabSpec aboutlist = tabhost.newTabSpec("aboutlist");
        	aboutlist.setIndicator("INFO");
        	aboutlist.setContent(intentAb);	
        	 
        	
        tabhost.addTab(namelist);	
        tabhost.addTab(addlist);
        tabhost.addTab(aboutlist);
        
        
    }
		
    
}
