package com.flywheel.cashiering.api;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Trip {
	private int Id;
	private String PickupLocation;
	private String DropoffLocation;
	
	Trip(int id) {
		this.Id = id;
	}
	
	Trip() {
		this.Id = 0;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getPickupLocation() {
		return PickupLocation;
	}
	public void setPickupLocation(String pickupLocation) {
		PickupLocation = pickupLocation;
	}
	public String getDropoffLocation() {
		return DropoffLocation;
	}
	public void setDropoffLocation(String dropoffLocation) {
		DropoffLocation = dropoffLocation;
	}
}
