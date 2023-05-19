package com.dkatalis.exercises.card.controller

import com.dkatalis.exercises.card.dto.GenerateCardNameDto
import com.dkatalis.exercises.card.dto.GeneratedCardName
import com.dkatalis.exercises.card.service.CardService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus

@RestController
@RequestMapping("card")
class CardController(
    @Autowired
    private val cardService: CardService
) {
    @GetMapping("/generateEmbossName")
    @ResponseStatus(HttpStatus.OK)
    fun getGeneratedCardNames(): List<GeneratedCardName> {
        return cardService.generateCardName()
    }

    @PostMapping("/generateName")
    @ResponseStatus(HttpStatus.OK)
    fun generateCardName(
        @RequestBody request: GenerateCardNameDto
    ): String {
        return cardService.generateTruncatedName(request.name)
    }
}