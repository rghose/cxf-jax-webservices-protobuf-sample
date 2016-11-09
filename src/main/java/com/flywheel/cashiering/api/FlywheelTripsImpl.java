package com.flywheel.cashiering.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlywheelTripsImpl implements FlywheelTrips {
	
	private static final Logger LOGGER = Logger.getLogger( "InfoLogging" );
	
	private String getConfigurationOptions() {
		LOGGER.info("starting getConfig...");

		Properties properties = new Properties();
		try {
			File catalinaBase = new File( System.getProperty( "catalina.base" ) ).getAbsoluteFile();
			File propertyFile = new File( catalinaBase, "conf/configs.prop" );
			InputStream inputStream = new FileInputStream( propertyFile );
			properties.load(inputStream);
		} catch(IOException ex) {
	      LOGGER.warning("exception loading properties file: " + ex.getMessage());
	    }
	    return properties.getProperty("url_get_trips");
	}

	@Override
	public Trip getTrips(int id) {
		Trip trip = new Trip(1);
		LOGGER.info("********** We have hit the server code **********");
		AbeBackend obj = new AbeBackend(getConfigurationOptions());
		try {
			obj.getTripsFromAbe();
		} catch (Exception ex) {
			LOGGER.warning("exception in fetching trips from backend: " + ex.getCause().getClass());
			LOGGER.log(Level.INFO, "Oops bad exception:", ex);
			ex.printStackTrace();
		}
		return trip;
	}
}
