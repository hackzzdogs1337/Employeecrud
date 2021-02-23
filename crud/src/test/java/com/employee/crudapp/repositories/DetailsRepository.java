package com.employee.crudapp.repositories;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.employee.crudapp.model.Employee;




public interface DetailsRepository extends MongoRepository<Employee,String> {
	Employee findById(BigInteger id);
	void deleteById(BigInteger id);
}
