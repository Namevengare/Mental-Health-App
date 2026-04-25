# Manual Tecnico - Mental Health App

## 1. Descripcion del sistema actual
`Mental Health App` es una aplicacion Android nativa hecha con Kotlin + Jetpack Compose.
El proyecto tiene un solo modulo (`:app`) y esta orientado a consulta de contenido de salud mental, centros de atencion y noticias cientificas.

## 2. Stack implementado
- Android Gradle Plugin: `9.0.1`
- Kotlin plugin (Compose): `2.0.21`
- Compile SDK: `36` (minor API `1`)
- Min SDK: `24`
- Target SDK: `36`
- Java source/target compatibility: `11`
- UI: Jetpack Compose + Material 3
- Navegacion: `androidx.navigation:navigation-compose:2.9.7`
- Red HTTP/WebSocket: OkHttp `4.12.0`
- Parseo JSON: Gson `2.10.1`
- Testing: JUnit 4, AndroidX Test, Espresso, MockK, Coroutines Test, Turbine

## 3. Configuracion del proyecto

### 3.1 Estructura de modulos
- `rootProject.name = "Mental Health app"`
- Modulos incluidos: `:app`

### 3.2 Repositorios de dependencias
- `google()`
- `mavenCentral()`
- `gradlePluginPortal()` (solo plugin management)

### 3.3 Build features
- `buildFeatures.compose = true`
- Build type `release` con `isMinifyEnabled = false`
- Runner de pruebas instrumentadas: `androidx.test.runner.AndroidJUnitRunner`

## 4. Permisos y manifiesto
En `app/src/main/AndroidManifest.xml` se declaran:
- `android.permission.INTERNET`
- `android.permission.POST_NOTIFICATIONS`

Configuracion de `application`:
- `android:usesCleartextTraffic="true"`
- Tema de app: `@style/Theme.MentalHealthApp`
- Actividad launcher: `.MainActivity` (`android:exported="true"`)

## 5. Arquitectura funcional actual

### 5.1 Entrada principal
`MainActivity`:
- Inicializa `NotificationHelper`.
- Crea y conecta `WebSocketManager` contra `wss://sharpie-wind-lily.ngrok-free.dev/ws-notifications`.
- Solicita permiso `POST_NOTIFICATIONS` en Android 13+.
- Lanza notificacion local periodica dentro de un `LaunchedEffect` con espera de `50000 ms`.
- Monta `Scaffold` con barra inferior y `NavHost`.

### 5.2 Navegacion
Rutas registradas:
- `home`
- `trastornos`
- `disorder_detail/{disorderId}`
- `citas`
- `noticias`

La barra inferior usa `Constants.BottomNavItems` y expone 4 secciones:
- Inicio
- Transtornos (texto en codigo actual)
- Citas
- Noticias

## 6. Pantallas implementadas

### 6.1 Inicio (`HomeScreen`)
- Renderiza banner `MentalHealthBanner`.
- Renderiza bloques informativos desde `Card_textinfo`.
- Muestra un dato aleatorio desde `randomDataHeatlh`.
- Usa scroll vertical.

### 6.2 Trastornos (`DisorderScreen`)
- Lista dinamicamente `disordersList`.
- Cada item navega a `disorder_detail/{id}`.
- Incluye nota de uso educativo.

### 6.3 Detalle de trastorno (`DisorderDetailScreen`)
Muestra para cada trastorno:
- Titulo
- Descripcion completa
- Prevalencia
- Lista de sintomas
- CTA "Buscar citas medicas" que navega a `citas`

### 6.4 Citas (`AppointmentsScreen`)
- Fuente de datos local: `centersList`.
- Busqueda por texto (nombre o especialidad).
- Filtro por ciudad (`Todos`, Medellin, Bello, Itagui, Envigado, Sabaneta).
- Tarjetas de centros con direccion, telefono, horario y tipo.

### 6.5 Noticias (`NewsScreen`)
- Usa `NewsViewModel`.
- Ejecuta `fetchNews()` al entrar.
- Paginacion local de 5 items por pagina.
- Boton para abrir cada articulo en navegador externo (`Intent.ACTION_VIEW`).

## 7. Modelos de datos en codigo
- `Disorder` (`id`, `title`, `shortDescription`, `fullDescription`, `prevalence`, `symptoms`)
- `MentalHealthCenter` (`name`, `type`, `address`, `city`, `phone`, `hours`, `specialties`)
- `NewsArticle` (`pmid`, `title`, `journal`, `publicationDate`, `doi`, `pubmedUrl`, `fetchedAt`)
- `BottomNavItem` (`label`, `Icon`, `route`)

Datos embebidos actuales:
- `disordersList`: 10 trastornos.
- `centersList`: 4 centros del Valle de Aburra.
- `Card_textinfo`: 3 tarjetas informativas.
- `randomDataHeatlh`: 3 datos aleatorios.

## 8. Integraciones de red implementadas

### 8.1 API REST de noticias
`NewsViewModel` consume por GET:
- `http://192.168.1.11:8081/api/news/mental-health`

Comportamiento:
- `isLoading = true` al iniciar.
- Si la respuesta es exitosa, parsea `List<NewsArticle>` con Gson.
- Si hay error HTTP o excepcion, registra logs y deja `isLoading = false`.

### 8.2 WebSocket de notificaciones
`WebSocketManager`:
- Conecta por OkHttp WebSocket.
- En cada mensaje de texto, dispara notificacion local:
  - Titulo: `Nueva Notificacion`
  - Mensaje: contenido del socket
- Cierra el socket en `disconnect()`.

## 9. Sistema de notificaciones local
`NotificationHelper`:
- Crea canal `websocket_notifications` (Android O+).
- Usa `NotificationManagerCompat`.
- `showNotification(title, message)` publica notificaciones con prioridad default.
- Captura `SecurityException` si falta permiso.

## 10. Tema y recursos
- Nombre de aplicacion: `Mental Health app`
- Tema XML declarado: `Theme.MentalHealthApp` con parent `android:Theme.Material.Light.NoActionBar`
- Recursos en `values`: `strings.xml`, `colors.xml`, `themes.xml`

## 11. Pruebas existentes

### 11.1 Unit tests (`app/src/test`)
- `DisordersDataTest`
  - Valida cantidad de trastornos (`10`), estructura, ids unicos y dato puntual de ansiedad.
- `AppointmentsDataTest`
  - Valida integridad de `centersList` y filtros por ciudad/especialidad/nombre.
- `HomeDataTest`
  - Valida listas de datos de Home y modelos de apoyo.
- `NewsViewModelTest`
  - Mockea OkHttp para validar flujo exitoso y manejo de error.
- `ExampleUnitTest`
  - Prueba base de ejemplo (`2 + 2 = 4`).

### 11.2 Instrumented tests (`app/src/androidTest`)
- `ExampleInstrumentedTest`
  - Verifica package name `com.example.mentalhealthapp`.

## 12. Ejecucion y comandos disponibles por wrapper
El repositorio incluye `gradlew` y `gradlew.bat`.
Comandos tipicos de este proyecto:
- Windows: `.\gradlew.bat assembleDebug`
- Windows: `.\gradlew.bat test`
- Windows: `.\gradlew.bat connectedAndroidTest`
- Unix/macOS: `./gradlew assembleDebug`
- Unix/macOS: `./gradlew test`
- Unix/macOS: `./gradlew connectedAndroidTest`

## 13. Estado documentado
Este manual describe exclusivamente elementos encontrados en el repositorio actual, sin secciones hipoteticas ni pendientes.
