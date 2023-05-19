package com.dkatalis.exercises.customer.repository

import com.dkatalis.exercises.customer.dto.CustomerDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.findOne
import org.springframework.stereotype.Repository
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@Configuration
@EnableMongoRepositories(
    basePackages = ["com.dkatalis.exercises.customer.repository"],
    mongoTemplateRef = "customerMongoTemplate"
)
@Repository
class CustomerRepository(
    @Autowired
    @Qualifier("customerMongoTemplate")
    protected var customerMongoTemplate: MongoTemplate
) {
    fun findCustomerByCustomerId(customerId: String): CustomerDto? {
        val query = Query().addCriteria(
            Criteria.where("id").`is`(customerId)
        )

        return customerMongoTemplate.findOne(query)
    }
}