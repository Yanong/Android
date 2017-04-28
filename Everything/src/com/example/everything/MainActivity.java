package com.example.everything;

import java.util.ArrayList;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemClickListener {
	
	GridView gv;
	ArrayList<Person> list = new ArrayList<Person>();
	GridAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.gv = (GridView) this.findViewById(R.id.gridView1);
        this.adapter = new GridAdapter(this,list);
        this.gv.setAdapter(adapter);
        
        this.list.add(new Person(R.drawable.img1,"Felix","BSIT"));
        this.list.add(new Person(R.drawable.img2,"Andy","BSIT"));
        this.list.add(new Person(R.drawable.img3,"sdASD","BSIT"));
        this.list.add(new Person(R.drawable.img4,"ASDZXCy","BSIT"));
        this.list.add(new Person(R.drawable.img5,"AZXCX","BSIT"));
        this.list.add(new Person(R.drawable.img6,"AQWASD","BSIT"));
        this.list.add(new Person(R.drawable.img7,"AGJGHJ","BSIT"));
        this.list.add(new Person(R.drawable.img8,"DFHGR","BSIT"));
        this.list.add(new Person(R.drawable.img9,"QWRRdy","BSIT"));
        this.list.add(new Person(R.drawable.img10,"ARTYR","BSIT"));
        
        this.gv.setOnItemClickListener(this);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		ImageView iv = new ImageView(this);
			iv.setImageResource(list.get(arg2).getImage());
		TextView tv = new TextView(this);
			tv.setText(list.get(arg2).getCourse());
			
		LinearLayout layout = new LinearLayout(this);
			layout.setOrientation(LinearLayout.HORIZONTAL);
			layout.addView(iv);
			layout.addView(tv);
			
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle(list.get(arg2).getName());
			builder.setView(layout);
			builder.setNeutralButton("Okey",null);
			
		AlertDialog dialog = builder.create();
			dialog.show();
		
	}
    
}
