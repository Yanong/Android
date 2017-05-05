package com.example.contactlist;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddItemActivity extends Activity implements OnClickListener {

	ImageView iv;
	EditText txtName,txtTel;
	Button btnSave,btnCancel;
	private Uri imageUri;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.additem_layout);
		this.iv=(ImageView) this.findViewById(R.id.imageView1);
		this.txtName=(EditText) this.findViewById(R.id.editText1);
		this.txtTel=(EditText) this.findViewById(R.id.editText2);
		this.btnSave=(Button) this.findViewById(R.id.button1);
		this.btnCancel=(Button) this.findViewById(R.id.button2);
		
		this.iv.setOnClickListener( this);
		this.btnSave.setOnClickListener(this);
		this.btnCancel.setOnClickListener(this);
		
		
		
		
		
		
	}

	@Override
	public void onClick(View arg0) {
		int id=arg0.getId();
		switch(id){
		case R.id.imageView1: 
			//get an image from the staggered
			
			Intent intent =new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
			this.startActivityForResult(intent, 100);
			
			break; 
		case R.id.button1: 
			//save the information to database 
			Intent n=new Intent();	//blind intent
			String name=this.txtName.getText().toString();
			String phone=this.txtTel.getText().toString();
			
			if(!name.equals("") && !phone.equals("")){
				n.putExtra("image",imageUri );
				n.putExtra("name", name);
				n.putExtra("phone", phone);
				this.setResult(Activity.RESULT_OK, n);
			}
			else Toast.makeText(this, "Please Fill all fields", Toast.LENGTH_SHORT).show();
			
		case R.id.button2:
			this.finish();	//terminate this activity
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		imageUri=data.getData();
		if(imageUri!=null){
			iv.setImageURI(imageUri);
		}
		
		
	}	
	
	
	
	
	
}





