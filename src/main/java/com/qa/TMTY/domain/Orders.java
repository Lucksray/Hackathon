package com.qa.TMTY.domain;

public class Orders {
	
	private int id;
	private String address;
	private Long packageId;
	
	public Orders(String address, Long packageId) {
		this.address = address;
		this.packageId = packageId;
	}
	
	public Orders(int id, String address, Long packageId) {
		this.id = id;
		this.address = address;
		this.packageId = packageId;
	}
	
	public int getId() {return this.id;}
	public void setId(int id) {this.id = id;}
	public String getAddress() {return this.address;}
	public void setAddress(String address) {this.address = address;}
	public Long getPackageId() {return this.packageId;}
	public void setPackageId(Long packageId) {this.packageId = packageId;}

	public String toString() {
		return "Orders [id=" + id + ", address=" + address + ", packageId=" + packageId + "]";
	}
}
