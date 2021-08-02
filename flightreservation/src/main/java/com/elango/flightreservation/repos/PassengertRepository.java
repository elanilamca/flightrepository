/**
 * 
 */
package com.elango.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elango.flightreservation.entities.Passenger;

/**
 * @author Dell
 *
 */
public interface PassengertRepository extends JpaRepository<Passenger, Long>{

}
