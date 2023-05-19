package com.dkatalis.exercises.customer.controller

import com.dkatalis.exercises.customer.dto.CustomerDto
import org.springframework.web.bind.annotation.GetMapping

import com.dkatalis.exercises.customer.repository.CustomerRepository
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Autowired

@RestController
@RequestMapping("customer")
class CustomerController(
    @Autowired
    private val customerRepository: CustomerRepository
) {

    @GetMapping("/getCustomer")
    fun getCustomers(): CustomerDto? {
        return customerRepository.findCustomerByCustomerId("642a89ac4b94148f5772d560")
    }
}