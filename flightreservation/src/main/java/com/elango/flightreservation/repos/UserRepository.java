/**
 * 
 */
package com.elango.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elango.flightreservation.entities.User;

/**
 * @author Dell
 *
 */
public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);

}
