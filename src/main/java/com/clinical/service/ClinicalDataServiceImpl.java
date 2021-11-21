package com.clinical.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinical.dto.ClinicalDataDTO;
import com.clinical.entity.ClinicalData;
import com.clinical.entity.Patient;
import com.clinical.repository.ClinicalDataRepository;
import com.clinical.repository.PatientRepository;
import com.clinical.utility.BMICalculator;

@Service
public class ClinicalDataServiceImpl implements ClinicalDataService {

	@Autowired
	private PatientRepository patientRepo;

	@Autowired
	private ClinicalDataRepository clinicalDataRepo;

	Map<String, String> filters = new HashMap<>();

	@Override
	public ClinicalData saveClinicalData(ClinicalDataDTO data) {
		Patient patient = patientRepo.findById(data.getPatientId()).get();
		ClinicalData clinicalData = new ClinicalData();
		clinicalData.setComponentName(data.getComponentName());
		clinicalData.setComponentValue(data.getComponentValue());
		clinicalData.setPatient(patient);
		clinicalData.setMeasuredDateTime(Timestamp.valueOf(LocalDateTime.now()));
		clinicalDataRepo.save(clinicalData);
		return clinicalData;
	}

	@Override
	public List<ClinicalData> analyse(Integer patientId) {
		List<ClinicalData> dataList = clinicalDataRepo.findAllByPatientId(patientId);
		List<ClinicalData> duplicateList = new ArrayList<>(dataList);
		for (ClinicalData cd : duplicateList) {

			if (filters.containsKey(cd.getComponentName())) {
				dataList.remove(cd);
			} else {
				filters.put(cd.getComponentName(), null);
			}

			if (cd.getComponentName().equals("hw")) {
				ClinicalData bmiData = BMICalculator.calculateBMI(cd);
				bmiData.setPatient(patientRepo.findById(patientId).get());
				dataList.add(bmiData);
			}
		}
		filters.clear();
		return dataList;
	}

	@Override
	public List<ClinicalData> getClinicalData(Integer patientId, String componentName) {
		if (componentName.equals("bmi")) {
			componentName = "hw";
		}
		List<ClinicalData> dataList = clinicalDataRepo.findByPatientIdAndComponentNameOrderByMeasuredDateTime(patientId,
				componentName);
		List<ClinicalData> duplicateList = new ArrayList<>();
		if (componentName.equals("hw")) {
			for (ClinicalData cd : dataList) {
				ClinicalData bmiData = BMICalculator.calculateBMI(cd);
				bmiData.setPatient(patientRepo.findById(patientId).get());
				duplicateList.add(bmiData);
			}
		}
		return duplicateList;
	}
}
