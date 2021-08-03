/**
 * 
 */
package com.elango.clinicals.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.elango.clinicals.dto.ClinicalDataRequest;
import com.elango.clinicals.model.ClinicalData;
import com.elango.clinicals.model.Patient;
import com.elango.clinicals.repos.ClinicalDataRepository;
import com.elango.clinicals.repos.PatientRepository;
import com.elango.clinicals.util.BMICalculator;

/**
 * @author Dell
 *
 */
@RestController
@RequestMapping("/api")
public class ClinicalDataController {
	
	@Autowired
	private ClinicalDataRepository clinicalDataRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	
	ClinicalDataController(ClinicalDataRepository clinicalDataRepository,PatientRepository patientRepository){
		this.clinicalDataRepository=clinicalDataRepository;
		this.patientRepository=patientRepository;
	}

	@RequestMapping(value = "/clinicals" ,method = RequestMethod.POST)
	public ClinicalData saveClinicalData(@RequestBody  ClinicalDataRequest request) {
		Patient patient = patientRepository.findById(request.getPatientId()).get();
		ClinicalData clinicalData = new ClinicalData();
		clinicalData.setComponentName(request.getComponentName());
		clinicalData.setComponentValue(request.getComponentValue());
		clinicalData.setPatient(patient);
		return clinicalDataRepository.save(clinicalData);
		
	}
	
	@RequestMapping(value = "/clinicals/{patientId}/{componentName}",method = RequestMethod.GET)
	public List<ClinicalData> getClinicalData(@PathVariable("patientId") int patientId,@PathVariable("componentName") String componentName){
		
		
		if(componentName.equals("bmi")) {
			componentName ="hw";
		}
		List<ClinicalData> clinicalData = clinicalDataRepository.findByPatientIdAndComponentNameOrderByMeasuredDateTime(patientId,componentName);
		
		List<ClinicalData> duplicateClinicalData = new ArrayList<>();
		for (ClinicalData eachEntry : duplicateClinicalData) {
			BMICalculator.calculateBMI(clinicalData, eachEntry);
		}
		return clinicalData;
		
	}
	
}
