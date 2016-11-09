package com.flywheel.cashiering.api;

import java.util.logging.Logger;

public class FlywheelTripsImpl implements FlywheelTrips {

	@Override
	public Trip[] getTrips(int id) {
		Trip []trips = new Trip[] {};
		Logger l = Logger.getLogger( "InfoLogging" );
		l.info("********** We have hit the server code **********");
		return trips;
	}
}
