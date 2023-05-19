package com.dkatalis.exercises.controller

import com.dkatalis.exercises.domain.Card
import com.dkatalis.exercises.domain.GeneratedCardName
import com.dkatalis.exercises.service.CardService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("cards")
class Controller(
    private val cardService: CardService
) {
    @GetMapping("/activeCardExamples")
    fun getAllCards(): List<Card> {
        return cardService.getAllCards()
    }

    @GetMapping("/generateCardName")
    fun getGeneratedCardNames(): List<GeneratedCardName> {
        return cardService.generateCardName()
    }
}