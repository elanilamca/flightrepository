/**
 * 
 */
package com.elango.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elango.flightreservation.dto.ReservationUpdateRequest;
import com.elango.flightreservation.entities.Reservation;
import com.elango.flightreservation.repos.ReservationRepository;
import com.elango.flightreservation.util.EmailUtil;

/**
 * @author Dell
 *
 */
@RestController
public class ReservationRestController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ReservationRestController.class);
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		LOGGER.info("Inside findReservation() for id:"+id);
		Reservation reservation = reservationRepository.findById(id).get();
		return reservation;
		
	}

	@RequestMapping("/reservations")
	public Reservation upateReservation(@RequestBody ReservationUpdateRequest request) {
		LOGGER.info("Inside upateReservation() for:"+request);
		Reservation reservationUpdate = reservationRepository.findById(request.getId()).get();
		reservationUpdate.setNumberOfBags(request.getNumberOfBags());
		reservationUpdate.setCheckedIn(request.getCheckedIn());
		LOGGER.info("Saving Reservation:");
		Reservation updatedReservation = reservationRepository.save(reservationUpdate);
		return updatedReservation;
		
	}
}
