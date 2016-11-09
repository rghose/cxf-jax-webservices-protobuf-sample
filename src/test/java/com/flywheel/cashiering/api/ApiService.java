package com.flywheel.cashiering.api;

import junit.framework.TestCase;

import org.apache.cxf.databinding.DataBinding;
import org.apache.cxf.jaxws.JaxWsClientFactoryBean;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import com.flywheel.cashiering.api.FlywheelTrips;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


public class ApiService extends TestCase {
	static {  
		JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean();  
	    svrFactory.getServiceFactory().setDataBinding((DataBinding) new JaxWsProxyFactoryBean());  
	    svrFactory.setServiceClass(FlywheelTrips.class);   
	    svrFactory.setAddress("http://localhost:8081/ApiCashier");
	    svrFactory.setServiceBean(new FlywheelTripsImpl());   
	    svrFactory.create();  
	}

	protected FlywheelTrips newFlywheelTripsRequest() {  
		JaxWsClientFactoryBean factory = new JaxWsClientFactoryBean();  
	    factory.setServiceClass(FlywheelTrips.class);  
	    factory.getServiceFactory().setDataBinding((DataBinding) new JaxWsProxyFactoryBean());  
	    factory.setAddress("http://localhost:8081/ApiCashier");  
	    return (FlywheelTrips) factory.create();
	}
	
	public void testService() throws ParseException {  
		FlywheelTrips ft=newFlywheelTripsRequest();
		Trip []results = ft.getTrips(1);
	    assertEquals(0, results.length);
	}
}
