/**
 * 
 */
package com.elango.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elango.entities.Location;
import com.elango.repos.LocationRepository;

/**
 * @author Dell
 *
 */
@RestController
@RequestMapping("/locations")
public class LocationRESTController {
	
	@Autowired
	LocationRepository repo;

	@GetMapping
	public List<Location> getLocations(){
		return repo.findAll();
	}
	
	@PostMapping
	public Location createLocation(@RequestBody Location location) {
		return repo.save(location);
	}
	
	@PutMapping
	public Location updateLocation(@RequestBody Location location) {
		return repo.save(location);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable("id") int id) {
		 repo.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Optional<Location> getParticularLocation(@PathVariable("id") int id) {
		 return repo.findById(id);
	}
}
