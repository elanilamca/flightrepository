package com.elango.service;

import java.util.List;

import com.elango.entities.Location;

public interface LocationServiceInterface {

	Location saveLocation(Location location);
	
	Location updateLocation(Location location);
	
	void deleteLocation(Location location);
	
	Location getLocationById(int id);

	List<Location> getAllLocation();

	
}
