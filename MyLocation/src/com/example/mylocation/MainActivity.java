package com.example.mylocation;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener,LocationListener {

	EditText txtLat,txtLng;
	Button btnOK,btnCANCEL;
	private LocationManager locman;
	private Criteria criteria;
	private String provider;
	private Location location;
    
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        locman=(LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        criteria = new Criteria();
        //
        criteria.setAccuracy(Criteria.ACCURACY_MEDIUM);
        criteria.setPowerRequirement(Criteria.POWER_MEDIUM);
        //
        provider = locman.getBestProvider(criteria,false);
        //
        locman.requestLocationUpdates(provider, 1, 10,this);
        location=locman.getLastKnownLocation(provider);
        
        
        txtLat=(EditText) this.findViewById(R.id.editText1);
        txtLng=(EditText) this.findViewById(R.id.editText2);
        this.btnOK=(Button) this.findViewById(R.id.button1);
        this.btnCANCEL=(Button) this.findViewById(R.id.button2);
        
        this.btnOK.setOnClickListener(this);
        this.btnCANCEL.setOnClickListener(this);
	
	}


	@Override
	public void onClick(View arg0) {
		
		int id = arg0.getId();
		switch(id){ 
		case R.id.button1:
			location=locman.getLastKnownLocation(provider);
			Log.d("provider",provider);
			
			String lat = String.format("%.3f",location.getLatitude());
			String lng = String.format("%.3f",location.getLongitude());
			this.txtLat.setText(lat);
			this.txtLng.setText(lng); 
			break;
		case R.id.button2:
			this.txtLat.setText("");
			this.txtLng.setText("");
			this.txtLat.requestFocus();
		
		}
		
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
