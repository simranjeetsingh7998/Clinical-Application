package com.clinical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinical.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
