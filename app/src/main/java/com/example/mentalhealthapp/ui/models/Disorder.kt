package com.example.mentalhealthapp.ui.models

data class Disorder(
    val id: String,
    val title: String,
    val shortDescription: String,
    val fullDescription: String,
    val prevalence: String,
    val symptoms: List<String>
)

val disordersList = listOf(
    Disorder(
        id = "ansiedad",
        title = "Trastornos de Ansiedad",
        shortDescription = "El grupo de trastornos mentales más común en todo el mundo",
        fullDescription = "Los trastornos de ansiedad se caracterizan por presentar miedo o ansiedad excesiva y alteraciones conductuales asociadas. La ansiedad es una respuesta normal al estrés, pero se vuelve un trastorno cuando es desproporcionada o persiste en el tiempo.",
        prevalence = "Afecta aproximadamente al 4% de la población mundial.",
        symptoms = listOf(
            "Preocupación excesiva y persistente",
            "Tensión muscular y fatiga",
            "Irritabilidad y dificultad para concentrarse",
            "Alteraciones del sueño"
        )
    ),
    Disorder(
        id = "depresion",
        title = "Depresión (Trastorno Depresivo Mayor)",
        shortDescription = "Va más allá de la tristeza temporal",
        fullDescription = "La depresión es un trastorno mental común. Se caracteriza por una tristeza persistente y una pérdida de interés en las actividades con las que normalmente se disfruta, acompañada de la incapacidad para llevar a cabo las actividades cotidianas.",
        prevalence = "Se estima que afecta al 5% de los adultos en todo el mundo.",
        symptoms = listOf(
            "Estado de ánimo deprimido la mayor parte del día",
            "Pérdida de interés o placer en las actividades",
            "Cambios significativos en el peso o apetito",
            "Sentimientos de inutilidad o culpa excesiva"
        )
    ),
    Disorder(
        id = "bipolar",
        title = "Trastorno Bipolar",
        shortDescription = "Cambios extremos en el estado de ánimo",
        fullDescription = "El trastorno bipolar es una enfermedad mental que causa cambios extremos en el estado de ánimo que comprenden altos emocionales (manía o hipomanía) y bajos emocionales (depresión).",
        prevalence = "Afecta aproximadamente al 1-2% de la población.",
        symptoms = listOf(
            "Episodios de euforia o irritabilidad extrema (manía)",
            "Disminución de la necesidad de dormir durante episodios altos",
            "Episodios de tristeza profunda y desesperanza (depresión)",
            "Cambios bruscos en los niveles de energía y actividad"
        )
    ),
    Disorder(
        id = "tdah",
        title = "TDAH",
        shortDescription = "Trastorno por déficit de atención e hiperactividad",
        fullDescription = "El TDAH es uno de los trastornos del neurodesarrollo más frecuentes de la niñez. Habitualmente su diagnóstico se realiza en la niñez y a menudo dura hasta la edad adulta.",
        prevalence = "Afecta a un 5% de los niños y adolescentes, y a un 2.5% de los adultos.",
        symptoms = listOf(
            "Dificultad para mantener la atención",
            "Hiperactividad motora y exceso de movimiento",
            "Impulsividad (actuar sin pensar)",
            "Dificultades de organización y gestión del tiempo"
        )
    ),
    Disorder(
        id = "tept",
        title = "TEPT",
        shortDescription = "Trastorno de estrés postraumático",
        fullDescription = "El TEPT es una afección de salud mental que algunas personas desarrollan tras experimentar o ver algún evento traumático, como una guerra, un desastre natural, o una agresión.",
        prevalence = "Aproximadamente el 3.5% de los adultos presentan TEPT en un año determinado.",
        symptoms = listOf(
            "Reviviscencias (flashbacks) del evento traumático",
            "Pesadillas y sueños angustiantes",
            "Evitación de lugares o personas que recuerdan el evento",
            "Hipervigilancia y respuesta de sobresalto exagerada"
        )
    ),
    Disorder(
        id = "esquizofrenia",
        title = "Esquizofrenia",
        shortDescription = "Afecta la percepción y el pensamiento",
        fullDescription = "La esquizofrenia es un trastorno mental grave por el cual las personas interpretan la realidad de manera anormal. Puede provocar una combinación de alucinaciones, delirios y trastornos graves del pensamiento.",
        prevalence = "Afecta a aproximadamente 24 millones de personas en todo el mundo (1 de cada 300).",
        symptoms = listOf(
            "Alucinaciones (oír o ver cosas que no existen)",
            "Delirios (creencias falsas firmemente arraigadas)",
            "Pensamiento desorganizado",
            "Falta de motivación y retraimiento social"
        )
    ),
    Disorder(
        id = "tca",
        title = "Trastornos de la Conducta Alimentaria (TCA)",
        shortDescription = "Trastornos relacionados con la comida y la imagen corporal",
        fullDescription = "Los TCA son afecciones graves de salud mental relacionadas con conductas alimentarias persistentes que afectan negativamente la salud, las emociones y la capacidad de funcionar en áreas importantes de la vida.",
        prevalence = "La prevalencia global se estima en torno al 8-9%.",
        symptoms = listOf(
            "Preocupación excesiva por el peso y la figura corporal",
            "Restricción extrema de la ingesta de alimentos",
            "Atracones seguidos de conductas compensatorias",
            "Uso excesivo de ejercicio para 'quemar' calorías"
        )
    ),
    Disorder(
        id = "toc",
        title = "Trastorno Obsesivo-Compulsivo (TOC)",
        shortDescription = "Pensamientos obsesivos y comportamientos compulsivos",
        fullDescription = "El TOC se caracteriza por un patrón de pensamientos y miedos no deseados (obsesiones) que provocan comportamientos repetitivos (compulsiones). Estas obsesiones y compulsiones interfieren en las actividades diarias y causan gran angustia.",
        prevalence = "Afecta aproximadamente al 1-2% de la población mundial.",
        symptoms = listOf(
            "Pensamientos obsesivos recurrentes y persistentes",
            "Miedo a la contaminación o a los gérmenes",
            "Necesidad de que las cosas estén ordenadas simétricamente",
            "Compulsiones de limpieza, verificación o conteo"
        )
    ),
    Disorder(
        id = "sustancias",
        title = "Trastorno por Uso de Sustancias",
        shortDescription = "Patrón problemático de consumo de sustancias",
        fullDescription = "Es una enfermedad que afecta el cerebro y el comportamiento de una persona, y da lugar a una incapacidad para controlar el consumo de medicamentos o drogas legales o ilegales.",
        prevalence = "Millones de personas en el mundo sufren trastornos por consumo de sustancias.",
        symptoms = listOf(
            "Necesidad de consumir la sustancia con frecuencia",
            "Fracaso en los intentos de dejar de consumir",
            "Dedicación de mucho tiempo a obtener o consumir la sustancia",
            "Síntomas de abstinencia al intentar interrumpir el consumo"
        )
    ),
    Disorder(
        id = "tea",
        title = "Trastornos del Espectro Autista (TEA)",
        shortDescription = "Afecta la comunicación e interacción social",
        fullDescription = "El TEA es una afección relacionada con el desarrollo del cerebro que afecta la manera en la que una persona percibe y socializa con otras personas, lo que causa problemas en la interacción social y la comunicación.",
        prevalence = "Se estima que 1 de cada 100 niños tiene autismo a nivel mundial.",
        symptoms = listOf(
            "Dificultades en la comunicación e interacción social",
            "Patrones de comportamiento e intereses restringidos o repetitivos",
            "Sensibilidad inusual a estímulos sensoriales",
            "Dificultad para mantener el contacto visual"
        )
    )
)
