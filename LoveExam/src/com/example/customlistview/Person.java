package com.example.customlistview;

public class Person implements CharSequence {

	private int image;
	private String name,phone;
	
	
	public Person(int image, String name, String phone) {
		super();
		this.image = image;
		this.name = name;
		this.phone = phone;
	}
	public int getImage() {
		return image;
	}
	public void setImage(int image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public char charAt(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public CharSequence subSequence(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
