package com.example.mentalhealthapp.ui.components.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun HomeContent(modifier: Modifier = Modifier) {
    val randomFact = remember { randomDataHeatlh.random() }
    val icon = painterResource(com.example.mentalhealthapp.R.drawable.fruit_15467270)

    Column(modifier = modifier.fillMaxWidth()) {
        // Tarjeta de Bienvenida
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
        ) {
            Row(
                modifier = Modifier.padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier.size(60.dp)
                )
                Spacer(Modifier.width(16.dp))
                Column {
                    Text(
                        text = "Bienvenido",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Text(
                        text = "Tu salud mental es nuestra prioridad.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                    )
                }
            }
        }

        Spacer(Modifier.height(24.dp))

        Text(
            text = "¿Por qué es importante?",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Lista de información
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Card_textinfo.forEach { item ->
                CardInfo(titulo = item.titulo, texto = item.texto)
            }
        }

        Spacer(Modifier.height(24.dp))

        // Tarjeta de Dato Curioso
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Lightbulb, contentDescription = null, tint = MaterialTheme.colorScheme.tertiary)
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "¿Sabías que?",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onTertiaryContainer
                    )
                }
                Spacer(Modifier.height(8.dp))
                Text(
                    text = randomFact.text,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onTertiaryContainer
                )
            }
        }
    }
}

@Composable
fun CardInfo(titulo: String, texto: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = titulo,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = texto,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

data class RandomDataHeatlh(val text: String)
val randomDataHeatlh = listOf(
    RandomDataHeatlh("El suicidio es ya una de las principales causas de muerte en jóvenes de 15 a 19 años a nivel mundial."),
    RandomDataHeatlh("Existe un fenómeno llamado catarsis a través de la música triste. Muchas personas escuchan música melancólica cuando están mal no para deprimirse más, sino porque el cerebro libera prolactina (una hormona que suele activarse durante la lactancia o el llanto real) para consolar al cuerpo, generando una sensación de alivio y comprensión."),
    RandomDataHeatlh("Hablar más de un idioma no solo te ayuda a viajar; se ha demostrado que el bilingüismo puede retrasar la aparición de síntomas de demencia y Alzheimer hasta 4 o 5 años. Esto se debe a que el cerebro bilingüe desarrolla una mayor reserva cognitiva al gestionar constantemente dos sistemas de lenguaje.")
)
data class Card_text(val titulo: String, val texto: String)
val Card_textinfo = listOf(
    Card_text("Salud integral", "La salud mental es tan importante como la física. Afecta cómo pensamos, sentimos y actuamos en nuestra vida diaria."),
    Card_text("Prevención y tratamiento", "Conocer los síntomas y buscar ayuda a tiempo puede marcar una gran diferencia en el tratamiento y recuperación."),
    Card_text("Romper el estigma", "La educación sobre salud mental ayuda a reducir el estigma y fomenta un ambiente de comprensión y apoyo.")
)
