package com.dkatalis.exercises.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal

@Document("cards")
data class Card(
    @Id
    val id: String,
    val cardId: String,
    val cardStatus: CardStatus?,
    val cardName: String,
    val embossName: String,
    val cardType: String?,
    val customerId: String,
) {
    enum class CardStatus {
        ACTIVE,
        INACTIVE,
        ACTIVATING,
        LOCKING,
        LOCKED,
        PERMANENT_BLOCKING,
        PERMANENT_BLOCKED,
        CLOSING,
        CLOSED,
        UNLOCKING,
        EXPIRED
    }
}

data class GeneratedCardName(
    @Id
    val id: String,
    val cardId: String,
    val cardName: String,
    val customerId: String,
    var generatedCustomerName: String
)