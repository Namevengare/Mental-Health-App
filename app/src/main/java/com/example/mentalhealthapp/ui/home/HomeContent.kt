package com.example.mentalhealthapp.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun HomeContent(modifier: Modifier = Modifier){

    val randomFact = remember { randomDataHeatlh.random() }

    val icon = painterResource(com.example.mentalhealthapp.R.drawable.fruit_15467270)
    Card(modifier.height(120.dp)) {
        Row() {
            Box(
                modifier = Modifier.fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = icon,
                    contentDescription = "Icon of the app",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                )
            }
            Column() {
                Text(
                    text = "Bienvenido a MentalHealth",
                    fontSize = 20.sp
                )
                Text(
                    text = "Tu salud mental es importante. Aquí encontrarás información valiosa sobre diversos trastornos mentales y recursos para cuidar tu bienestar."
                )}
            }

    }
    Spacer(Modifier.height(20.dp))
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = "¿Por qué es importante?",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
        Card_textinfo.forEach { item -> CardInfo(Titulo = item.titulo, Texto = item.texto) }
    }
    Spacer(Modifier.height(20.dp))
    Card() {
        Text(
            text = randomFact.text
        )
    }
}
@Composable
fun CardInfo(Titulo: String, Texto: String){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ){
        Text(
            text = Titulo,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()

            )
        Text(
            text = Texto
        )
    }
}
data class RandomDataHeatlh(val text: String)

val randomDataHeatlh = listOf(
    RandomDataHeatlh(
        text = "El cerebro humano no termina de desarrollarse completamente hasta los 25 años, lo que explica por qué los adolescentes son más vulnerables a ciertos trastornos mentales. Además, el cerebro procesa el dolor emocional en las mismas áreas que el dolor físico."
    ),
    RandomDataHeatlh(
        text = "30 minutos de ejercicio aeróbico tienen un efecto antidepresivo comparable al de algunos medicamentos. El ejercicio aumenta la producción de BDNF, una proteína que literalmente hace crecer nuevas neuronas."
    ),
    RandomDataHeatlh(
        text = "Casi el 60% de las personas con trastornos mentales no busca ayuda profesional, principalmente por estigma social o falta de acceso. El tiempo promedio entre el inicio de los síntomas y recibir tratamiento es de 11 años."
    )

)

data class Card_text(val titulo: String, val texto: String)

val Card_textinfo = listOf(
    Card_text(
        titulo = "Salud integral",
        texto = "La salud mental es tan importante como la física. Afecta cómo pensamos, sentimos y actuamos en nuestra vida diaria."
    ),
    Card_text (
        titulo = "Prevención y tratamiento",
        texto = "Conocer los síntomas y buscar ayuda a tiempo puede marcar una gran diferencia en el tratamiento y recuperación."
    ),
    Card_text (
        titulo = "Romper el estigma",
        texto = "La educación sobre salud mental ayuda a reducir el estigma y fomenta un ambiente de comprensión y apoyo."
    )
)


