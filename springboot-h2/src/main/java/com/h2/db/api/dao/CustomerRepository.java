package com.h2.db.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.h2.db.api.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

//	List<Employee> findbyDept(String dept);

}
