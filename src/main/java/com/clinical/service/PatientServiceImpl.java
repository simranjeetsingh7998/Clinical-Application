package com.clinical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinical.entity.Patient;
import com.clinical.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository repo;

	@Override
	public List<Patient> getPatients() {
		return repo.findAll();
	}

	@Override
	public Patient getPatient(Integer patientId) {
		Patient patient = repo.findById(patientId).get();
		return patient;
	}

	@Override
	public Patient savePatient(Patient patient) {
		Patient savedPatient = repo.save(patient);
		return savedPatient;
	}
}
