package com.example.tab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PersonAdd extends Activity implements OnClickListener {
	Button btnSAVE,btnCANCEL;
	PersonDatabase db;
	EditText txtName;
	TextView tv1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.addname);
		
		db = new PersonDatabase(this);
		this.txtName = (EditText) this.findViewById(R.id.editText1);
		this.btnSAVE = (Button) this.findViewById(R.id.button1);
		this.btnCANCEL = (Button) this.findViewById(R.id.button2);
		
		this.tv1 = (TextView) this.findViewById(R.id.textView1);
	
		this.btnSAVE.setOnClickListener(this);
		this.btnCANCEL.setOnClickListener(this);
		
		/*StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	    StrictMode.setThreadPolicy(policy);*/
	
		/*btnSAVE.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			String name = txtName.getText().toString();
			if(!name.equals("")){
				db.AddPerson(name);
				Toast.makeText(PersonAdd.this,name+" has been added.", Toast.LENGTH_LONG).show();
				overridePendingTransition(0,0);
				Intent intent = new Intent(PersonAdd.this,MainActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				overridePendingTransition(0,0);
				startActivity(intent);
			}
	}});
		
		btnCANCEL.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				txtName.setText("");
				txtName.requestFocus();
			}
		});
		*/
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		int i = arg0.getId();
		switch(i){
		case R.id.button1:
			String name = txtName.getText().toString();
			if(!name.equals("")){
				//Add new list
				db.AddPerson(name);//from PersonDatabase 
				Toast.makeText(PersonAdd.this,String.format("%s has been added", name), Toast.LENGTH_LONG).show();
				
				//View list
				Intent intent = new Intent(PersonAdd.this,MainActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				this.startActivity(intent);
			}
			break;
		case R.id.button2:
			txtName.setText("");
			txtName.requestFocus();
		
		}
	}
}
