/**
 * 
 */
package com.elango.flightcheckin.integration.dto;

/**
 * @author Dell
 *
 */
public class Reservation  {

	private Long id;
	private Boolean checkedIn;
	private int numberOfBags;
	
	private Passenger passenger;
	
	private Flight flight;
	
	
	
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the checkedIn
	 */
	public Boolean getCheckedIn() {
		return checkedIn;
	}
	/**
	 * @param checkedIn the checkedIn to set
	 */
	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	/**
	 * @return the numberOfBags
	 */
	public int getNumberOfBags() {
		return numberOfBags;
	}
	/**
	 * @param numberOfBags the numberOfBags to set
	 */
	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}
	/**
	 * @return the passenger
	 */
	public Passenger getPassenger() {
		return passenger;
	}
	/**
	 * @param passenger the passenger to set
	 */
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	/**
	 * @return the flight
	 */
	public Flight getFlight() {
		return flight;
	}
	/**
	 * @param flight the flight to set
	 */
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	
	
}
