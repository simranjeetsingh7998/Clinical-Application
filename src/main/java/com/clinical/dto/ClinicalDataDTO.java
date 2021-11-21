package com.clinical.dto;

public class ClinicalDataDTO {
	private Integer patientId;
	private String componentName;
	private String componentValue;

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public String getComponentValue() {
		return componentValue;
	}

	public void setComponentValue(String componentValue) {
		this.componentValue = componentValue;
	}

	@Override
	public String toString() {
		return "ClinicalDataDTO [patientId=" + patientId + ", componentName=" + componentName + ", componentValue="
				+ componentValue + "]";
	}

}
