package rmi.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import rmi.Flight;

public class FlightImpl extends UnicastRemoteObject implements Flight {
	
	protected String flightNumber;
	protected String origin;
	protected String destination;
	protected String skdDeparture;
	protected String skdArrival;
	
	public FlightImpl(String flightNumber, String origin,
			String destination, String skdDeparture, String skdArrival)
			throws RemoteException {
		this.flightNumber = flightNumber;
		this.origin = origin;
		this.destination = destination;
		this.skdDeparture = skdDeparture;
		this.skdArrival = skdArrival;
	}

	@Override
	public String getFlightNumber() throws RemoteException {
		System.out.println("调用 getFlightNumber(), 返回" + flightNumber);
		return flightNumber;
	}

	@Override
	public String getOrigin() throws RemoteException {
		return origin;
	}

	@Override
	public String getDestination() throws RemoteException {
		return destination;
	}

	@Override
	public String getSkdDeparture() throws RemoteException {
		return skdDeparture;
	}

	@Override
	public String getSkdArrival() throws RemoteException {
		return skdArrival;
	}

	@Override
	public void setOrigin(String origin) throws RemoteException {
		this.origin = origin;
	}

	@Override
	public void setDestination(String destination) throws RemoteException {
		this.destination = destination;
	}

	@Override
	public void setSkdDeparture(String skdDeparture) throws RemoteException {
		this.skdDeparture = skdDeparture;
	}

	@Override
	public void setSkdArrival(String skdArrival) throws RemoteException {
		this.skdArrival = skdArrival;
	}

}
