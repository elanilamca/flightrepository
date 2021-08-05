package com.elango.flightcheckin.integration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.elango.flightcheckin.integration.dto.Reservation;
import com.elango.flightcheckin.integration.dto.ReservationUpdateRequest;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

	//private static final String RESERVATION_REST_URL = "http://localhost:8080/flightreservation/reservations/";
	
	@Value("${com.elango.flighcheckin.integration.resturl}")
	private String RESERVATION_REST_URL;
	
	@Override
	public Reservation findReservation(Long id) {
		
		RestTemplate restTemplate=new RestTemplate();
		Reservation reservationObject = restTemplate.getForObject(RESERVATION_REST_URL+id, Reservation.class);
		return reservationObject;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {

		RestTemplate restTemplate=new RestTemplate();
		Reservation reservationObject = restTemplate.postForObject(RESERVATION_REST_URL, request ,Reservation.class);

		return reservationObject;
	}

}
