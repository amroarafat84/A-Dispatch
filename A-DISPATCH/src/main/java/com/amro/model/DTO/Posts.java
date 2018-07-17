package com.amro.model.DTO;

public class Posts {
	
	private int postId;
	private int shipperId;
	private int carrierId;
	private String pickupStreet;
	private String pickupCity;
	private String pickupState;
	private String pickupZipCode;
	private String dropoffStreet;
	private String dropoffCity;
	private String dropoffState;
	private String dropoffZipCode;
	private int price;
	private int assigned;
	private int accepted;
	private int pickedup;
	private int delivered;
	private int canceled;
	private String dispute;
	
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getShipperId() {
		return shipperId;
	}
	public void setShipperId(int shipperId) {
		this.shipperId = shipperId;
	}
	public int getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(int carrierId) {
		this.carrierId = carrierId;
	}
	public String getPickupStreet() {
		return pickupStreet;
	}
	public void setPickupStreet(String pickupStreet) {
		this.pickupStreet = pickupStreet;
	}
	public String getPickupCity() {
		return pickupCity;
	}
	public void setPickupCity(String pickupCity) {
		this.pickupCity = pickupCity;
	}
	public String getPickupState() {
		return pickupState;
	}
	public void setPickupState(String pickupState) {
		this.pickupState = pickupState;
	}
	public String getPickupZipCode() {
		return pickupZipCode;
	}
	public void setPickupZipCode(String pickupZipCode) {
		this.pickupZipCode = pickupZipCode;
	}
	public String getDropoffStreet() {
		return dropoffStreet;
	}
	public void setDropoffStreet(String dropoffStreet) {
		this.dropoffStreet = dropoffStreet;
	}
	public String getDropoffCity() {
		return dropoffCity;
	}
	public void setDropoffCity(String dropoffCity) {
		this.dropoffCity = dropoffCity;
	}
	public String getDropoffState() {
		return dropoffState;
	}
	public void setDropoffState(String dropoffState) {
		this.dropoffState = dropoffState;
	}
	public String getDropoffZipCode() {
		return dropoffZipCode;
	}
	public void setDropoffZipCode(String dropoffZipCode) {
		this.dropoffZipCode = dropoffZipCode;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAssigned() {
		return assigned;
	}
	public void setAssigned(int assigned) {
		this.assigned = assigned;
	}
	public int getAccepted() {
		return accepted;
	}
	public void setAccepted(int accepted) {
		this.accepted = accepted;
	}
	public int getPickedup() {
		return pickedup;
	}
	public void setPickedup(int pickedup) {
		this.pickedup = pickedup;
	}
	public int getDelivered() {
		return delivered;
	}
	public void setDelivered(int delivered) {
		this.delivered = delivered;
	}
	public int getCanceled() {
		return canceled;
	}
	public void setCanceled(int canceled) {
		this.canceled = canceled;
	}
	public String getDispute() {
		return dispute;
	}
	public void setDispute(String dispute) {
		this.dispute = dispute;
	}
	@Override
	public String toString() {
		return "Posts [postId=" + postId + ", shipperId=" + shipperId + ", carrierId=" + carrierId + ", pickupStreet="
				+ pickupStreet + ", pickupCity=" + pickupCity + ", pickupState=" + pickupState + ", pickupZipCode="
				+ pickupZipCode + ", dropoffStreet=" + dropoffStreet + ", dropoffCity=" + dropoffCity
				+ ", dropoffState=" + dropoffState + ", dropoffZipCode=" + dropoffZipCode + ", price=" + price
				+ ", assigned=" + assigned + ", accepted=" + accepted + ", pickedup=" + pickedup + ", delivered="
				+ delivered + ", canceled=" + canceled + ", dispute=" + dispute + "]";
	}
	
	
	
	

}
