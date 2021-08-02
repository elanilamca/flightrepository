/**
 * 
 */
package com.elango.flightreservation.springsecurity;

/**
 * @author Dell
 *
 */
public interface SecurityService {

	boolean login(String username,String password);
}
