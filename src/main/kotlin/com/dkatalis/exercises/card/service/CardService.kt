package com.dkatalis.exercises.card.service

import com.dkatalis.exercises.card.dto.GeneratedCardName
import com.dkatalis.exercises.card.repository.CardRepository
import com.dkatalis.exercises.card.util.CardUtils
import com.dkatalis.exercises.customer.repository.CustomerRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired

@Service("cardService")
class CardService(
    @Autowired
    private val cardRepository: CardRepository,
    private val cardUtils: CardUtils,
    private val customerRepository: CustomerRepository
) {
    fun generateCardName(): List<GeneratedCardName> {
        val fieldSorting = Sort.by(Sort.Direction.DESC, "updatedAt")
        val pageNo = 1
        val pagesize = 10
        val pageable: Pageable = PageRequest.of(pageNo, pagesize, fieldSorting)
        return cardRepository.findCardLongEmbossName(pageable).map {
            val customer = customerRepository.findCustomerByCustomerId(it.customerId)
            GeneratedCardName(
                it.id,
                it.cardId,
                it.customerId,
                it.cardName,
                customer?.fullName ?: it.embossName,
                it.embossName,
                cardUtils.generateCardName(customer?.fullName ?: it.embossName)
            )
        }
    }

    fun generateTruncatedName(name: String): String {
        return cardUtils.generateCardName(name)
    }

}