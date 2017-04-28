package com.example.picgrid;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class UpdatePersonActivity extends Activity implements OnClickListener {

	ImageView iv;
	EditText txtName;
	ImageButton btnSave, btnCancel;
	private Uri uriImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		this.setContentView(R.layout.update_person);

		this.iv = (ImageView) this.findViewById(R.id.imageView1);
		this.txtName = (EditText) this.findViewById(R.id.editText1);
		this.btnSave = (ImageButton) this.findViewById(R.id.imageButton1);
		this.btnCancel = (ImageButton) this.findViewById(R.id.imageButton2);

		this.iv.setOnClickListener(this);
		this.btnSave.setOnClickListener(this);
		this.btnCancel.setOnClickListener(this);

	} 

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		int id = arg0.getId();
		switch (id) {
		case R.id.imageView1:

			Intent intent = new Intent(
					Intent.ACTION_PICK,
					android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
			this.startActivityForResult(intent, 100);
			break;
		case R.id.imageButton1:
			String myname = this.txtName.getText().toString();
			if (!myname.equals("")) {
				Intent n = new Intent();
				n.putExtra("image", uriImage);
				n.putExtra("name", myname);

				this.setResult(Activity.RESULT_OK, n);

				Toast.makeText(this, "New Person Added", Toast.LENGTH_SHORT)
						.show();
				this.finish();
				break;
			}
			
		case R.id.imageButton2: {
			Toast.makeText(this, "Cancel Adding", Toast.LENGTH_SHORT).show();
			this.finish();
		}
		}                         
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		uriImage = data.getData();
		this.iv.setImageURI(uriImage);

	}

}
