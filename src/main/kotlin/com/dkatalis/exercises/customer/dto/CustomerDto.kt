package com.dkatalis.exercises.customer.dto

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "customers")
data class CustomerDto(
    @Id
    val id: String,
    val cif: String,
    val fullName: String,
    val status: String,
)