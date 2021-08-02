/**
 * 
 */
package com.elango.flightreservation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elango.flightreservation.controllers.ReservationController;
import com.elango.flightreservation.dto.ReservationRequest;
import com.elango.flightreservation.entities.Flight;
import com.elango.flightreservation.entities.Passenger;
import com.elango.flightreservation.entities.Reservation;
import com.elango.flightreservation.repos.FlightRepository;
import com.elango.flightreservation.repos.PassengertRepository;
import com.elango.flightreservation.repos.ReservationRepository;
import com.elango.flightreservation.util.EmailUtil;
import com.elango.flightreservation.util.PDFGenerator;

/**
 * @author Dell
 *
 */
@Service
public class ReservationServiceImpl implements ReservationService{
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	@Value("${com.elango.flightreservation.itinerary.dirpath}")
	private String ITINERARY_DIR;

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengertRepository passengertRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	PDFGenerator pdfGenerator;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Override
	@Transactional
	public Reservation bookFlight(ReservationRequest request) {
		
		//Make Payment
		
		LOGGER.info("Inside bookFlight()");
		Long flightId= request.getFlightId();
		Flight flight = flightRepository.findById(flightId).get();
		LOGGER.info("Fetching flight for flight id:"+flightId);
		
		Passenger passenger=new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		LOGGER.info("Saving the Passenger:"+passenger);
		Passenger savePassenger = passengertRepository.save(passenger);
		
		Reservation reservation=new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savePassenger);
		reservation.setCheckedIn(false);
		
		LOGGER.info("Saving the reservation:"+passenger);
		Reservation savedReservation = reservationRepository.save(reservation);
		
		String filePath = ITINERARY_DIR+savedReservation.getId()+".pdf";
		LOGGER.info("Generating the itinerary");
		pdfGenerator.generateItinerary(savedReservation, filePath);
		LOGGER.info("Emailing the itinerary");
		emailUtil.sendItinerary(passenger.getEmail(), filePath);
		
		return savedReservation;
	}

}
