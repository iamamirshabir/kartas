package com.example.demo.scholarship;

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
@RequestMapping(value = "/api/scholarship")
public class scholarshipController {
	
	@Autowired
	private final scholarrepo repository;	
	
	scholarshipController(scholarrepo repository) {
		    this.repository = repository;
		   
		  }
	  @CrossOrigin(origins = "http://localhost:3000") 
	  @GetMapping("/")
	  @PreAuthorize("hasRole('ADMIN') or hasRole('STUDENT')")
	  
	  public
	  List<scholarship> all(){
		  List<scholarship> scholarship = repository.findAll();
		  return scholarship;
	  }
	  
	  @CrossOrigin(origins = "http://localhost:8089") 
	  @GetMapping("/{id}")
	  @PreAuthorize("hasRole('ADMIN') or hasRole('STUDENT')")
	  
	  public
	  ResponseEntity<?> getById(@RequestParam(name = "id") Long id){
		  Optional<scholarship> optionalUser = repository.findById(id);
		  if (!optionalUser.isPresent()) {
	            return ResponseEntity.unprocessableEntity().build();
	        }
		  return ResponseEntity.ok().body((optionalUser.get()));
	   }
	  
	  @CrossOrigin(origins = "http://localhost:8089") 
	  @PostMapping("/")
	  @PreAuthorize("hasRole('ADMIN') or hasRole('STUDENT')")
	  
	  ResponseEntity<?> newUser(@RequestBody scholarship newUser ) {
		  scholarship scholarship = repository.save(newUser);
		  return ResponseEntity.ok(scholarship);
	  }
	  
	  @PutMapping("/{id}")
	  @PreAuthorize("hasRole('ADMIN') or hasRole('STUDENT')")
	  
	  ResponseEntity<?> replacescholarship(@RequestBody scholarship newscholarship, @PathVariable Long id) {
		  scholarship updatedUser = repository.findById(id)
				  .map(scholarship ->{
					  scholarship.setAmount(newscholarship.getAmount());
					  scholarship.setGranted(newscholarship.getGranted());
					  
					  return repository.save(scholarship);
				  })
				  .orElseGet(() ->{
					  newscholarship.setId(id);
					  return repository.save(newscholarship);
				  });
		  
		  return ResponseEntity.ok(updatedUser);
				  
					 
	  }
	  
	  @DeleteMapping("/{id}")
	  @PreAuthorize("hasRole('ADMIN') or hasRole('STUDENT')")
	  
	  void deletescholarship(@PathVariable Long id) {
	    repository.deleteById(id);
	  }
	  

}

