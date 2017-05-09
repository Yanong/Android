package com.example.prefinalreq;

public class Location {
	private String name;
	private String lat;
	private String lng;
	private int id;
	public Location(String lat, String lng, int id) {
		super();
		this.lat = lat;
		this.lng = lng;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
