package com.elango.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.elango.entities.Location;
import com.elango.repos.LocationRepository;
import com.elango.service.LocationServiceInterface;
import com.elango.util.EmailUtil;
import com.elango.util.ReportUtil;

@Controller
//@RequestMapping("/location")
public class LocationController {
	
	
	@Autowired
	private LocationServiceInterface service;
	
	@Autowired
	LocationRepository repo;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Autowired
	ReportUtil reportutil;
	
	@Autowired
	ServletContext sc;
	
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}
	
	
	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location,ModelMap modelMap) {
		Location locationSaved=service.saveLocation(location);
		String msg="Location saved with id :" +locationSaved.getId();
		modelMap.addAttribute("msg", msg);
		
		//Sending Email
		emailUtil.sendEmail("springsendmail100@gmail.com", "Location Saved", "Location Saved Successfully and about to return the response");
		return "createLocation";
	}
	
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) {
		List<Location> locations=service.getAllLocation();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}
	
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id,ModelMap modelMap) {
		//Location location=service.getLocationById(id);//reduce db call
		Location location=new Location();
		location.setId(id); 
		service.deleteLocation(location);
		
		//after delete get all Location
		List<Location> locations=service.getAllLocation();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id,ModelMap modelMap) {
		Location upadteLocation=service.getLocationById(id);
		modelMap.addAttribute("upadteLocation", upadteLocation);
		return "updateLocation";
		
	}
	
	@RequestMapping("/updateLoc")
	public String updateLoction(@ModelAttribute("location") Location location,ModelMap modelMap) {
		service.updateLocation(location);
		
		//after update get all Location
		List<Location> locations=service.getAllLocation();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}
	
	@RequestMapping("/generateReport")
	public String generateReport() {
		//List<Object[]> data = repo.findTypeAndTypeCount();
		//String realPath = sc.getRealPath("/");
		//reportutil.generatePieChart(realPath, data);
		return "report";
		
	}
	
	
}

