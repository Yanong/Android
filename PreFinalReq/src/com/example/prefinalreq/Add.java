package com.example.prefinalreq;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.location.Geocoder;

public class Add extends Activity implements LocationListener{
	Button btnAdd, btnCancel, btnGenerate;
	private LocationManager locman;
	private Criteria criteria;
	private String provider;
	private Location location;
	String lat, lng;
	EditText txtLat, txtLng;
	Geocoder geocoder;
	Address thisAddress;
	TextView t1, t2, t3, t4;
	LocationDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add);
		geocoder = new Geocoder(this);
		
		db = new LocationDatabase(this);
		//this.txtName = (EditText)	this.findViewById(R.id.editText3);
		this.txtLat = (EditText) this.findViewById(R.id.editText1);
		this.txtLng = (EditText) this.findViewById(R.id.editText2);
		this.btnGenerate = (Button) this.findViewById(R.id.button3);
		this.btnAdd = (Button) this.findViewById(R.id.button1);
		this.btnCancel = (Button) this.findViewById(R.id.button2);
		this.t1 = (TextView) this.findViewById(R.id.textView1);
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	    StrictMode.setThreadPolicy(policy);
		

		btnGenerate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				locman = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
				criteria = new Criteria();
				
				criteria.setAccuracy(Criteria.ACCURACY_MEDIUM);
				criteria.setPowerRequirement(Criteria.ACCURACY_MEDIUM);
					
				provider = locman.getBestProvider(criteria, false);
				locman.requestLocationUpdates(provider, 1, 10,Add.this);
				
				location = locman.getLastKnownLocation(provider);
				lat = String.format("%.5f",location.getLatitude());
				lng = String.format("%.5f",location.getLongitude());
				Toast.makeText(Add.this, lat + "  " +lng, Toast.LENGTH_LONG).show();

			
				txtLat.setText(lat);
				txtLng.setText(lng);
			
			}
		});
		
		btnAdd.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
			String lat = txtLat.getText().toString();
				String lng = txtLng.getText().toString();
				//String name = txtName.getText().toString();
				if(!lat.equals("") && (!lng.equals(""))){
					db.addLocation(lat, lng);
					Toast.makeText(Add.this, "Added Successfully", Toast.LENGTH_LONG).show();
					overridePendingTransition(0,0);
					Intent intent = new Intent(Add.this,MainActivity.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
					overridePendingTransition(0,0);
					startActivity(intent);

					
					
				}
			
			
			
	}});	
		
	btnCancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
						
					txtLng.setText("");
					txtLat.setText("");
					txtLat.requestFocus();
					txtLng.requestFocus();

					
					
				}
			
			
			
	});
	
	
	}
	
	
	
	
	  
	@Override
	public void onLocationChanged(Location arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}

}
