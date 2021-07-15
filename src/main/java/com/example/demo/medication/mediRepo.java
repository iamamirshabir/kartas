package com.example.demo.medication;

import org.springframework.data.jpa.repository.JpaRepository;

public interface mediRepo extends JpaRepository<Medication, Long> {

}
