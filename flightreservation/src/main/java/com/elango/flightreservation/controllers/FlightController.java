/**
 * 
 */
package com.elango.flightreservation.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.elango.flightreservation.entities.Flight;
import com.elango.flightreservation.repos.FlightRepository;

/**
 * @author Dell
 *
 */
@Controller
public class FlightController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(FlightController.class);
	
	@Autowired
	FlightRepository flightRepository;
	
	@RequestMapping("findFlights")
	public String findFlights(@RequestParam("from") String from,
			@RequestParam("to")String to,
			//@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy")   Date departureDate,
			ModelMap modelMap) {
		
		LOGGER.info("Inside findFlights() From:" + from + " TO:" +to);
		
		List<Flight> flights = flightRepository.findFlights(from,to);	//departureDate
		System.out.println("flights....."+flights);
		modelMap.addAttribute("flights", flights);
		
		LOGGER.info("Flight Found are" +flights);
		return "displayFlights";
	}

	@RequestMapping("admin/showAddFlight")
	public String ShowAddFlight() {
		return "addFlight";
	}
}
