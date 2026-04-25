package com.example.mentalhealthapp.ui.components.screens.disorders

import com.example.mentalhealthapp.ui.models.disordersList
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class DisordersDataTest {

    @Test
    fun `disordersList contains expected number of disorders`() {
        // Based on the file content, there should be 10 disorders
        assertEquals(10, disordersList.size)
    }

    @Test
    fun `disorders have valid data`() {
        disordersList.forEach { disorder ->
            assertNotNull(disorder.id)
            assertTrue(disorder.title.isNotEmpty())
            assertTrue(disorder.shortDescription.isNotEmpty())
            assertTrue(disorder.fullDescription.isNotEmpty())
            assertTrue(disorder.prevalence.isNotEmpty())
            assertTrue(disorder.symptoms.isNotEmpty())
        }
    }

    @Test
    fun `specific disorder data is correct`() {
        val anxiety = disordersList.find { it.id == "ansiedad" }
        assertNotNull(anxiety)
        assertEquals("Trastornos de Ansiedad", anxiety?.title)
        assertTrue(anxiety?.symptoms?.contains("Tensión muscular y fatiga") == true)
    }

    @Test
    fun `disorder IDs are unique`() {
        val ids = disordersList.map { it.id }
        assertEquals(ids.size, ids.distinct().size)
    }
}
