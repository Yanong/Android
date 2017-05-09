package com.example.prefinalreq;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class LocationAdapter extends BaseAdapter{
	ArrayList<Location> list = new ArrayList<Location>();
	Context context;
	LayoutInflater inflater;
	
	
	public LocationAdapter(ArrayList<Location> list, Context context) {
		super();
		this.list = list;
		this.context = context;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		LocationHandler handler = null;

		if(arg1==null){
			arg1 = inflater.inflate(R.layout.locationlayout, null);
			handler = new LocationHandler();
			handler.lng =(TextView) arg1.findViewById(R.id.textView2);
			handler.lat =  (TextView) arg1.findViewById(R.id.textView4);
			arg1.setTag(handler);
		}else handler = (LocationHandler) arg1.getTag();
			handler.lat.setText(list.get(arg0).getLat());
			handler.lng.setText(list.get(arg0).getLng());		
	
	return arg1;
	}
	static class LocationHandler{
	
		TextView lng, lat;
	}
}
