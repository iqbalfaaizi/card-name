package com.dkatalis.exercises.service

import com.dkatalis.exercises.domain.Card
import com.dkatalis.exercises.domain.GeneratedCardName
import com.dkatalis.exercises.repository.CardRepository
import com.dkatalis.exercises.util.CardUtils
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class CardService(
    private val cardRepository: CardRepository,
    private val cardUtils: CardUtils
) {
    fun getAllCards(): List<Card> {
        val fieldSorting = Sort.by(Sort.Direction.DESC, "updatedAt")
        val pageNo = 1
        val pagesize = 10
        val pageable: Pageable = PageRequest.of(pageNo, pagesize, fieldSorting)

        return cardRepository.findAllCards(pageable)
    }

    fun generateCardName(): List<GeneratedCardName> {
        val fieldSorting = Sort.by(Sort.Direction.DESC, "updatedAt")
        val pageNo = 1
        val pagesize = 10
        val pageable: Pageable = PageRequest.of(pageNo, pagesize, fieldSorting)
        return cardRepository.findCardLongEmbossName(pageable).map {
            GeneratedCardName(
                id = it.id,
                cardId = it.cardId,
                cardName = it.cardName,
                customerId = it.customerId,
                generatedCustomerName = cardUtils.generateCardName(it.embossName)
            )
        }
    }

}