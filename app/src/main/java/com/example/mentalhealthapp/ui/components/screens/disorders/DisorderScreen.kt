package com.example.mentalhealthapp.ui.components.screens.disorders

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mentalhealthapp.ui.components.screens.home.MentalHealthBanner

@Composable
fun DisorderScreen(onItemClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        MentalHealthBanner(showSubtitle = false)

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Trastornos Mentales",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "Información detallada sobre los trastornos de salud mental más comunes",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            val disorders = listOf(
                "Trastornos de Ansiedad" to "El grupo de trastornos mentales más común en todo el mundo",
                "Depresión (Trastorno Depresivo Mayor)" to "Va más allá de la tristeza temporal",
                "Trastorno Bipolar" to "Cambios extremos en el estado de ánimo",
                "Trastorno por Déficit de Atención e Hiperactividad (TDAH)" to "Trastorno por déficit de atención e hiperactividad",
                "TEPT" to "Trastorno de Estrés Postraumático (TEPT)",
                "Esquizofrenia" to "Afecta la percepción y el pensamiento",
                "Trastornos de la Conducta Alimentaria" to "Trastornos de la conducta alimentaria",
                "Trastorno Obsesivo-Compulsivo (TOC)" to "Pensamientos obsesivos y comportamientos compulsivos",
                "Trastorno por Uso de Sustancias" to "Patrón problemático de consumo de sustancias",
                "Trastornos del Espectro Autista (TEA)" to "Trastorno del espectro autista"
            )

            disorders.forEach { (title, desc) ->
                DisorderItem(
                    title = title,
                    description = desc,
                    onClick = { if (title.contains("TOC")) onItemClick("toc") }
                )
                Spacer(Modifier.height(12.dp))
            }

            Spacer(Modifier.height(16.dp))

            // Nota informativa (se queda aquí como aviso general)
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.2f)
                )
            ) {
                Text(
                    text = "Nota: Esta información tiene fines educativos únicamente y no sustituye el diagnóstico, tratamiento o asesoramiento médico profesional. Siempre consulta con profesionales de la salud calificados para obtener orientación específica.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    lineHeight = 18.sp,
                    modifier = Modifier.padding(16.dp)
                )
            }
            
            Spacer(Modifier.height(24.dp))
        }
    }
}

@Composable
fun DisorderItem(title: String, description: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
