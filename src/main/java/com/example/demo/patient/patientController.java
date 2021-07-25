package com.example.demo.patient;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/patient")
public class patientController {
	
	@Autowired
	private final patientrepo repository;	
	
	  patientController(patientrepo repository) {
		    this.repository = repository;
		   
		  }
	  @CrossOrigin(origins = "http://localhost:3000") 
	  @GetMapping("/")
	  @PreAuthorize("hasRole('ADMIN') or hasRole('PATIENT')")
	  
	  public
	  List<Patient> all(){
		  List<Patient> patients = repository.findAll();
		  return patients;
	  }
	  
	  @CrossOrigin(origins = "http://localhost:3000") 
	  @GetMapping("/{id}")
	  @PreAuthorize("hasRole('ADMIN') or hasRole('PATIENT')")
	  
	  public
	  ResponseEntity<?> getById(@RequestParam(name = "id") Long id){
		  Optional<Patient> optionalUser = repository.findById(id);
		  if (!optionalUser.isPresent()) {
	            return ResponseEntity.unprocessableEntity().build();
	        }
		  return ResponseEntity.ok().body((optionalUser.get()));
	   }
	  
	  @CrossOrigin(origins = "http://localhost:3000") 
	  @PostMapping("/")
	  @PreAuthorize("hasRole('ADMIN') or hasRole('PATIENT')")
	  ResponseEntity<?> newUser(@RequestBody Patient newUser ) {
		Patient patient = repository.save(newUser);
		  return ResponseEntity.ok(patient);
	  }
	  
	  @CrossOrigin(origins = "http://localhost:3000") 
	  @PutMapping("/{id}")
	  @PreAuthorize("hasRole('ADMIN') or hasRole('PATIENT')")
	  
	  ResponseEntity<?> replacePatient(@RequestBody Patient newPatient, @PathVariable Long id) {
		  Patient updatedUser = repository.findById(id)
				  .map(patient ->{
					  patient.setPatient_cnic(newPatient.getPatient_cnic());
					  patient.setPatient_email(newPatient.getPatient_email());
					  patient.setPatient_hospital(newPatient.getPatient_hospital());
					  patient.setPatient_mobile(newPatient.getPatient_mobile());
					  patient.setPatient_name(newPatient.getPatient_name());
					  return repository.save(patient);
				  })
				  .orElseGet(() ->{
					  newPatient.setPatient_id(id);
					  return repository.save(newPatient);
				  });
		  
		  return ResponseEntity.ok(updatedUser);
				  
					 
	  }
	  
	  @CrossOrigin(origins = "http://localhost:3000") 
	  @DeleteMapping("/{id}")
	  @PreAuthorize("hasRole('ADMIN') or hasRole('PATIENT')")
	  
	  void deletePatient(@PathVariable Long id) {
	    repository.deleteById(id);
	  }
	  

}
