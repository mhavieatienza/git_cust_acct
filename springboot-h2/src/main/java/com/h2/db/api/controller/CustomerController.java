package com.h2.db.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.h2.db.api.dao.CustomerRepository;
import com.h2.db.api.model.Customer;

import io.micrometer.common.util.StringUtils;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository repo;
	
	
	@PostMapping("/api/v1/account")
	public ResponseEntity<List<String>> saveEmployee(@RequestBody Customer employee) {
		
		List<String> status = new ArrayList<>();
		
		if(StringUtils.isEmpty(employee.getCustomeraddress1()) || StringUtils.isEmpty(employee.getCustomerEmail()) ||
				StringUtils.isEmpty(employee.getCustomerMobile()) || StringUtils.isEmpty(employee.getCustomerName())||
						StringUtils.isEmpty(employee.getAccountType().toString())) {
			status.add("Status: 401");
			status.add("Creating Customer Failed Missing Data..!!");
		}else {
			Customer emp = repo.save(employee);
			status.add("Customer Number: " + emp.getCustomerId());
			status.add("Status: 200");
			status.add("Customer account created..!");
		}
		return ResponseEntity.ok(status);
	}
	
	@GetMapping("/api/v1/account/getCustomer")
	public List<Customer> getAll(){
		
		return repo.findAll();
	}
	
	@GetMapping("/api/v1/account/{accountId}")
	public Optional<Customer> getAccountByAccountId(@PathVariable int accountId){
		
		return repo.findById(accountId);
	}
	
}
