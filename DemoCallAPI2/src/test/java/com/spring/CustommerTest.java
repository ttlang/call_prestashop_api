package com.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.repository.CustomerRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustommerTest {
	@Autowired
	CustomerRepository customerRepository;
	@Test
	public void testGetCus() {
		System.err.println(this.customerRepository.convertJsonToXML(this.customerRepository.getAllCustomer(1)));
	}

}
