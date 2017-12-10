package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.repository.CustomerRepository;

@RestController
public class CustomerRest {
	@Autowired
	CustomerRepository customerRepository;

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCustomerByID(@PathVariable("id") int customerID) {
		String result = this.customerRepository.getAllCustomer(customerID);
		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}
	@RequestMapping(value = "/customer/{id}/xml", method = RequestMethod.GET)
	public ResponseEntity<?> getCustomer(@PathVariable("id") int customerID) {
		String result = this.customerRepository.getAllCustomer(customerID);
		return new ResponseEntity<Object>(this.customerRepository.convertJsonToXML(result), HttpStatus.OK);
	}
}
