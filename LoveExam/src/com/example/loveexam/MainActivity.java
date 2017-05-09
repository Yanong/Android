package com.example.loveexam;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.example.customlistview.Person;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
	ListView lv;
	ArrayList<Person> list= new ArrayList<Person>();
	MyAdapter adapter;
	AlertDialog dialog;
	ImageView image;
	EditText Name;
	EditText Phone;
	
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.lv = (ListView) this.findViewById(R.id.listView1);
         adapter = new MyAdapter(this,list);
         this.lv.setAdapter(adapter);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
    	LinearLayout dialoglayout=new LinearLayout(this);
    	dialoglayout.setOrientation(LinearLayout.VERTICAL);
    	image = new ImageView(this);
    	Name = new EditText(this);
    		Name.setHint("Enter Name:");
    		Name.setPadding(10,10,10,10);
    	Phone = new EditText(this);
    		Phone.setHint("Enter Phone:");
    		Phone.setPadding(10,10,10,10);
    		
		dialoglayout.addView(Name);
		dialoglayout.addView(Phone);
    	
    		
    		AlertDialog.Builder builder = new AlertDialog.Builder(this);
    		builder.setTitle("Add Item");
    		builder.setView(dialoglayout);
    		builder.setPositiveButton("Save", this);
    		builder.setNegativeButton("Cancel", this);
    		
    		
    	dialog = builder.create();
    		dialog.show();
    		
    	
		return super.onOptionsItemSelected(item);
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		// TODO Auto-generated method stub
		
		switch(arg1)
		{
		case DialogInterface.BUTTON_POSITIVE:
			for(int i=1;i<5;i++){
				String name = this.Name.getText().toString();
			 	String Phone = this.Phone.getText().toString();
				list.add(new Person(R.drawable.ic_launcher,name,Phone));
				adapter.notifyDataSetChanged();
				break;
			}
			
			
			
			
			
			
		case DialogInterface.BUTTON_NEGATIVE:
			dialog.dismiss();
		}
	}
    
}
