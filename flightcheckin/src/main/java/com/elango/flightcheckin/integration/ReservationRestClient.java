package com.elango.flightcheckin.integration;

import com.elango.flightcheckin.integration.dto.Reservation;
import com.elango.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {



public Reservation findReservation(Long id);

public Reservation updateReservation(ReservationUpdateRequest request);


}