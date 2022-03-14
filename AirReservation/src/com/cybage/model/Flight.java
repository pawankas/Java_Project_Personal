package com.cybage.model;

public class Flight {
	private int flightId;
	private String flightName;
	private String flightNumber;
	private String destination;
	private String noOfStops;
	
	public Flight() {
		// TODO Auto-generated constructor stub
	}

	public Flight(int flightId, String flightName, String flightNumber, String destination, String noOfStops) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.flightNumber = flightNumber;
		this.destination = destination;
		this.noOfStops = noOfStops;
	}
	
	

	public Flight(String flightName, String flightNumber, String destination, String noOfStops) {
		super();
		this.flightName = flightName;
		this.flightNumber = flightNumber;
		this.destination = destination;
		this.noOfStops = noOfStops;
	}

	public Flight(int flightId2) {
		// TODO Auto-generated constructor stub
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getNoOfStops() {
		return noOfStops;
	}

	public void setNoOfStops(String noOfStops) {
		this.noOfStops = noOfStops;
	}

	@Override
	public String toString() {
		return "flight [flightId=" + flightId + ", flightName=" + flightName + ", flightNumber=" + flightNumber
				+ ", destination=" + destination + ", noOfStops=" + noOfStops + "]";
	}
	
	
	
}
