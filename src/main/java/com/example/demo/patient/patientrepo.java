package com.example.demo.patient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface patientrepo extends JpaRepository<Patient, Long> {

}
