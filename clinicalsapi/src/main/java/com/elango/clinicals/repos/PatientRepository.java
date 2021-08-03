package com.elango.clinicals.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elango.clinicals.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
