package com.dkatalis.exercises.repository

import com.dkatalis.exercises.domain.Card
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.find
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository

@Repository
class CardRepository(
    private val mongoTemplate: MongoTemplate
){
    fun findAllCards(pageable: Pageable?): List<Card> {
        val criterion: Criteria = Criteria.where("cardStatus").`is`("ACTIVE")

        val query = Query(criterion)

        if (pageable != null) return mongoTemplate.find(query.with(pageable))

        return mongoTemplate.find(query)
    }

    fun findCardLongEmbossName(pageable: Pageable?): List<Card> {
        val criteria = Criteria.where("embossName").regex(".{24,}")
        val query = Query().addCriteria(criteria)

        if (pageable != null) return mongoTemplate.find(query.with(pageable))

        return mongoTemplate.find(query)
    }
}