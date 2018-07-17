package com.amro.model.DTO;

public class Load {
	
	private int loadId;
	private int loadType;
	private int postId;
	private int year;
	private String make;
	private String model;
	private int drivalble;
	
	public int getLoadId() {
		return loadId;
	}
	public void setLoadId(int loadId) {
		this.loadId = loadId;
	}
	public int getLoadType() {
		return loadType;
	}
	public void setLoadType(int loadType) {
		this.loadType = loadType;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getDrivalble() {
		return drivalble;
	}
	public void setDrivalble(int drivalble) {
		this.drivalble = drivalble;
	}
	@Override
	public String toString() {
		return "Load [loadId=" + loadId + ", loadType=" + loadType + ", postId=" + postId + ", year=" + year + ", make="
				+ make + ", model=" + model + ", drivalble=" + drivalble + "]";
	}
	
	

}
