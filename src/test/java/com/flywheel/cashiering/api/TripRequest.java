package com.flywheel.cashiering.api;

import java.util.Date;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class TripRequest {
	String username;
	String password;
	Integer fleet;
	
	Date dateFrom;
	Date dateTo;

	public TripRequest(String u, String p, Integer f) {
		this.username = u;
		this.password = p;
		this.fleet = f;
	}
}
