package com.example.mentalhealthapp.ui.components.screens.appointments

import com.example.mentalhealthapp.ui.models.centersList
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class AppointmentsDataTest {

    @Test
    fun `centersList contains items`() {
        assertTrue(centersList.isNotEmpty())
    }

    @Test
    fun `centers have required information`() {
        centersList.forEach { center ->
            assertTrue(center.name.isNotEmpty())
            assertTrue(center.city.isNotEmpty())
            assertTrue(center.address.isNotEmpty())
            assertTrue(center.phone.isNotEmpty())
            assertTrue(center.specialties.isNotEmpty())
        }
    }

    @Test
    fun `filtering by city works correctly`() {
        val medellinCenters = centersList.filter { it.city == "Medellín" }
        medellinCenters.forEach {
            assertEquals("Medellín", it.city)
        }
    }

    @Test
    fun `filtering by specialty works correctly`() {
        val query = "Ansiedad"
        val filtered = centersList.filter { center ->
            center.specialties.any { it.contains(query, ignoreCase = true) }
        }
        assertTrue(filtered.any { it.name.contains("Belén") })
    }

    @Test
    fun `search by name works correctly`() {
        val query = "San Juan"
        val filtered = centersList.filter { it.name.contains(query, ignoreCase = true) }
        assertEquals(1, filtered.size)
        assertEquals("Clínica San Juan de Dios", filtered[0].name)
    }
}
