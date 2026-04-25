package com.example.mentalhealthapp.ui.components.screens.home

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class HomeDataTest {

    @Test
    fun `randomDataHealth list is not empty`() {
        assertTrue(randomDataHeatlh.isNotEmpty())
    }

    @Test
    fun `Card_textinfo list has correct items`() {
        assertEquals(3, Card_textinfo.size)
        assertEquals("Salud integral", Card_textinfo[0].titulo)
        assertEquals("Prevención y tratamiento", Card_textinfo[1].titulo)
        assertEquals("Romper el estigma", Card_textinfo[2].titulo)
    }

    @Test
    fun `RandomDataHeatlh model holds data correctly`() {
        val fact = RandomDataHeatlh("Test fact")
        assertEquals("Test fact", fact.text)
    }

    @Test
    fun `Card_text model holds data correctly`() {
        val card = Card_text("Title", "Content")
        assertEquals("Title", card.titulo)
        assertEquals("Content", card.texto)
    }
}
