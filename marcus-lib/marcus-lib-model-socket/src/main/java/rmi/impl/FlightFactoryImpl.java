package rmi.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

import rmi.Flight;
import rmi.FlightFactory;

public class FlightFactoryImpl extends UnicastRemoteObject implements FlightFactory {
	
	protected Hashtable<String, Flight> flights;
	
	public FlightFactoryImpl() throws RemoteException {
		flights = new Hashtable<String, Flight>();
	}

	@Override
	public Flight getFlight(String flightNumber) throws RemoteException {
		Flight flight = flights.get(flightNumber);
		if (flight != null) {
			return flight;
		}
		
		flight = new FlightImpl(flightNumber, null, null, null, null);
		flights.put(flightNumber, flight);
		return flight;
	}

}
