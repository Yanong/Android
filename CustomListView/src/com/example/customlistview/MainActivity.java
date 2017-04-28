package com.example.customlistview;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener, OnItemClickListener {

	ListView lv;
	ItemAdapter adapter;
	ArrayList<Student> list = new ArrayList<Student>();
	
	EditText txtSearch;
	ArrayList<Student> display = new ArrayList<Student>();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.txtSearch = (EditText) this.findViewById(R.id.editText1);
        this.lv = (ListView) this.findViewById(R.id.listView1);
        adapter = new ItemAdapter(this,display);
        this.lv.setAdapter(adapter);
        
        this.list.add(new Student(R.drawable.img1,"Felix","BSIT"));
        this.list.add(new Student(R.drawable.img2,"Manejo","BSCS"));
        this.list.add(new Student(R.drawable.img3,"Durano","BSEE"));
        this.list.add(new Student(R.drawable.img4,"Dennis","BSECE"));
        this.list.add(new Student(R.drawable.img5,"Alpha","BSCREAM"));
        this.list.add(new Student(R.drawable.img6,"Bravo","BSHRM"));
        this.list.add(new Student(R.drawable.img7,"Dora","BSOA"));
        this.list.add(new Student(R.drawable.img8,"Boots","BEED"));
        this.list.add(new Student(R.drawable.img9,"Doraemon","BSCREAM"));
        this.list.add(new Student(R.drawable.img10,"Nobita","BSHRM"));
        
        
        
        
        this.lv.setOnItemClickListener(this);
        
        this.txtSearch.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				display.clear();
				Pattern p=Pattern.compile(arg0.toString().toLowerCase());
				for(int i=0;i<list.size();i++)
				{
					Matcher name = p.matcher(list.get(i).getName().toLowerCase());
					Matcher course = p.matcher(list.get(i).getCourse().toLowerCase());
						if(name.find()|| course.find())
						{
							display.add(list.get(i));
						}
				}
				adapter.notifyDataSetChanged();
			}});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		LinearLayout dialoglayout=new LinearLayout(this);
		dialoglayout.setOrientation(LinearLayout.HORIZONTAL);
		dialoglayout.setGravity(LinearLayout.TEXT_ALIGNMENT_GRAVITY);
	ImageView iv = new ImageView(this);
	TextView name_course = new TextView(this);
		
		iv.setImageResource(list.get(arg2).getImage());
		String namecourse = list.get(arg2).getCourse();
		
		name_course.setText(namecourse);
		dialoglayout.addView(iv);
		dialoglayout.addView(name_course);
		
	AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(list.get(arg2).getName());
		builder.setView(dialoglayout);
		builder.setNeutralButton("Okay",null);
	
		AlertDialog dialog = builder.create();
			dialog.show();
	}
    
}
