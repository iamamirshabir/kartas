package com.example.demo.student;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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

import com.example.demo.patient.Patient;
import com.example.demo.patient.patientrepo;








@RestController
@RequestMapping(value = "/api/student")
public class studentController {
	
	@Autowired
	private final studentrepo repository;	
	
	studentController(studentrepo repository) {
		    this.repository = repository;
		   
		  }
	  @CrossOrigin(origins = "http://localhost:3000") 
	  @GetMapping("/")
	  public
	  List<Student> all(){
		  List<Student> student = repository.findAll();
		  return student;
	  }
	  
	  @CrossOrigin(origins = "http://localhost:8089") 
	  @GetMapping("/{id}")
	  public
	  ResponseEntity<?> getById(@RequestParam(name = "id") Long id){
		  Optional<Student> optionalUser = repository.findById(id);
		  if (!optionalUser.isPresent()) {
	            return ResponseEntity.unprocessableEntity().build();
	        }
		  return ResponseEntity.ok().body((optionalUser.get()));
	   }
	  
	  @CrossOrigin(origins = "http://localhost:8089") 
	  @PostMapping("/")
	  ResponseEntity<?> newUser(@RequestBody Student newUser ) {
		  Student student = repository.save(newUser);
		  return ResponseEntity.ok(student);
	  }
	  
	  @PutMapping("/{id}")
	  ResponseEntity<?> replaceStudent(@RequestBody Student newStudent, @PathVariable Long id) {
		  Student updatedUser = repository.findById(id)
				  .map(student ->{
					  student.setStudent_dob(newStudent.getStudent_dob());
					  student.setStudent_name(newStudent.getStudent_name());
					  student.setStudent_email(newStudent.getStudent_email());
					  student.setStudent_mobile(newStudent.getStudent_mobile());
					  student.setStudent_institute(newStudent.getStudent_institute());
					  student.setStudent_rollno(newStudent.getStudent_rollno());
					  student.setStudent_semester(newStudent.getStudent_semester());
					  return repository.save(student);
				  })
				  .orElseGet(() ->{
					  newStudent.setStudent_id(id);
					  return repository.save(newStudent);
				  });
		  
		  return ResponseEntity.ok(updatedUser);
				  
					 
	  }
	  
	  @DeleteMapping("/{id}")
	  void deleteStudent(@PathVariable Long id) {
	    repository.deleteById(id);
	  }
	  

}
