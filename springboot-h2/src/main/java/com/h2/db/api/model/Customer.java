package com.h2.db.api.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue
	private int customerId;
	private String customerName;
	private String customerMobile;
	private String customerEmail;
	private String customeraddress1;
	private String customeraddress2;
	private AccountType accountType;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_accountNumber")
	private Account accountDetails;

}
