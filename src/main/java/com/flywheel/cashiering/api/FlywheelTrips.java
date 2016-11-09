package com.flywheel.cashiering.api;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/** A simple birthday calendar service. */  
@WebService(name="trips", targetNamespace="http://api.cashiering.flywheel.com/" )
public interface FlywheelTrips {
	@WebMethod
	Trip[] getTrips(@WebParam(name="id") int id);
}
