package com.example.demo.donor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
@RequestMapping(value = "/api/donor")
public class donorController {
	
	@Autowired
	private final donorrepo repository;	
	
	donorController(donorrepo repository) {
		    this.repository = repository;
		   
		  }
	  @CrossOrigin(origins = "http://localhost:3000") 
	  @GetMapping("/")
	  public
	  List<Donor> all(){
		  List<Donor> donor = repository.findAll();
		  return donor;
	  }
	  
	  @CrossOrigin(origins = "http://localhost:8089") 
	  @GetMapping("/{id}")
	  public
	  ResponseEntity<?> getById(@RequestParam(name = "id") Long id){
		  Optional<Donor> optionalUser = repository.findById(id);
		  if (!optionalUser.isPresent()) {
	            return ResponseEntity.unprocessableEntity().build();
	        }
		  return ResponseEntity.ok().body((optionalUser.get()));
	   }
	  
	  @CrossOrigin(origins = "http://localhost:8089") 
	  @PostMapping("/")
	  ResponseEntity<?> newUser(@RequestBody Donor newUser ) {
		  Donor donor = repository.save(newUser);
		  return ResponseEntity.ok(donor);
	  }
	  
	  @PutMapping("/{id}")
	  ResponseEntity<?> replaceDonor(@RequestBody Donor newDonor, @PathVariable Long id) {
		  Donor updatedUser = repository.findById(id)
				  .map(donor ->{
					  donor.setName(newDonor.getName());
					  donor.setEmail(newDonor.getEmail());
					  donor.setMobile(newDonor.getMobile());
					  donor.setAmount(newDonor.getAmount());
					 
					  return repository.save(donor);
				  })
				  .orElseGet(() ->{
					  newDonor.setDonor_id(id);
					  return repository.save(newDonor);
				  });
		  
		  return ResponseEntity.ok(updatedUser);
				  
					 
	  }
	  
	  @DeleteMapping("/{id}")
	  void deleteStudent(@PathVariable Long id) {
	    repository.deleteById(id);
	  }
	  

}

	
	


