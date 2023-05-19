package com.dkatalis.exercises.config

import org.springframework.boot.autoconfigure.mongo.MongoProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.mongodb.MongoDatabaseFactory
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory

@Configuration
class MongoConfig {
    @Primary
    @Bean(name = ["cardMongoProperties"])
    @ConfigurationProperties(prefix = "card.mongodb")
    fun getCardMongo() : MongoProperties {
        return MongoProperties()
    }

    @Bean(name = ["customerMongoProperties"])
    @ConfigurationProperties(prefix = "customer.mongodb")
    fun getCustomerMongo() : MongoProperties {
        return MongoProperties()
    }

    @Primary
    @Bean(name = ["cardMongoTemplate"])
    fun cardMongoTemplate() : MongoTemplate {
        return MongoTemplate(cardMongoDatabaseFactory(getCardMongo()))
    }

    @Bean(name = ["customerMongoTemplate"])
    fun customerMongoTemplate() : MongoTemplate {
        return MongoTemplate(customerMongoDatabaseFactory(getCustomerMongo()))
    }

    @Primary
    @Bean
    fun cardMongoDatabaseFactory(mongo : MongoProperties) : MongoDatabaseFactory {
        return SimpleMongoClientDatabaseFactory(
            mongo.uri
        )
    }

    @Bean
    fun customerMongoDatabaseFactory(mongo : MongoProperties) : MongoDatabaseFactory {
        return SimpleMongoClientDatabaseFactory(
            mongo.uri
        )
    }
}