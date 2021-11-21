package com.clinical.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clinicaldata")
public class ClinicalData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String componentName;
	private String componentValue;
	private Timestamp measuredDateTime;
	@ManyToOne(cascade = CascadeType.ALL)
	private Patient patient;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Timestamp getMeasuredDateTime() {
		return measuredDateTime;
	}

	public void setMeasuredDateTime(Timestamp measuredDateTime) {
		this.measuredDateTime = measuredDateTime;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "ClinicalData [id=" + id + ", componentName=" + componentName + ", componentValue=" + componentValue
				+ ", measuredDateTime=" + measuredDateTime + ", patient=" + patient + "]";
	}

}