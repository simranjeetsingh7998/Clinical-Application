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

import com.clinical.dto.ClinicalDataDTO;
import com.clinical.entity.ClinicalData;
import com.clinical.service.ClinicalDataService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin
public class ClinicalDataController {

	@Autowired
	private ClinicalDataService clinicalDataService;

	@PostMapping(value = "/clinicals")
	public ResponseEntity<ClinicalData> saveClinicalData(@RequestBody ClinicalDataDTO data) {
		ClinicalData clinicalData = clinicalDataService.saveClinicalData(data);
		return new ResponseEntity<>(clinicalData, HttpStatus.OK);
	}

	@GetMapping(value = "/clinicals/analyse/{patientId}")
	public ResponseEntity<List<ClinicalData>> analyse(@PathVariable Integer patientId) {
		List<ClinicalData> dataList = clinicalDataService.analyse(patientId);
		return new ResponseEntity<>(dataList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/clinicals/{patientId}/{componentName}")
	public ResponseEntity<List<ClinicalData>> getClinicalData(
			@PathVariable Integer patientId, @PathVariable String componentName) {
		List<ClinicalData> dataList = clinicalDataService.getClinicalData(patientId, componentName);
		return new ResponseEntity<>(dataList, HttpStatus.OK);
		
	}
}
