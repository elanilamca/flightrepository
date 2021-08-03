package com.elango.clinicals.dto;

public class ClinicalDataRequest {

	
	private String componentName;
	private String componentValue;
	private int patientId;
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
	 * @return the patientId
	 */
	public int getPatientId() {
		return patientId;
	}
	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	@Override
	public String toString() {
		return "ClinicalDataRequest [componentName=" + componentName + ", componentValue=" + componentValue
				+ ", patientId=" + patientId + "]";
	}
	
	
}
