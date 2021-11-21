package com.clinical.service;

import java.util.List;

import com.clinical.entity.Patient;

public interface PatientService {
	List<Patient> getPatients();

	Patient getPatient(Integer id);

	Patient savePatient(Patient patient);
}
