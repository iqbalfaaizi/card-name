package com.dkatalis.exercises.card.repository

import com.dkatalis.exercises.card.dto.CardDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.find
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository

@Qualifier("cards")
@Repository
class CardRepository(
    @Autowired
    @Qualifier("cardMongoTemplate")
    private val cardMongoTemplate: MongoTemplate
){
    fun findCardLongEmbossName(pageable: Pageable?): List<CardDto> {
        val criteria = Criteria().andOperator(
            Criteria.where("embossName").regex(".{24,}")
        )

        val query = Query().addCriteria(criteria)

        if (pageable != null) return cardMongoTemplate.find(query.with(pageable))

        return cardMongoTemplate.find(query)
    }
}