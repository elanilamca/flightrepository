package com.elango.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elango.entities.Location;
import com.elango.repos.LocationRepository;

@Service
public class LocationService implements LocationServiceInterface {
	
	@Autowired
	private LocationRepository repo;

	@Override
	public Location saveLocation(Location location) {
		Location savedLocation= repo.save(location);
		return savedLocation;
	}

	
	@Override
	public Location updateLocation(Location location) {
		Location updateLocation= repo.save(location);
		return updateLocation;
	}

	@Override
	public void deleteLocation(Location location) {
		repo.delete(location);
	}

	@Override
	public Location getLocationById(int id) {
		
		Location searchId=repo.findById(id).get();
		return searchId;
	}

	@Override
	public List<Location> getAllLocation() {
		List<Location> retrieveAll=  (List<Location>) repo.findAll();
		return retrieveAll;
	}

}
