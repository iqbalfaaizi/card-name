package com.dkatalis.exercises.card.dto

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("cards")
data class CardDto(
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
    val customerId: String,
    val cardName: String,
    val fullName: String,
    val defaultEmbossName: String,
    var generatedEmbossName: String
)

data class GenerateCardNameDto(
    @JsonProperty("name") val name: String
)