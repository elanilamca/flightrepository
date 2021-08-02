/**
 * 
 */
package com.elango.flightreservation.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author Dell
 *
 */
@Entity
public class Reservation extends AbstractEntity {

	//private Long id;
	private Boolean checkedIn;
	private int numberOfBags;
	
	@OneToOne
	private Passenger passenger;
	
	@OneToOne
	private Flight flight;
	
	
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
	
	@Override
	public String toString() {
		return "Reservation [checkedIn=" + checkedIn + ", numberOfBags=" + numberOfBags + ", passenger=" + passenger
				+ ", flight=" + flight + "]";
	}
	
	
	
}
