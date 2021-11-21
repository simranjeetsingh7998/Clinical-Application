package com.clinical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinical.entity.ClinicalData;

public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Integer> {

	List<ClinicalData> findAllByPatientId(Integer patientId);

	List<ClinicalData> findByPatientIdAndComponentNameOrderByMeasuredDateTime(Integer patientId, String componentName);

}
