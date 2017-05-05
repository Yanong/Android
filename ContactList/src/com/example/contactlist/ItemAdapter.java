package com.example.contactlist;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {
	
	Context context;
	ArrayList<Contact> list;
	LayoutInflater inflater;
	
	

	public ItemAdapter(Context context, ArrayList<Contact> list) {
		super();
		this.context = context;
		this.list = list;
		this.inflater=LayoutInflater.from(context);
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
		ItemHandler handler=null;
		if(arg1==null){
			arg1=inflater.inflate(R.layout.item_layout, null);
			handler=new ItemHandler();
			handler.iv=(ImageView) arg1.findViewById(R.id.imageView1);
			handler.lblName=(TextView) arg1.findViewById(R.id.textView1);
			handler.lblTel=(TextView) arg1.findViewById(R.id.textView2);
			arg1.setTag(handler);
		}else handler=(ItemHandler) arg1.getTag();
		handler.iv.setImageURI(list.get(arg0).getImageUri());
		handler.lblName.setText(list.get(arg0).getName());
		handler.lblTel.setText(list.get(arg0).getTel());
		
		return arg1;
	}
	static class ItemHandler{
		ImageView iv;
		TextView lblName,lblTel;
		
	}
	

}
