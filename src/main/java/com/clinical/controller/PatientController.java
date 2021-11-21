package com.clinical.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinical.entity.Patient;
import com.clinical.service.PatientService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin
public class PatientController {

	@Autowired
	private PatientService patientService;

	@GetMapping(value = "/patients")
	public ResponseEntity<List<Patient>> getPatients() {
		List<Patient> patientList = patientService.getPatients();
		return new ResponseEntity<>(patientList, HttpStatus.OK);
	}

	@GetMapping(value = "/patients/{id}")
	public ResponseEntity<Patient> getPatient(@PathVariable Integer id) {
		Patient patient = patientService.getPatient(id);
		return new ResponseEntity<>(patient, HttpStatus.OK);
	}

	@PostMapping(value = "/patients")
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {
		Patient savedPatient = patientService.savePatient(patient);
		return new ResponseEntity<>(savedPatient, HttpStatus.OK);
	}
}
