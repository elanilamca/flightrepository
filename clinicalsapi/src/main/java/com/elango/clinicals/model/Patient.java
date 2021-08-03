package com.elango.clinicals.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String lastName;
	private String firstName;
	private int age;
	
	@OneToMany(cascade=CascadeType.ALL ,fetch = FetchType.EAGER,mappedBy = "patient")
	private List<ClinicalData> clinicalData;
	
	
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
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the clinicalData
	 */
	public List<ClinicalData> getClinicalData() {
		return clinicalData;
	}
	/**
	 * @param clinicalData the clinicalData to set
	 */
	public void setClinicalData(List<ClinicalData> clinicalData) {
		this.clinicalData = clinicalData;
	}
	
	
	
}
