package com.flywheel.cashiering.api;

import java.util.Date;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class Trip {
	int Id;
	Date StartDate;
	Date EndDate;
	String PickupLocation;
}
