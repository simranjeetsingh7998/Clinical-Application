package com.clinical.service;

import java.util.List;

import com.clinical.dto.ClinicalDataDTO;
import com.clinical.entity.ClinicalData;

public interface ClinicalDataService {
	ClinicalData saveClinicalData(ClinicalDataDTO data);

	List<ClinicalData> analyse(Integer id);

	List<ClinicalData> getClinicalData(Integer id, String componentName);
}
