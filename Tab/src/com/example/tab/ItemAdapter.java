package com.example.tab;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {

	Context context;
	ArrayList<Person> list = new ArrayList<Person>();
	LayoutInflater inflater;
	
	
	public ItemAdapter(Context context, ArrayList<Person> list) {
		super();
		this.context = context;
		this.list = list;
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
		ItemHandler handler = null;
		if(arg1==null){
			arg1=inflater.inflate(R.layout.item_lay, null);
			handler = new ItemHandler();
			handler.txtName=(TextView) arg1.findViewById(R.id.textView1);
			arg1.setTag(handler);
		}else handler = (ItemHandler) arg1.getTag();
		handler.txtName.setText(list.get(arg0).getName());
		
		return arg1;
	}

	static class ItemHandler{
		TextView txtName;
	}
}
