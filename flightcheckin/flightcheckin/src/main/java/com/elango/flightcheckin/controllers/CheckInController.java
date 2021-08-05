/**
 * 
 */
package com.elango.flightcheckin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.elango.flightcheckin.integration.ReservationRestClient;
import com.elango.flightcheckin.integration.dto.Reservation;
import com.elango.flightcheckin.integration.dto.ReservationUpdateRequest;

/**
 * @author Dell
 *
 */
@Controller
public class CheckInController {
	
	@Autowired
	ReservationRestClient restClient;
	
	@RequestMapping("/showCheckIn")
	public String showCheckIn() {
		return "startCheckIn";
	}
	
	@RequestMapping("/showStartCheckIn")
	public String showStartCheckin() {
		return "startCheckIn";
		
	}
	
	@RequestMapping("/startCheckIn")
	public String startCheckin(@RequestParam("reservationId") Long reservationId,
			ModelMap modelmap) {
		Reservation reservation = restClient.findReservation(reservationId);
		modelmap.addAttribute("reservation", reservation);
		return "displayReservationDetails";
	}
	
	
	@RequestMapping("/completeCheckIn")
	public String completeCheckIn(@RequestParam("reservationId") Long reservationId,@RequestParam("numberOfBags") int numberOfBags) {
		ReservationUpdateRequest reservationUpdateRequest=new ReservationUpdateRequest();
		reservationUpdateRequest.setId(reservationId);
		reservationUpdateRequest.setCheckedIn(true);
		reservationUpdateRequest.setNumberOfBags(numberOfBags);
		restClient.updateReservation(reservationUpdateRequest);
		return "checkInConfirmation";
	}

}
