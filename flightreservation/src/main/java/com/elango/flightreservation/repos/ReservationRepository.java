/**
 * 
 */
package com.elango.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elango.flightreservation.entities.Reservation;

/**
 * @author Dell
 *
 */
public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
