/**
 * 
 */
package com.elango.flightcheckin.integration.dto;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Dell
 *
 */
public class Flight{

	private Long id;
	private String fligtNumber;
	private String operatingAirlines;
	private String departureCity;
	private String arrivalCity;
	private Date dateOfDeparture;
	private Timestamp estimatedDepartureTime;
	
	
	
	
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
	 * @return the fligtNumber
	 */
	public String getFligtNumber() {
		return fligtNumber;
	}
	/**
	 * @param fligtNumber the fligtNumber to set
	 */
	public void setFligtNumber(String fligtNumber) {
		this.fligtNumber = fligtNumber;
	}
	/**
	 * @return the operatingAirlines
	 */
	public String getOperatingAirlines() {
		return operatingAirlines;
	}
	/**
	 * @param operatingAirlines the operatingAirlines to set
	 */
	public void setOperatingAirlines(String operatingAirlines) {
		this.operatingAirlines = operatingAirlines;
	}
	/**
	 * @return the departureCity
	 */
	public String getDepartureCity() {
		return departureCity;
	}
	/**
	 * @param departureCity the departureCity to set
	 */
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	/**
	 * @return the arrivalCity
	 */
	public String getArrivalCity() {
		return arrivalCity;
	}
	/**
	 * @param arrivalCity the arrivalCity to set
	 */
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	/**
	 * @return the dateOfDeparture
	 */
	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}
	/**
	 * @param dateOfDeparture the dateOfDeparture to set
	 */
	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}
	/**
	 * @return the estimatedDepartureTime
	 */
	public Timestamp getEstimatedDepartureTime() {
		return estimatedDepartureTime;
	}
	/**
	 * @param estimatedDepartureTime the estimatedDepartureTime to set
	 */
	public void setEstimatedDepartureTime(Timestamp estimatedDepartureTime) {
		this.estimatedDepartureTime = estimatedDepartureTime;
	}
	
	
}
