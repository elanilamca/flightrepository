package com.elango.clinicals.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "clinicaldata")
public class ClinicalData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String componentName;
	private String componentValue;
	private Timestamp measuredDateTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="patient_id",nullable = false)
	@JsonIgnore
	private Patient patient;
	
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the componentName
	 */
	public String getComponentName() {
		return componentName;
	}
	/**
	 * @param componentName the componentName to set
	 */
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	/**
	 * @return the componentValue
	 */
	public String getComponentValue() {
		return componentValue;
	}
	/**
	 * @param componentValue the componentValue to set
	 */
	public void setComponentValue(String componentValue) {
		this.componentValue = componentValue;
	}
	/**
	 * @return the measuredDateTime
	 */
	public Timestamp getMeasuredDateTime() {
		return measuredDateTime;
	}
	/**
	 * @param measuredDateTime the measuredDateTime to set
	 */
	public void setMeasuredDateTime(Timestamp measuredDateTime) {
		this.measuredDateTime = measuredDateTime;
	}
	/**
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}
	/**
	 * @param patient the patient to set
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
}
