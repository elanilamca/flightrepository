/**
 * 
 */
package com.elango.flightreservation.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.elango.flightreservation.dto.ReservationRequest;
import com.elango.flightreservation.entities.Flight;
import com.elango.flightreservation.entities.Reservation;
import com.elango.flightreservation.repos.FlightRepository;
import com.elango.flightreservation.services.ReservationService;

/**
 * @author Dell
 *
 */
@Controller
public class ReservationController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservstion(@RequestParam("flightId") Long flightId,ModelMap modelMap) {
		
		LOGGER.info("Inside showCompleteReservation() invoked with the flight Id" +flightId);
		Flight flight=flightRepository.findById(flightId).get();
	    modelMap.addAttribute("flight", flight);
	    LOGGER.info("Flight is:" +flight);
		return "completeReservation";
	}
	
	//create custom request (bung of values comes from jsp)
	@RequestMapping(value =  "/completeReservation",method = RequestMethod.POST)
	public String completeReservation(ReservationRequest request,ModelMap modelMap) {
		LOGGER.info("Inside completeReservation() " +request);
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation created successfully and the id is "+reservation.getId());
		return "reservationConfirmation";
		
	}
}
