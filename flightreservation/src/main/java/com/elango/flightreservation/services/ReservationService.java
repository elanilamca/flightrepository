/**
 * 
 */
package com.elango.flightreservation.services;

import com.elango.flightreservation.dto.ReservationRequest;
import com.elango.flightreservation.entities.Reservation;

/**
 * @author Dell
 *
 */
public interface ReservationService {

	public Reservation bookFlight(ReservationRequest request);
}
