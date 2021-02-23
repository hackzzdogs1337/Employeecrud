package com.employee.crudapp.service;


import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.crudapp.model.Employee;
import com.employee.crudapp.repositories.DetailsRepository;




@RestController
@RequestMapping("/employee")
public class Employeeapi {
	//Get single employee value
	Employee employee=new Employee();
	
	@Autowired
	private DetailsRepository repo;
	
	@GetMapping("/all")
	public List<Employee> getallemployees(){
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getemployeewithid(@PathVariable("id") BigInteger id){
		employee.setId(id);
		return ResponseEntity.ok(repo.findById(employee.getId()));
		
		
	}
	
	@PostMapping("/new")
	public String createemployee(@RequestBody Employee employee){
		repo.insert(employee);
		return "success";
	}
	
	@PutMapping("/{id}")
	public ResponseEntity editemployee(@PathVariable("id") BigInteger id,@RequestBody Employee employee) {
		repo.save(employee);
		return (ResponseEntity) ResponseEntity.noContent();
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteemployee(@PathVariable("id") BigInteger id) {
		repo.deleteById(id);
		return ResponseEntity.ok("{\"deleted\":true}");
	}
}
