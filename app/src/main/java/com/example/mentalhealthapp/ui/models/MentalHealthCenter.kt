package com.example.mentalhealthapp.ui.models

data class MentalHealthCenter(
    val name: String,
    val type: String,
    val address: String,
    val city: String,
    val phone: String,
    val hours: String,
    val specialties: List<String>
)

val centersList = listOf(
    MentalHealthCenter(
        name = "Centro de Salud Mental Belén",
        type = "Centro de Atención Psicológica",
        address = "Calle 30A #75-50",
        city = "Medellín",
        phone = "(4) 444-5566",
        hours = "Lun-Vie: 7:00 AM - 6:00 PM",
        specialties = listOf("Ansiedad", "Depresión", "Terapia Familiar")
    ),
    MentalHealthCenter(
        name = "Clínica San Juan de Dios",
        type = "Hospital Mental",
        address = "Carrera 42 #52-33",
        city = "Bello",
        phone = "(4) 275-0101",
        hours = "24 Horas",
        specialties = listOf("Esquizofrenia", "Bipolaridad", "Urgencias")
    ),
    MentalHealthCenter(
        name = "Unidad de Salud Mental Envigado",
        type = "IPS Especializada",
        address = "Diagonal 31 #32-15",
        city = "Envigado",
        phone = "(4) 339-4000",
        hours = "Lun-Sáb: 8:00 AM - 5:00 PM",
        specialties = listOf("TDAH", "TEA", "Psicopedagogía")
    ),
    MentalHealthCenter(
        name = "Centro Psicológico Itagüí",
        type = "Consultorio Particular",
        address = "Calle 50 #51-20",
        city = "Itagüí",
        phone = "(4) 373-1212",
        hours = "Lun-Vie: 9:00 AM - 7:00 PM",
        specialties = listOf("Duelos", "Autoestima", "Estrés")
    )
)
