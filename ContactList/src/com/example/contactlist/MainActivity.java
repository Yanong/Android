package com.example.contactlist;

import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Color;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements android.view.View.OnClickListener, OnClickListener {

	ListView lv;
	ArrayList<Contact> list = new ArrayList<Contact>();
	ItemAdapter adapter;
	ContactDatabase db;
	AdapterView.AdapterContextMenuInfo info;
	AlertDialog alertdialog , alertdialog1;
	private Uri imageUri;
	Dialog d4 ,d5 ;
	
	ImageView editImage;
    EditText editName;
    EditText editPhone;
    Uri editImageUri;
    String pastNum;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        this.lv=(ListView) this.findViewById(R.id.listView1);
        
        
        db=new ContactDatabase(this);
        if(db.getAllContact().size()>0){
        	list=db.getAllContact();
        }
        this.adapter=new ItemAdapter(this,list);
        this.lv.setAdapter(adapter);
        this.registerForContextMenu(lv);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

     
    
    
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		int id = item.getItemId();
		switch(id){
		case R.id.edit:
			d5 = new Dialog(this);
			d5.setContentView(R.layout.additem_layout);
						
			d5.setTitle(list.get(info.position).getName());
			editImage = (ImageView) d5.findViewById(R.id.imageView1);
	        editName = (EditText) d5.findViewById(R.id.editText1);
	        editPhone = (EditText) d5.findViewById(R.id.editText2);
	        Button save = (Button) d5.findViewById(R.id.button1);
	        Button cancel = (Button) d5.findViewById(R.id.button2);
			
	        
	        pastNum = list.get(info.position).getTel();
	        editImage.setImageURI(list.get(info.position).getImageUri());
	        editName.setText(list.get(info.position).getName());
	        editPhone.setText(list.get(info.position).getTel());
	        save.setText("Update");
	       
	        
	        editImageUri = list.get(info.position).getImageUri();
	        editImage.setOnClickListener(this);
	        save.setOnClickListener(this);
	        cancel.setOnClickListener(this);

	        d5.show();
			
			break;
		case R.id.view:
			ImageView iv = new ImageView(this);
			TextView lblname = new TextView(this);
			TextView lbltel = new TextView(this);
			
			iv.setImageURI(list.get(info.position).getImageUri());
			lblname.setText(list.get(info.position).getName());
			lbltel.setText(list.get(info.position).getTel());
			lbltel.setPadding(10,0,10,10);
			
			LinearLayout layout = new LinearLayout(this);
			layout.setOrientation(LinearLayout.HORIZONTAL);
			layout.addView(iv);
			layout.addView(lblname);
			layout.addView(lbltel);			
			
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Selected Contact");
			builder.setView(layout);
			builder.setNeutralButton("OK", null);
			
			alertdialog = builder.create();
			alertdialog.show();
			break;
		case R.id.call:

			String telephone = list.get(info.position).getTel();
			Uri uri = Uri.parse("tel: "+ telephone);
			Intent intent = new Intent(Intent.ACTION_CALL,uri);
			this.startActivity(intent);
			break;
		case R.id.send:
			Intent intent1 = new Intent(android.content.Intent.ACTION_VIEW);
			intent1.putExtra("address",list.get(info.position).getTel());
			intent1.putExtra("sms_body", "");
			intent1.setType("vnd.android-dir/mms-sms");
			this.startActivity(intent1);
			break;
		case R.id.delete:
			
			AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
			builder1.setTitle("Delete Contact");
			builder1.setMessage(String.format("Are you sure you want to delete %s ? ",list.get(info.position).getName()));
			builder1.setNegativeButton("Yes",this);
			builder1.setPositiveButton("No", this);
			
			
			
			
			
			alertdialog1 = builder1.create();
			alertdialog1.show();
		}
		return super.onContextItemSelected(item);
	}


	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		getMenuInflater().inflate(R.menu.contextmenu, menu);
		info = (AdapterContextMenuInfo) menuInfo;
		menu.setHeaderTitle(list.get(info.position).getName());
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent = new Intent(this,AddItemActivity.class);
		this.startActivityForResult(intent, 0);//add new contact
		return super.onOptionsItemSelected(item);
	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
	
	    if(resultCode == Activity.RESULT_OK) {
            if(requestCode == 0) {
                Bundle b = data.getExtras();

                Uri imageUri = b.getParcelable("image");
                String name = b.getString("name");
                String phone = b.getString("phone");

                this.db.addContact(imageUri.toString(), name, phone);
                this.list.add(new Contact(imageUri, name, phone));
                this.adapter.notifyDataSetChanged();
            } else if(requestCode == 200) {
                if(data != null) {
                    editImageUri = data.getData();
                    try {
                        editImage.setImageURI(editImageUri);
                    } catch(Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
	
	}
		
		@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		int i = arg0.getId();
		
		switch(i){
		case R.id.imageView1:
			Intent in = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            this.startActivityForResult(in, 200);
            break;
		case R.id.button2:
			  d5.dismiss();
			  Toast.makeText(this, "Cancel Editing", Toast.LENGTH_SHORT).show();
			  break;
		case R.id.button1:
			String setname = editName.getText().toString();
            String setphone = editPhone.getText().toString();

            list.get(info.position).setImageUri(editImageUri);
            list.get(info.position).setName(setname);
            list.get(info.position).setTel(setphone);

            db.deleteContact(pastNum);
            db.addContact(editImageUri.toString(), setname, setphone);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, String.format("%s has been edited", setname), Toast.LENGTH_SHORT).show();
            d5.dismiss();
            break;
	  
		  
		}
		
	}


		@Override
		public void onClick(DialogInterface arg0, int arg1) {
			// TODO Auto-generated method stub
			switch(arg1){
			case DialogInterface.BUTTON_POSITIVE:
				alertdialog1.dismiss();
				break;
			case DialogInterface.BUTTON_NEGATIVE:

				String phoneNum = list.get(info.position).getTel();
	            list.remove(info.position);
	            db.deleteContact(phoneNum);
	            adapter.notifyDataSetChanged();

	            Toast.makeText(this,"Deleted!", Toast.LENGTH_SHORT).show();
	            break;
			}
		}
    
    
    
}
