package com.example.loveexam;

import java.util.ArrayList;

import com.example.customlistview.Person;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	Context context;
	ArrayList<Person> list;
	LayoutInflater inflater;
	 
	public MyAdapter(Context context, ArrayList<Person> list) {
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
		// TODO Auto-generated method stub
		int[] image = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9,R.drawable.img10,R.drawable.img11,R.drawable.img12};
		
		ItemHandler handler =null;
		
			if((arg0%2)==0)
			{
				arg1=inflater.inflate(R.layout.item_layout2, null);
			}
			else
			{
				arg1=inflater.inflate(R.layout.item_layout1, null);
			}
			handler=new ItemHandler();
			handler.iv= (ImageView) arg1.findViewById(R.id.imageView1);
			handler.Name= (TextView) arg1.findViewById(R.id.textView1);
			handler.Phone= (TextView) arg1.findViewById(R.id.textView2);
			arg1.setTag(handler);
		
		for(int i=1;i<12;i++)
		{
			handler.iv.setImageResource(image[arg0]);
			handler.Name.setText(list.get(arg0).getName());
			handler.Phone.setText(list.get(arg0).getPhone());
			return arg1;
		}
		return null;
		
	}
	
	static class ItemHandler
	{
		ImageView iv;
		TextView Name;
		TextView Phone;
	}
	

}
