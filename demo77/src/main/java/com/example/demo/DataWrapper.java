package com.example.demo;

public class DataWrapper {

	private Integer id;
	private String lat;
	private String lng;
	private String title;
	private String body;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "DataWrapper [id=" + id + ", lat=" + lat + ", lng=" + lng + ", title=" + title + ", body=" + body + "]";
	}
	
	
	
	
	
	
	
}
